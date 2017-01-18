package com.example.a653401.sampleapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by A653401 on 18-01-2017.
 */

public class ListItemViewHolder extends BaseViewHolder {
    public ListItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    @Bind(R.id.ListItemTitle)
    TextView listItemTitle;

    @Bind(R.id.childlist)
    RecyclerView childList;
}
