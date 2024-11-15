package com.example.demo.model;


public class RankingData {
    private String schoolImage;
    private String schoolName;
    private Double avgScore;
    private Long postCount;
    private Integer schoolDeviationValue;

    public RankingData(String schoolImage, String schoolName, Double avgScore, Long postCount, Integer schoolDeviationValue) {
        this.schoolImage = schoolImage;
        this.schoolName = schoolName;
        this.avgScore = avgScore;
        this.postCount = postCount;
        this.schoolDeviationValue = schoolDeviationValue;
    }
    
    // Getters and setters
    public String getSchoolImage() {
        return schoolImage;
    }

    public void setSchoolImage(String schoolImage) {
        this.schoolImage = schoolImage;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    public Long getPostCount() {
        return postCount;
    }

    public void setPostCount(Long postCount) {
        this.postCount = postCount;
    }

    public Integer getSchoolDeviationValue() {
        return schoolDeviationValue;
    }

    public void setSchoolDeviationValue(Integer schoolDeviationValue) {
        this.schoolDeviationValue = schoolDeviationValue;
    }
}