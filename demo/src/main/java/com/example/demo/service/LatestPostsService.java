package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.repository.LatestPostsRepository;

@Service
public class LatestPostsService {
    
    @Autowired
    private LatestPostsRepository latestPostsRepository;

    //最新の投稿3件取得 削除されていない 降順ソート
    public List<Post> findAllPosts(){
        return latestPostsRepository.findTop3ByIsDeletedFalseOrderByIdDesc();
    }
}
