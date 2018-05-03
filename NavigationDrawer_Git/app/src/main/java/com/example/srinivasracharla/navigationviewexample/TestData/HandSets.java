package com.example.srinivasracharla.navigationviewexample.TestData;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import de.hdodenhof.circleimageview.CircleImageView;

public class HandSets {

    public int getHandsetViewId() {
        return handsetViewId;
    }

    public void setHandsetViewId(int handsetViewId) {
        this.handsetViewId = handsetViewId;
    }

    int handsetViewId;
    String name;
    boolean available;
    int noOfModels;
    long noOf_Qnty;
    GradientDrawable colorCode;


    public HandSets(int handsetViewId, String name, boolean available, int noOfModels, int noOf_Qnty, GradientDrawable colorCode) {
        this.handsetViewId = handsetViewId;
        this.name = name;
        this.available = available;
        this.noOfModels = noOfModels;
        this.noOf_Qnty = noOf_Qnty;
        this.colorCode = colorCode;

    }


    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public GradientDrawable getColorCode() {
        return colorCode;
    }

    public void setColorCode(GradientDrawable colorCode) {
        this.colorCode = colorCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfModels() {
        return noOfModels;
    }

    public void setNoOfModels(int noOfModels) {
        this.noOfModels = noOfModels;
    }

    public long getNoOf_Qnty() {
        return noOf_Qnty;
    }

    public void setNoOf_Qnty(long noOf_Qnty) {
        this.noOf_Qnty = noOf_Qnty;
    }


}
