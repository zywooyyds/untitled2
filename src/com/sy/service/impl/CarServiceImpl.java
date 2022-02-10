package com.sy.service.impl;

import com.sy.entity.Car;
import com.sy.exception.BusinessException;
import com.sy.mapper.CarMapper;
import com.sy.service.CarService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.sy.constant.BusinessConstant.PAGE_SIZE;
import static com.sy.constant.RegexConstant.NUM_REGEX;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Override
    public List<Car> getNewCars() {
            List<Car> cars = carMapper.getNewCars();
            if (CollectionUtils.isEmpty(cars)){
                throw new BusinessException(HttpStatus.NOT_FOUND,"暂无车辆信息");
            }
            return cars;
    }

    @Override
    public List<Car> getCars(String page) {

            if (StringUtils.isBlank(page)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"编号不能为空");
            }
            if (!page.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"编号必须为数字");
            }
            int pageNum = Integer.parseInt(page);
            List<Car> cars = carMapper.getAllNewCars();
            List<Car> carList = cars.stream().limit(pageNum * PAGE_SIZE).collect(Collectors.toList());
            if (Math.ceil(carList.size()/(PAGE_SIZE*1.0))< pageNum){
                throw new BusinessException(HttpStatus.NOT_FOUND,"已经没有更多二手车信息了");
            }
         return carList;
    }
}
