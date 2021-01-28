package com.dev.bisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.bisa.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>{

}
