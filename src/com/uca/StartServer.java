package com.uca;

import com.uca.dao._Initializer;
import com.uca.gui.*;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);

        _Initializer.Init();

        //*Defining our routes

        //For GET requests :
        get("/", (req, res) -> {
            return "index.html";
        });

        get("/users", (req, res) -> {
            return UserGUI.getAllUsers();
        });

        get("/books", (req, res) -> {
            return BookGUI.getAllBooks();
        });
        
        get("/books/{bookId}", (req, res) -> {
            return UserGUI.getBook(bookId);
        });

        /*
        get("/books/{bookId}/{stickerId}", (req, res) -> {
            return UserGUI.getSticker(bookId, stickerId);
        });

        //For POST requests :
        post("/books/", (req, res) -> {
            return UserGui.postNewSticker();
        });
        */
    }
}