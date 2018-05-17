package com.neu.edu.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.edu.pojo.SNSUserInfo;
import com.neu.edu.pojo.WeixinOauth2Token;
import com.neu.edu.util.AdvancedUtil;
import com.neu.edu.util.CommonUtil;
import com.neu.edu.util.SignUtils;

import net.sf.json.JSONObject;

public class OAuthServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1847238807216447030L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		 System.out.println("请求路径"+request.getRequestURI());
		
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        if(code==null)
        {
        	System.out.println("redirect.........");
        	response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1481522e253290f2&redirect_uri=http%3A%2F%2Fwww.zyrc.tech%2Fneusoft%2FOAuthServlet&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        }
        else
        {
        	System.out.println("codecodecodecodecodecode:"+code);

            SNSUserInfo snsUserInfo = new SNSUserInfo();
            // 用户同意授权
            if (!"authdeny".equals(code)) {
            	
                // 获取网页授权access_token          
            	WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("wx1481522e253290f2", "21831a52ccf51f2181cc4562793b9867", code);
            	
                System.out.println("code已经发送了！！！");
                
                // 网页授权接口访问凭证
                String accessToken = weixinOauth2Token.getAccessToken();
                
                // 用户标识
                String openId = weixinOauth2Token.getOpenId();

                // 获取用户信息
                snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);
     
                // 设置要传递的参数
                request.getSession().setAttribute("snsUserInfo", snsUserInfo);
                
                System.out.println("得到用户信息，"+openId+"..."+snsUserInfo.getHeadImgUrl());
              
            }
            
            //配置微信分享
          //1. 得到access token
      		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
      		url = url.replace("APPID", "wx1481522e253290f2");
      		url = url.replace("APPSECRET", "21831a52ccf51f2181cc4562793b9867");		
      		JSONObject obj = CommonUtil.httpsRequest(url, "GET",null);
      		String access_token = obj.getString("access_token");
      		
      		//2. 得到jsapi_ticket
      		String url2 = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
      		url2 = url2.replace("ACCESS_TOKEN", access_token);
      		JSONObject obj2 = CommonUtil.httpsRequest(url2, "GET",null);
      		String jsapi_ticket = obj2.getString("ticket");
      		
      		System.out.println("jsapi_ticket:"+jsapi_ticket);
      		
      		//3. 得到wx.config所需要的参数		
      		String requesturl = "http://www.zyrc.tech/neusoft/OAuthServlet?code="+code+"&state=STATE";
      		System.out.println("requesturlrequesturl:"+requesturl);
      		Map<String, String> map = SignUtils.sign(jsapi_ticket, requesturl);
      		
      		request.getSession().setAttribute("map", map);		
      		
            
            //response.sendRedirect(request.getContextPath()+"/main.jsp");
      		request.getRequestDispatcher("/main.jsp").forward(request, response);
        }
	}
	
}
