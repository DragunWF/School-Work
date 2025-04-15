package com.example.matchupgame.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchupgame.R;
import com.example.matchupgame.data.Card;
import com.example.matchupgame.helpers.GameState;
import com.example.matchupgame.helpers.Utils;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<Card> localDataSet;
    private View view;
    private Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView cardImage;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            cardImage = view.findViewById(R.id.cardImage);
        }

        public ImageView getCardImage() {
            return cardImage;
        }
    }

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView
     */
    public CardAdapter(List<Card> dataSet, View view, Context context) {
        localDataSet = dataSet;
        this.view = view;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_card, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final int DEFAULT_IMAGE_RESOURCE = R.drawable.question_mark;

        Card card = localDataSet.get(position);

        // Set the correct image based on card state
        viewHolder.getCardImage().setImageResource(card.isOpen() ? card.getImageResource() : DEFAULT_IMAGE_RESOURCE);

        viewHolder.getCardImage().setOnClickListener(v -> {
            if (card.isMatched() || card.isOpen() || GameState.isBothChosen()) {
                return;
            }
            card.setOpen(true);
            GameState.chooseCard(card);

            // Update the ImageView with the new state immediately
            viewHolder.getCardImage().setImageResource(card.isOpen() ? card.getImageResource() : DEFAULT_IMAGE_RESOURCE);
            notifyItemChanged(position);

            if (GameState.isBothChosen()) {
                // Create a handler to delay the Snackbar and card flipping
                new Handler().postDelayed(() -> {
                    Utils.snackbar(GameState.isMatched() ? "Both pairs have been matched!" : "Wrong pair!", view);
                    GameState.resetPair();
                    notifyDataSetChanged();
                }, 1000);
            }

            if (GameState.isGameWon()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("To play again, click the reset button down below.")
                        .setTitle("You won!");

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}