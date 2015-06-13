/**
 * 
 */
package com.ecjtu.kyhelper.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ecjtu.kyhelper.R;

/**
 * TODO : ���߹���--
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��28��
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebviewAppriseScore extends Activity {

	private String url = "http://blog.nicerdata.com/���߹���.html";
	// private ProgressDialog dialog;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webviews);
		init();
	}

	private void init() {
		webView = (WebView) findViewById(R.id.id_for_webview);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setDefaultFontSize(5);
		webView.loadUrl(url);
		// ʹ��ҳ������webView��ֱ�Ӵ�
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// ����ֵ��true��ʱ�������ҳ��webView��ȥ�򿪣����Ϊfalse�͵���ϵͳ�����
				view.loadUrl(url);
				return true;
			}

		});
		// ����֧��javaScript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		// WebView����ҳ������ʹ�û������
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

	}
}
