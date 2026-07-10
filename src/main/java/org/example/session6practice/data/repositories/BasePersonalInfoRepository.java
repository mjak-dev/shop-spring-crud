package org.example.session6practice.data.repositories;

import org.example.session6practice.data.entities.BasePersonalInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BasePersonalInfoRepository extends JpaRepository<BasePersonalInfo,Long> {

    Page<BasePersonalInfo> findByNameAndFamily(String name, String family, Pageable pageable);
}
