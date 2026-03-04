package service;

import model.Dictionary;
import model.WordCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Random;

public class CheckerService {

    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    private final Random randomizer = new Random();

    public void startChecking(Dictionary dictionary, int checksCount) {
        int rightAnswers = 0;

        for (int i = 0; i < checksCount; i++) {
            int index = randomizer.nextInt(dictionary.getWords().size());
            WordCard wordCard = dictionary.getWords().get(index);
            outQuestion(wordCard.getWord(), i);
            String answer = inputAnswer();
            boolean isCorrect = isAnswerCorrect(wordCard, answer);

            if (isCorrect) {
                System.out.println(GREEN + "Right." + RESET);
                ++rightAnswers;
            } else {
                System.out.println(RED + "Wrong. Right answer - " + wordCard.getMeanings() + RESET);
            }
        }

        System.out.println("--------------------");
        System.out.printf("Result: %s/%s", rightAnswers, checksCount);

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
