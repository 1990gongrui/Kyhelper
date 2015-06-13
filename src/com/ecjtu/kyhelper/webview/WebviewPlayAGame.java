package com.ecjtu.kyhelper.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.ecjtu.kyhelper.R;

/**
 * TODO : �����Ϸ������
 * 
 * @author ECJTU IsayesHu
 * @date 2015��4��2��
 */

public class WebviewPlayAGame extends Activity {

	private String url = "http://blog.nicerdata.com/resources/ky/";
	private WebView webView;
	private ProgressDialog dialog;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wsq);

		webView = (WebView) findViewById(R.id.wv_wsq);
		// ����ʹ�ù�ִ��JS�ű�
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(url);
		// ʹ��ҳ������webView��ֱ�Ӵ�
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// ����ֵ��true��ʱ�������ҳ��webView��ȥ�򿪣����Ϊfalse�͵���ϵͳ�����
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
					dialog = new ProgressDialog(WebviewPlayAGame.this);
					dialog.setTitle("����������...");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.setProgress(newProgress);
					dialog.show();
				} else {
					dialog.setProgress(newProgress);
				}
			}
		});
	}
}
