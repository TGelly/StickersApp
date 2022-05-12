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
            String id = req.queryParams("bookID");
            if(id == null){
                return BookGUI.getAllBooks();
            }
            else{
                return BookGUI.getBook(id);
            }
        });

        get("/stickers", (req, res) -> {
            String stickerID = req.queryParams("stickerID");
            String bookID = req.queryParams("bookID");
            if(stickerID != null){
                return StickerGUI.getSticker(stickerID);
            }
            else if (bookID != null){
                return StickerGUI.getStickersInBook(bookID);
            }
            else{
                return StickerGUI.getAllStickers();
            }
        });

        /*
        //For POST requests :
        post("/books/", (req, res) -> {
            return UserGui.postNewSticker();
        });
        */
    }
}