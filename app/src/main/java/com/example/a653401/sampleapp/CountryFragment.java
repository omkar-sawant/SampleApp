package com.example.a653401.sampleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by A653401 on 16-01-2017.
 */

public class CountryFragment extends Fragment {
    ListView countryList;
    ArrayList<String> countryArray;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.country_fragment,container,false);
        countryList = (ListView) view.findViewById(R.id.countryList);
        countryArray = new ArrayList<>();
        countryArray.add("Country A");countryArray.add("Country B");countryArray.add("Country C");countryArray.add("Country D");
        countryArray.add("Country E");countryArray.add("Country F");countryArray.add("Country G");countryArray.add("Country H");
        countryArray.add("Country A");countryArray.add("Country B");countryArray.add("Country C");countryArray.add("Country D");
        countryArray.add("Country E");countryArray.add("Country F");countryArray.add("Country G");countryArray.add("Country H");
        ArrayAdapter stateAdapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,countryArray);
        countryList.setAdapter(stateAdapter);
        return view;
    }
}
