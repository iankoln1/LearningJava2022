import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


class Main {
  public static void main(String[] args) {
   int[] nums = importFile("Day1.txt");
    System.out.println(find(nums));
  }
  public static int find(int[] s){
    int num = 0;
    for (int i = 0; i < s.length; i++){
      for (int j = 0; j < s.length; j++){
        for (int x = 0; x < s.length; x++){
        if (s[i] + s[j] + s[x] == 2020){
          num = s[i] * s[j] * s[x];
        }
      }
    }
      }
    return num;
  }
 
  
  
  public static int[] importFile(String fileName) {
    ArrayList<Integer> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        int data = myReader.nextInt();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    int[] wordArray = toArray(words);
    return wordArray;
  }

  public static int[] toArray(ArrayList<Integer> s) {
    int[] words = new int[s.size()];
    for (int i = 0; i < words.length; i++) {
      words[i] = s.get(i);
    }
    return words;
  }
}