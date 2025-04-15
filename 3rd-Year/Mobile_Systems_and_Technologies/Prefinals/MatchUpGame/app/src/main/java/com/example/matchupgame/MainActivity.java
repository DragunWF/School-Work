package com.example.matchupgame;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchupgame.adapters.CardAdapter;
import com.example.matchupgame.helpers.GameState;
import com.example.matchupgame.helpers.Utils;

public class MainActivity extends AppCompatActivity {
    private View view;
    private Button resetBtn;

    private RecyclerView cardRecycler;
    private CardAdapter cardAdapter;
    private RecyclerView.LayoutManager layoutManager;

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
            GameState.resetGame();

            bindElements();
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    GameState.resetGame();
                    setRecycler();
                    Utils.snackbar("Game has been reset!", view);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancels the dialog.
                }
            });
            builder.setTitle("Confirmation Dialog");
            builder.setMessage("Are you sure you want to reset the game? This will flip all the cards back to their default state.");

            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    private void setRecycler() {
        cardRecycler.setHasFixedSize(false);

        cardAdapter = new CardAdapter(GameState.getGameCards(), view, this);
        cardRecycler.setAdapter(cardAdapter);

        layoutManager = new GridLayoutManager(this, 3);
        cardRecycler.setLayoutManager(layoutManager);
    }
}