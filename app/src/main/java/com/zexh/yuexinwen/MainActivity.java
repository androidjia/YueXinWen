package com.zexh.yuexinwen;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zexh.yuexinwen.Fragment.ChatFragment;
import com.zexh.yuexinwen.Fragment.FunFragment;
import com.zexh.yuexinwen.Fragment.HomeFragment;
import com.zexh.yuexinwen.JPush.ExampleUtil;
import com.zexh.yuexinwen.JPush.PushSetActivity;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.JPushInterface;
public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

//    private Button mInit;
//    private Button mSetting;
//    private Button mStopPush;
//    private Button mResumePush;
//    private Button mGetRid;
//    private TextView mRegId;
//    private EditText msgText;
    private RadioGroup radioGroup;
    private RadioButton button_home,botton_yule,botton_sendMessage;
    FragmentManager fragmentManager ;
    FragmentTransaction transaction;
    HomeFragment homeFragment;
    FunFragment funFragment;
    ChatFragment chatFragment;
    public static boolean isForeground = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

     //   initView();
     //   registerMessageReceiver();  // used for receive msg

    }


//    private void initView(){
//        TextView mImei = (TextView) findViewById(R.id.tv_imei);
//        String udid =  ExampleUtil.getImei(getApplicationContext(), "");
//        if (null != udid) mImei.setText("IMEI: " + udid);
//
//        TextView mAppKey = (TextView) findViewById(R.id.tv_appkey);
//        String appKey = ExampleUtil.getAppKey(getApplicationContext());
//        if (null == appKey) appKey = "AppKey异常";
//        mAppKey.setText("AppKey: " + appKey);
//
//        mRegId = (TextView) findViewById(R.id.tv_regId);
//        mRegId.setText("RegId:");
//
//        String packageName =  getPackageName();
//        TextView mPackage = (TextView) findViewById(R.id.tv_package);
//        mPackage.setText("PackageName: " + packageName);
//
//        String deviceId = ExampleUtil.getDeviceId(getApplicationContext());
//        TextView mDeviceId = (TextView) findViewById(R.id.tv_device_id);
//        mDeviceId.setText("deviceId:" + deviceId);
//
//        String versionName =  ExampleUtil.GetVersion(getApplicationContext());
//        TextView mVersion = (TextView) findViewById(R.id.tv_version);
//        mVersion.setText("Version: " + versionName);
//
//        mInit = (Button)findViewById(R.id.init);
//        mInit.setOnClickListener(this);
//
//        mStopPush = (Button)findViewById(R.id.stopPush);
//        mStopPush.setOnClickListener(this);
//
//        mResumePush = (Button)findViewById(R.id.resumePush);
//        mResumePush.setOnClickListener(this);
//
//        mGetRid = (Button) findViewById(R.id.getRegistrationId);
//        mGetRid.setOnClickListener(this);
//
//        mSetting = (Button)findViewById(R.id.setting);
//        mSetting.setOnClickListener(this);
//
//        msgText = (EditText)findViewById(R.id.msg_rec);
//    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.init:
//                init();
//                break;
//            case R.id.setting:
//                Intent intent = new Intent(MainActivity.this, PushSetActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.stopPush:
//                JPushInterface.stopPush(getApplicationContext());
//                break;
//            case R.id.resumePush:
//                JPushInterface.resumePush(getApplicationContext());
//                break;
//            case R.id.getRegistrationId:
//                String rid = JPushInterface.getRegistrationID(getApplicationContext());
//                if (!rid.isEmpty()) {
//                    mRegId.setText("RegId:" + rid);
//                } else {
//                    Toast.makeText(this, "Get registration fail, JPush init failed!", Toast.LENGTH_SHORT).show();
//                }
//                break;
//        }
//    }


    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init(){
        fragmentManager = getSupportFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.main_bottom_radio);
        radioGroup.setOnCheckedChangeListener(this);
        button_home = (RadioButton) findViewById(R.id.main_homepage);
        botton_sendMessage = (RadioButton) findViewById(R.id.main_sendMessage);
        botton_yule = (RadioButton) findViewById(R.id.main_yule);
        homeFragment = new HomeFragment(MainActivity.this);
        funFragment = new FunFragment(MainActivity.this);
        chatFragment = new ChatFragment(MainActivity.this);
        button_home.setEnabled(false);
        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.main_top_framelayout,homeFragment);
        transaction.add(R.id.main_top_framelayout,funFragment);
        transaction.add(R.id.main_top_framelayout,chatFragment);
        initFragmenthint();
        transaction.show(homeFragment);
        transaction.commit();
        JPushInterface.init(getApplicationContext());
    }

    private void initFragmenthint() {
        transaction.hide(homeFragment);
        transaction.hide(funFragment);
        transaction.hide(chatFragment);
    }

    private void initEnabled(){
       button_home.setEnabled(true);
       botton_sendMessage.setEnabled(true);
       botton_yule.setEnabled(true);
   }
    @Override
    public void onStop() {
        JPushInterface.stopPush(getApplicationContext());
        super.onStop();
    }

    @Override
    protected void onResume() {
        isForeground = true;
        JPushInterface.resumePush(getApplicationContext());
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
     //   unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }


    //for receive customer msg from jpush server
  //  private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        transaction = fragmentManager.beginTransaction();
        switch (i){
            case R.id.main_homepage:
                initEnabled();
                button_home.setEnabled(false);
                initFragmenthint();
                transaction.show(homeFragment);
                transaction.commit();
                break;
            case R.id.main_yule:
                initEnabled();
                botton_yule.setEnabled(false);
                initFragmenthint();
                transaction.show(funFragment);
                transaction.commit();
                break;
            case R.id.main_sendMessage:
                initEnabled();
                botton_sendMessage.setEnabled(false);
                initFragmenthint();
                transaction.show(chatFragment);
                transaction.commit();
                break;

        }
    }

//    public void registerMessageReceiver() {
//        mMessageReceiver = new MessageReceiver();
//        IntentFilter filter = new IntentFilter();
//        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
//        filter.addAction(MESSAGE_RECEIVED_ACTION);
//        registerReceiver(mMessageReceiver, filter);
//    }

//    public class MessageReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
//                String messge = intent.getStringExtra(KEY_MESSAGE);
//                String extras = intent.getStringExtra(KEY_EXTRAS);
//                StringBuilder showMsg = new StringBuilder();
//                showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
//                if (!ExampleUtil.isEmpty(extras)) {
//                    showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
//                }
//                setCostomMsg(showMsg.toString());
//            }
//        }
//    }

//    private void setCostomMsg(String msg){
//        if (null != msgText) {
//            msgText.setText(msg);
//            msgText.setVisibility(android.view.View.VISIBLE);
//        }
//    }

}
