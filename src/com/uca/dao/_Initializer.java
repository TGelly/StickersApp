package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (userID int primary key auto_increment, role varchar(10), firstname varchar(100), lastname varchar(100), username varchar(100), password varchar(100)); ");
            statement.executeUpdate();

            /*
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS class (classID int primary key auto_increment, containerTeacher int, foreign key (containerTeacher) references users(userID)); ");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS books (bookID int primary key auto_increment, childName varchar(100), containerClass int, containerParent int), foreign key (containerClass) references class(classID), foreign key (containerParent) references user(userID)); ");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS sticker (stickerID int primary key auto_increment, stickerDate varchar(100), color varchar(8), comment varchar(250), containerBook int, teacher int, foreign key (containerBook) references book(bookID), foreign key (teacher) references user(userID)); ");
            statement.executeUpdate();
            */

            //Todo Remove me !
            statement = connection.prepareStatement("INSERT INTO users(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, "Theodore");
            statement.setString(2, "Muillerez");
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
