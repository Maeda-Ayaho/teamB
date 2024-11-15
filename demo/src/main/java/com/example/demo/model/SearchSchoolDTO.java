package com.example.demo.model;

import java.util.List;

public class SearchSchoolDTO {
    private String prefecture;
    private List<String> establishmentType;
    private List<String> genderType;
    private Integer deviationValueMin;
    private Integer deviationValueMax;
    private String name;
    private Integer deviationValue;

    
    public Integer getDeviationValue() {
        return deviationValue;
    }

    public void setDeviationValue(Integer deviationValue) {
        this.deviationValue = deviationValue;
    }

    public String getPrefecture() {
        return prefecture;
    }
    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }
    public List<String> getEstablishmentType() {
        return establishmentType;
    }
    public void setEstablishmentType(List<String> establishmentType) {
        this.establishmentType = establishmentType;
    }
    public List<String> getGenderType() {
        return genderType;
    }
    public void setGenderType(List<String> genderType) {
        this.genderType = genderType;
    }
    public Integer getDeviationValueMin() {
        return deviationValueMin;
    }
    public void setDeviationValueMin(Integer deviationValueMin) {
        this.deviationValueMin = deviationValueMin;
    }
    public Integer getDeviationValueMax() {
        return deviationValueMax;
    }
    public void setDeviationValueMax(Integer deviationValueMax) {
        this.deviationValueMax = deviationValueMax;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}