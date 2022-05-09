package com.uca.gui;

import com.uca.core.BookCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class BookGUI {

    public static String getAllBooks() throws IOException, TemplateException {
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        System.out.println(BookCore.getAllBooks().toString());
        input.put("books", BookCore.getAllBooks());

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("books/books.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
