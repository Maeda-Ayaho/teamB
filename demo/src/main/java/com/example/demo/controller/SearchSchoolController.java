package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Post;
import com.example.demo.model.School;
import com.example.demo.service.PostService;
import com.example.demo.service.SchoolService;
import com.example.demo.service.SearchSchoolService;

@Controller
public class SearchSchoolController {

    @Autowired
    private SearchSchoolService searchschoolservice;

    @Autowired
    private PostService postService;

    @Autowired
    private SchoolService schoolService;
    

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

 //学校詳細ページに遷移するメソッド
    @GetMapping("schools/detail/{id}")
    public String getSchoolDetail(@PathVariable("id") Long schoolId, Model model) {
    // IDに基づいて学校の詳細を検索
    Optional<School> schools = schoolService.findschoolById(schoolId);
    // 取得した学校の学校IDに基づいて、該当学校に寄せられている投稿を取得

    if(schools==null){
        //エラー処理
    }
    //Optional→School型
    School s = schools.get();
    
    List<Post> postList = postService.findPostList(s.getId());

    // モデルに学校情報を追加
    model.addAttribute("school", schools.get());
    // モデルに投稿情報を追加、
    model.addAttribute("posts",postList);
    
    // school-detail.htmlに遷移
    return "layout/school-detail";
    }

}
