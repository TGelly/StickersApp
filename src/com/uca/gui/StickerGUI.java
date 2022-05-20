package com.uca.gui;

import com.uca.core.StickerCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StickerGUI {

    public static String getAllStickers() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("stickers", StickerCore.getAllStickers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("stickers/stickers.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getSticker(String stickerID) throws IOException, TemplateException {

        //todo tout changer

        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("stickers", StickerCore.getAllStickers());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("stickers/sticker.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static String getStickersInBook(int bookID) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("stickers", StickerCore.getStickersInBook(bookID));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("stickers/stickers.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    public static void newSticker(String color, String comment, String date) throws IOException, TemplateException {
        StickerCore.newSticker(color, comment, date);
    }

    public static String newStickerForm(){

        Path filename = Path.of("/home/thibault/StickersApp/src/main/resources/static/newstickerform.html");
        String result = "erreur";
        try {
            result = Files.readString(filename);
        } catch (IOException e) {
            //TODO: handle exception
        } 
        return result;

        /*
        String file = "/home/thibault/StickersApp/src/main/resources/static/newstickerform.html";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("erreur d'ouverture du fichier");
        }
        String result = "";
        while (scanner.hasNext()){
            result += scanner.next();
        }
        return result;
        */
    }
}