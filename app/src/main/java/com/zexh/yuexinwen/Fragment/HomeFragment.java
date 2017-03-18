package com.zexh.yuexinwen.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zexh.yuexinwen.R;

/**
 * Created by Administrator on 2017/3/11.
 */
public class HomeFragment extends Fragment {
    Context context;
    public HomeFragment(){}
    @SuppressLint("ValidFragment")
    public HomeFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.main_homefragment,null);



        return view;
    }
}
