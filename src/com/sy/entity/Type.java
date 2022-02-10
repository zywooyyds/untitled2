package com.sy.entity;

public class Type {
    private Integer id;
    private String name;
    private Integer brandId;

    public Type() {
    }

    public Type(Integer id, String name, Integer brandId) {
        this.id = id;
        this.name = name;
        this.brandId = brandId;
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandId=" + brandId +
                '}';
    }
}
