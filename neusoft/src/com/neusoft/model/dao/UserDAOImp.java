package com.neusoft.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.model.bean.UserInfo;
import com.neusoft.utils.DBUtil;

public class UserDAOImp implements UserDAO {
	
	Connection conn;
	
	public UserDAOImp(Connection conn){
		this.conn = conn;
	}

	//用户信息的插入
	public void insertUser(UserInfo user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(" insert into UserInfo "
				+ " values (null,?,?,?,?,?,?,now(),?,?,?) ");
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getSex());
		ps.setString(3, user.getUsertele());
		ps.setString(4, user.getUserwork());
		ps.setString(5, user.getUseremail());
		ps.setInt(6, user.getUserQRcode());
	    ps.setString(7, user.getOpenid());
	    ps.setString(8, user.getImgurl());
	    ps.setString(9, user.getAgendar());
		ps.executeUpdate();
		DBUtil.closePreparedStatement(ps);
	}

	//二维码判重复
	public Boolean selectQRcode(Integer QRcode) throws SQLException {
		Boolean flag = false;
		PreparedStatement ps = conn.prepareStatement(" select * from UserInfo where userQRcode = ? ");
		ps.setInt(1, QRcode);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			flag = true;
		}
		DBUtil.closeResult(rs);
		return flag;
	}

	//用户信息的修改
	public void updateUser(UserInfo user) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(" update UserInfo set "
				+ " username = ? , usersex = ? , usertele = ? , userwork = ? , useremail = ?, agendar=? "
				+ " where userQRcode = ? ");
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getSex());
		ps.setString(3, user.getUsertele());
		ps.setString(4, user.getUserwork());
		ps.setString(5, user.getUseremail());
		ps.setString(6, user.getAgendar());
		ps.setInt(7, user.getUserQRcode());
		
		ps.executeUpdate();
		DBUtil.closePreparedStatement(ps);
	}
	
	public UserInfo getUserInfo(String openid) throws SQLException {
		UserInfo u= null;
		PreparedStatement ps = conn.prepareStatement("select * from UserInfo where openid = ? ");
		ps.setString(1, openid);
		ResultSet rs = ps.executeQuery();		
		if(rs.next()){
			
			u = new UserInfo();
			u.setUserid(rs.getInt("userid"));
			u.setUsername(rs.getString("username"));
			u.setSex(rs.getString("usersex"));
			u.setUsertele(rs.getString("usertele"));
			u.setUserwork(rs.getString("userwork"));
			u.setUseremail(rs.getString("useremail"));
			u.setUserQRcode(rs.getInt("userQRcode"));
			u.setOpenid(rs.getString("openid"));
			u.setImgurl(rs.getString("imgurl"));	
			u.setAgendar(rs.getString("agendar"));
		}
		DBUtil.closeResult(rs);
		return u;
	}

}
