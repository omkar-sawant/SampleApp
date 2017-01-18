package com.example.a653401.sampleapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by A653401 on 18-01-2017.
 */

public class ChildListItemViewHolder extends BaseViewHolder

{
    public ChildListItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Bind(R.id.childItemTitle)
    TextView childItemTitle;

    @Bind(R.id.childItemImageview)
    ImageView childItemImageView;
}
