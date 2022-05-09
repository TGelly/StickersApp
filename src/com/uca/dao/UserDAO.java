package com.uca.dao;

import com.uca.entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends _Generic<UserEntity> {

    public ArrayList<UserEntity> getAllUsers() {
        ArrayList<UserEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM users ORDER BY userID ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserEntity entity = new UserEntity();
                entity.setId(resultSet.getInt("userID"));
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
    public UserEntity create(UserEntity obj) {
        String id = Integer.toString(obj.getId());
        String firstname = obj.getFirstName();
        String lastname = obj.getLastName();

        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO users VALUES(?,?,?);");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,firstname);
            preparedStatement.setString(3,lastname);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(UserEntity obj) {
        String id = Integer.toString(obj.getId());

        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM users WHERE userID = ?;");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}