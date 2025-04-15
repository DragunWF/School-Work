package com.example.matchupgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchupgame.adapters.CardAdapter;
import com.example.matchupgame.data.Card;
import com.example.matchupgame.helpers.GameState;
import com.example.matchupgame.helpers.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private View view;
    private Button resetBtn;

    private RecyclerView cardRecycler;
    private CardAdapter cardAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Card> gameCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        try {
            bindElements();
            addCardData();
            setButtons();
            setRecycler();
        } catch (Exception err) {
            err.printStackTrace();
            Utils.toast(err.getMessage(), this);
        }
    }

    private void bindElements() {
        view = findViewById(R.id.main);
        resetBtn = findViewById(R.id.resetBtn);
        cardRecycler = findViewById(R.id.cardRecycler);
    }

    private void setButtons() {
        resetBtn.setOnClickListener(v -> {

        });
    }

    private void setRecycler() {
        cardRecycler.setHasFixedSize(false);

        cardAdapter = new CardAdapter(gameCards, view);
        cardRecycler.setAdapter(cardAdapter);

        layoutManager = new GridLayoutManager(this, 3);
        cardRecycler.setLayoutManager(layoutManager);
    }

    private void addCardData() {
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