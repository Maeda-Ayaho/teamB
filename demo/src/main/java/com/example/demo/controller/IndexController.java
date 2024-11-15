package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Post;
import com.example.demo.service.LatestPostsService;

@Controller
public class IndexController {

    @Autowired
    private LatestPostsService latestPostsService;
    @GetMapping("/")
    public String index(Model model) {
        List <Post> posts = latestPostsService.findTop3Posts();
        //最新の3件のpostを取得
        model.addAttribute("posts", posts);
        return "layout/top";
    }

    // @GetMapping("/login")
    // public String login() {
        
    //     return "";
    // }
}