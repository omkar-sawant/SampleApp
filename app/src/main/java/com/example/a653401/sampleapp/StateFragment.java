package com.example.a653401.sampleapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A653401 on 16-01-2017.
 */

public class StateFragment extends Fragment {

    ListView stateList;
    ArrayList<String> stateArray;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.state_fragment,container,false);
        ((TextView)view.findViewById(R.id.txt1)).setText("sttrhsrhrthrhstsrhsrthsrtsrttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttshtrsrthsrhst" +
                "shrthhhhhhhhhhhhhhhhhhhhhhhhhh" +
                "strhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" +
                "strhrrrrrrrrrrrrrrrrrrrrrrrrrr");
/*        stateList = (ListView) view.findViewById(R.id.stateList);
        stateArray = new ArrayList<>();
        stateArray.add("A");stateArray.add("B");stateArray.add("C");stateArray.add("D");
        stateArray.add("E");stateArray.add("F");stateArray.add("G");stateArray.add("H");
        stateArray.add("A");stateArray.add("B");stateArray.add("C");stateArray.add("D");
        stateArray.add("E");stateArray.add("F");stateArray.add("G");stateArray.add("H");
        StateAdapter stateAdapter = new StateAdapter(getActivity(),android.R.layout.simple_list_item_1,stateArray);
        stateList.setAdapter(stateAdapter);*/
        return view;
    }
/*    public class StateAdapter extends ArrayAdapter<String>{

        public StateAdapter(Context context, int resource, ArrayList<String> states) {
            super(context, resource, states);
        }
    }*/
}
