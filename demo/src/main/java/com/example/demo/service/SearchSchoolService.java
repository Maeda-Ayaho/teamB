package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SearchSchoolDTO;
import com.example.demo.repository.SearchSchoolRepository;

@Service
public class SearchSchoolService {
    
    @Autowired
    private SearchSchoolRepository searchschoolrepository;

    public List<SearchSchoolDTO> dynamicSearchSchools(String schoolNameInput, String prefecture,
                                            List<String> establishmentType, List<String> genderType,
                                            Integer deviationValueMin, Integer deviationValueMax) {
    // 「高校」を除去
    String processedName = schoolNameInput.replaceAll("高校", "").trim() ;

    // 名前の検索条件を設定
    // String nameColumn = "name"; // デフォルトは name (漢字名) カラム
    if (processedName.matches("^[ぁ-ん]+$")) {
        // ひらがなのみの場合、ふりがなで検索
            return searchschoolrepository.searchschoolsByFurigana(
                prefecture,
                processedName,
                establishmentType,
                genderType,
                deviationValueMin,
                deviationValueMax
                );
    }else{
        // 漢字または混合入力の場合、漢字名で検索
            return searchschoolrepository.searchschoolsByKanji(
                prefecture,
                processedName,
                establishmentType,
                genderType,
                deviationValueMin,
                deviationValueMax
            );
    }
}
}
