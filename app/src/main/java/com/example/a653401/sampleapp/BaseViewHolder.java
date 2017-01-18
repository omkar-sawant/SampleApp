package com.example.a653401.sampleapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by A653401 on 18-01-2017.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }
    public interface onViewHolderClickListener{
        void onViewHolderClick(View view, int adapterPosition);
    }
    protected onViewHolderClickListener listener;

    public void setListener(onViewHolderClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onViewHolderClick(view,getAdapterPosition());
    }
}
