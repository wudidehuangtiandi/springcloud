package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.CarrierInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Component;

@Component
public interface CarrierInfoRepository extends JpaRepository<CarrierInfo, String>, QuerydslPredicateExecutor<CarrierInfo> {
}