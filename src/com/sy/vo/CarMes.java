package com.sy.vo;

import java.util.Date;

public class CarMes {
    private Integer brandId;
    private Integer typeId;
    private Integer PriceId;
    private Date startPublishDate;
    private Date endPublishDate;

    public CarMes() {
    }

    public CarMes(Integer brandId, Integer typeId, Integer priceId, Date startPublishDate, Date endPublishDate) {
        this.brandId = brandId;
        this.typeId = typeId;
        PriceId = priceId;
        this.startPublishDate = startPublishDate;
        this.endPublishDate = endPublishDate;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getPriceId() {
        return PriceId;
    }

    public void setPriceId(Integer priceId) {
        PriceId = priceId;
    }

    public Date getStartPublishDate() {
        return startPublishDate;
    }

    public void setStartPublishDate(Date startPublishDate) {
        this.startPublishDate = startPublishDate;
    }

    public Date getEndPublishDate() {
        return endPublishDate;
    }

    public void setEndPublishDate(Date endPublishDate) {
        this.endPublishDate = endPublishDate;
    }

    @Override
    public String toString() {
        return "GetCarVo{" +
                "brandId=" + brandId +
                ", typeId=" + typeId +
                ", PriceId=" + PriceId +
                ", startPublishDate=" + startPublishDate +
                ", endPublishDate=" + endPublishDate +
                '}';
    }
}
