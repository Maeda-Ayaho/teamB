package com.example.demo.service;

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
    private SchoolEvaluationsRepository schoolEvaluationsRepository;

    //投稿の新規登録
    @Transactional
    public void savePost(PostsDTO postsDTO){
        Post post = new Post();
        SchoolEvaluations schoolEvaluations = new SchoolEvaluations();
        //入力内容をエンティティに設定
        post.setSchoolId(postsDTO.getSchoolId());//学校ID
        post.setPostedAt(postsDTO.getPostedAt());//投稿日
        post.setEnrollment(postsDTO.getEnrollment());//入学卒業年
        post.setGender(postsDTO.getGender());//男女
        post.setTitle(postsDTO.getTitle());//タイトル
        post.setIsDeleted(false);//論理削除

        schoolEvaluations.setPostId(postsDTO.getPostId());//投稿ID
        schoolEvaluations.setEnvironmentScore(postsDTO.getEnvironmentScore());//環境スコア
        schoolEvaluations.setClubScore(postsDTO.getClubScore());//部活動スコア
        schoolEvaluations.setEventScore(postsDTO.getEventScore());//イベントスコア
        schoolEvaluations.setTotalScore(postsDTO.getTotalScore());//総合スコア
        schoolEvaluations.setEnvironmentComment(postsDTO.getEnvironmentComment());//環境コメント
        schoolEvaluations.setClubComment(postsDTO.getClubComment());//部活動コメント
        schoolEvaluations.setEventComment(postsDTO.getEventComment());//イベントコメント
        schoolEvaluations.setTotalComment(postsDTO.getTotalComment());//総合コメント

        postRepository.save(post);
        schoolEvaluationsRepository.save(schoolEvaluations);
    }
}
