package com.ecjtu.kyhelper.model;

import cn.bmob.v3.BmobObject;

/**
 * TODO : ��ҳ��Ѷ����ʵ����
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��3��
 */
public class KyNews extends BmobObject {

	private String type; // ��������
	private String title; // ���±���
	private String author; // ��������
	private String content; // ��������

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
