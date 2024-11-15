package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SchoolEvaluations;
@Repository
public interface SchoolEvaluationsRepository extends JpaRepository<SchoolEvaluations, Long> {
    SchoolEvaluations findByPostId(Long postId);
}