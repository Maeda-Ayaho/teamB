package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SchoolEvaluations;
import com.example.demo.repository.SchoolEvaluationsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class SchoolEvaluationsService {
    @Autowired
    private SchoolEvaluationsRepository schoolEvaluationsRepository;
    @PersistenceContext
    private EntityManager entityManager;

    SchoolEvaluations findByPostId(Long id) {
        return schoolEvaluationsRepository.findByPostId(id);
    }
}
