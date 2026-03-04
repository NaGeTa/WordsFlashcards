package model;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private final List<WordCard> words = new ArrayList<>();

    public List<WordCard> getWords() {
        return words;
    }

    public void addWord(WordCard wordCard) {
        words.add(wordCard);
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "words=" + words +
                '}';
    }
}
