package com.kanghe.notes;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NotesApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(NotesApplication.class).run(args);
    }

}
