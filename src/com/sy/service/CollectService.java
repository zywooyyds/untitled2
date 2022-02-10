package com.sy.service;

import com.sy.dto.CollectDto;
import com.sy.entity.Collect;

import java.util.List;

public interface CollectService {
    void addCollect(String carId);
    void deleteCollect(String carId);
    List<Collect> getAllCollect();
    List<CollectDto> getCollectInfo();
}
