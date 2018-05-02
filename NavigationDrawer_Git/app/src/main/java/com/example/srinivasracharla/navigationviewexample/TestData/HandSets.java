package com.example.srinivasracharla.navigationviewexample.TestData;

import android.graphics.drawable.GradientDrawable;

public class HandSets {
    String name;
    int noOfModels;
    long noOf_Qnty;
    GradientDrawable colorCode;


    public HandSets(String name, int noOfModels, int noOf_Qnty, GradientDrawable colorCode) {
        this.name = name;
        this.noOfModels = noOfModels;
        this.noOf_Qnty = noOf_Qnty;
        this.colorCode = colorCode;

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
