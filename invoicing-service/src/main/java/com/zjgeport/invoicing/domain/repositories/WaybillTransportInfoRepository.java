package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.WaybillTransportInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface WaybillTransportInfoRepository extends JpaRepository<WaybillTransportInfo, String>, QuerydslPredicateExecutor<WaybillTransportInfo> {
}