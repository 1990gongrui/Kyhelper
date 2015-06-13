package com.ecjtu.kyhelper.webview;

import com.ecjtu.kyhelper.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * TODO : ������Ѷ
 * 
 * @author ECJTU IsayesHu
 * @date 2015��3��31��
 */
public class WebviewXinWenZiXun extends Activity {
	private String url = "http://blog.nicerdata.com/������Ѷ.html";
	private WebView webView;
	private ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webviews);
		init();
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void init() {
		webView = (WebView) findViewById(R.id.id_for_webview);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setDefaultFontSize(5);
		webView.loadUrl(url);
		// ʹ��ҳ������webView��ֱ�Ӵ�
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// ����ֵ��true��ʱ�������ҳ��webView��ȥ�򿪣����
				// Ϊfalse�͵���ϵͳ �����
				view.loadUrl(url);
				return true;
			}
			// WebViewClient����WebViewȥ����һЩҳ����ƺ�����֪ͨ

		});
		// ����֧��javaScript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		// WebView����ҳ������ʹ�û������
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {

				// newProgress 1-100֮�������
				if (newProgress == 100) {
					// ��ҳ�������
					closeDialog();
				} else {
					// ��ҳ���ڼ���,��ProgressDialog
					openDialog(newProgress);
				}
				super.onProgressChanged(view, newProgress);
			}

			private void closeDialog() {
				if (dialog != null && dialog.isShowing()) {
					dialog.dismiss();
					dialog = null;
				}
			}

			private void openDialog(int newProgress) {
				if (dialog == null) {
					dialog = new ProgressDialog(WebviewXinWenZiXun.this);
					dialog.setTitle("���ڼ���...");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.setProgress(newProgress);
					dialog.show();
				} else {
					dialog.setProgress(newProgress);
				}
			}
		});
	}

	// ��д���������ص��߼�
	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	//
	// if (keyCode == KeyEvent.KEYCODE_BACK) {
	// Toast.makeText(this, webView.getUrl(), Toast.LENGTH_SHORT).show();
	//
	// if (webView.canGoBack()) {
	// // ������һҳ��
	// webView.goBack();
	// return true;
	// } else {
	// System.exit(0);
	// }
	// }
	// return super.onKeyDown(keyCode, event);
	// }
}
