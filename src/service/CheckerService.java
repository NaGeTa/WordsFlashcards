package service;

import model.Dictionary;
import model.WordCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class CheckerService {

    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public void startChecking(Dictionary dictionary, int checksCount) {
        int rightAnswers = 0;

        Collections.shuffle(dictionary.getWords());

        for (int i = 0; i < checksCount; i++) {
            int index = i < dictionary.getWords().size() ? i : i - dictionary.getWords().size();
            WordCard wordCard = dictionary.getWords().get(index);
            boolean isCorrect = check(wordCard, i);
            if (isCorrect) {
                System.out.println(GREEN + wordCard.getMeanings() + RESET);
                ++rightAnswers;
            } else {
                System.out.println(RED + wordCard.getMeanings() + RESET);
            }
        }

        System.out.println("--------------------");
        System.out.printf("Result: %s/%s", rightAnswers, checksCount);

    }

    private boolean check(WordCard wordCard, int i) {
        outQuestion(wordCard.getWord(), i);
        String answer = inputAnswer();
        return isAnswerCorrect(wordCard, answer);
    }

    private void outQuestion(String word, int number) {
        System.out.printf("%n#%s. What does mean %s%s%s?%n", number + 1, YELLOW, word, RESET);
    }

    private String inputAnswer() {
        try {
            Reader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private boolean isAnswerCorrect(WordCard wordCard, String answer) {
        List<String> meanings = wordCard.getMeanings();
        return meanings.contains(answer);
    }
}
