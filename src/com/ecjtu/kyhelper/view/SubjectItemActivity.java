package com.ecjtu.kyhelper.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.ViewPagerAdapter;
import com.ecjtu.kyhelper.model.Subject;
import com.ecjtu.ui.ViewPagerCompat;

@SuppressLint({ "InflateParams", "SimpleDateFormat" })
public class SubjectItemActivity extends Activity implements OnClickListener {

	private static final String TAG = "ClassifyItemActivity";

	// ViewPagerҳ
	private View view2;
	private ViewPagerCompat viewPager; // viewpager
	private ViewPagerAdapter subjectViewPagerAdapter;
	private PagerTabStrip pagerTabStrip; // һ��viewpager��ָʾ����Ч������һ����Ĵֵ��»���
	private List<View> viewList; // ����Ҫ������ҳ����ӵ����list��
	private List<String> titleList; // viewpager�ı���

	// �ؼ�
	private TextView tvSubjectName;
	private TextView tvSubjectInfo;
	private TextView tvSubjectLoc;
	private Button btnCommit;
	private EditText etCommit;
	private LinearLayout llCommitParent; // ���۸����Բ���
	@SuppressWarnings("unused")
	private LinearLayout llCommitSon; // ���������Բ���

	// ���ϼ�ҳ���д��������
	private Subject subject; // ����ѡ���Subject
	private String subjectID; // ��ǰѡ���Subject��ID

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_item);

		// ��ȡ����ClassifyAllActivity�д��ݹ�����Subject����
		subject = (Subject) getIntent().getSerializableExtra("subject");
		subjectID = getIntent().getStringExtra("subjectID");
		Log.i(TAG, "<<�յ�<<" + "subjectID: " + subject.getObjectId()
				+ " subjectName: " + subject.getName());
		Log.i(TAG, "<<�յ�<<" + "subjectID: " + subjectID + " subjectName: "
				+ subject.getName());

		initView();

		// ��ʼ��ҳ���Լ���������
		initContentView();

	}

	@SuppressLint("InflateParams")
	public void initView() {

		viewPager = (ViewPagerCompat) findViewById(R.id.viewpager);
		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
		pagerTabStrip.setTabIndicatorColor(Color.YELLOW);
		pagerTabStrip.setDrawFullUnderline(false);
		pagerTabStrip.setBackgroundColor(Color.WHITE);
		pagerTabStrip.setTextSpacing(50);

		// view1 =
		// LayoutInflater.from(this).inflate(R.layout.viewpager_menu,null);
		view2 = LayoutInflater.from(this).inflate(
				R.layout.viewpager_subjectinfo, null);

		viewList = new ArrayList<View>();// ��Ҫ��ҳ��ʾ��Viewװ��������
		// viewList.add(view1);
		viewList.add(view2);

		titleList = new ArrayList<String>();// ÿ��ҳ���Title����
		// titleList.add("Ŀ¼");
		titleList.add("����");
		subjectViewPagerAdapter = new ViewPagerAdapter(viewList, titleList);

		viewPager.setAdapter(subjectViewPagerAdapter);

	}

	public void initContentView() {

		tvSubjectName = (TextView) view2.findViewById(R.id.tv_subject_title);
		tvSubjectInfo = (TextView) view2
				.findViewById(R.id.tv_subject_introduce);
		tvSubjectLoc = (TextView) view2.findViewById(R.id.tv_subject_location);
		tvSubjectName.setText(subject.getName()); // ����֪ʶ����
		tvSubjectInfo.setText(subject.getContent()); // ����֪ʶ������
		tvSubjectLoc.setText("�����ǣ�" + subject.getSummary()); // ����֪ʶ��Ŀ¼����

		btnCommit = (Button) view2.findViewById(R.id.btn_commit);
		btnCommit.setOnClickListener(this);

		// ��ȡ�����۵Ĳ���
		etCommit = (EditText) view2.findViewById(R.id.et_commit);
		llCommitParent = (LinearLayout) view2
				.findViewById(R.id.ll_commit_parent_view);
		llCommitSon = (LinearLayout) findViewById(R.id.ll_commit_son_view);

	}

	/**
	 * ���һ������
	 * 
	 * @param user
	 * @param content
	 */
	public void insertCommit(String user, String content) {
		View view = LayoutInflater.from(this).inflate(R.layout.commit, null);
		TextView tvUser = (TextView) view.findViewById(R.id.tv_commit_user);
		TextView tvContent = (TextView) view
				.findViewById(R.id.tv_commit_content);
		tvUser.setText(user);
		tvContent.setText(content);
		llCommitParent.addView(view);
		tvUser = null;
		tvContent = null;
	}

	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_commit:
			if (etCommit.getText().toString().equals("")) {
				toast("����һ���");
			} else {
				// SimpleDateFormat formatter = new SimpleDateFormat(
				// "yyyy��MM��dd��  HH:mm:ss ");
				// Date curDate = new Date(System.currentTimeMillis());// ��ȡ��ǰʱ��
				// String time = formatter.format(curDate);
				String content = etCommit.getText().toString();
				// + "[" + time
				// + "]";
				insertCommit("��" + ":", content);
				etCommit.setText("");
			}
			break;

		default:
			break;
		}

	}

}
