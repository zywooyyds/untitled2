package com.sy.controller;


import com.sy.dto.CarDto;
import com.sy.service.CarDtoService;
import com.sy.vo.CarMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("cars")
public class CarDtoController {
    @Autowired
    private CarDtoService carDtoService;
    @RequestMapping(method = RequestMethod.GET,params = {"brandId","typeId","PriceId","startPublishDate","endPublishDate"})
    public List<CarDto> getCarsByCondition(CarMess carMess) throws ParseException {
        List<CarDto> car = carDtoService.getCars(carMess);
        return car;
    }

}
