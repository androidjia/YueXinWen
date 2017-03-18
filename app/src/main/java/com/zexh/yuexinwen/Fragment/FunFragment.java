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
import android.widget.TextView;
import android.widget.Toast;

import com.zexh.yuexinwen.Activitys.TestActivity;
import com.zexh.yuexinwen.R;

/**
 * Created by Administrator on 2017/3/11.
 */
public class FunFragment extends Fragment {
    Context context;
    private TextView textView;
    public FunFragment() {}

    @SuppressLint("ValidFragment")
    public FunFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mian_funfragment,null);
        textView = (TextView) view.findViewById(R.id.funfragment_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intents = new Intent();
                intents.setClass(getActivity(), TestActivity.class);
                getActivity().startActivity(intents);
            }
        });

        return view;
    }
}
