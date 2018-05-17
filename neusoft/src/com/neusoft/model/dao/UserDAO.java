package com.neusoft.model.dao;

import java.sql.SQLException;

import com.neusoft.model.bean.UserInfo;

public interface UserDAO {
		
	//进行用户信息的插入
	public void insertUser(UserInfo user) throws SQLException;
	
	//判定是否有重复的二维码号码
	public Boolean selectQRcode(Integer QRcode) throws SQLException;
	
	//进行用户信息的修改
	public void updateUser(UserInfo user) throws SQLException;
	
	public UserInfo getUserInfo(String openid) throws SQLException;
	
}
