package com.example.entity;

public class Advertiser {
    private Long id;
    private String name;
    private String address;
    private String director;
    private String phone;
    private Long requestId;
    private String payment;
    private Long printedEducationId;
    private String adPlacementLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Long getPrintedEducationId() {
        return printedEducationId;
    }

    public void setPrintedEducationId(Long printedEducationId) {
        this.printedEducationId = printedEducationId;
    }

    public String getAdPlacementLocation() {
        return adPlacementLocation;
    }

    public void setAdPlacementLocation(String adPlacementLocation) {
        this.adPlacementLocation = adPlacementLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
