package com.sy.mapper;

import com.sy.dto.CompareDto;
import com.sy.entity.Compare;

import java.util.List;

public interface CompareMapper {
    Compare getCompareByCarId(int carId);
    boolean addCompare(int carId);
    List<CompareDto> getCompareInfo();
    boolean deleteCompare(int carId);
}
