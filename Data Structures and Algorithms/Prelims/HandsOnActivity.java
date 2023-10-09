// 03_HandsOnActivity_1

import java.util.*;

public class HandsOnActivity {
    private static LinkedList<String> songs = new LinkedList<>();
    private static LinkedList<String> artists = new LinkedList<>();
    private static LinkedList<String> playlist = new LinkedList<>();

    public static void main(String[] args) {
        addContents();
        displayLinkedList(songs);
        displayLinkedList(artists);
        iterateLinkedList(playlist);
    }

    private static void displayLinkedList(LinkedList<String> linkedList) {
        System.out.print("[");
        for (int i = 0, n = linkedList.size(); i < n; i++) {
            System.out.print(linkedList.get(i));
            if (i + 1 != n) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static void iterateLinkedList(LinkedList<String> linkedList) {
        for (int i = 0, n = linkedList.size(); i < n; i++) {
            System.out.println(linkedList.get(i));
        }
    }

    private static void addContents() {
        songs.add("So Sick");
        songs.add("Sugar");
        songs.add("You and Me");
        songs.add("Tonight");
        songs.add("Dancing");

        artists.add("Neyo");
        artists.add("Maroon 5");
        artists.add("Lifehouse");
        artists.add("FM Static");
        artists.add("Aaron Smith");

        for (int i = 0, n = songs.size(); i < n; i++) {
            playlist.add(String.format("%s - %s", songs.get(i), artists.get(i)));
        }
    }
}