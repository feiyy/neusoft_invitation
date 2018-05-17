package com.neusoft.model.dao;

import java.sql.SQLException;

import com.neusoft.model.bean.UserInfo;

public interface UserDAO {
		
	//�����û���Ϣ�Ĳ���
	public void insertUser(UserInfo user) throws SQLException;
	
	//�ж��Ƿ����ظ��Ķ�ά�����
	public Boolean selectQRcode(Integer QRcode) throws SQLException;
	
	//�����û���Ϣ���޸�
	public void updateUser(UserInfo user) throws SQLException;
	
	public UserInfo getUserInfo(String openid) throws SQLException;
	
}
