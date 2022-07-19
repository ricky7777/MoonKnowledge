package com.cathaybk.dbs.beanknowledge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.cathaybk.dbs.beanknowledge.R;

/**
 * Created by Ricky on 2022/7/19.
 */
public class AnimationListAdapter extends BaseAdapter {
    private int[] imgs = {R.drawable.countdown_0, R.drawable.countdown_1, R.drawable.countdown_2, R.drawable.countdown_3};

    private Context mContext;

    public AnimationListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.animation_listview_item, null);
            holder.img = (ImageView) convertView.findViewById(R.id.animation_listview_item_img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img.setImageResource(imgs[position]);
        return convertView;
    }

    class ViewHolder {
        public ImageView img;
    }
}
