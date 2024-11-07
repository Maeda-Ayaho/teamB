package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.RankingData;
import com.example.demo.repository.RankingRepository;

@Service
public class RankingService {

    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public List<RankingData> getSchoolRankings() {
        return rankingRepository.findSchoolRankings();
    }

}