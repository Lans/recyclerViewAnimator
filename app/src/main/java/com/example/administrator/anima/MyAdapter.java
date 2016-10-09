package com.example.administrator.anima;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private LayoutInflater inflater;
    private Context context;
    private String[] size;

    public MyAdapter(String[] size, Context context) {
        this.size = size;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.itms, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.text.setText(size[position]);
        Glide.with(context).load(R.mipmap.bb).asBitmap().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return size.length;
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;

        public MyHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
