package com.ecjtu.kyhelper.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * TODO : ����Ŀ֪ʶ��ϸ�ֵ�ʵ���࣬ ʵ�����л�, Activity֮��ʵ�ִ���
 * ���л�����һ����������������Ļ��ƣ���ν������Ҳ���ǽ���������ݽ�������
 * �����Զ�������Ķ�����ж�д������Ҳ�ɽ�������Ķ�����������֮�䡣���л���Ϊ�˽���ڶԶ��������ж�д����ʱ�����������⡣
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��3��
 */
public class Subject extends BmobObject implements Serializable {

	
	private static final long serialVersionUID = -8796635595320697255L;

	private String type;// ����11�����һ��GridView�еĵ�һ��
	private String name;
	private String summary;
	private String content;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
