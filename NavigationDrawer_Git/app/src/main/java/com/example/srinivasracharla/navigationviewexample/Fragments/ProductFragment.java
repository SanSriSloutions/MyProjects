package com.example.srinivasracharla.navigationviewexample.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.srinivasracharla.navigationviewexample.Adapters.HandsetAdapter;
import com.example.srinivasracharla.navigationviewexample.Listners.RecyclerTouchListener;
import com.example.srinivasracharla.navigationviewexample.R;
import com.example.srinivasracharla.navigationviewexample.TestData.HandSets;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    RecyclerView recyclerView;
    HandsetAdapter handsetAdapter;
    List<HandSets> handSetsList;
    Context mContext;
    EditText searchEditText;

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeViews();
        prepareHandSetData();
    }

    private void prepareHandSetData() {
        HandSets handSet = new HandSets("Four Mobiles", 75, 1000, R.color.button_backgroundcolor);
        handSetsList.add(handSet);
        handSet = new HandSets("Samsung", 75, 1000, R.color.label_color_blue);
        handSetsList.add(handSet);
        handSet = new HandSets("Oppo", 75, 1000, R.color.subject_button_background);
        handSetsList.add(handSet);
        handSet = new HandSets("Apple", 75, 1000, R.color.button_backgroundcolor);
        handSetsList.add(handSet);
        handSet = new HandSets("Lenovo", 75, 1000, R.color.subject_button_background);
        handSetsList.add(handSet);

        handSet = new HandSets("Huawei", 75, 1000, R.color.label_color_blue);
        handSetsList.add(handSet);

        handSet = new HandSets("Lenovo", 75, 1000, R.color.button_backgroundcolor);
        handSetsList.add(handSet);

        handSet = new HandSets("Lenovo", 75, 1000, R.color.button_backgroundcolor);
        handSetsList.add(handSet);
        handSet = new HandSets("Lenovo", 75, 1000, R.color.button_backgroundcolor);
        handSetsList.add(handSet);
        handSet = new HandSets("Lenovo", 75, 1000, R.color.button_backgroundcolor);
        handSetsList.add(handSet);
        handsetAdapter.notifyDataSetChanged();
    }


    private void initializeViews() {
        searchEditText = getView().findViewById(R.id.editTextSearch);
        handSetsList = new ArrayList<>();
        handsetAdapter = new HandsetAdapter(mContext, handSetsList);
        recyclerView = getView().findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext.getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(handsetAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(mContext.getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                HandSets handSet = handSetsList.get(position);
                Toast.makeText(mContext.getApplicationContext(), handSet.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                HandSets handSet = handSetsList.get(position);
                Toast.makeText(mContext.getApplicationContext(), handSet.getNoOfModels() + " is selected!", Toast.LENGTH_SHORT).show();
            }
        }));

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString().toLowerCase());
            }
        });
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        List<HandSets> filterHandsets = new ArrayList<>();

        for (int i = 0; i < handSetsList.size(); i++) {
            String name = handSetsList.get(i).getName().toLowerCase();
            if (name.contains(text)) filterHandsets.add(handSetsList.get(i));
        }
        //calling a method of the adapter class and passing the filtered list
        handsetAdapter.filterList(filterHandsets);
    }


}
