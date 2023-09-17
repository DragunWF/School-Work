public class Junk {
    private static Scanner sc = new Scanner(System.in);
  
    public static void main(String[] args) {
      intro();
        ArrayList<String> words = new ArrayList<>();
      for (int i = 1; i <= 10; i++) {
          System.out.printf("%s: brub", i);
          words.add("brub");
          System.out.println();
      }
      
      System.out.println("\nWords you said:");
      for (int i = 0; i < words.size(); i++) {
          System.out.printf("%s: %s\n", i + 1, words.get(i));
      }
      System.out.println("\nProgram Finished...");
    }
    
    private static void intro() {
       System.out.println("In this program you will be asked to say words 10 times");
      System.out.println("Say anything you want: ");
    }
  }