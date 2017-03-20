package com.zexh.yuexinwen.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.zexh.yuexinwen.Activitys.TestActivity;
import com.zexh.yuexinwen.R;
import com.zexh.yuexinwen.yuntongxin.ui.LauncherActivity;
import com.zexh.yuexinwen.yuntongxin.ui.account.LoginActivity;

/**
 * Created by Administrator on 2017/3/11.
 */
public class ChatFragment extends Fragment implements View.OnClickListener{
    Context context;
    private WebView webView;
    private Button redbtn,colorbtn_login;
    public ChatFragment() {}
    @SuppressLint("ValidFragment")
    public ChatFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  view = inflater.inflate(R.layout.main_chatfragment,null);
        redbtn = (Button) view.findViewById(R.id.red);
        colorbtn_login = (Button) view.findViewById(R.id.color);
        webView = (WebView) view.findViewById(R.id.webchatview);
        redbtn.setOnClickListener(this);
        colorbtn_login.setOnClickListener(this);
        initWebView();
        webView.loadUrl("file:///android_asset/new_file.html");
        return view;
    }
    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);
        ButtononClick click = new ButtononClick();
        webView.addJavascriptInterface(click,click.toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.red:
                webView.loadUrl("javascript:setRed()");
            break;
            case R.id.color:
                webView.loadUrl("javascript:setColor('#00f','这是android 原生调用JS代码的触发事件')");
                break;

        }
    }

    class  ButtononClick{
        //这是 button.click0() 的触发事件
        //H5调用方法：javascript:button.click0()
        @JavascriptInterface
        public void click0(){
            shows();
        }
        //这是 button.click0() 的触发事件，可以传递待参数
        //H5调用方法：javascript:button.click0('参数1','参数2')
        @JavascriptInterface
        public void click0(String data1,String data2){
            show(data1,data2);
        }
        //必须添加，这样才可以标志这个类的名称是 button
        @JavascriptInterface
        public String toString(){
            return "button";
        }
    }

    private void shows() {
        Toast.makeText(context,"点击进行支付",Toast.LENGTH_SHORT);
    }

    private void show(String title,String data) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(data)
                .setPositiveButton("确定",null)
                .create().show();
    }
}
