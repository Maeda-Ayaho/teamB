package com.example.demo.dto;

//投稿情報を格納するDTOクラス
public class PostsDTO {

    //Postの情報を保持するDTO
    private Long schoolId;//学校ID

    private String postedAt; // 投稿日時

    private String enrollment;//入学卒業年

    private String gender;//男女

    private String title;//タイトル

    private String status;//ステータス(在校生卒業生)

    private Boolean isDeleted;//論理削除

    //SchoolEvaluationsの情報を保持するDTO
    private Long postId; // 投稿ID (外部キー)

    private Integer environmentScore;//環境スコア

    private Integer clubScore; // 部活動スコア

    private Integer eventScore; // イベントスコア

    private Double totalScore; // 総合スコア

    private String environmentComment; // 環境コメント

    private String clubComment; // 部活動コメント

    private String eventComment; // イベントコメント

    private String totalComment; // 総合コメント

    //コンストラクタ
    public PostsDTO(Long schoolId, String postedAt, String enrollment, String gender, String title, String status, Boolean isDeleted,
            Long postId, Integer environmentScore, Integer clubScore, Integer eventScore, Double totalScore,
            String environmentComment, String clubComment, String eventComment, String totalComment) {
        this.schoolId = schoolId;//追加
        this.postedAt = postedAt;//追加
        this.enrollment = enrollment;
        this.gender = gender;
        this.title = title;
        this.status = status;
        this.isDeleted = isDeleted;
        this.postId = postId;//追加
        this.environmentScore = environmentScore;
        this.clubScore = clubScore;
        this.eventScore = eventScore;
        this.totalScore = totalScore;
        this.environmentComment = environmentComment;
        this.clubComment = clubComment;
        this.eventComment = eventComment;
        this.totalComment = totalComment;
    }

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

    public String setPostedAt() {
        return postedAt;
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