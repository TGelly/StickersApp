package com.uca.core;

import com.uca.dao.StickerDAO;
import com.uca.entity.StickerEntity;

import java.util.ArrayList;

public class StickerCore {

    public static ArrayList<StickerEntity> getAllStickers() {
        return new StickerDAO().getAllStickers();
    }

    public static ArrayList<StickerEntity> getStickersInBook(int bookID) {
        return new StickerDAO().getStickersInBook(bookID);
    }

    public static void newSticker(String color, String comment, String date) {
        StickerEntity S = new StickerEntity();
        S.setComment(comment);
        S.setColor(color);
        S.setDate(date);
        new StickerDAO().create(bookID);
    }
}