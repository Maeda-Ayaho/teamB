package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.School;


@Repository
public interface SearchSchoolRepository extends JpaRepository<School, Long> {
    
}
