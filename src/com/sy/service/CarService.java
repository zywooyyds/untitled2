package com.sy.service;

import com.sy.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getNewCars();
    List<Car> getCars(String page);
}
