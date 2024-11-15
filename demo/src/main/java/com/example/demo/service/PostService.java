package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PostsDTO;
import com.example.demo.model.Post;
import com.example.demo.model.SchoolEvaluations;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SchoolEvaluationsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Service
    public class PostService {
        @Autowired//postRepositoryと依存関係
        private PostRepository postRepository;
        @Autowired
        private SchoolEvaluationsRepository schoolEvaluationsRepository;

    @PersistenceContext
    private EntityManager entityManager;

        //投稿の新規登録
        @Transactional
        public void savePost(PostsDTO postsDTO) {
        // 新規投稿の作成
        Post post = new Post();
        post.setStatus(postsDTO.getStatus());
        post.setSchoolId(postsDTO.getSchoolId());  // 学校ID
        post.setEnrollment(postsDTO.getEnrollment());  // 入学卒業年
        post.setGender(postsDTO.getGender());  // 性別
        post.setTitle(postsDTO.getTitle());  // タイトル
        post.setIsDeleted(false);  // 論理削除
        postRepository.save(post);  // Postテーブルに保存
        post.setPostedAt(LocalDateTime.now()); // 投稿日時をセット
        // 投稿IDを取得
        Long postId = post.getId();  // 保存後に自動で生成されたIDを取得

        // 評価情報の作成
        SchoolEvaluations schoolEvaluations = new SchoolEvaluations();
        schoolEvaluations.setPostId(postId);  // 投稿ID
        schoolEvaluations.setEnvironmentScore(postsDTO.getEnvironmentScore());  // 環境スコア
        schoolEvaluations.setClubScore(postsDTO.getClubScore());  // 部活動スコア
        schoolEvaluations.setEventScore(postsDTO.getEventScore());  // イベントスコア
        schoolEvaluations.setEnvironmentComment(postsDTO.getEnvironmentComment());  // 環境コメント
        schoolEvaluations.setClubComment(postsDTO.getClubComment());  // 部活動コメント
        schoolEvaluations.setEventComment(postsDTO.getEventComment());  // イベントコメント
        schoolEvaluations.setTotalComment(postsDTO.getTotalComment());  // 総合コメント
        schoolEvaluations.setEventScore(postsDTO.getEnvironmentScore(),postsDTO.getClubScore(),postsDTO.getEventScore());
        schoolEvaluationsRepository.save(schoolEvaluations);  // SchoolEvaluationsテーブルに保
    }

    // 特定の学校のポスト一覧を取得
    public List<Post>  findPostList(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> post = cq.from(Post.class);

        cq.select(post);
        cq.where(cb.equal(post.get("schoolId"), id));
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Post>  ex(Long id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> post = cq.from(Post.class);


        cq.select(post);
        Join<Post, SchoolEvaluations> schoolEvaluations = post.join("schoolEvaluations");
        Predicate condition = cb.equal(schoolEvaluations.get("schoolId"), id);
        cq.where(condition);
        
        return entityManager.createQuery(cq).getResultList();
    }
}
