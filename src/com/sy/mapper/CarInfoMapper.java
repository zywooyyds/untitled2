package com.sy.mapper;

import com.sy.dto.CarDto;
import com.sy.vo.CarMes;

import java.util.List;

public interface CarInfoMapper {
    List<CarDto> getCarsByCondition(CarMes getCarVo);
    List<CarDto> getCarInfos();
}
