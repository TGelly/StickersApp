package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //todo remove me!
            statement = connection.prepareStatement("drop table if exists users, classes, books, stickers;");
            statement.executeUpdate();

            //Init articles table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (userID int primary key auto_increment, role varchar(10), firstname varchar(100), lastname varchar(100), username varchar(100), password varchar(100)); ");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS classes (classID int primary key auto_increment, containerTeacher int, foreign key (containerTeacher) references users(userID)); ");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS books (bookID int primary key auto_increment, childName varchar(100), containerClass int, containerParent int); "); /*", foreign key (containerClass) references classes(classID), foreign key (containerParent) references users(userID)); "); */
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS stickers (stickerID int primary key auto_increment, stickerDate varchar(100), color varchar(8), comment varchar(250), containerBook int, teacher int, foreign key (containerBook) references books(bookID), foreign key (teacher) references users(userID)); ");
            statement.executeUpdate();

            //Todo Remove me !

            
            statement = connection.prepareStatement("INSERT INTO users SELECT * FROM CSVREAD('/home/thibault/StickersApp/src/com/uca/dao/usersSet.csv');");
            statement.executeUpdate();
            statement = connection.prepareStatement("INSERT INTO books SELECT * FROM CSVREAD('/home/thibault/StickersApp/src/com/uca/dao/booksSet.csv');");
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
