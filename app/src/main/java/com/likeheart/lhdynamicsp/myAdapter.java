package com.likeheart.lhdynamicsp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    ArrayList<DataModel> list;
    Context context;
    int id;

    public myAdapter(ArrayList<DataModel> list, Context context, int id) {
        this.list = list;
        this.context = context;
        this.id = id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(id==0){
            holder.cb_like.setChecked(list.get(position).isCb_like());
            holder.cb_heart.setVisibility(View.GONE);
//            holder.cb_heart.setChecked(list.get(position).isCb_heart());
            holder.tv_id.setText(list.get(position).getId());
        }

        if(id==1){
            holder.cb_like.setVisibility(View.GONE);
            holder.cb_heart.setChecked(list.get(position).isCb_heart());
            holder.tv_id.setText(list.get(position).getId());
        }

        if(id==2){
            holder.cb_like.setChecked(list.get(position).isCb_like());
            holder.cb_heart.setChecked(list.get(position).isCb_heart());
            holder.tv_id.setText(list.get(position).getId());
        }
    }

    @Override
    public int getItemCount() {
        return(null != list?list.size():0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id;
        CheckBox cb_like,cb_heart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            cb_heart = itemView.findViewById(R.id.cb_heart);
            cb_like = itemView.findViewById(R.id.cb_like);
        }
    }
}
