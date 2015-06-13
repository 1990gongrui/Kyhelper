package com.ecjtu.kyhelper.view;

import com.ecjtu.kyhelper.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * TODO : Ӧ��������
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��3��
 */
@SuppressWarnings("deprecation")
public class BaseActivity extends TabActivity {

	private TabHost tabHost;
	private LayoutInflater layoutInflater;

	String[] mTitle = new String[] { "��Ѷ", "����", "����", "����" };
	int[] mIcon = new int[] { R.drawable.ic_tabkynews, R.drawable.ic_tabmenu,
			R.drawable.ic_tabtalk, R.drawable.ic_tabmore };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		initTabView();

	}

	@SuppressLint("InflateParams")
	public View getTabItemView(int i) {
		// TODO Auto-generated method stub
		View view = layoutInflater.inflate(R.layout.tab_widget_item, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mIcon[i]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTitle[i]);
		return view;
	}

	public void initTabView() {

		/**
		 * tabHost.newTabSpec("artist")����һ����ǩ�����artistΪ���ı�ǩ��ʶ����
		 * �൱��jspҳ���ǩ��name����
		 * setIndicator("������ǩ",resources.getDrawable(R.drawable
		 * .ic_tab))���ñ�ǩ��ʾ�ı��Լ���ǩ�ϵ�ͼ�꣨��ͼ�겢����һ��ͼƬ������һ��xml�ļ�Ŷ��
		 * setContent(intent)Ϊ��ǰ��ǩָ��һ����ͼ tabHost.addTab(spec); ����ǩ����ӵ���ǩ��
		 */

		tabHost = getTabHost();
		layoutInflater = LayoutInflater.from(this);
		TabHost.TabSpec spec;

		Intent intent1 = new Intent(this, HomeActivity.class);
		spec = tabHost.newTabSpec(mTitle[0]).setIndicator(getTabItemView(0))
				.setContent(intent1);
		tabHost.addTab(spec);

		Intent intent2 = new Intent(this, ClassifyActivity.class);
		spec = tabHost.newTabSpec(mTitle[1]).setIndicator(getTabItemView(1))
				.setContent(intent2);
		tabHost.addTab(spec);

		Intent intent3 = new Intent(this, CommunionWsqActivity.class);
		spec = tabHost.newTabSpec(mTitle[2]).setIndicator(getTabItemView(2))
				.setContent(intent3);
		tabHost.addTab(spec);

		Intent intent4 = new Intent(this, MoreActivity.class);
		spec = tabHost.newTabSpec(mTitle[3]).setIndicator(getTabItemView(3))
				.setContent(intent4);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(this, "ȷ��Ҫ�˳���������ô?", Toast.LENGTH_LONG).show();
		// super.onBackPressed();
	}

}
