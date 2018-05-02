package com.example.srinivasracharla.navigationviewexample.Fragments;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.srinivasracharla.navigationviewexample.Adapters.BrandsAdapter;
import com.example.srinivasracharla.navigationviewexample.Adapters.ProductListAdapter;
import com.example.srinivasracharla.navigationviewexample.R;
import com.example.srinivasracharla.navigationviewexample.TestData.ProductData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {

    RecyclerView recyclerView_products, recyclerView_brands;
    ProductListAdapter productListAdapter;
    BrandsAdapter brandsAdapter;
    List<ProductData> productDataList;
    List<Integer> brandsList;
    Context mContext;
    EditText searchEditText;

    private static final int VERTICAL_ITEM_SPACE = 30;

    public ProductListFragment() {
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
        return inflater.inflate(R.layout.fragment_product_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeViews();
        prepareProductData();
        prepareBrandsData();
    }

    private void prepareBrandsData() {

        int images[] = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};
        brandsList.add(R.drawable.profile);
        brandsList.add(R.drawable.profile);
        brandsList.add(R.drawable.profile);
        brandsList.add(R.drawable.profile);
        brandsList.add(R.drawable.profile);
        brandsList.add(R.drawable.profile);
        brandsAdapter.notifyDataSetChanged();
    }


    private void initializeViews() {
        searchEditText = getView().findViewById(R.id.editTextSearch);
        //brands
        recyclerView_brands = getView().findViewById(R.id.recycler_view_brands);
        brandsList = new ArrayList<>();
        brandsAdapter = new BrandsAdapter(mContext, brandsList);
        RecyclerView.LayoutManager layoutManager_brands = new LinearLayoutManager(mContext.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_brands.setLayoutManager(layoutManager_brands);
        recyclerView_brands.setAdapter(brandsAdapter);

        //products
        recyclerView_products = getView().findViewById(R.id.recycler_view_products);
        productDataList = new ArrayList<>();
        productListAdapter = new ProductListAdapter(mContext, productDataList);
        RecyclerView.LayoutManager layoutManager_products = new LinearLayoutManager(mContext.getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView_products.setLayoutManager(layoutManager_products);
        recyclerView_products.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        recyclerView_products.setAdapter(productListAdapter);
        //add ItemDecoration



    }

    private void prepareProductData() {
        ProductData productData = new ProductData("SAMSUNG GALAXY NOTE 8", "64GB", "BLACK", "AED 1,599", "AED 1,399", "(1459 - VAT Incl)", "Exclusive price only for you", 1399, 1299, 1259);
        productDataList.add(productData);
        productData = new ProductData("SAMSUNG GALAXY NOTE 8", "64GB", "BLACK", "AED 1,599", "AED 1,399", "(1459 - VAT Incl)", "Exclusive price only for you", 1399, 1299, 1259);
        productDataList.add(productData);
        productData = new ProductData("SAMSUNG GALAXY NOTE 8", "64GB", "BLACK", "AED 1,599", "AED 1,399", "(1459 - VAT Incl)", "Exclusive price only for you", 1399, 1299, 1259);
        productDataList.add(productData);
        productData = new ProductData("SAMSUNG GALAXY NOTE 8", "64GB", "BLACK", "AED 1,599", "AED 1,399", "(1459 - VAT Incl)", "Exclusive price only for you", 1399, 1299, 1259);
        productDataList.add(productData);
        productListAdapter.notifyDataSetChanged();
    }
}

class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        //outRect.bottom = verticalSpaceHeight;
        if(parent.getChildAdapterPosition(view)==0){
            outRect.top=verticalSpaceHeight;
        }
        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1) {
            outRect.bottom = verticalSpaceHeight;
        }
    }
}
