import engine.GameEngine;

import java.util.Optional;

public class Game {

    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        if (checkMainArgs(args).isPresent())
            trySetRange(engine, args);
        engine.start();
    }

    private static void trySetRange(GameEngine engine, String[] args) {
        try {
            engine.setRange(args[0], args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Arguments in game class wasn't integer type so in game we will used default range value");
        }
    }

    private static Optional<String[]> checkMainArgs(String[] args) {
        if (args.length < 2) {
            System.out.println("The game does not have enough arguments :( so in game we will used default range value");
            return Optional.empty();
        }
        return Optional.of(args);
    }
}
