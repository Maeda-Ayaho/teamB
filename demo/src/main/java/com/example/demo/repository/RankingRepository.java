/*
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RankingData;
import com.example.demo.model.School;

@Repository
public interface RankingRepository extends JpaRepository<School, Long> {

    @Query("SELECT s.image, s.name, AVG(se.totalScore), COUNT(p.id), s.deviationValue"
            +
            "FROM School s " +
            "LEFT JOIN Post p ON p.school.id = s.id " +
            "LEFT JOIN SchoolEvaluations se ON se.post.id = p.id " +
            "WHERE p.isDeleted = false " +
            "GROUP BY s.image, s.name, s.deviationValue " +
            "ORDER BY AVG(se.totalScore) DESC")
    List<RankingData> findSchoolRankings();
}
 * 
 */