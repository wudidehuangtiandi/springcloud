package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.ReceiptSingleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReceiptSingleInfoRepository extends JpaRepository<ReceiptSingleInfo, String>, QuerydslPredicateExecutor<ReceiptSingleInfo> {
}