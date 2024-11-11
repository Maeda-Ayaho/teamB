package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.PostsDTO;
import com.example.demo.service.PostService;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired//postService依存関係
    private PostService postService;

    //投稿入力ページ表示userform
    @GetMapping("/schools/{id}/userform")
    public String showUserForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("title", "投稿入力");
        return "layout/userForm";
    }

    //確認ページに遷移userform_check
    @PostMapping("/schools/{schoolId}/user/add")
    public String confirmPost(@ModelAttribute PostsDTO postsDTO, @PathVariable("id") Long schoolId, BindingResult result, Model model){
        //schoolIdをpostsDTOにセット
        postsDTO.setSchoolId(schoolId);
        if(result.hasErrors()){
            return "error-other";
        }

        postsDTO.setSchoolId(schoolId);
        //postsDTO.setSchoolId(id);
        model.addAttribute("postsDTO", postsDTO); // キャメルケースにする
        model.addAttribute("title", "入力確認");
        return "layout/userform_check";
    }

    @GetMapping("/layout/thanks")
    //thanksページを表示する
    public String viewThanksPage(Model model){
        return "layout/thanks";
    }

    //投稿完了Thanksページ
    @PostMapping("/thanks")
    public String registerPost (@ModelAttribute PostsDTO postsDTO, BindingResult result, Model model){
        if(result.hasErrors()){
            //バリデーションがある場合
            result.getAllErrors().forEach(error ->{
                System.out.println("Error: " + error.getDefaultMessage());
            });
            return "error-404";
        }
        //投稿IDがないときに新規で投稿IDを作る
        
        postService.savePost(postsDTO);
        return "redirect:/layout/thanks";
    }
}