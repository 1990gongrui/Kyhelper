package com.ecjtu.kyhelper.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.listener.InsertListener;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.model.User;
import com.ecjtu.kyhelper.Util;

/**
 * TODO : RegisterActivity.java--ע��
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��29��
 */
public class RegisterActivity extends Activity implements OnClickListener {

	private Button btnReg;
	private EditText etUsername;
	private EditText etPassword;
	private EditText etComfirmPsd;
	private EditText etPhone;
	private String username = null;
	private String password = null;
	private String comfirmPsd = null;
	private String phone = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);

		etUsername = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_password);
		etComfirmPsd = (EditText) findViewById(R.id.et_comfirm_psd);
		etPhone = (EditText) findViewById(R.id.et_phone);
		btnReg = (Button) findViewById(R.id.btn_reg_now);
		btnReg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_reg_now:
			username = etUsername.getText().toString();
			password = etPassword.getText().toString();
			comfirmPsd = etComfirmPsd.getText().toString();
			phone = etPhone.getText().toString();
			if (!Util.isNetworkConnected(this)) {
				toast("û������==");
			} else if (username.equals("") || password.equals("")
					|| comfirmPsd.equals("") || phone.equals("")) {
				toast("�����������������õ����֤��");
			} else if (!comfirmPsd.equals(password)) {
				toast("�����������벻һ��");
			} else if (!Util.isPhoneNumberValid(phone)) {
				toast("��������ȷ���ֻ�����");
			} else {
				// ��ʼ�ύע����Ϣ
				User bu = new User();
				bu.setUsername(username);
				bu.setPassword(password);
				bu.setPhone(phone);
				bu.signUp(this, new InsertListener() {
					@Override
					public void onSuccess() {
						toast("�����õ����֤��, �����������ֻ�ӭ��");
						Intent backLogin = new Intent(RegisterActivity.this,
								LoginActivity.class);
						startActivity(backLogin);
						RegisterActivity.this.finish();
					}

					@Override
					public void onFailure(String msg) {
						toast("���˽����ȵ���, ������½����.");
					}
				});
			}
			break;

		default:
			break;
		}
	}

	public void toast(String toastText) {
		// TODO Auto-generated method stub
		Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
	};

}
