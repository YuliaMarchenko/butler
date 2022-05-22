package com.hamsters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jokes {
    private List<String> lines;
    private Random random;

    public Jokes() throws IOException {
        this.lines = new ArrayList<>();
        this.random = new Random(System.currentTimeMillis());
        try (BufferedReader br = new BufferedReader(new FileReader("quotes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
    }

    public String getRandomJoke(){
        int index = random.nextInt(lines.size());
        return lines.get(index);
    }
}
