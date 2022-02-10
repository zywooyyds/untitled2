package com.sy.service.impl;

import com.sy.dto.CollectDto;
import com.sy.entity.Collect;
import com.sy.exception.BusinessException;
import com.sy.mapper.CollectMapper;
import com.sy.service.CollectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.sy.constant.RegexConstant.NUM_REGEX;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public void addCollect(String carIdStr){

        if (StringUtils.isBlank(carIdStr)) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号不能为空");
        }
        if (!carIdStr.matches(NUM_REGEX)) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号必须为数字");
        }
        int carId = Integer.parseInt(carIdStr);
        Collect collect = collectMapper.selectCollect(carId);
        if (Objects.nonNull(collect)) {
            throw new BusinessException(HttpStatus.BAD_GATEWAY,"该车辆已收藏");
        } else {
            boolean addCollect = collectMapper.addCollect(carId);
            if (!addCollect) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"收藏失败");
            }
        }
    }

    @Override
    public void deleteCollect(String carIdStr) {

            if (StringUtils.isBlank(carIdStr)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号不能为空");
            }
            if (!carIdStr.matches(NUM_REGEX)) {
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"车辆编号必须为数字");
            }
            Integer carId = Integer.parseInt(carIdStr);
            Collect collect = collectMapper.selectCollect(carId);
            if (Objects.isNull(collect)){
                throw new BusinessException(HttpStatus.BAD_GATEWAY,"该车辆未被收藏");
            }else {
                boolean deleteCollect = collectMapper.deleteCollect(carId);
                if (!deleteCollect) {
                    throw new BusinessException(HttpStatus.NOT_FOUND,"服务器故障，移除收藏失败");
                }
            }

    }

    @Override
    public List<Collect> getAllCollect() {
            List<Collect> allCollect = collectMapper.getAllCollect();
            return allCollect;
    }

    @Override
    public List<CollectDto> getCollectInfo() {
            List<CollectDto> cars = collectMapper.getCollectInfo();
            if (cars.size()==0){
                throw new BusinessException(HttpStatus.NOT_FOUND,"暂未收藏车辆");
            }
            return cars;
    }
}
