package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//投稿情報を格納するDTOクラス
public class PostsDTO {

    //Postの情報を保持するDTO
    @NotNull
    @Column(name = "school_id", nullable = false)
    private Long schoolId;//学校ID

    @Column(name = "posted_at")
    private String postedAt; // 投稿日時

    @NotBlank(message = "必須です")
    @Column(name = "enrollment")
    private String enrollment;//入学卒業年

    @NotBlank(message = "必須です")
    @Column(name = "gender", nullable = false)
    private String gender;//男女

    @NotBlank(message = "必須です")
    @Size(max = 30, message = "タイトルは30文字以下です")
    @Column(name = "title", nullable = false, length = 30)
    private String title;//タイトル

    @NotNull(message = "必須です")
    @NotBlank(message = "必須です")
    @Column(name = "status", nullable = false)
    private String status;//ステータス(在校生卒業生)

    @NotNull
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;//論理削除

    //SchoolEvaluationsの情報を保持するDTO

    @NotNull
    @Column(name = "post_id", nullable = false)
    private Long postId; // 投稿ID (外部キー)

    @NotNull
    @Column(name = "environment_score", nullable = false)
    private Integer environmentScore;//環境スコア

    @NotNull
    @Column(name = "club_score", nullable = false)
    private Integer clubScore; // 部活動スコア

    @NotNull
    @Column(name = "event_score", nullable = false)
    private Integer eventScore; // イベントスコア

    @NotNull
    @Column(name = "total_score", nullable = false)
    private Double totalScore; // 総合スコア

    @Size(max = 400, message = "400文字以下です")
    @Column(name = "environment_comment", length = 400)
    private String environmentComment; // 環境コメント

    @Size(max = 400, message = "400文字以下です")
    @Column(name = "club_comment", length = 400)
    private String clubComment; // 部活動コメント

    @Size(max = 400, message = "400文字以下です")
    @Column(name = "event_comment", length = 400)
    private String eventComment; // イベントコメント

    @Size(max = 400, message = "400文字以下です")
    @Column(name = "total_comment", length = 400)
    private String totalComment; // 総合コメント

    //ゲッターセッター
    public Long getSchoolId() {
        return schoolId;
    }//追加

    public String getPostedAt() {
        return postedAt;
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

    public Double getTotalScore() {
        return totalScore;
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

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
        //return postedAt;
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

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
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