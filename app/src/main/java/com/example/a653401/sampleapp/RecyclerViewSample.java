package com.example.a653401.sampleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class RecyclerViewSample extends Fragment implements BaseRecyclerViewAdapter.ListItemClickListener{

    private RecyclerView mainList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.list_view,container,false);
        mainList = (RecyclerView)view.findViewById(R.id.mainlist);
        ArrayList<String> childTitle = new ArrayList<>();
        childTitle.add("Child 1");childTitle.add("Child 2");childTitle.add("Child 3");
        childTitle.add("Child 4");childTitle.add("Child 5");childTitle.add("Child 6");
        childTitle.add("Child 7");childTitle.add("Child 8");childTitle.add("Child 9");
        childTitle.add("Child 10");childTitle.add("Child 11");childTitle.add("Child 12");
        ListAdapter childListAdapter = new ListAdapter(childTitle);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mainList.setLayoutManager(layoutManager);
        mainList.setAdapter(childListAdapter);
        childListAdapter.setListItemClickListener(this);
        RecyclerViewDivider dividerItemDecoration = new RecyclerViewDivider(getContext(), R.drawable.line_divider);
        mainList.addItemDecoration(dividerItemDecoration);
        return view;
    }

    @Override
    public void onRecyclerViewItemClickListener(RecyclerView recyclerView, View view, int adapterposition) {
        Toast.makeText(getContext(),"Item clicked!",Toast.LENGTH_SHORT).show();
    }
}
