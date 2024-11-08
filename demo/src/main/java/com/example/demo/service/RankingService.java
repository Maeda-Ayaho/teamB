/*
package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.model.RankingData;
import com.example.demo.model.School;
import com.example.demo.model.SchoolEvaluations;
import com.example.demo.repository.RankingRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Service
public class RankingService {

    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    
    @PersistenceContext
    private EntityManager entityManager;
	
    // SLStudioという名前のユーザーを取得するクエリビルダー用メソッド
    public List<RankingData> getSchoolRankings() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RankingData> cq = cb.createQuery(RankingData.class);
        // もとになるクラス
        Root<School> rankingData = cq.from(School.class);
        // Joinの作成
        Join<School, Post> school = rankingData.Join("post", JoinType.INNER);
        Join<School, SchoolEvaluations> schoole = rankingData.Join("schoolevaluations", JoinType.INNER);
        // GroupByのフィールドを設定
        cq.groupBy(school.get("image"), school.get("name"), school.get("deviationValue"));

        cq.multiselect(
            cb.construct(
                RankingData.class,
                school.get("image"),
                school.get("name"),
                cb.avg(schoolEvaluations.get("totalScore")),
                cb.count(post.get("id")),
                school.get("deviationValue")
            )
        );
        // クエリ実行
        TypedQuery<RankingData> typedQuery = entityManager.createQuery(cq);
        List<RankingData> results = typedQuery.getResultList();

		
        // 実行する
        return results;
    }
    

}
 * 
 */