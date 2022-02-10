package com.sy.service.impl;

import com.sy.dto.CompareDto;
import com.sy.entity.Compare;
import com.sy.exception.BusinessException;
import com.sy.mapper.CompareMapper;
import com.sy.service.CompareService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


import static com.sy.constant.RegexConstant.NUM_REGEX;

@Service
public class CompareServiceImpl implements CompareService {
    @Autowired
    private CompareMapper compareMapper;
    @Override
    public void addCompare(String carIdStr) {

            List<CompareDto> cars = compareMapper.getCompareInfo();

            if (StringUtils.isBlank(carIdStr)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号不能为空");
            }
            if (!carIdStr.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号必须为数字");
            }
            int carId = Integer.parseInt(carIdStr);
            Compare compare = compareMapper.getCompareByCarId(carId);
            if (Objects.nonNull(compare)){
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"不可重复加入对比");
            }else {
                boolean addCompare = compareMapper.addCompare(carId);
                if (!addCompare){
                    throw new BusinessException(HttpStatus.BAD_GATEWAY,"加入对比失败");
                }
            }

    }

    @Override
    public List<CompareDto> getCompareInfo() {

            List<CompareDto> cars = compareMapper.getCompareInfo();
            if (cars.size()==0){
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"暂未添加对比");
            }
            return cars;

    }

    @Override
    public void deleteCompare(String carIdStr) {

            if (StringUtils.isBlank(carIdStr)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号不能为空");
            }
            if (!carIdStr.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号必须为数字");
            }
            int carId = Integer.parseInt(carIdStr);
            Compare compare = compareMapper.getCompareByCarId(carId);
            if (Objects.isNull(compare)){
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"该车辆已从对比删除");
            }
            boolean deleteCompare = compareMapper.deleteCompare(carId);
            if (!deleteCompare){
                throw new BusinessException(HttpStatus.NOT_FOUND,"移除对比失败");
            }
    }
}
