package com.ecjtu.kyhelper.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.GridAdapter;
import com.ecjtu.ui.MyGridView;

/**
 * TODO : ClassifyActivity.java--����������
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��29��
 */
public class ClassifyActivity extends Activity implements OnItemClickListener {

	private MyGridView kdMathClass; // ��ѧ���Ŀ���
	private MyGridView kdEnglishClass; // Ӣ����Ŀ���
	private MyGridView kdPolityClass; // ���κ��Ŀ���
	private MyGridView kdFuXi; // ���и�ϰ����

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify);

		initView();
	}

	/**
	 * ��ʼ���������������
	 */
	public void initView() {
		kdEnglishClass = (MyGridView) findViewById(R.id.gv_english_class);
		kdPolityClass = (MyGridView) findViewById(R.id.gv_polity_class);
		kdFuXi = (MyGridView) findViewById(R.id.gv_fuxi_class);
		kdMathClass = (MyGridView) findViewById(R.id.gv_math_class);

		kdEnglishClass.setAdapter(new GridAdapter(this, 0));
		kdEnglishClass.setOnItemClickListener(this);

		kdPolityClass.setAdapter(new GridAdapter(this, 1));
		kdPolityClass.setOnItemClickListener(this);

		kdFuXi.setAdapter(new GridAdapter(this, 2));
		kdFuXi.setOnItemClickListener(this);

		kdMathClass.setAdapter(new GridAdapter(this, 3));
		kdMathClass.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Log.i("GridView����ˣ� ", "position");
		// toast("����ˣ� " + position);
		switch (parent.getId()) {

		// �����ѧ���Ŀ����е�����
		case R.id.gv_math_class:
			toClassifyAllActivity(GridAdapter.mMathTexts[position], "1"
					+ (position + 1));
			break;
		// ���Ӣ����Ŀ����е�����
		case R.id.gv_english_class:
			toClassifyAllActivity(GridAdapter.kyEngTexts[position], "2"
					+ (position + 1));
			break;
		// ������κ��Ŀ��������
		case R.id.gv_polity_class:
			toClassifyAllActivity(GridAdapter.mPolityTexts[position], "3"
					+ (position + 1));
			break;
		// ������и�ϰ���������
		case R.id.gv_fuxi_class:
			toClassifyAllActivity(GridAdapter.mExperienceTexts[position], "4"
					+ (position + 1));
			break;
		default:
			break;
		}

	}

	@SuppressWarnings("unused")
	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};

	private void toClassifyAllActivity(String title, String type) {
		Intent toClassifyAll = new Intent(ClassifyActivity.this,
				ClassifyAllActivity.class);
		toClassifyAll.putExtra("title", title);
		// ��ǰ�������ĸ�����
		toClassifyAll.putExtra("type", type);
		startActivity(toClassifyAll);
	}

}
