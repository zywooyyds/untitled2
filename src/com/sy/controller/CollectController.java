package com.sy.controller;

import com.sy.dto.CollectDto;
import com.sy.entity.Collect;
import com.sy.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @RequestMapping(method = RequestMethod.POST)
    public void addCollect(String carId){
        collectService.addCollect(carId);
    }
    @RequestMapping( method = RequestMethod.DELETE)
    public void deleteCollect(String carId){
        collectService.deleteCollect(carId);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Collect> getAllCollect(){
        List<Collect> allCollect = collectService.getAllCollect();
        return allCollect;
    }

}
