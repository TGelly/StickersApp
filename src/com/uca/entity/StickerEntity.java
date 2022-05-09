package com.uca.entity;

import java.sql.Timestamp;

public class StickerEntity {
    private int stickerId;
    private String color;
    private String comment;
    private String date;

    public StickerEntity() {
        //Ignored !
    }

    public int getStickerId(){
        return stickerId;
    }

    public void setStickerId(int stickerId){
        this.stickerId = stickerId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}