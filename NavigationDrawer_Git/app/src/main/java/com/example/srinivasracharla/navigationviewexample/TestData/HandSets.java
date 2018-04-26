package com.example.srinivasracharla.navigationviewexample.TestData;

public class HandSets {
    String name;
    int noOfModels;
    long noOf_Qnty;
    int colorCode;


    public HandSets(String name, int noOfModels, int noOf_Qnty, int colorCode) {
        this.name = name;
        this.noOfModels = noOfModels;
        this.noOf_Qnty = noOf_Qnty;
        this.colorCode = colorCode;

    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
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
