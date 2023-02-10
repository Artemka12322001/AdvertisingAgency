package com.example.dto;

public class RequestForTable {
    private String printedEducationName;
    private String advertiserName;
    private Integer price;

    public String getPrintedEducationName() {
        return printedEducationName;
    }

    public void setPrintedEducationName(String printedEducationName) {
        this.printedEducationName = printedEducationName;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
