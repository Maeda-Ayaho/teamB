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

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class PostController {

    @Autowired//postService依存関係
    private PostService postService;

    //投稿入力ページ表示edit-post
    @GetMapping("/schools/{id}/edit-post")
    public String showUserForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("schoolId", id);
        PostsDTO postsDTO = new PostsDTO();
        model.addAttribute("postsDTO", postsDTO);
        //PostsDTOクラスでユーザーが入力しないカラムをセッターで送る
        postsDTO.setIsDeleted(false);
        postsDTO.setSchoolId(id);
        return "layout/edit-post";
    }

    //確認ページに遷移edit-psot-check
    @PostMapping("/schools/{schoolId}/user/add")
    public String confirmPost(@Valid @ModelAttribute PostsDTO postsDTO,
                                @PathVariable(name = "schoolId") Long schoolId,
                                BindingResult result, Model model){
        //エラーループして出力するのは本実装じゃない？エラーメッセージ用のモデルに値詰めて表示するとかやる必要ある
        if(result.hasErrors()){
            result.getAllErrors().forEach(error ->{
                System.out.println("Error: " + error.getDefaultMessage());
            });
            return "layout/error-other";
        }
        return "layout/edit-psot-check";
    }

    //投稿完了Thanksページ
    @PostMapping("/schools/thanks")
    public String registerPost (@Valid @ModelAttribute PostsDTO postsDTO,
                                    BindingResult result, Model model){
        if(result.hasErrors()){
            //バリデーションがある場合
            //エラーループして出力するのは本実装じゃない？エラーメッセージ用のモデルに値詰めて表示するとかやる必要ある
            result.getAllErrors().forEach(error ->{
                System.out.println("Error: " + error.getDefaultMessage());
            });
            return "layout/error-other";
        }
        //DB操作をする
        
        //投稿IDがないときに新規で投稿IDを作る
        postService.savePost(postsDTO);
        return "/schools/layout/thanks";
    }

    //ToDo これは正規のリダイレクト先にする事。いったん /layout/thanksにしています
    @GetMapping("/layout/thanks")
    //thanksページを表示する
    /*public String viewThanksPage(Model model){
        return "layout/thanks";*/
    public String getMethodName() {
        return "done";
    }
}