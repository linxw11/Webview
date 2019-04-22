package com.example.linxw.webview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

public class MyWebView extends WebView {

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollListener != null) {
            Log.e("www", ""+this.getScrollY());
            mScrollListener.onScrollChanged(this.getScrollY());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e("MyWebView", "onTouchEvent" + super.onTouchEvent(ev));
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(this.getScrollY() <= 0){
                    this.scrollTo(0,1);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(ev);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        Log.e("MyWebView", "dispatchTouchEvent" + super.dispatchTouchEvent(ev));
        return super.dispatchTouchEvent(ev);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("MyWebView", "onInterceptTouchEvent" + super.onInterceptTouchEvent(ev));
        return super.onInterceptTouchEvent(ev);
    }

    public interface IScrollListener {
        void onScrollChanged(int scrollY);
    }

    private IScrollListener mScrollListener;

    public void setOnScrollListener(IScrollListener listener) {
        mScrollListener = listener;
    }
}
