package com.zexh.yuexinwen.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zexh.yuexinwen.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/18.
 */
public class ClassifyMainAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> list;
    private int position = 0;
    private boolean islodingimg = true;
    Holder holder;

    public ClassifyMainAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
    }

    public ClassifyMainAdapter(Context context, List<Map<String, Object>> list, boolean islodingimg) {
        this.context = context;
        this.list = list;
        this.islodingimg = islodingimg;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view  = View.inflate(context,R.layout.item_classify_mainlist,null);
            holder = new Holder(view);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        if (islodingimg ==true){
            holder.img.setImageResource(Integer.parseInt(list.get(i).get("img").toString()));
        }
        holder.txt.setText(list.get(i).get("txt").toString());
        holder.layout.setBackgroundColor(0xFFEBEBEB);
        if (i == position ){
            holder.layout.setBackgroundColor(0xFFFFFFFF);
        }
        return view;
    }
    public void setSelectItem(int position){
        this.position = position;
    }
    public int getSelectItem(){
        return position;
    }
    private static class Holder{
        LinearLayout layout;
        ImageView img;
        TextView txt;
        public Holder(View view){
            txt = (TextView) view.findViewById(R.id.mainitem_txt);
            img = (ImageView) view.findViewById(R.id.mainitem_img);
            layout = (LinearLayout) view.findViewById(R.id.mainitem_layout);

        }
    }
}
