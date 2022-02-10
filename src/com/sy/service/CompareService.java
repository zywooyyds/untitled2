package com.sy.service;


import com.sy.dto.CompareDto;

import java.util.List;

public interface CompareService {
    void addCompare(String carId);
    List<CompareDto> getCompareInfo();
    void deleteCompare(String carId);
}
