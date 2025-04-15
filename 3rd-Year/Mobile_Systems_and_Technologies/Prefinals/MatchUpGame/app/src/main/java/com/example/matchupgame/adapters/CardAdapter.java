package com.example.matchupgame.adapters;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.matchupgame.R;
import com.example.matchupgame.data.Card;
import com.example.matchupgame.helpers.GameState;
import com.example.matchupgame.helpers.Utils;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<Card> localDataSet;
    private View view;

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
    public CardAdapter(List<Card> dataSet, View view) {
        localDataSet = dataSet;
        this.view = view;
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
                    GameState.reset();
                    notifyDataSetChanged();
                }, 1000);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}