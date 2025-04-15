package com.example.matchupgame.helpers;

import com.example.matchupgame.data.Card;

import java.util.Objects;

public class GameState {
    private static Card firstChoice, secondChoice;
    private static boolean isMatched;

    public static void chooseCard(Card chosenCard) {
        if (firstChoice == null) {
            firstChoice = chosenCard;
            return;
        }

        secondChoice = chosenCard;
        isMatched = Objects.equals(firstChoice.getPairName(), secondChoice.getPairName());
        if (isMatched) {
            firstChoice.setMatched(true);
            secondChoice.setMatched(true);
        }
    }

    public static boolean isBothChosen() {
        return firstChoice != null && secondChoice != null;
    }

    public static boolean isMatched() {
        return isMatched;
    }

    public static void reset() {
        firstChoice.setOpen(false);
        secondChoice.setOpen(false);
        firstChoice = null;
        secondChoice = null;
    }
}
