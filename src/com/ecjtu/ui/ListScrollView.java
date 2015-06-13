package com.ecjtu.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

//HomeActivity.java
public class ListScrollView extends ScrollView {

	private ListView listView;

	public ListScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ListScrollView(Context context) {
		super(context);
	}

	/**
	 * ��дonInterceptTouchEvent�������������������ListView�������ʱ��,
	 * ����false��ScrollView��onTouchEvent���ղ���MotionEvent�����ǰ�Event������һ���Ŀؼ���
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (listView != null && checkArea(listView, ev)) {
			return false;
		}
		return super.onInterceptTouchEvent(ev);
	}

	/**
	 * ����view�Ƿ��ڵ����Χ��
	 * 
	 * @param locate
	 * @param v
	 * @return
	 */
	private boolean checkArea(View v, MotionEvent event) {
		float x = event.getRawX();
		float y = event.getRawY();
		int[] locate = new int[2];
		v.getLocationOnScreen(locate);
		int l = locate[0];
		int r = l + v.getWidth();
		int t = locate[1];
		int b = t + v.getHeight();
		if (l < x && x < r && t < y && y < b) {
			return true;
		}
		return false;
	}

	public ListView getListView() {
		return listView;
	}

	public void setListView(ListView listView) {
		this.listView = listView;
	}
}
