package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Post;

@Repository
public interface LatestPostsRepository extends JpaRepository<Post, Long>{

    //IDが大きい順で3件取得
    //@Query("SELECT p FROM Post p WHERE p.isDeleted = false ORDER BY p.id DESC")
    //isDeletedがfalseかつ、IDの降順で最新の3件を取得するメソッド
    List<Post> findTop3ByIsDeletedFalseOrderByIdDesc();
}
