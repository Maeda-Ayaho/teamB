package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PostsDTO;
import com.example.demo.model.Post;
import com.example.demo.model.SchoolEvaluations;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SchoolEvaluationsRepository;

import jakarta.transaction.Transactional;

@Service
    public class PostService {
        @Autowired//postRepositoryと依存関係
        private PostRepository postRepository;
        @Autowired
        private SchoolEvaluationsRepository schoolEvaluationsRepository;

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
}
