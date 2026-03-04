package model;

import java.util.List;

public class WordCard {
    private final String word;

    private final List<String> meanings;

    public WordCard(String word, List<String> meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public List<String> getMeanings() {
        return meanings;
    }

    @Override
    public String toString() {
        return "WordCard{" +
                "word='" + word + '\'' +
                ", meanings=" + meanings +
                '}';
    }
}
