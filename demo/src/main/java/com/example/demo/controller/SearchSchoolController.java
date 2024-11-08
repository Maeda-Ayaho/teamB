package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.SearchSchoolDTO;
import com.example.demo.service.SearchSchoolService;

@Controller
public class SearchSchoolController {

    private SearchSchoolService searchschoolservice;

    public SearchSchoolController(SearchSchoolService searchschoolservice) {
        this.searchschoolservice = searchschoolservice;
    }

    @GetMapping("/")
    public String searchschools(@RequestParam(required = false) String prefecture,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) List<String> establishmentType,
                                @RequestParam(required = false) List<String> genderType,
                                @RequestParam(required = false) Integer deviationValueMin,
                                @RequestParam(required = false) Integer deviationValueMax,
                                Model model) {

        List<SearchSchoolDTO> schools = searchschoolservice.dynamicSearchSchools(prefecture, name, establishmentType, genderType, deviationValueMin, deviationValueMax);
        model.addAttribute("schools", schools);
        return "top"; // 検索結果を表示するページ
    }
}
