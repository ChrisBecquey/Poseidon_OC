package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
@Table(name = "rating")
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "MoodysRating is mandatory")
    private String moodysRating;
    private String sandRating;
    private String fitchRating;
    @NotNull(message = "OrderNumber must not be null")
    private Integer orderNumber;

    public Rating(String moodys_rating, String sand_pRating, String fitch_rating, int orderNumber) {
        this.moodysRating = moodys_rating;
        this.sandRating = sand_pRating;
        this.fitchRating = fitch_rating;
        this.orderNumber = orderNumber;
    }

    public Rating() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoodysRating() {
        return moodysRating;
    }

    public void setMoodysRating(String moodysRating) {
        this.moodysRating = moodysRating;
    }

    public String getSandRating() {
        return sandRating;
    }

    public void setSandRating(String sandRating) {
        this.sandRating = sandRating;
    }

    public String getFitchRating() {
        return fitchRating;
    }

    public void setFitchRating(String fitchRating) {
        this.fitchRating = fitchRating;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}
