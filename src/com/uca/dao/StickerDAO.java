package com.uca.dao;

import com.uca.entity.StickerEntity;

import java.sql.*;
import java.util.ArrayList;

public class StickerDAO extends _Generic<StickerEntity> {

    public ArrayList<StickerEntity> getAllStickers() {
        ArrayList<StickerEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM stickers ORDER BY stickerID ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                StickerEntity entity = new StickerEntity();
                entity.setStickerId(resultSet.getInt("stickerID"));
                entity.setColor(resultSet.getString("color"));
                entity.setComment(resultSet.getString("comment"));
                entity.setDate(resultSet.getString("stickerDate"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public StickerEntity create(StickerEntity obj) {
        String id = Integer.toString(obj.getStickerId());
        String color = obj.getColor();
        String comment = obj.getComment();
        String date = obj.getDate();

        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO stickers VALUES(?,?,?,?);");
            preparedStatement.setString(1,id.toString());
            preparedStatement.setString(2,color);
            preparedStatement.setString(3,comment);
            preparedStatement.setString(4,date);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(StickerEntity obj) {
        String id = Integer.toString(obj.getStickerId());

        try{
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM stickers WHERE stickerID = ?;");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}