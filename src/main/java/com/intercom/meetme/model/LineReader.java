package com.intercom.meetme.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LineReader {

    public static List<String> build(InputStream is) {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(is));
        List<String> lines = new ArrayList<>();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return lines;
    }

}
