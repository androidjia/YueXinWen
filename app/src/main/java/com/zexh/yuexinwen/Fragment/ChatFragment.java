package com.zexh.yuexinwen.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zexh.yuexinwen.Activitys.TestActivity;
import com.zexh.yuexinwen.R;
import com.zexh.yuexinwen.yuntongxin.ui.LauncherActivity;
import com.zexh.yuexinwen.yuntongxin.ui.account.LoginActivity;

/**
 * Created by Administrator on 2017/3/11.
 */
public class ChatFragment extends Fragment {
    Context context;
    private Button btn,btn_login;
    public ChatFragment() {}
    @SuppressLint("ValidFragment")
    public ChatFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  view = inflater.inflate(R.layout.main_chatfragment,null);
        btn = (Button) view.findViewById(R.id.chatfragment_into);
        btn_login = (Button) view.findViewById(R.id.chatfragment_Login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intents = new Intent();
                intents.setClass(getActivity(), TestActivity.class);
                getActivity().startActivity(intents);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),LauncherActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}
