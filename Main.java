import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    String[] lines = importFile("dive.txt");
    // System.out.println(lines.length);
    // think about how you might separate each of the lines
    // https://www.youtube.com/watch?v=sBApUWZ80GQ
    String num = "100";
    int n = Integer.parseInt(num);
    System.out.println(n);
    System.out.println(dive(lines));
    System.out.println("Hello World");
  }

  public static int dive(String[] s) {
    int depth = 0;
    int horiz = 0;
    int sum = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i].indexOf("forward") != -1) {
        int num = Integer.parseInt(s[i].substring(s[i].length()-1));
        horiz += num;
      }  if (s[i].indexOf("down") != -1) {
        int num1 = Integer.parseInt(s[i].substring(s[i].length()-1));
        depth += num1;

      }  if (s[i].indexOf("up") != -1) {
        
        int num2 = Integer.parseInt(s[i].substring(s[i].length()-1));
        depth -= num2;
      }
    }
    sum = depth * horiz;
    return sum;
  }

  // don't touch below this line...
  public static String[] importFile(String fileName) {
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    String[] wordArray = toArray(words);
    return wordArray;
  }

  public static String[] toArray(ArrayList<String> s) {
    String[] words = new String[s.size()];
    for (int i = 0; i < words.length; i++) {
      words[i] = s.get(i);
    }
    return words;
  }
}// end class