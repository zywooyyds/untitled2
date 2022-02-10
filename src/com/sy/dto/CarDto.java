package com.sy.dto;

import java.math.BigDecimal;
import java.util.Date;


public class CarDto {
    private Integer id;
    private String typeName;
    private String brandName;
    private String name;
    private BigDecimal mileage;
    private BigDecimal price;
    private Date publishDate;
    private String carImage;

    public CarDto() {
    }

    public CarDto(Integer id, String typeName, String brandName, String name, BigDecimal mileage, BigDecimal price, Date publishDate, String carImage) {
        this.id = id;
        this.typeName = typeName;
        this.brandName = brandName;
        this.name = name;
        this.mileage = mileage;
        this.price = price;
        this.publishDate = publishDate;
        this.carImage = carImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    @Override
    public String toString() {
        return "CarInfoDto{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", name='" + name + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", carImage='" + carImage + '\'' +
                '}';
    }
}
