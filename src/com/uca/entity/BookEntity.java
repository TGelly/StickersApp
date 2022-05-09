package com.uca.entity;

import java.sql.Timestamp;

public class BookEntity {
    private String childName;
    private int bookId;

    public BookEntity() {
        //Ignored !
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }
}