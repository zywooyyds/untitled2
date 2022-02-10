package com.sy.entity;

public class Price {
    private Integer id;
    private String desc;
    private Integer min;
    private Integer max;

    public Price() {
    }

    public Price(Integer id, String desc, Integer min, Integer max) {
        this.id = id;
        this.desc = desc;
        this.min = min;
        this.max = max;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
