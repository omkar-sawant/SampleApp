package com.example.a653401.sampleapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by A653401 on 18-01-2017.
 */

public class ListAdapter extends BaseRecyclerViewAdapter implements BaseViewHolder.onViewHolderClickListener,BaseRecyclerViewAdapter.ListItemClickListener{

    private ArrayList<String> listItem;

    public ListAdapter(ArrayList<String> listItem){
        this.listItem = listItem;
    }
    Context ctx;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder;
        holder = new ListItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false));
        holder.setListener(this);
        ctx = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListItemViewHolder itemView = (ListItemViewHolder)holder;
        itemView.listItemTitle.setText(listItem.get(position));
        ArrayList<String> childTitle = new ArrayList<>();
        childTitle.add("Sub Child 1");childTitle.add("Sub Child 2");childTitle.add("Sub Child 3");
        childTitle.add("Sub Child 4");childTitle.add("Sub Child 5");childTitle.add("Sub Child 6");
        ChildLisstAdapter childListAdapter = new ChildLisstAdapter(childTitle);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(ctx,LinearLayoutManager.HORIZONTAL,false);
        itemView.childList.setLayoutManager(layoutManager);
        itemView.childList.setAdapter(childListAdapter);
        childListAdapter.setListItemClickListener(this);
/*        RecyclerViewDivider dividerItemDecoration = new RecyclerViewDivider(ctx, R.drawable.line_divider);
        itemView.childList.addItemDecoration(dividerItemDecoration);*/
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(ctx,
                DividerItemDecoration.HORIZONTAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(ctx, R.drawable.line_divider);
        horizontalDecoration.setDrawable(horizontalDivider);
        itemView.childList.addItemDecoration(horizontalDecoration);

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @Override
    public void onRecyclerViewItemClickListener(RecyclerView recyclerView, View view, int adapterposition) {
        Toast.makeText(ctx,"Child Item clicked!",Toast.LENGTH_SHORT).show();
    }
}
