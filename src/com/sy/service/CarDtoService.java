package com.sy.service;

import com.sy.dto.CarDto;
import com.sy.vo.CarMess;

import java.text.ParseException;
import java.util.List;

public interface CarDtoService {
    List<CarDto> getCars(CarMess carMess) throws ParseException;
    List<CarDto> getCarsByKeyword(String keyword);
}
