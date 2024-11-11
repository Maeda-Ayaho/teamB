package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "schools", uniqueConstraints = @UniqueConstraint(columnNames = {"prefecture", "name"}))
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 学校ID

    @NotBlank
    @Size(max = 30)
    @Column(name = "name", nullable = false, length = 30)
    private String name; // 学校名(漢字)

    @NotBlank
    @Size(max = 100)
    @Column(name = "name_furigana", nullable = false, length = 100)
    private String nameFurigana; // 学校名(ふりがな)

    @NotBlank
    @Column(name = "prefecture", nullable = false)
    private String prefecture; // 都道府県

    @Min(value = 0, message = "偏差値は28以上である必要があります")
    @Max(value = 100, message = "偏差値は78以下である必要があります")
    @Column(name = "deviation_value", nullable = false)
    private int deviationValue;

    @Column(name = "image")
    private String image; // 学校画像

    @NotBlank
    @Column(name = "homepage", nullable = false)
    private String homepage; // 学校HP

    @NotBlank
    @Size(max = 100)
    @Column(name = "address", nullable = false, length = 100)
    private String address; // 所在地

    @NotBlank
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber; // 電話番号

    @NotBlank
    @Column(name = "gender_type", nullable = false)
    private String genderType; // 男女共学

    @NotBlank
    @Column(name = "establishment_type", nullable = false)
    private String establishmentType; // 国公私立

    @NotBlank
    @Size(max = 400)
    @Column(name = "description", nullable = false, length = 400)
    private String description; // 学校概要

    @OneToOne(mappedBy = "school") // 1対1のリレーションを定義。`school`フィールドがリレーションを所有
    private Post post; // 投稿と1対1リレーション

    public School() {
    }

<<<<<<< HEAD
    public School(String name, String nameFurigana, String prefecture, Integer deviationValue,
=======
    public School(String name, String nameFurigana, String prefecture, int deviationValue,
>>>>>>> 7a45eebfaed19fbba18b96150900798bd1aea601
                  String image, String homepage, String address, String phoneNumber,
                  String genderType, String establishmentType, String description) {
        this.name = name;
        this.nameFurigana = nameFurigana;
        this.prefecture = prefecture;
        this.deviationValue = deviationValue;
        this.image = image;
        this.homepage = homepage;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.genderType = genderType;
        this.establishmentType = establishmentType;
        this.description = description;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameFurigana() {
        return nameFurigana;
    }

    public void setNameFurigana(String nameFurigana) {
        this.nameFurigana = nameFurigana;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public int getDeviationValue() {
        return deviationValue;
    }

    public void setDeviationValue(int deviationValue) {
        this.deviationValue = deviationValue;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String getEstablishmentType() {
        return establishmentType;
    }

    public void setEstablishmentType(String establishmentType) {
        this.establishmentType = establishmentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}