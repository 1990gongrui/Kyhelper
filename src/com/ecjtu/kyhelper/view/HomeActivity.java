package com.ecjtu.kyhelper.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.NewsListAdapter;
import com.ecjtu.kyhelper.model.KyNews;
import com.ecjtu.ui.ListScrollView;

/**
 * TODO : ��Ѷ����
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��23��
 */
@SuppressLint("ShowToast")
public class HomeActivity extends Activity implements OnItemClickListener {

	private ListScrollView listScrollView;

	// У��
	private TextView tvWeek; // �ܴκ�����
	private TextView tvDay; // ������

	// ��Ѷ����
	private ListView lvNewsList;
	private List<KyNews> newsList = new ArrayList<KyNews>();
	private NewsListAdapter newsListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		listScrollView = (ListScrollView) findViewById(R.id.listScrollView);
		lvNewsList = (ListView) findViewById(R.id.lv_news);
		listScrollView.setListView(lvNewsList);

		// ����
		tvWeek = (TextView) findViewById(R.id.tv_week);
		tvDay = (TextView) findViewById(R.id.tv_day);
		setTime();

		// ����
		newsListAdapter = new NewsListAdapter(this, newsList);
		// Ϊ ListView ����������
		lvNewsList.setAdapter(newsListAdapter);
		lvNewsList.setOnItemClickListener(this);

		getNewsData();
	}

	/**
	 * �������ڵ�ʱ��
	 */
	public void setTime() {
		Calendar calendar = Calendar.getInstance();
		String year = calendar.get(Calendar.YEAR) + "";
		String month = calendar.get(Calendar.MONTH) + 1 + "";
		String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
		String week = calendar.get(Calendar.WEEK_OF_YEAR) - 9 + "";
		String dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 + "";
		toast(year + "-" + month + "-" + day + " " + " �� " + week + " �� " + " "
				+ " ���� " + dayOfWeek);
		tvWeek.setText(" �� " + week + " �� " + " " + " ���� " + dayOfWeek);
		tvDay.setText(year + "�� " + month + "�� " + day + "��  ");
	}

	/**
	 * ��ʼ�������б�����
	 * 
	 * @date
	 * @author
	 */
	public void getNewsData() {
		BmobQuery<KyNews> query = new BmobQuery<KyNews>();
		query.order("-updatedAt");
		query.findObjects(this, new FindListener<KyNews>() {

			@Override
			public void onSuccess(List<KyNews> object) {
				newsList = object;
				// ֪ͨAdapter���ݸ���
				newsListAdapter.refresh((ArrayList<KyNews>) newsList);
				newsListAdapter.notifyDataSetChanged();
			}

			@Override
			public void onError(String arg0) {
				toast("��ȡ����ʧ����");
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent toNewsDetail = new Intent(HomeActivity.this, NewsActivity.class);
		toNewsDetail.putExtra("NewsTitle", newsList.get(position).getTitle());
		toNewsDetail.putExtra("NewsAuthor", newsList.get(position).getAuthor());
		toNewsDetail
				.putExtra("NewsTime", newsList.get(position).getCreatedAt());
		toNewsDetail.putExtra("NewsContent", newsList.get(position)
				.getContent());
		startActivity(toNewsDetail);
	}

	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT);
	}

}
