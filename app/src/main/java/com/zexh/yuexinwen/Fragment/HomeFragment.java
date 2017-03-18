package com.zexh.yuexinwen.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zexh.yuexinwen.Activitys.ListListActivity;
import com.zexh.yuexinwen.R;

/**
 * Created by Administrator on 2017/3/11.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    Context context;
    private Button listListViw,listGriview,expandableListView,expandableGridView;
    public HomeFragment(){}
    @SuppressLint("ValidFragment")
    public HomeFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.main_homefragment,null);
        listListViw = (Button) view.findViewById(R.id.listlist);
        listGriview = (Button) view.findViewById(R.id.listgrid);
        expandableListView = (Button) view.findViewById(R.id.expandableListView);
        expandableGridView = (Button) view.findViewById(R.id.expandableGridView);
        initOnclickListener();


        return view;
    }

    private void initOnclickListener() {
        listListViw.setOnClickListener(this);
        listGriview.setOnClickListener(this);
        expandableListView.setOnClickListener(this);
        expandableGridView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.listlist:
                Intent intent = new Intent();
                intent.setClass(getActivity(), ListListActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.listgrid:

                break;

            case R.id.expandableListView:

                break;

            case R.id.expandableGridView:

                break;
        }
    }
}
