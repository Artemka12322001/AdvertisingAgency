package com.example.entity;

public class PrintedEducation {
    private Long id;
    private String name;
    private String typeAdvertising;
    private Integer priceAdvertising;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeAdvertising() {
        return typeAdvertising;
    }

    public void setTypeAdvertising(String typeAdvertising) {
        this.typeAdvertising = typeAdvertising;
    }

    public Integer getPriceAdvertising() {
        return priceAdvertising;
    }

    public void setPriceAdvertising(Integer priceAdvertising) {
        this.priceAdvertising = priceAdvertising;
    }
}
