package com.example.matchupgame;

import java.util.Objects;

public class GameState {
    private Card firstChoice, secondChoice;
    private boolean isCorrect;

    public void chooseCard(Card chosenCard) {
        if (firstChoice != null) {
            firstChoice = chosenCard;
            return;
        }

        secondChoice = chosenCard;
        isCorrect = Objects.equals(firstChoice.getPairName(), secondChoice.getPairName());
    }

    public boolean isBothChosen() {
        return firstChoice != null && secondChoice != null;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void reset() {
        firstChoice = null;
        secondChoice = null;
    }
}
