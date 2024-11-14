package com.example.demo.controller;
import java.util.Optional;

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
import jakarta.validation.Valid;


@Controller
@RequestMapping("/admin")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    // 学校新規登録画面へ
    @GetMapping("/new")
    public String addSchoolForm(Model model) {
        model.addAttribute("school", new School());
        model.addAttribute("title", "学校登録");
        return "layout/edit-school";  // 新規登録フォーム
    }

    // 学校情報の確認画面に遷移
    @PostMapping("/add")
    public String addSchool(@Valid @ModelAttribute School school, BindingResult bindingResult, Model model, HttpSession session) {
        // バリデーションエラーがあればフォームに戻す
        if (bindingResult.hasErrors()) {
            return "layout/edit-school";  // フォームに戻る（テンプレート名に合わせて変更）
        }
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
        // バリデーションエラーの確認
        if (result.hasErrors()) {
            // バリデーションエラーがある場合
            result.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.getDefaultMessage());
            });
            return "error-404";
        }
            // 更新された学校情報を保存
        schoolService.save(school); // Schholオブジェクトのフィールド確認する。id入ってなければupdate掛からない
        
        // 更新完了後に成功ページへリダイレクト
        return "redirect:/admin/thanks";
    }


    // 学校情報を取得して編集画面に遷移
    @GetMapping("/edit/{id}")
    public String editSchool(@PathVariable("id") Long id, Model model) {
        // 学校情報をIDで検索
        Optional<School> optionalSchool = schoolService.findschoolById(id);
        // 学校情報をビューに渡す
        if (optionalSchool.isPresent()) {
            // 値が存在する場合の処理
            School school = optionalSchool.get();
            model.addAttribute("school", school);
            model.addAttribute("title", "学校編集");
            // 編集画面のビューを返す
            return "layout/edit-school";
        }
        return "error-404";
    }

    // 登録完了画面
    @GetMapping("/thanks")
    public String thanksPage() {
        System.out.println("登録完了ページにアクセスしました。");
        return "layout/thanks";  // 登録完了画面
    }
}




