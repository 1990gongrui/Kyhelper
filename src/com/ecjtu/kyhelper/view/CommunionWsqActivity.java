package com.ecjtu.kyhelper.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.ecjtu.kyhelper.R;

/**
 * TODO : CommunionWsqActivity--΢�����������������б�ʤ��
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��29��
 */

@SuppressLint("SetJavaScriptEnabled")
public class CommunionWsqActivity extends Activity {

	private WebView wsqWebView;
	private static final String URL_WSQ = "http://m.wsq.qq.com/264442267";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wsq);

		wsqWebView = (WebView) findViewById(R.id.wv_wsq);
		// ����ʹ�ù�ִ��JS�ű�
		wsqWebView.getSettings().setJavaScriptEnabled(true);
		// ����ʹ֧������
		wsqWebView.getSettings().setBuiltInZoomControls(true);
		wsqWebView.getSettings().setDefaultFontSize(5);
		wsqWebView.loadUrl(URL_WSQ);
		wsqWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// ʹ�õ�ǰ WebView ������ת
				view.loadUrl(url);
				// true ��ʾ���¼��ڴ˴�����������Ҫ�ٹ㲥
				return true;
			}

			// ת�����ʱ�Ĵ���
			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(CommunionWsqActivity.this,
						"Oh no! " + description, Toast.LENGTH_SHORT).show();
			}
		});
	}

}
