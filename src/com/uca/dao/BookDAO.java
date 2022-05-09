package com.uca.dao;

import com.uca.entity.BookEntity;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO extends _Generic<BookEntity> {

    public ArrayList<BookEntity> getAllBooks() {
        ArrayList<BookEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM books ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookEntity entity = new BookEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public BookEntity create(BookEntity obj) {
        int id = obj.getId();
        //todo faire la requête SQL qui créé un Book
        //TODO !
        return null;
    }

    @Override
    public void delete(BookEntity obj) {
        int id = obj.getId();
        //todo faire la requête SQL qui supprime un Book
        //TODO !
    }
}
