package com.neusoft.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.neusoft.model.bean.UserInfo;
import com.neusoft.model.dao.UserDAO;
import com.neusoft.model.dao.UserDAOImp;
import com.neusoft.utils.DBUtil;

public class UserService {
	
	private UserService(){};
	
	private static UserService user = new UserService();
	
	public static UserService getUserInstanceof(){
		return user;
	}
	
	//�û���Ϣ��ע�����
	public void insertUser(UserInfo user) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.closeAUTOCommit(conn);
			UserDAO dao = new UserDAOImp(conn);
			dao.insertUser(user);
			DBUtil.commitTransaction(conn);
		} catch (Exception e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	//��ѯ�Ƿ����ظ���ά��
	public Boolean selectQRcode(Integer QRcode) throws SQLException{
		Connection conn = null;
		Boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			DBUtil.closeAUTOCommit(conn);
			UserDAO dao = new UserDAOImp(conn);
			flag = dao.selectQRcode(QRcode);
			DBUtil.commitTransaction(conn);
		} catch (Exception e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return flag;
	}
	
	//�û���Ϣ���޸�
	public void updateUser(UserInfo user) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			DBUtil.closeAUTOCommit(conn);
			UserDAO dao = new UserDAOImp(conn);
			dao.updateUser(user);
			DBUtil.commitTransaction(conn);
		} catch (Exception e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
	}
	
	public UserInfo getUserinfo(String openid) throws SQLException
	{
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			UserDAO dao = new UserDAOImp(conn);
			return dao.getUserInfo(openid);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	
	
}
