package com.ecjtu.kyhelper.adapter;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.model.KyNews;

/**
 * TODO : ��Ѷ�б�������
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��3��
 */
public class NewsListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private List<KyNews> mNewsList = null; // ��ѡ�����µ������б�

	public NewsListAdapter(Context context, List<KyNews> newsList) {
		setmContext(context);
		mNewsList = newsList;
		mInflater = LayoutInflater.from(context);
	}

	// getCount������listviewһ���ж��ٸ�item
	@Override
	public int getCount() {
		return mNewsList.size();
	}

	// ����setOnItemClickListener���ѡ�����¼��з���ص���,����ȡ��ǰ�����ݵ�
	@Override
	public Object getItem(int position) {
		return mNewsList.get(position);
	}

	// �����ص��Ǹ�postion��Ӧitem��id
	@Override
	public long getItemId(int position) {
		return position;
	}

	// ˢ���б��е�����
	public void refresh(ArrayList<KyNews> list) {
		mNewsList = list;
		// �޸��Ѿ����ɵ��б���ӻ����޸�����,notifyDataSetChanged()�������޸��������󶨵�����󣬲�������ˢ��Activity��֪ͨActivity����ListView��
		notifyDataSetChanged();
	}

	// getView������ÿ��item������ʾ��view
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NewsHolder newsHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.news_list_item, null);
			newsHolder = new NewsHolder();
			newsHolder.tvNewsType = (TextView) convertView
					.findViewById(R.id.tv_news_type);
			newsHolder.tvNewsTitle = (TextView) convertView
					.findViewById(R.id.tv_news_title);
			newsHolder.tvNewsDate = (TextView) convertView
					.findViewById(R.id.tv_news_date);
			convertView.setTag(newsHolder);
		} else {
			newsHolder = (NewsHolder) convertView.getTag();
		}
		// ����ַ�����ֻȡ������
		String[] ss = new String[2];
		ss = mNewsList.get(position).getCreatedAt().split(" ");
		newsHolder.tvNewsType.setText(mNewsList.get(position).getType()); // ��������
		newsHolder.tvNewsTitle.setText(mNewsList.get(position).getTitle()); // ���±���
		newsHolder.tvNewsDate.setText(ss[0]); // ���·�������
		return convertView;
	}

	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}
}
