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
    private List<Test> size;
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }

    public MyAdapter(List<Test> size, Context context) {
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
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.text.setText(size.get(position).getName());
        Glide.with(context).load(R.mipmap.bb).asBitmap().into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myOnClick != null) {
                    myOnClick.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return size.size();
    }

    //  删除指定的Item
    public void removeData(int position) {
        size.remove(position);
        //  通知RecyclerView控件某个Item已经被删除
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    //  在指定位置添加一个新的Item
    public void addItem(Test test, int positionToAdd) {
        size.add(positionToAdd,test);
        //  通知RecyclerView控件插入了某个Item
        notifyItemInserted(positionToAdd);
        notifyDataSetChanged();
    }

    public interface MyOnClick {
        void onClick(int position);
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
