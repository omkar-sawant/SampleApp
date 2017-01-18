package com.example.a653401.sampleapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by A653401 on 18-01-2017.
 */

public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> implements BaseViewHolder.onViewHolderClickListener {

    RecyclerView recyclerView;
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onViewHolderClick(View view, int adapterPosition) {
        listItemClickListener.onRecyclerViewItemClickListener(recyclerView,view,adapterPosition);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    public interface ListItemClickListener{
        void onRecyclerViewItemClickListener(RecyclerView recyclerView,View view,int adapterposition);
    }

    private ListItemClickListener listItemClickListener;

    public void setListItemClickListener(ListItemClickListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
    }
}
