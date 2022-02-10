package com.sy.service.impl;

import com.sy.dto.CarDto;
import com.sy.exception.BusinessException;
import com.sy.mapper.CarInfoMapper;
import com.sy.service.CarDtoService;
import com.sy.vo.CarMess;
import com.sy.vo.CarMes;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sy.constant.RegexConstant.NUM_REGEX;

@Service
public class CarDtoServiceImpl implements CarDtoService {
    @Autowired
    private CarInfoMapper carInfoMapper;
    @Override
    public List<CarDto> getCars(CarMess carMess) throws ParseException {

            String strVoBrandId = carMess.getBrandId();
            if (StringUtils.isBlank(strVoBrandId)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"品牌编号不能为空");
            }
            if (!strVoBrandId.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"品牌编号必须为数字");
            }
            int brandId = Integer.parseInt(strVoBrandId);
            String strVoTypeId = carMess.getTypeId();
            if (StringUtils.isBlank(strVoTypeId)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车型编号不能为空");
            }
            if (!strVoTypeId.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车型编号必须为数字");
            }
            int typeId = Integer.parseInt(strVoTypeId);
            String strVoPriceId = carMess.getPriceId();
            if (StringUtils.isBlank(strVoPriceId)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"价格编号不能为空");
            }
            if (!strVoPriceId.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"价格编号必须为数字");
            }
            int priceId = Integer.parseInt(strVoPriceId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strVoStartPublishDate = carMess.getStartPublishDate();
            if (StringUtils.isBlank(strVoStartPublishDate)){
                strVoStartPublishDate="2000-1-1";
            }
            Date startPublishDate = sdf.parse(strVoStartPublishDate);
            String strVoEndPublishDate = carMess.getEndPublishDate();
            if (StringUtils.isBlank(strVoEndPublishDate)){
                strVoEndPublishDate="2100-1-1";
            }
            Date endPublishDate = sdf.parse(strVoEndPublishDate);
            CarMes getCarVo = new CarMes(brandId, typeId, priceId, startPublishDate, endPublishDate);
            List<CarDto> cars = carInfoMapper.getCarsByCondition(getCarVo);
            if (CollectionUtils.isEmpty(cars)) {
                throw new BusinessException(HttpStatus.NOT_FOUND,"没有符合条件的车");
            }
            return cars;
    }

    @Override
    public List<CarDto> getCarsByKeyword(String keyword) {

            if (StringUtils.isBlank(keyword)){
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"搜索项为空");
            }
            ArrayList<CarDto> carList = new ArrayList<>();
            List<CarDto> cars = carInfoMapper.getCarInfos();
            for (CarDto car : cars) {
                if (car.getName().contains(keyword)){
                    carList.add(car);
                }
            }
            if (CollectionUtils.isEmpty(carList)) {
                throw new BusinessException(HttpStatus.NOT_FOUND,"没有符合条件的车");
            }
            return carList;

    }
}
