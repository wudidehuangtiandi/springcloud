package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.WaybillContractInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WaybillContractInfoRepository extends JpaRepository<WaybillContractInfo, String>, QuerydslPredicateExecutor<WaybillContractInfo> {
}