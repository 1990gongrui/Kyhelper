package com.ecjtu.kyhelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * TODO : Util.java--�����࣬�����Ƿ���Ч�������Ƿ�����
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��29��
 */
public class Util {

	// �жϵ绰�����Ƿ���Ч
	public static boolean isPhoneNumberValid(String phoneNumber) {

		boolean isValid = false;
		String expression = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
		// CharSequence��ֵ�ǿɶ���д���У���String��ֵ��ֻ������
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}

	// �ж������Ƿ�����
	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			// ConnectivityManager��Ҫ���������������صĲ���
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

}
