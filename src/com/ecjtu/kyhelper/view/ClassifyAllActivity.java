package com.ecjtu.kyhelper.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.ClassifyListAdapter;
import com.ecjtu.kyhelper.model.Subject;

/**
 * TODO : ĳһ�����µ�����ҳ��
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��2��
 */
public class ClassifyAllActivity extends Activity implements
		OnItemClickListener {

	private static final String TAG = "ClassifyAllActivity"; // need it

	private TextView tvTitle;
	private ListView lvSubjectAllList;
	private ClassifyListAdapter classifyListAdapter;

	// ��¼��ClassifyActivity�д������ĵ�ǰ����������
	private String type;
	private List<Subject> subjectList = new ArrayList<Subject>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_all);

		// �õ����ϼ�Activity�д����Type����
		type = getIntent().getStringExtra("type");

		// ��ȡ��Ŀ����
		getSubjectsData();

		initView();

	}

	public void initView() {
		// ���ñ���
		tvTitle = (TextView) findViewById(R.id.tv_title);
		tvTitle.setText(getIntent().getStringExtra("title"));

		lvSubjectAllList = (ListView) findViewById(R.id.lv_subject_all);
		classifyListAdapter = new ClassifyListAdapter(this,
				(ArrayList<Subject>) subjectList, type);
		lvSubjectAllList.setAdapter(classifyListAdapter);
		lvSubjectAllList.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// toast("����ˣ� " + position);
		// ����ǰ�����Subject���󴫵ݸ���һ��Activity
		Intent toSubjectItem = new Intent(ClassifyAllActivity.this,
				SubjectItemActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable("subject", subjectList.get(position));
		bundle.putString("subjectID", subjectList.get(position).getObjectId()); // ID��Ҫ��������,�����ȡ������null
		Log.i(TAG, ">>����>>" + "subjectID: "
				+ subjectList.get(position).getObjectId() + " subjectName: "
				+ subjectList.get(position).getName());
		toSubjectItem.putExtras(bundle);
		startActivity(toSubjectItem);
	}

	private void getSubjectsData() {
		BmobQuery<Subject> query = new BmobQuery<Subject>();
		query.order("-updatedAt");
		Subject subject = new Subject();
		subject.setType(type);
		query.addWhereEqualTo("type", subject.getType()); // ��ѯ��ǰ���͵�֪ʶ��
		query.findObjects(this, new FindListener<Subject>() {

			@Override
			public void onSuccess(List<Subject> object) {
				// toast("��ѯ�ɹ�. ����" + object.size());
				if (object.size() == 0)
					toast("���ϻ�û������, ���ĵȴ���");
				subjectList = object;
				// ֪ͨAdapter���ݸ���
				classifyListAdapter.refresh((ArrayList<Subject>) subjectList);
				classifyListAdapter.notifyDataSetChanged();

			}

			@Override
			public void onError(String msg) {
				toast("��ѯʧ��:" + msg);
			}

		});
	}

	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};

}
