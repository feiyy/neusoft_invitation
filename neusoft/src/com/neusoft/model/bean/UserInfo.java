package com.neusoft.model.bean;

import java.sql.Date;

public class UserInfo {

	private Integer userid;
	private String username;
	private String sex;
	private String usertele;
	private String userwork;
	private String useremail;
	private Integer userQRcode;
	private Date userCreateDate;
	private String openid;
	private String imgurl;
	private String agendar;
	
	public String getAgendar() {
		return agendar;
	}

	public void setAgendar(String agendar) {
		this.agendar = agendar;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertele() {
		return usertele;
	}

	public void setUsertele(String usertele) {
		this.usertele = usertele;
	}

	public String getUserwork() {
		return userwork;
	}

	public void setUserwork(String userwork) {
		this.userwork = userwork;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Integer getUserQRcode() {
		return userQRcode;
	}

	public void setUserQRcode(Integer userQRcode) {
		this.userQRcode = userQRcode;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}

}
