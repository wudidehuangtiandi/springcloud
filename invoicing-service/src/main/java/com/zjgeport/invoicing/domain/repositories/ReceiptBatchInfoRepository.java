package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.ReceiptBatchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ReceiptBatchInfoRepository extends JpaRepository<ReceiptBatchInfo, String>, QuerydslPredicateExecutor<ReceiptBatchInfo> {
}