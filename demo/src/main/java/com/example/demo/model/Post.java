package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 投稿ID

    @NotNull
    @Column(name = "school_id", nullable = false)
    private Long schoolId; // 学校ID (外部キー)

    @Column(name = "posted_at")
    private String postedAt; // 投稿日時

    @NotBlank
    @Column(name = "enrollment")
    private String enrollment;//入学卒業年

    @NotBlank
    @Column(name = "gender", nullable = false)
    private String gender; // 男女

    @NotBlank
    @Size(max = 30)
    @Column(name = "title", nullable = false, length = 30)
    private String title; // タイトル

    @NotBlank
    @Column(name = "status", nullable = false)
    private String status; // ステータス

    @NotNull
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted; // 論理削除

    @OneToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id", insertable = false, updatable = false)
    private School school; // 1対1リレーションを設定

    // 1対1のリレーションを設定
    @OneToOne(mappedBy = "post") // 逆側で`post`が所有する
    private SchoolEvaluations schoolEvaluations;

    public Post() {
    }

    public Post(Long schoolId, String postedAt, String enrollment, String gender, String title, String status, Boolean isDeleted) {
        this.schoolId = schoolId;
        this.postedAt = postedAt;
        this.enrollment = enrollment;
        this.gender = gender;
        this.title = title;
        this.status = status;
        this.isDeleted = isDeleted;
    }

    public SchoolEvaluations getSchoolEvaluations() {
        return schoolEvaluations;
    }

    public void setSchoolEvaluations(SchoolEvaluations schoolEvaluations) {
        this.schoolEvaluations = schoolEvaluations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getEnrollment(){
        return enrollment;
    }

    public void setEnrollment(String enrollment){
        this.enrollment = enrollment;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

