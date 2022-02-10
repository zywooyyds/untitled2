package com.sy.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CompareDto {
    private Integer id;
    private String name;
    private BigDecimal mileage;
    private BigDecimal price;
    private Date publishDate;

    public CompareDto() {
    }

    public CompareDto(Integer id, String name, BigDecimal mileage, BigDecimal price, Date publishDate) {
        this.id = id;
        this.name = name;
        this.mileage = mileage;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "CarCollectDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
