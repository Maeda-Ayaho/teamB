package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.School;

@Repository
public interface SearchSchoolRepository extends JpaRepository<School, Long> {

    @Query("SELECT s FROM School s WHERE "
    + "(:prefecture IS NULL OR s.prefecture = :prefecture) AND "
    + "(:establishmentType IS NULL OR s.establishmentType IN :establishmentType) AND "
    + "(:genderType IS NULL OR s.genderType IN :genderType) AND "
    + "(:deviationValueMin IS NULL OR s.deviationValue >= :deviationValueMin) AND "
    + "(:deviationValueMax IS NULL OR s.deviationValue <= :deviationValueMax) AND "
    + "(:name IS NULL OR :name = '' OR s.name LIKE CONCAT('%', :name, '%'))")
    List<School> searchschoolsByKanji(
        @Param("prefecture") String prefecture,
        @Param("name") String name,
        @Param("establishmentType") List<String> establishmentType,
        @Param("genderType") List<String> genderType,
        @Param("deviationValueMin") Integer deviationValueMin,
        @Param("deviationValueMax") Integer deviationValueMax
    );

    @Query("SELECT s FROM School s WHERE "
    + "(:prefecture IS NULL OR s.prefecture = :prefecture) AND "
    + "(:establishmentType IS NULL OR s.establishmentType IN :establishmentType) AND "
    + "(:genderType IS NULL OR s.genderType IN :genderType) AND "
    + "(:deviationValueMin IS NULL OR s.deviationValue >= :deviationValueMin) AND "
    + "(:deviationValueMax IS NULL OR s.deviationValue <= :deviationValueMax) AND "
    + "(:name IS NULL OR :name = '' OR s.nameFurigana LIKE CONCAT('%', :name, '%'))")
    List<School> searchschoolsByFurigana(
        @Param("prefecture") String prefecture,
        @Param("name") String name,
        @Param("establishmentType") List<String> establishmentType,
        @Param("genderType") List<String> genderType,
        @Param("deviationValueMin") Integer deviationValueMin,
        @Param("deviationValueMax") Integer deviationValueMax
    );
}
