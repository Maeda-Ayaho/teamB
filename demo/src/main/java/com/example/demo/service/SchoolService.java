package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepository;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    // 学校情報を保存
    public void save(School school) {
        schoolRepository.save(school);
    }

    // 学校IDで学校を取得
    public School findById(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public Optional<School> findschoolById(Long id) {
        return schoolRepository.findById(id);
    }
}
