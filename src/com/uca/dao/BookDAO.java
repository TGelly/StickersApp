package com.uca.dao;

import com.uca.entity.BookEntity;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO extends _Generic<BookEntity> {

    public ArrayList<BookEntity> getAllBooks() {
        ArrayList<BookEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM books ORDER BY BookID ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookEntity entity = new BookEntity();
                entity.setBookId(resultSet.getInt("bookID"));
                entity.setChildName(resultSet.getString("childName"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public BookEntity create(BookEntity obj) {
        String id = Integer.toString(obj.getBookId());
        String childName = obj.getChildName();
        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO books VALUES(?,?);");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,childName);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(BookEntity obj) {
        String id = Integer.toString(obj.getBookId());
        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM books WHERE bookID = ?");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}