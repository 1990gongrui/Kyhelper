package com.ecjtu.kyhelper.model;

import cn.bmob.v3.BmobUser;

/**
 * TODO : �û�ʵ����
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��3��
 */
public class User extends BmobUser {

	// �������Ѿ����ڵ�����
	// private String id;
	// private String username;
	// private String password;
	// private String email;
	// private String regTime;

	private String phone; // �绰

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
