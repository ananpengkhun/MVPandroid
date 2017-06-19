package com.example.ananpengkhun.mvpwithdialogfragment.main;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ananpengkhun.mvpwithdialogfragment.DataDao;
import com.example.ananpengkhun.mvpwithdialogfragment.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ananpengkhun on 6/16/17.
 */

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DataDao> data;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
        return new DataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DataViewHolder){
            DataViewHolder dataViewHolder = (DataViewHolder) holder;
            dataViewHolder.tvName.setText(data.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        if(data == null){
            return 0;
        }
        return data.size();
    }

    public void setData(List<DataDao> data) {
        this.data = data;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name) TextView tvName;
        public DataViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}
