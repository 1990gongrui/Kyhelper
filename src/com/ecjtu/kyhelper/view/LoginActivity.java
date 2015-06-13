package com.ecjtu.kyhelper.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.InsertListener;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.Util;
import com.ecjtu.kyhelper.model.User;

/**
 * TODO : LoginActivity.java--��¼
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��29��
 */
public class LoginActivity extends Activity implements OnClickListener {

	private Button btnLogin;
	private Button btnReg;
	private EditText etUsername;
	private EditText etPassword;
	private String username;
	private String password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ��ʼ�� BmobSDK,�ڶ�����������Bmob�������˴�����Application ID
		Bmob.initialize(this, "d025748e46a151ab53b2038b002afe42");
		setContentView(R.layout.activity_login);
		btnLogin = (Button) findViewById(R.id.btn_login);
		btnReg = (Button) findViewById(R.id.btn_register);
		etUsername = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_password);
		btnLogin.setOnClickListener(this);
		btnReg.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		// ��½
		case R.id.btn_login:
			username = etUsername.getText().toString();
			password = etPassword.getText().toString();
			if (!Util.isNetworkConnected(this)) {
				toast("û�����簡==");
			} else if (username.equals("") || password.equals("")) {
				toast("��������ȷ�Ļ�����������");
				break;
			} else {
				User bu2 = new User();
				bu2.setUsername(username);
				bu2.setPassword(password);
				bu2.login(this, new InsertListener() {
					@Override
					public void onSuccess() {
						toast("����������������~");
						// ��ת����ҳ
						Intent toHome = new Intent(LoginActivity.this,
								BaseActivity.class);
						startActivity(toHome);
						finish();
					}

					@Override
					public void onFailure(String msg) {
						toast("������ȷ,�����޷�������֤~");
					}
				});
			}
			break;

		case R.id.btn_register:
			Intent toReg = new Intent(LoginActivity.this,
					RegisterActivity.class);
			startActivity(toReg);
			break;
		default:
			break;

		}
	}

	public void toast(String toast) {
		// TODO Auto-generated method stub
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};

}
