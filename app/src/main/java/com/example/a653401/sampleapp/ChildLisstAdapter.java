package com.example.a653401.sampleapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by A653401 on 18-01-2017.
 */

public class ChildLisstAdapter extends BaseRecyclerViewAdapter implements BaseViewHolder.onViewHolderClickListener{

    ArrayList<String> childTitle;
    public ChildLisstAdapter(ArrayList<String> childTitleArrayList){
        childTitle = childTitleArrayList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder childHolder;
        childHolder = new ChildListItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.child_list_item,parent,false));
        childHolder.setListener(this);
        return childHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChildListItemViewHolder childHolder = (ChildListItemViewHolder)holder;
        childHolder.childItemTitle.setText(childTitle.get(position));
    }

    @Override
    public int getItemCount() {
        return childTitle.size();
    }
}
