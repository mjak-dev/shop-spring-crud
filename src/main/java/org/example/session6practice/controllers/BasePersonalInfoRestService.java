package org.example.session6practice.controllers;

import org.example.session6practice.Finals;
import org.example.session6practice.data.entities.BasePersonalInfo;
import org.example.session6practice.data.services.BasePersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/BasePersonalInfoService")
public class BasePersonalInfoRestService {

    @Autowired
    private BasePersonalInfoService basepersonalInfoService;

    @RequestMapping(method = RequestMethod.POST)
    @GetMapping("/json")
    public Map<String,String> addOrUpdate(BasePersonalInfo basePersonalInfo) {
        basepersonalInfoService.addOrUpdateBasePersonalInfo(basePersonalInfo);

        Map<String,String> map = new HashMap<>();
        map.put("response","BasePersonalInfo added successfylly ");
        return map;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @GetMapping("/json")
    public Map<String,String> delete(BasePersonalInfo basePersonalInfo) {
        basepersonalInfoService.removePersonalInfo(basePersonalInfo);

        Map<String,String> map = new HashMap<>();
        map.put("response","BasePersonalInfo deleted successfully ");
        return map;
    }

    @RequestMapping(value = "DeleteById",method = RequestMethod.DELETE)
    @GetMapping("/json")
    public Map<String,String> deleteById(long id) {
        basepersonalInfoService.removePersonalInfoById(id);

        Map<String,String> map = new HashMap<>();
        map.put("response","BasePersonalInfo deleted successfully");
        return map;
    }

    @RequestMapping(value = "GetByNameAndFamily",method = RequestMethod.GET)
    public List<BasePersonalInfo> getByNameAndFamily(String name,String family,int pageNo) {
        return basepersonalInfoService.findByNameAndFamily(name,family,pageNo, Finals.PER_PAGE_PAGINATION);
    }

    @RequestMapping(method = RequestMethod.GET)
    public BasePersonalInfo getById(long id) {
        return basepersonalInfoService.findById(id);
    }

    @RequestMapping(value = "GetAllById",method = RequestMethod.GET)
    public List<BasePersonalInfo> getAllById(List<Long> id) {
        return basepersonalInfoService.findAllById(id);
    }

}