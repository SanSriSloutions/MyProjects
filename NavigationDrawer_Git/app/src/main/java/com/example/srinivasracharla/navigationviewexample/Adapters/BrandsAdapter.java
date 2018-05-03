package com.example.srinivasracharla.navigationviewexample.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.srinivasracharla.navigationviewexample.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.BrandViewHolder> {

    Context mContext;
    List<Integer> brandsList;

    public BrandsAdapter(Context mContext, List<Integer> brandsList) {
        this.mContext = mContext;
        this.brandsList = brandsList;
    }

    public class BrandViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;

        public BrandViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.profile_image);
        }
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_view, parent, false);
        return new BrandsAdapter.BrandViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        holder.imageView.setImageResource(brandsList.get(position));
    }


    @Override
    public int getItemCount() {
        return brandsList.size();
    }


}
