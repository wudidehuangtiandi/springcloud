package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.ShipInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ShipInfoRepository extends JpaRepository<ShipInfo, String>, QuerydslPredicateExecutor<ShipInfo> {
}