package com.example.demo.model;

<<<<<<< HEAD


=======
>>>>>>> 7a45eebfaed19fbba18b96150900798bd1aea601
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
<<<<<<< HEAD
import jakarta.persistence.ManyToOne;
=======
import jakarta.persistence.OneToOne;
>>>>>>> 7a45eebfaed19fbba18b96150900798bd1aea601
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
<<<<<<< HEAD
@Table(name = "school_evaluations")
=======
@Table(name = "school_evaluations") // テーブル名も小文字にすることが一般的
>>>>>>> 7a45eebfaed19fbba18b96150900798bd1aea601
public class SchoolEvaluations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID (bigserial)

    @NotNull
    @Column(name = "post_id", nullable = false)
    private Long postId; // 投稿ID (外部キー)

    @NotNull
    @Column(name = "school_id", nullable = false)
    private Long schoolId; // 学校ID (外部キー)

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

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id", insertable = false, updatable = false)
    private School school; // 学校エンティティとのリレーション

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Post post; // 投稿エンティティとのリレーション
    
    public SchoolEvaluations() {
    }

    public SchoolEvaluations(Long postId, Long schoolId, Integer environmentScore, Integer clubScore, Integer eventScore,
                Double totalScore, String environmentComment, String clubComment,
                String eventComment, String totalComment) {
=======
    // 1対1のリレーションを設定
    @OneToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Post post; // 投稿IDと関連付ける

    public SchoolEvaluations() {
    }

    public SchoolEvaluations(Long postId, Integer environmentScore, Integer clubScore, Integer eventScore,
                             Double totalScore, String environmentComment, String clubComment,
                             String eventComment, String totalComment) {
>>>>>>> 7a45eebfaed19fbba18b96150900798bd1aea601
        this.postId = postId;
        this.schoolId = schoolId;
        this.environmentScore = environmentScore;
        this.clubScore = clubScore;
        this.eventScore = eventScore;
        this.totalScore = totalScore;
        this.environmentComment = environmentComment;
        this.clubComment = clubComment;
        this.eventComment = eventComment;
        this.totalComment = totalComment;
    }

<<<<<<< HEAD
    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    // Getters and Setters
=======
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

>>>>>>> 7a45eebfaed19fbba18b96150900798bd1aea601
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