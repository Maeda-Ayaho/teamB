package com.example.demo.model;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "school_evaluations")
public class School_evaluations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID (bigserial)

    @NotNull
    @Column(name = "post_id", nullable = false)
    private Long postId; // 投稿ID (外部キー)

    @NotNull
    @Column(name = "environment_score", nullable = false)
    private Integer environmentScore; // 環境スコア

    @NotNull
    @Column(name = "club_score", nullable = false)
    private Integer clubScore; // 部活動スコア

    @NotNull
    @Column(name = "event_score", nullable = false)
    private Integer eventScore; // イベントスコア

    @NotNull
    @Column(name = "total_score", nullable = false)
    private Double totalScore; // 総合スコア

    @Size(max = 400)
    @Column(name = "environment_comment", length = 400)
    private String environmentComment; // 環境コメント

    @Size(max = 400)
    @Column(name = "club_comment", length = 400)
    private String clubComment; // 部活動コメント

    @Size(max = 400)
    @Column(name = "event_comment", length = 400)
    private String eventComment; // イベントコメント

    @Size(max = 400)
    @Column(name = "total_comment", length = 400)
    private String totalComment; // 総合コメント

    public School_evaluations() {
    }

    public School_evaluations(Long postId, Integer environmentScore, Integer clubScore, Integer eventScore,
                Double totalScore, String environmentComment, String clubComment,
                String eventComment, String totalComment) {
        this.postId = postId;
        this.environmentScore = environmentScore;
        this.clubScore = clubScore;
        this.eventScore = eventScore;
        this.totalScore = totalScore;
        this.environmentComment = environmentComment;
        this.clubComment = clubComment;
        this.eventComment = eventComment;
        this.totalComment = totalComment;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Integer getEnvironmentScore() {
        return environmentScore;
    }

    public void setEnvironmentScore(Integer environmentScore) {
        this.environmentScore = environmentScore;
    }

    public Integer getClubScore() {
        return clubScore;
    }

    public void setClubScore(Integer clubScore) {
        this.clubScore = clubScore;
    }

    public Integer getEventScore() {
        return eventScore;
    }

    public void setEventScore(Integer eventScore) {
        this.eventScore = eventScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public String getEnvironmentComment() {
        return environmentComment;
    }

    public void setEnvironmentComment(String environmentComment) {
        this.environmentComment = environmentComment;
    }

    public String getClubComment() {
        return clubComment;
    }

    public void setClubComment(String clubComment) {
        this.clubComment = clubComment;
    }

    public String getEventComment() {
        return eventComment;
    }

    public void setEventComment(String eventComment) {
        this.eventComment = eventComment;
    }

    public String getTotalComment() {
        return totalComment;
    }

    public void setTotalComment(String totalComment) {
        this.totalComment = totalComment;
    }
}