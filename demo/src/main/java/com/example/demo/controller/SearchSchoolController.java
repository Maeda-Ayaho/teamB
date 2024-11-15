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
    @GetMapping("/schools/search")
    public String searchSchools(
            @RequestParam(name = "pref", required = false) String prefecture,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "est", required = false) List<String> establishmentType,
            @RequestParam(name = "gen", required = false) List<String> genderType,
            @RequestParam(name = "min", required = false) Integer deviationValueMin,
            @RequestParam(name = "max", required = false) Integer deviationValueMax,
            Model model) {

        // 学校を検索
        List<School> results = searchschoolservice.searchSchools(
                prefecture, name, establishmentType, genderType, deviationValueMin, deviationValueMax
        );

        // 検索結果をビューに渡す
        model.addAttribute("results", results);
        return "layout/search-result"; // schoolSearchResult.html に結果を表示
    }
/* 以下　作りかけです　井口
 * 
        // 学校詳細ページに遷移するメソッド
    @GetMapping("schools/detail/{id}")
    public String getSchoolDetail(@RequestParam("id") Long schoolId, Model model) {
        // IDに基づいて学校の詳細を検索
        School schools = searchschoolservice.findBySchoolId(schoolId);
        
        // モデルに学校情報を追加
        model.addAttribute("schools", schools);
        
        // school-detail.htmlに遷移
        return "layout/school-detail";
    }
*/

}
