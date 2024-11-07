package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.RankingData;
import com.example.demo.service.RankingService;

@Controller
public class RankingController {

    @Autowired
    private final RankingService rankingService;

    @GetMapping("/ranking")
    public String showRanking(Model model) {
        List<RankingData> rankingList = rankingService.getSchoolRankings();
        model.addAttribute("rankingList", rankingList);
        System.out.println("Retrieved Rankings: " + rankingList);   //ログに内容出力するためだけ
        return "layout/ranking";
        // 本来はmain.htmlに表示させる部分だが、一旦テストでranking.htmlに出力させる
    }
}