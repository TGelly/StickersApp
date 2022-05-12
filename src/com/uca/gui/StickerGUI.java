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

    public static String getStickersInBook(String bookID) throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("stickers", StickerCore.getStickersInBook(bookID));

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("stickers/stickers.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

}