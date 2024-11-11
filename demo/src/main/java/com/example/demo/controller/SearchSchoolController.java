package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.School;
import com.example.demo.service.SearchSchoolService;

@Controller
public class SearchSchoolController {

    private SearchSchoolService searchschoolservice;

    public SearchSchoolController(SearchSchoolService searchschoolservice) {
        this.searchschoolservice = searchschoolservice;
    }
    // 学校検索結果を表示する
    @GetMapping("/school-result")
    public String searchSchools(
            @RequestParam(value = "prefecture", required = false) String prefecture,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "establishmentType", required = false) List<String> establishmentType,
            @RequestParam(value = "genderType", required = false) List<String> genderType,
            @RequestParam(value = "deviationValueMin", required = false) Integer deviationValueMin,
            @RequestParam(value = "deviationValueMax", required = false) Integer deviationValueMax,
            Model model) {

        // 学校を検索
        List<School> resuluts = searchschoolservice.searchSchools(
                prefecture, name, establishmentType, genderType, deviationValueMin, deviationValueMax
        );

        // 検索結果をビューに渡す
        model.addAttribute("schools", resuluts);
        return "school-result"; // schoolSearchResult.html に結果を表示
    }

    // 学校詳細ページに遷移するメソッド
    @GetMapping("/school-detail")
    public String getSchoolDetail(@RequestParam("id") Long schoolId, Model model) {
        // IDに基づいて学校の詳細を検索
        School schools = searchschoolservice.findSchoolById(schoolId);
        
        // モデルに学校情報を追加
        model.addAttribute("schools", schools);
        
        // school-detail.htmlに遷移
        return "school-detail";
    }

}
