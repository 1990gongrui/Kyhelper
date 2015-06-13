package com.ecjtu.kyhelper.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ecjtu.data.TypeDef;
import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.model.Subject;

/**
 * TODO : ������--����ĳһ�����µ��б�����
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��3��
 */

@SuppressLint("InflateParams")
public class ClassifyListAdapter extends BaseAdapter {

	/**
	 * LayoutInflater��������res/layout/�µ�xml�����ļ�������ʵ��������findViewById()
	 * ����xml�����ļ��µľ���widget�ؼ�(��Button��TextView��)
	 */
	private Context mContext;
	private LayoutInflater mInflater = null;// LayoutInflater�����ǽ�layout��xml�����ļ�ʵ����ΪView�����
	private ArrayList<Subject> mClassifyList = null; // ��ѡ�����µ������б�
	private String subType; // ��Ŀ�ķ���

	public ClassifyListAdapter(Context context,
			ArrayList<Subject> classifyList, String type) {
		setmContext(context);
		mClassifyList = classifyList;
		subType = type;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mClassifyList.size();
	}

	@Override
	public Object getItem(int position) {
		return mClassifyList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// ˢ���б��е�����
	public void refresh(ArrayList<Subject> list) {
		mClassifyList = list;
		// �����ֵ����ͱ��ת��Ϊ����
		exchangeType(subType);
		notifyDataSetChanged();
	}

	/**
	 * ���ݵ�ǰ��type����, ת������Ӧ������
	 * 
	 * @param typeString
	 */
	private void exchangeType(String typeString) {

		int type = Integer.parseInt(typeString);
		int fatherType = type / 10; // �����ͱ��
		int sonType = type % 10; // �����ͱ��

		Iterator<Subject> iterator = mClassifyList.iterator();
		while (iterator.hasNext()) {
			switch (fatherType) {
			case 1:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList1[sonType - 1]);
				break;
			case 2:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList2[sonType - 1]);
				break;
			case 3:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList3[sonType - 1]);
				break;
			case 4:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList4[sonType - 1]);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/**
		 * int positionλ�ã�һ��BaseAdapter���Ǻܶ�����һ��������չʾ�ڽ��棬���������ж���ʾ�ڽ����ϵ��ǵڼ�����
		 * ͨ��position��BaseAdapter�Զ����������߼�����ȡֵ����չʾ�ڽ����ϡ� View convertView
		 * չʾ�ڽ����ϵ�һ��item����Ϊ�ֻ���Ļ����ô������һ��չʾ���û������������ǹ̶��ģ������List����1000�����ݣ�
		 * ��Ӧ��new1000��converView
		 * �������ڴ�϶����㣬Ӧ��ѧ��ؼ����ã�������Ļ��convertView���������½�����item������ʹ�ã�ֻ���޸�����չʾ��ֵ
		 */
		ClassifyHolder classifyHodler;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.subject_all_list_item,
					null);
			classifyHodler = new ClassifyHolder();
			classifyHodler.tvClassifyName = (TextView) convertView
					.findViewById(R.id.tv_subject_name);
			classifyHodler.tvClassifyType = (TextView) convertView
					.findViewById(R.id.tv_subject_type);
			classifyHodler.tvClassifyLoc = (TextView) convertView
					.findViewById(R.id.tv_subject_loc);
			convertView.setTag(classifyHodler);
		} else {
			// �Ѳ��ҵ�view������������������
			// �������¹���VIEW������ϵͳ�л����VIEW���������Ч��
			classifyHodler = (ClassifyHolder) convertView.getTag();
		}
		classifyHodler.tvClassifyName.setText(mClassifyList.get(position)
				.getName());
		// ������Ҫ��������
		classifyHodler.tvClassifyType.setText(mClassifyList.get(position)
				.getType());
		classifyHodler.tvClassifyLoc.setText(mClassifyList.get(position)
				.getSummary());
		return convertView;
	}

	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

}
