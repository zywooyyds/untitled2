package com.sy.entity;

public class Compare {
    private Integer id;
    private Integer UserId;
    private Integer carId;

    public Compare() {
    }

    public Compare(Integer id, Integer userId, Integer carId) {
        this.id = id;
        UserId = userId;
        this.carId = carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", UserId=" + UserId +
                ", carId=" + carId +
                '}';
    }
}
