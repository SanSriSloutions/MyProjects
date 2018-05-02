package com.example.srinivasracharla.navigationviewexample.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.srinivasracharla.navigationviewexample.R;
import com.example.srinivasracharla.navigationviewexample.TestData.HandSets;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HandsetAdapter extends RecyclerView.Adapter<HandsetAdapter.HandsetViewHolder> {

    Context mContext;
    private List<HandSets> handSets;


    public HandsetAdapter(Context mContext, List<HandSets> handSets) {
        this.mContext = mContext;
        this.handSets = handSets;
    }

    class HandsetViewHolder extends RecyclerView.ViewHolder {

        public TextView handsetTitle, noOfModels, noOfQty;
        public CardView cardView;
        public RelativeLayout rel_layout;

        public HandsetViewHolder(View view) {
            super(view);
            Log.d("srinivas", "HandsetViewHolder is called");
            handsetTitle = view.findViewById(R.id.txt_handsetitle);
            noOfModels = view.findViewById(R.id.txt_no_of_models);
            noOfQty = view.findViewById(R.id.txt_no_of_qty);

            cardView = view.findViewById(R.id.card_view);

            rel_layout=view.findViewById(R.id.card_view_child);
        }
    }


    @NonNull
    @Override
    public HandsetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.handset_card_view, parent, false);
        Log.d("srinivas", "onCreateViewHolder() is called");

        return new HandsetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HandsetViewHolder holder, int position) {
        HandSets handSet = handSets.get(position);
        holder.handsetTitle.setText(handSet.getName());
        holder.noOfModels.setText(String.valueOf(handSet.getNoOfModels()));
        holder.noOfQty.setText(String.valueOf(handSet.getNoOf_Qnty()));
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            holder.rel_layout.setBackgroundDrawable(handSet.getColorCode());
        } else {
            holder.rel_layout.setBackground(handSet.getColorCode());
        }
        Log.d("srinivas", "onBindViewHolder() is called");
    }

    public void filterList(List<HandSets> handSets) {
        this.handSets = handSets;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        Log.d("srinivas", "getItemCount() is called");
        return handSets.size();
    }
}
