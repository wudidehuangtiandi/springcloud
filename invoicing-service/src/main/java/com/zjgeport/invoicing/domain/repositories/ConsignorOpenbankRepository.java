package com.zjgeport.invoicing.domain.repositories;

import com.zjgeport.invoicing.domain.models.ConsignorOpenbank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ConsignorOpenbankRepository extends JpaRepository<ConsignorOpenbank, String>, QuerydslPredicateExecutor<ConsignorOpenbank> {
}