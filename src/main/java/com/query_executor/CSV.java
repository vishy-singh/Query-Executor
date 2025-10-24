package com.query_executor;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CSV {

    public static void main(String[] args) {
        readCsv();
    }

    public static void readCsv() {

        StringBuilder stringBuilder = new StringBuilder();
        try {

            // Load file from resources
            ClassPathResource resource = new ClassPathResource("TABLE_NAME.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(",");
            }

            reader.close();
        } catch (IOException e) {


            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());
    }
}