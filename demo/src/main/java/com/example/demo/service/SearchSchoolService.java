package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.School;
import com.example.demo.repository.SearchSchoolRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class SearchSchoolService {
    
    @Autowired
    private SearchSchoolRepository searchschoolrepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<School> searchSchools(String prefecture, String name,  List<String> establishmentType, List<String> genderType, Integer deviationValueMin, Integer deviationValueMax) {
        
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<School> query = cb.createQuery(School.class);
        Root<School> school = query.from(School.class);

        List<Predicate> predicates = new ArrayList<>();

        // 都道府県が指定された場合の検索条件
        if (prefecture != null && !prefecture.isEmpty()) {
            predicates.add(cb.equal(school.get("prefecture"), prefecture));
        }

        // 学校名が指定された場合の検索条件
        if (name != null && !name.isEmpty()) {
            if (name.matches("^[あ-ん]+$"))  {
                predicates.add(cb.or(
                    cb.like(school.get("nameFurigana"), "%" + name + "%")));
            }else{
                predicates.add(cb.or(
                    cb.like(school.get("name"), "%" + name + "%")));
                }
        }

        // 学校の種類（国立・公立・私立）が指定された場合の検索条件
        if (establishmentType != null && !establishmentType.isEmpty()) {
            predicates.add(school.get("establishmentType").in(establishmentType));
        }

        // 男女共学が指定された場合の検索条件
        if (genderType != null && !genderType.isEmpty()) {
            predicates.add(school.get("genderType").in(genderType));
        }

        // 偏差値の範囲が指定された場合の検索条件
        if (deviationValueMin != null) {
            predicates.add(cb.greaterThanOrEqualTo(school.get("deviationValue"), deviationValueMin));
        }
        if (deviationValueMax != null) {
            predicates.add(cb.lessThanOrEqualTo(school.get("deviationValue"), deviationValueMax));
        }


        // 条件が一つも指定されていない場合、全件取得
        if (predicates.isEmpty()) {
            return entityManager.createQuery(query).getResultList();  // 条件なしで全件取得
        }

        // WHERE句に全ての条件を追加
        query.where(cb.and(predicates.toArray(new Predicate[0])));

        // クエリを実行
        TypedQuery<School> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
/*
 * 
        // 学校を押下時の挙動
    public School findBySchoolId(Long schoolId) {
        return searchschoolrepository.findById(schoolId).orElse(null);  // 存在しない場合はnullを返す
    }
*/
}