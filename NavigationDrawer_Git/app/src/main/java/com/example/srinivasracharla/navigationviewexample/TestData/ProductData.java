package com.example.srinivasracharla.navigationviewexample.TestData;

public class ProductData {

    String name;
    String type;
    String colorName;
    String actualPrize;
    String offerPrize;
    String vatPrize;

    String isSpecialUserMessage;
    int slabPrize1;
    int slabPrize2;
    int slabPrize3;

    int selectedQty;


    public ProductData(String name, String type, String colorName, String actualPrize, String offerPrize, String vatPrize, String isSpecialUserMessage, int slabPrize1, int slabPrize2, int slabPrize3) {
        this.name = name;
        this.type = type;
        this.colorName = colorName;
        this.actualPrize = actualPrize;
        this.offerPrize = offerPrize;
        this.vatPrize = vatPrize;
        this.isSpecialUserMessage = isSpecialUserMessage;
        this.slabPrize1 = slabPrize1;
        this.slabPrize2 = slabPrize2;
        this.slabPrize3 = slabPrize3;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getActualPrize() {
        return actualPrize;
    }

    public void setActualPrize(String actualPrize) {
        this.actualPrize = actualPrize;
    }

    public String getOfferPrize() {
        return offerPrize;
    }

    public void setOfferPrize(String offerPrize) {
        this.offerPrize = offerPrize;
    }

    public String getVatPrize() {
        return vatPrize;
    }

    public void setVatPrize(String vatPrize) {
        this.vatPrize = vatPrize;
    }

    public String getIsSpecialUserMessage() {
        return isSpecialUserMessage;
    }

    public void setIsSpecialUserMessage(String isSpecialUserMessage) {
        this.isSpecialUserMessage = isSpecialUserMessage;
    }

    public int getSlabPrize1() {
        return slabPrize1;
    }

    public void setSlabPrize1(int slabPrize1) {
        this.slabPrize1 = slabPrize1;
    }

    public int getSlabPrize2() {
        return slabPrize2;
    }

    public void setSlabPrize2(int slabPrize2) {
        this.slabPrize2 = slabPrize2;
    }

    public int getSlabPrize3() {
        return slabPrize3;
    }

    public void setSlabPrize3(int slabPrize3) {
        this.slabPrize3 = slabPrize3;
    }

    public int getSelectedQty() {
        return selectedQty;
    }

    public void setSelectedQty(int selectedQty) {
        this.selectedQty = selectedQty;
    }


}
