package com.example.entity;

public class Request {
    private Long id;
    private String type;
    private String size;
    private Long printedEducationId;
    private Integer numberOfIssues;
    private String additionalInformation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getPrintedEducationId() {
        return printedEducationId;
    }

    public void setPrintedEducationId(Long printedEducationId) {
        this.printedEducationId = printedEducationId;
    }

    public Integer getNumberOfIssues() {
        return numberOfIssues;
    }

    public void setNumberOfIssues(Integer numberOfIssues) {
        this.numberOfIssues = numberOfIssues;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
