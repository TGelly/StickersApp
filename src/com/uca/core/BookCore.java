package com.uca.core;

import com.uca.dao.BookDAO;
import com.uca.entity.BookEntity;

import java.util.ArrayList;

public class BookCore {

    public static ArrayList<BookEntity> getAllBooks() {
        return new BookDAO().getAllBooks();
    }

}
