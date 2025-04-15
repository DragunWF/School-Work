package com.example.matchupgame.helpers;

import com.example.matchupgame.R;
import com.example.matchupgame.data.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameState {
    private static Card firstChoice, secondChoice;
    private static boolean isMatched;
    private static List<Card> gameCards;

    public static List<Card> getGameCards() {
        return gameCards;
    }

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

    public static boolean isGameWon() {
        for (Card card : gameCards) {
            if (!card.isMatched()) {
                return false;
            }
        }
        return true;
    }

    public static void resetPair() {
        if (firstChoice != null) {
            firstChoice.setOpen(false);
        }
        if (secondChoice != null) {
            secondChoice.setOpen(false);
        }

        firstChoice = null;
        secondChoice = null;
    }

    public static void resetGame() {
        addCardData();
        resetPair();
    }

    private static void addCardData() {
        gameCards = new ArrayList<>();

        // Create pairs of programming language cards
        // Each card needs to have a pair with the same pairName

        // Pair 1: Java
        gameCards.add(new Card("java", R.drawable.java_logo));
        gameCards.add(new Card("java", R.drawable.java_logo));

        // Pair 2: Python
        gameCards.add(new Card("python", R.drawable.python_logo));
        gameCards.add(new Card("python", R.drawable.python_logo));

        // Pair 3: JavaScript
        gameCards.add(new Card("javascript", R.drawable.javascript_logo));
        gameCards.add(new Card("javascript", R.drawable.javascript_logo));

        // Pair 4: Kotlin
        gameCards.add(new Card("lua", R.drawable.lua_logo));
        gameCards.add(new Card("lua", R.drawable.lua_logo));

        // Pair 5: Swift
        gameCards.add(new Card("swift", R.drawable.swift_logo));
        gameCards.add(new Card("swift", R.drawable.swift_logo));

        // Pair 6: C++
        gameCards.add(new Card("cpp", R.drawable.cpp_logo));
        gameCards.add(new Card("cpp", R.drawable.cpp_logo));

        // Shuffle the cards to randomize their positions
        Collections.shuffle(gameCards);
    }
}
