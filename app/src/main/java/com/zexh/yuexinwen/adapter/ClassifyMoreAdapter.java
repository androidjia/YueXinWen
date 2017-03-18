package com.zexh.yuexinwen.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zexh.yuexinwen.R;

/**
 * Created by Administrator on 2017/3/18.
 */
public class ClassifyMoreAdapter extends BaseAdapter {
    private Context context;
    private String[] text_list;
    private int position = 0;
    Holder holder;

    public ClassifyMoreAdapter(Context context, String[] text_list) {
        this.context = context;
        this.text_list = text_list;
    }

    @Override
    public int getCount() {
        return text_list.length;
    }

    @Override
    public Object getItem(int i) {
        return text_list[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = View.inflate(context,R.layout.item_classify_morelist,null);
            holder = new Holder(view);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.txt.setText(text_list[i]);
        holder.txt.setTextColor(0xFF666666);
        if (i==position){
            holder.txt.setTextColor(0xFFFF8C00);
        }
        return view;
    }

    public void setSelectItem(int position) {
        this.position = position;
    }
    private static class Holder{
        TextView txt;
        public Holder(View view){
            txt = (TextView) view.findViewById(R.id.moreitem_txt);
        }
    }
}
