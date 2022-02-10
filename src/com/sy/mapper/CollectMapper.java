package com.sy.mapper;

import com.sy.dto.CollectDto;
import com.sy.entity.Collect;

import java.util.List;

public interface CollectMapper {
    boolean addCollect(Integer carId);
    Collect selectCollect(Integer carId);
    boolean deleteCollect(Integer carId);
    List<Collect> getAllCollect();
    List<CollectDto> getCollectInfo();
}
