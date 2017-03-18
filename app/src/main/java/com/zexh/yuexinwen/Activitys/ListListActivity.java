package com.zexh.yuexinwen.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zexh.yuexinwen.Model.Model;
import com.zexh.yuexinwen.R;
import com.zexh.yuexinwen.adapter.ClassifyMainAdapter;
import com.zexh.yuexinwen.adapter.ClassifyMoreAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListListActivity extends AppCompatActivity {
    private ListView mainList,moreList;
    private List<Map<String,Object>> mainListdata;
    ClassifyMainAdapter mainAdapter;
    ClassifyMoreAdapter moreAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_list);
        initModle();
        initView();
    }

    private void initView() {
        mainList = (ListView) findViewById(R.id.classify_mainlist);
        moreList = (ListView) findViewById(R.id.classify_morelist);
        mainAdapter = new ClassifyMainAdapter(ListListActivity.this,mainListdata);
        mainList.setAdapter(mainAdapter);
        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                initAdapter(Model.MORELISTTXT[i]);
                mainAdapter.setSelectItem(i);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mainList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 一定要设置这个属性，否则ListView不会刷新
        initAdapter(Model.MORELISTTXT[0]);
        moreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                moreAdapter.setSelectItem(i);
                moreAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initAdapter(String[] array) {
        moreAdapter = new ClassifyMoreAdapter(this,array);
        moreList.setAdapter(moreAdapter);
        moreAdapter.notifyDataSetChanged();
    }

    private void initModle() {
        mainListdata = new ArrayList<>();
        for (int i=0;i< Model.LISTVIEWIMG.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("img",Model.LISTVIEWIMG[i]);
            map.put("txt",Model.LISTVIEWTXT[i]);
            mainListdata.add(map);
        }
    }
}
