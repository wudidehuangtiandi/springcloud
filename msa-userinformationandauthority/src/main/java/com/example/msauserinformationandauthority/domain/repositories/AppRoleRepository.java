package com.example.msauserinformationandauthority.domain.repositories;


import com.example.msauserinformationandauthority.domain.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, String>, QuerydslPredicateExecutor<AppRole> {
}