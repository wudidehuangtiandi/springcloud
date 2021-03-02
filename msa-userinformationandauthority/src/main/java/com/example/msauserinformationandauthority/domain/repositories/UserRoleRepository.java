package com.example.msauserinformationandauthority.domain.repositories;


import com.example.msauserinformationandauthority.domain.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String>, QuerydslPredicateExecutor<UserRole> {
}