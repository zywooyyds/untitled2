package com.sy.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Car {
    private Integer id;
    private String name;
    private BigDecimal mileage;
    private BigDecimal price;
    private Date publishDate;
    private Integer typeId;
    private String carImage;

    public Car() {
    }

    public Car(Integer id, String name, BigDecimal mileage, BigDecimal price, Date publishDate, Integer typeId, String carImage) {
        this.id = id;
        this.name = name;
        this.mileage = mileage;
        this.price = price;
        this.publishDate = publishDate;
        this.typeId = typeId;
        this.carImage = carImage;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", typeId=" + typeId +
                ", carImage='" + carImage + '\'' +
                '}';
    }
}
