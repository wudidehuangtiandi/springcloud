package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.WaybillCargoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WaybillCargoInfoRepository extends JpaRepository<WaybillCargoInfo, String>, QuerydslPredicateExecutor<WaybillCargoInfo> {
}