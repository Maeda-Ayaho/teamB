package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Post;

@Repository
public interface LatestPostsRepository extends JpaRepository<Post, Long>{

    //IDが大きい順で3件取得
    @Query("SELECT DISTINCT p FROM Post p JOIN FETCH p.school WHERE p.isDeleted = false ORDER BY p.id DESC LIMIT 3")
    //isDeletedがfalseかつ、IDの降順で最新の3件を取得するメソッド
    List<Post> findTop3ByIsDeletedFalseOrderByIdDesc();
}
