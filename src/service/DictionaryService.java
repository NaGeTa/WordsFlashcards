package service;

import model.Dictionary;
import model.WordCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class DictionaryService {

    public Dictionary getDictionary() {
        Dictionary dictionary = new Dictionary();

        try (BufferedReader br = new BufferedReader(new FileReader("src/resource/words.txt"))) {
            
            String line = br.readLine();
            while (line != null) {

                if (!line.isBlank()) {
                    WordCard wordCard = createWordCard(line);
                    dictionary.addWord(wordCard);
                }

                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("Words in dictionary - %s \n\n", dictionary.getWords().size());

        return dictionary;
    }

    private WordCard createWordCard(String line) {
        String[] wordAndMeanings = line.split(" - ");
        if (wordAndMeanings.length != 2) {
            throw new IllegalArgumentException("Invalid string format:\n " + line);
        }
        String word = wordAndMeanings[0];
        String meanings = wordAndMeanings[1];
        return buildWordCard(word, meanings);
    }

    private WordCard buildWordCard(String word, String meanings) {
        List<String> meaningsList = List.of(meanings.split(", "));
        return new WordCard(word, meaningsList);
    }

}
