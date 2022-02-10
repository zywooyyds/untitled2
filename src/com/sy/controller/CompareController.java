package com.sy.controller;

import com.sy.dto.CompareDto;
import com.sy.service.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compare")
public class CompareController {
    @Autowired
    private CompareService compareService;
    @RequestMapping(method = RequestMethod.POST)
    public void addCompare(@RequestBody String carId){
        compareService.addCompare(carId);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<CompareDto> getCompareInfo(){
        List<CompareDto> compareInfo = compareService.getCompareInfo();
        return compareInfo;
    }
    @RequestMapping( method = RequestMethod.DELETE)
    public void deleteCompare(String carId){
        compareService.deleteCompare(carId);
    }

}
