package com.example.matchupgame;

public class Card {
    private String pairName;
    private boolean isOpen;
    private int imageResource;

    public Card(String name, int imageResource) {
        this.pairName = name;
        this.isOpen = false;
        this.imageResource = imageResource;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + pairName + '\'' +
                ", isOpen=" + isOpen +
                ", imageResource=" + imageResource +
                '}';
    }

    public String getPairName() {
        return pairName;
    }

    public void setPairName(String pairName) {
        this.pairName = pairName;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
