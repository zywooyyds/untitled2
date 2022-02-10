package com.sy.mapper;

import com.sy.entity.Car;

import java.util.List;

public interface CarMapper {
    List<Car> getNewCars();
    List<Car> getAllNewCars();
}
