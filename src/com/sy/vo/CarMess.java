package com.sy.vo;

public class CarMess {
    private String brandId;
    private String typeId;
    private String PriceId;
    private String startPublishDate;
    private String endPublishDate;

    public CarMess() {
    }

    public CarMess(String brandId, String typeId, String priceId, String startPublishDate, String endPublishDate) {
        this.brandId = brandId;
        this.typeId = typeId;
        PriceId = priceId;
        this.startPublishDate = startPublishDate;
        this.endPublishDate = endPublishDate;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getPriceId() {
        return PriceId;
    }

    public void setPriceId(String priceId) {
        PriceId = priceId;
    }

    public String getStartPublishDate() {
        return startPublishDate;
    }

    public void setStartPublishDate(String startPublishDate) {
        this.startPublishDate = startPublishDate;
    }

    public String getEndPublishDate() {
        return endPublishDate;
    }

    public void setEndPublishDate(String endPublishDate) {
        this.endPublishDate = endPublishDate;
    }

    @Override
    public String toString() {
        return "GetCarStrVo{" +
                "brandId='" + brandId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", PriceId='" + PriceId + '\'' +
                ", startPublishDate='" + startPublishDate + '\'' +
                ", endPublishDate='" + endPublishDate + '\'' +
                '}';
    }
}
