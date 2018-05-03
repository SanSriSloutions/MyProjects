package com.example.srinivasracharla.navigationviewexample.Fragments;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
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
public class HandSetFragment extends Fragment {

    RecyclerView recyclerView;
    HandsetAdapter handsetAdapter;
    List<HandSets> handSetsList;
    Context mContext;
    EditText searchEditText;

    public HandSetFragment() {
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
        View view = inflater.inflate(R.layout.fragment_handset, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeViews();
        prepareHandSetData();
    }

    private void initializeViews() {
        searchEditText = getView().findViewById(R.id.editTextSearch);
        handSetsList = new ArrayList<>();
        handsetAdapter = new HandsetAdapter(mContext, handSetsList);
        recyclerView = getView().findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext.getApplicationContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
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
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    findBrands();
                    return true;
                }
                return false;
            }
        });

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                /*if (editable.toString().isEmpty()) {
                    handsetAdapter.filterList(handSetsList);
                }*/
                filter(editable.toString().toLowerCase());

            }
        });
    }


    private void findBrands() {
        String req_brand = searchEditText.getText().toString().toLowerCase();
        List<HandSets> filterHandsets = new ArrayList<>();
        for (int i = 0; i < handSetsList.size(); i++) {
            String name = handSetsList.get(i).getName().toLowerCase();
            if (name.contains(req_brand)) filterHandsets.add(handSetsList.get(i));
        }
        //calling a method of the adapter class and passing the filtered list
        if (filterHandsets.size() != 0) {
            handsetAdapter.filterList(filterHandsets);
        } else {
            Toast.makeText(mContext.getApplicationContext(), "need to call Api", Toast.LENGTH_SHORT).show();
        }
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


    private void prepareHandSetData() {
        HandSets handSet = new HandSets(R.drawable.ic_launcher, "Lenovo", true, 75, 1000, prePareGradientColor(0xffFFC382, 0xffF8809C));
        handSetsList.add(handSet);
        handSet = new HandSets(R.drawable.ic_launcher, "Samsung", true, 75, 1000, prePareGradientColor(0xffCDD5EB, 0xff90A2FC));
        handSetsList.add(handSet);
        handSet = new HandSets(R.drawable.ic_launcher, "Oppo", true, 75, 1000, prePareGradientColor(0xffCCECCE, 0xff8FE57C));
        handSetsList.add(handSet);
        handSet = new HandSets(R.drawable.ic_launcher, "Apple", true, 75, 1000, prePareGradientColor(0xffCAE1F2, 0xff81B3E7));
        handSetsList.add(handSet);
        handSet = new HandSets(R.drawable.ic_launcher, "Lenovo", true, 75, 1000, prePareGradientColor(0xffFFC382, 0xffF8809C));
        handSetsList.add(handSet);
        handSet = new HandSets(R.drawable.ic_launcher, "Samsung", true, 75, 1000, prePareGradientColor(0xffCDD5EB, 0xff90A2FC));
        handSetsList.add(handSet);
        handSet = new HandSets(R.drawable.ic_launcher, "Oppo", true, 75, 1000, prePareGradientColor(0xffCCECCE, 0xff8FE57C));
        handSetsList.add(handSet);
        handSet = new HandSets(R.drawable.ic_launcher, "Apple", true, 75, 1000, prePareGradientColor(0xffCAE1F2, 0xff81B3E7));
        handSetsList.add(handSet);
        handsetAdapter.notifyDataSetChanged();
    }

    /**
     * @param startColor
     * @param endColor
     * @return create gradient drawable based on startColor, endColor
     */
    private GradientDrawable prePareGradientColor(int startColor, int endColor) {
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{startColor, endColor});

        return gradientDrawable;
    }


}
