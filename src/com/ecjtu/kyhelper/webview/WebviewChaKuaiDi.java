package com.ecjtu.kyhelper.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ecjtu.kyhelper.R;

/**
 * TODO : ����--
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��31��
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebviewChaKuaiDi extends Activity {

	private String url = "http://m.kuaidi100.com/all/";
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webviews);
		init();
	}

	private void init() {
		webView = (WebView) findViewById(R.id.id_for_webview);
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

	// ��д���������ص��߼�
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Toast.makeText(this, webView.getUrl(),
			// Toast.LENGTH_SHORT).show();

			if (webView.canGoBack()) {
				// ������һҳ��
				webView.goBack();
				return true;
			} else {
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
