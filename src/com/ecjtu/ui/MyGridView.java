package com.ecjtu.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * TODO : ����ҳ--����������ͼ
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��3��
 */
public class MyGridView extends GridView {

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyGridView(Context context) {
		super(context);
	}

	public MyGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * onMeasure�����ǲ���view���������ݣ�����measured width��measured height�ģ����������
	 * measure(int, int)��������������Ը�дonMeasure���ṩ����׼ȷ����Ч�Ĳ�����
	 */
	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
/**
 * ListView����GridViewǶ����ScrollView�У�Ƕ��ʹ��ʱ�������ListView/GridView���Լ��Ĺ�������
 * ��ScrollView�����Լ��Ĺ����������������ĺ����ǣ���дListView/GridView��OnMesure������
 */
