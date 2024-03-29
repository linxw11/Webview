package com.example.linxw.webview.vassonic;


import android.os.Bundle;
import android.webkit.WebView;

import com.tencent.sonic.sdk.SonicSessionClient;

import java.util.HashMap;

public class SonicSessionClientImpl extends SonicSessionClient {

    private WebView webView;
    public void bindWebView(WebView webView) {
        this.webView = webView;
    }

    public WebView getWebView() {
        return this.webView;
    }
    @Override
    public void loadUrl(String url, Bundle extraData) {
        webView.loadUrl(url);
    }

    @Override
    public void loadDataWithBaseUrl(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        webView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    @Override
    public void loadDataWithBaseUrlAndHeader(String baseUrl, String data, String mimeType, String encoding, String historyUrl, HashMap<String, String> headers){
        webView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }
}
