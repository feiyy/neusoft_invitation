package com.neu.edu.pojo;

import java.util.List;

public class SNSUserInfo {
	
		private String openId;  //�û���ʶ
		private String nickname; //�û��ǳ�
		private int sex; //�Ա�1������ 2��Ů�� 0��δ֪��
		private String country; //����
		private String province; //ʡ��
		private String city; //����
		private String headImgUrl; //ͷ������
		private List<String> privilegeList; //��Ȩ��Ϣ
		
		public String getOpenId() {
			return openId;
		}
		public void setOpenId(String openId) {
			this.openId = openId;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public int getSex() {
			return sex;
		}
		public void setSex(int sex) {
			this.sex = sex;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getHeadImgUrl() {
			return headImgUrl;
		}
		public void setHeadImgUrl(String headImgUrl) {
			this.headImgUrl = headImgUrl;
		}
		public List<String> getPrivilegeList() {
			return privilegeList;
		}
		public void setPrivilegeList(List<String> privilegeList) {
			this.privilegeList = privilegeList;
		}
	
		
	

}
