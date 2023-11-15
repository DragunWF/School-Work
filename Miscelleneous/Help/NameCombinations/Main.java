/*
 Gusto ko sana gumamit ng ibang features such as custom methods, 
 string formatting and other data structures but im limiting my tool 
 set to just what was discussed in my friend's classes.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];

        // Dito mo kinukuha ang mga names, then store sa names array
        System.out.println("Enter three names");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.nextLine();
        }

        // Kunin lahat ng combinations
        String[] combinations = new String[names.length * 2]; // number of possible combinations
        for (int i = 0, k = 0; i < names.length; i++) {
            // Assign yung mga combinations sa array
            for (int j = 0; j < names.length; j++) {
                if (i != j) { // avoid duplicates
                    combinations[k] = names[i] + " " + names[j];
                    k++;
                }
            }
        }

        // Display lahat ng combinations
        System.out.println("Possible names are:");
        for (int i = 0; i < combinations.length; i++) {
            System.out.println((i + 1) + " - " + combinations[i]);
        }

        // Pili ng combination
        System.out.print("Enter 1-6 to select a name: ");
        int chosenIndex = sc.nextInt() - 1;

        // Split name into two parts "firstName" and "lastName"
        String[] name = combinations[chosenIndex].split(" ");

        // Combine yung first letter ng first and last name to convert to uppercase
        String initials = (String.valueOf(name[0].charAt(0)) + String.valueOf(name[1].charAt(0))).toUpperCase();

        // Combine yung first name and last name then convert to upper case and separate
        // both using "_"
        String username = String.join("_", name).toLowerCase();

        // Output ng lahat
        System.out.println("The initials for " + combinations[chosenIndex] + " is " + initials);
        System.out.println("Suggested username: " + username);

        sc.close(); // close Scanner to prevent Resource leak
    }
}