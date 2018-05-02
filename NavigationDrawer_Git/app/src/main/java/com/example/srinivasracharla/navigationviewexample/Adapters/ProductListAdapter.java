package com.example.srinivasracharla.navigationviewexample.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.srinivasracharla.navigationviewexample.R;
import com.example.srinivasracharla.navigationviewexample.TestData.HandSets;
import com.example.srinivasracharla.navigationviewexample.TestData.ProductData;

import org.w3c.dom.Text;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    List<ProductData> productList;
    Context mContext;

    public ProductListAdapter(Context mContext, List<ProductData> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView name, actualPrize, offerPrize, vat_prize, slabPrize1, slabPrize2, slabPrize3;

        public ProductViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txt_productName);
            actualPrize = view.findViewById(R.id.txt_product_actual_prize);
            offerPrize = view.findViewById(R.id.txt_product_offer_prize);
            vat_prize = view.findViewById(R.id.txt_product_vat_prize);
            slabPrize1 = view.findViewById(R.id.txt_slab_prize_value);
        }
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_view, parent, false);
        Log.d("srinivas", "onCreateViewHolder() is called");
        return new ProductListAdapter.ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        ProductData productData = productList.get(position);
        holder.name.setText(productData.getName() + productData.getType() + productData.getColorName());
        holder.actualPrize.setText(productData.getActualPrize());
        holder.actualPrize.setPaintFlags(holder.actualPrize.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.offerPrize.setText(productData.getOfferPrize());
        holder.vat_prize.setText(productData.getVatPrize());
        holder.slabPrize1.setText(String.valueOf(productData.getSlabPrize1()));
        /*holder.slabPrize2.setText(String.valueOf(productData.getSlabPrize2()));
        holder.slabPrize3.setText(String.valueOf(productData.getSlabPrize3()));*/

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


}
