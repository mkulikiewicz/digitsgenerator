package engine;

import java.util.Optional;
import java.util.Scanner;

public class GameEngine {

    public void  start() {
        showWelcomeMessage();
        int digit = generateDigit();
        startChecking(digit);
    }

    private int generateDigit() {
        return (int)(Math.random() * 10 + 0);
    }

    private void showWelcomeMessage() {
        System.out.println("Hi! We prepare digit for you ;) Can you guess it ?");
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
            Optional<Integer> userDigit = getDigitFromUser();
            if (userDigit.isPresent()) {
                if (digit > userDigit.get()) {
                    System.out.println("Your digit("+userDigit.get()+") is less then generated digit");
                } else if (digit < userDigit.get()) {
                    System.out.println("Your digit("+userDigit.get()+") is greater then generated digit");
                } else {
                    System.out.println("Congratulation! You got me :) it is " + digit);
                    break;
                }
            } else {
                System.out.println("It wasn't a digit ;)");
            }
        }
    }
}
