package com.sy.controller;

import com.sy.entity.Car;
import com.sy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("newCars")
public class CarController {
    @Autowired
    private CarService carService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getNewCars(){
        List<Car> cars = carService.getNewCars();
        return cars;
    }
    @RequestMapping(method = RequestMethod.GET,params = {"page"})
    public List<Car> getCars(String page){
        List<Car> cars = carService.getCars(page);
        return cars;
    }

}
