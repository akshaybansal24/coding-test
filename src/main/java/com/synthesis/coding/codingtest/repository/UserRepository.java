package com.synthesis.coding.codingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synthesis.coding.codingtest.model.USER_DETAILS;

@Repository
public interface UserRepository extends JpaRepository<USER_DETAILS, Long>{

}
