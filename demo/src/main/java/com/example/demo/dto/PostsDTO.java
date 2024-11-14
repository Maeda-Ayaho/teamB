package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//投稿情報を格納するDTOクラス
public class PostsDTO {

    //Postの情報を保持するDTO
    @NotNull
    private Long schoolId;//学校ID

    @NotBlank(message = "必須です")
    private String enrollment;//入学卒業年

    @NotBlank(message = "必須です")
    private String gender;//男女

    @NotBlank(message = "必須です")
    @Size(max = 30, message = "タイトルは30文字以下です")
    private String title;//タイトル

    @NotNull(message = "必須です")
    @NotBlank(message = "必須です")
    private String status;//ステータス(在校生卒業生)

    @NotNull
    private Boolean isDeleted = false;//論理削除

    //SchoolEvaluationsの情報を保持するDTO

    private Long postId = null; // 投稿ID (外部キー)

    @NotNull
    private Integer environmentScore;//環境スコア

    @NotNull
    private Integer clubScore; // 部活動スコア

    @NotNull
    private Integer eventScore; // イベントスコア

    @Size(max = 400, message = "400文字以下です")
    private String environmentComment; // 環境コメント

    @Size(max = 400, message = "400文字以下です")
    private String clubComment; // 部活動コメント

    @Size(max = 400, message = "400文字以下です")
    private String eventComment; // イベントコメント

    @Size(max = 400, message = "400文字以下です")
    private String totalComment; // 総合コメント

    //ゲッターセッター
    public Long getSchoolId() {
        return schoolId;
    }//追加

    public String getEnrollment() {
        return enrollment;
    }

    public String getGender() {
        return gender;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public Long getPostId() {
        return postId;
    }//追加

    public Integer getEnvironmentScore() {
        return environmentScore;
    }

    public Integer getClubScore() {
        return clubScore;
    }

    public Integer getEventScore() {
        return eventScore;
    }

    public String getEnvironmentComment() {
        return environmentComment;
    }

    public String getClubComment() {
        return clubComment;
    }

    public String getEventComment() {
        return eventComment;
    }

    public String getTotalComment() {
        return totalComment;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }//追加

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setEnvironmentScore(Integer environmentScore) {
        this.environmentScore = environmentScore;
    }

    public void setClubScore(Integer clubScore) {
        this.clubScore = clubScore;
    }

    public void setEventScore(Integer eventScore) {
        this.eventScore = eventScore;
    }

    public void setEnvironmentComment(String environmentComment) {
        this.environmentComment = environmentComment;
    }

    public void setClubComment(String clubComment) {
        this.clubComment = clubComment;
    }

    public void setEventComment(String eventComment) {
        this.eventComment = eventComment;
    }

    public void setTotalComment(String totalComment) {
        this.totalComment = totalComment;
    }

    
}