package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;


@Controller
public class SchoolController {

    private SchoolService schoolService;

    // 新しい学校を追加するためのメソッド
    @GetMapping("/schools/new")
    public String addSchoolForm(Model model) {
        // 新しいSchoolオブジェクトを作成してモデルに追加
        model.addAttribute("school", new School());
        return "edit_school"; // edit_school.htmlを表示
    }

    @PostMapping("/schools/add")
    public String addSchool(@ModelAttribute School school, Model model) {
        // 受け取った学校情報を保存
        //schoolService.save(school);
        // モデルに学校情報を追加
        model.addAttribute("school", school);
        // 登録確認画面へ遷移
        return "edit_school_check";
    }
    @PostMapping("/schools/add2")
    public String addSchool2(@ModelAttribute School school, Model model) {
        // 受け取った学校情報を保存
        schoolService.save(school);
        // モデルに学校情報を追加
        model.addAttribute("school", school);
        // 登録確認画面へ遷移
        return "edit_school_check";
    }
}
