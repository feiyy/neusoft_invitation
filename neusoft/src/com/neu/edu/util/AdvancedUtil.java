package com.neu.edu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.neu.edu.pojo.SNSUserInfo;
import com.neu.edu.pojo.WeixinOauth2Token;

public class AdvancedUtil {
	//private static Logger log = LoggerFactory.getLogger(AdvancedUtil.class);
	
	/**
     * ��ȡ��ҳ��Ȩƾ֤
     * 
     * @param appId �����˺ŵ�Ψһ��ʶ
     * @param appSecret �����˺ŵ���Կ
     * @param code
     * @return WeixinAouth2Token
     */
    public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
        WeixinOauth2Token wat = null;
        // ƴ�������ַ
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        requestUrl = requestUrl.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        
        System.out.println("requestUrl:"+requestUrl);
        
        // ��ȡ��ҳ��Ȩƾ֤
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
        
        System.out.println("��ȡ��ҳ��Ȩ�ɹ��ˣ�");
        
        
        if (null != jsonObject) {
            try {
                wat = new WeixinOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInt("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                wat = null;
                System.out.println("ʧ���ˣ�"+e.toString());
               // int errorCode = jsonObject.getInt("errcode");
                //String errorMsg = jsonObject.getString("errmsg");
                //log.error("��ȡ��ҳ��Ȩƾ֤ʧ�� errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return wat;
    }
    
    
    
    /**
     * ͨ����ҳ��Ȩ��ȡ�û���Ϣ
     * 
     * @param accessToken ��ҳ��Ȩ�ӿڵ���ƾ֤
     * @param openId �û���ʶ
     * @return SNSUserInfo
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
    	
    	System.out.println("hahahahahhaa-accessToken:"+accessToken);
    	System.out.println("hahahahahhaa-openId:"+openId);
        SNSUserInfo snsUserInfo = null;
        // ƴ�������ַ
        String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
        // ͨ����ҳ��Ȩ��ȡ�û���Ϣ
        JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                snsUserInfo = new SNSUserInfo();
                // �û��ı�ʶ
                snsUserInfo.setOpenId(jsonObject.getString("openid"));
                System.out.println("openid�ǣ�"+snsUserInfo.getOpenId());
                // �ǳ�
                snsUserInfo.setNickname(jsonObject.getString("nickname"));
                
                System.out.println("�ǳ��ǣ�"+snsUserInfo.getNickname());
                
                // �Ա�1�����ԣ�2��Ů�ԣ�0��δ֪��
                snsUserInfo.setSex(jsonObject.getInt("sex"));
                
                System.out.println("sex�ǣ�"+snsUserInfo.getSex());
                // �û����ڹ���
                snsUserInfo.setCountry(jsonObject.getString("country"));
                // �û�����ʡ��
                snsUserInfo.setProvince(jsonObject.getString("province"));
                // �û����ڳ���
                snsUserInfo.setCity(jsonObject.getString("city"));
                // �û�ͷ��
                snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                
                System.out.println("ͷ���ǣ�"+snsUserInfo.getHeadImgUrl());
                // �û���Ȩ��Ϣ
                snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
            } catch (Exception e) {
                snsUserInfo = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                System.out.println("��ȡ�û���Ϣʧ�ܣ�"+e.toString());
                //log.error("��ȡ�û���Ϣʧ�� errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
        return snsUserInfo;
    }

}
