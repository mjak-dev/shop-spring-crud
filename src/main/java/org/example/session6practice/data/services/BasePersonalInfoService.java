package org.example.session6practice.data.services;

import org.example.session6practice.data.entities.BasePersonalInfo;
import org.example.session6practice.data.repositories.BasePersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasePersonalInfoService {

    @Autowired
    private BasePersonalInfoRepository basePersonalInfoRepository;

    public void addOrUpdateBasePersonalInfo(BasePersonalInfo personalInfo) {
        basePersonalInfoRepository.save(personalInfo);
    }

    public void removePersonalInfo(BasePersonalInfo personalInfo) {
        basePersonalInfoRepository.delete(personalInfo);
    }

    public void removePersonalInfoById(long id) {
        basePersonalInfoRepository.deleteById(id);
    }

    public List<BasePersonalInfo> findByNameAndFamily(String name,String family,int pageNo,int perPage) {
        List<BasePersonalInfo> basePersonalInfos = basePersonalInfoRepository
                .findByNameAndFamily(name,family, PageRequest.of(pageNo,perPage)).stream().toList();
        return basePersonalInfos;
    }

    public BasePersonalInfo findById(long id) {
        return basePersonalInfoRepository.findById(id).get();
    }

    public List<BasePersonalInfo> findAllById(List<Long> id) {
        return basePersonalInfoRepository.findAllById(id);
    }


}
