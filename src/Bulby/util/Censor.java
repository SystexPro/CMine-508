package Bulby.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Censor {

    public static List<String> censored = new ArrayList<String>();

    public Censor() {
	loadWords();
    }

    private void loadWords() {
        String word = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("./data/Censor.txt"));
            while ((word = in.readLine()) != null) {
                censored.add(word);
            }
            in.close();
            in = null;
        } catch (Exception e) {
            Misc.println("Error load the censor.");
        }
    }

}