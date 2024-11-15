package com.example.demo.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// 投稿情報を格納するDTOクラス
public class PostsDTO {

    // Postの情報を保持するDTO
    @NotNull
    private Long schoolId; // 学校ID

    @NotBlank(message = "必須です")
    private String enrollment; // 入学卒業年

    @NotBlank(message = "必須です")
    private String gender; // 男女

    @NotBlank(message = "必須です")
    @Size(max = 30, message = "タイトルは30文字以下です")
    private String title; // タイトル

    @NotNull(message = "必須です")
    @NotBlank(message = "必須です")
    private String status; // ステータス(在校生卒業生)

    private LocalDateTime postedAt;  // 投稿日時

    @NotNull
    private Boolean isDeleted = false; // 論理削除

    // SchoolEvaluationsの情報を保持するDTO
    private Long postId = null; // 投稿ID (外部キー)

    @NotNull
    private int environmentScore; // 環境スコア

    @NotNull
    private int clubScore; // 部活動スコア

    @NotNull
    private int eventScore; // イベントスコア

    @Size(max = 400, message = "400文字以下です")
    private String environmentComment; // 環境コメント

    @Size(max = 400, message = "400文字以下です")
    private String clubComment; // 部活動コメント

    @Size(max = 400, message = "400文字以下です")
    private String eventComment; // イベントコメント

    @Size(max = 400, message = "400文字以下です")
    private String totalComment; // 総合コメント

    public PostsDTO() {
        // デフォルトコンストラクタ
    }

    public PostsDTO(Long schoolId, String enrollment, String gender, String title, String status,
                    Boolean isDeleted, Long postId, int environmentScore, int clubScore,
                    int eventScore, String environmentComment, String clubComment, 
                    String eventComment, String totalComment) {
        this.schoolId = schoolId;
        this.enrollment = enrollment;
        this.gender = gender;
        this.title = title;
        this.status = status;
        this.isDeleted = isDeleted != null ? isDeleted : false;  // nullチェックを行い、デフォルト値を設定
        this.postId = postId;
        this.environmentScore = environmentScore;
        this.clubScore = clubScore;
        this.eventScore = eventScore;
        this.environmentComment = environmentComment;
        this.clubComment = clubComment;
        this.eventComment = eventComment;
        this.totalComment = totalComment;
    }

    // ゲッターセッター
    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public Long getSchoolId() {
        return schoolId;
    }

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
    }

    public int getEnvironmentScore() {
        return environmentScore;
    }

    public int getClubScore() {
        return clubScore;
    }

    public int getEventScore() {
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
    }

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

    public void setEnvironmentScore(int environmentScore) {
        this.environmentScore = environmentScore;
    }

    public void setClubScore(int clubScore) {
        this.clubScore = clubScore;
    }

    public void setEventScore(int eventScore) {
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