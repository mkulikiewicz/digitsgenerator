package engine;

import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameEngine {

    private static final String MESSAGE_NOT_AN_DIGIT = "It wasn't a digit ;)";
    private static final String MESSAGE_END_THE_GAME = "Congratulation! You got me :)";
    private static final String MESSAGE_WELCOME = "Hi! We prepared digit for you ;) Can you guess it ?";
    private static int rangeMin = 0;
    private static int rangeMax = 10;

    public void start() {
        showWelcomeMessage();
        showRange();
        int digit = generateDigit();
        startChecking(digit);
    }

    private void showRange() {
        System.out.println("Range <"+rangeMin+ ","+rangeMax+">");
    }

    int generateDigit() {
        return ThreadLocalRandom.current().nextInt(rangeMin, rangeMax + 1);
    }

    private void showWelcomeMessage() {
        System.out.println(MESSAGE_WELCOME);
    }

    private Optional<Integer> getDigitFromUser() {
        try {
            return Optional.of(new Scanner(System.in).nextInt());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private void startChecking(int digit) {
        while (true) {
            if (check(digit, getDigitFromUser())) {
                System.out.println(MESSAGE_END_THE_GAME);
                break;
            }
        }
    }

    private boolean check(int digit, Optional<Integer> digitFromUser) {
        if (digitFromUser.isPresent()) {
            int getedDigitFromUser = digitFromUser.get();
            if (digit > getedDigitFromUser) {
                System.out.println(messageDigitLess(getedDigitFromUser));
            } else if (digit < getedDigitFromUser) {
                System.out.println(messageDigitGreater(getedDigitFromUser));
            } else if (digit == getedDigitFromUser) {
                return true;
            }
        } else {
            System.out.println(MESSAGE_NOT_AN_DIGIT);
        }
        return false;
    }

    private String messageDigitGreater(int digit) {
        return "Your digit(" + digit + ") is greater then generated digit";
    }

    private String messageDigitLess(int digit) {
        return "Your digit(" + digit + ") is smaller then generated digit";
    }

    public void setRange(String min, String max) throws NumberFormatException {
        int probableMax = Integer.parseInt(max);
        int probableMin = Integer.parseInt(min);
        rangeMax = Math.max(probableMin, probableMax);
        rangeMin = Math.min(probableMin, probableMax);
    }
}
