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

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    // 学校新規登録画面へ
    @GetMapping("/new")
    public String addSchoolForm(Model model) {
        model.addAttribute("school", new School());
        return "layout/edit-school";  // 新規登録フォーム
    }

    // 学校情報の確認画面に遷移
    @PostMapping("/add")
    public String addSchool(@ModelAttribute School school, Model model, HttpSession session) {
        // モデルに追加することで、セッションに保存する
        session.setAttribute("school", school);  // セッションに学校情報を保存
        // 確認画面へリダイレクト
        return "redirect:/admin/edit_school_check";
    }


    @GetMapping("/edit_school_check")
    public String editSchoolCheck(Model model, HttpSession session) {
        // セッションから学校情報を取得
        School school = (School) session.getAttribute("school");
        
        if (school != null) {
            model.addAttribute("school", school);  // モデルに学校情報を追加
        }
        
        return "layout/edit-school-check";  // 確認画面を表示
    }
    // 学校情報を保存し、登録完了画面に遷移
    @PostMapping("/add2")
    public String addSchool2(@ModelAttribute School school, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // バリデーションエラーがある場合
            result.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.getDefaultMessage());
            });
            return "error-404";
        }
        
        schoolService.save(school);
        model.addAttribute("school", school);
        // 登録完了ページにリダイレクト
        return "redirect:/admin/thanks";
    }

    // 学校情報を取得して編集画面に遷移
    @GetMapping("/edit/{id}")
    public String editSchool(@PathVariable Long id, Model model) {
        // 学校情報をIDで検索
        School school = schoolService.findById(id);
        // 学校情報をビューに渡す
        model.addAttribute("school", school);
        // 編集画面のビューを返す
        return "layout/edit-school";
    }


    // 登録完了画面
    @GetMapping("/thanks")
    public String thanksPage() {
        System.out.println("登録完了ページにアクセスしました。");
        return "layout/thanks";  // 登録完了画面
    }
}




