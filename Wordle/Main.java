import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    ArrayList<String> allTheWords = importFile("englishwords.txt");
    String[][] guesses = new String[12][5];
    Scanner word = new Scanner(System.in);
    String randomWord = startWordle(allTheWords, word);
    feedback(guesses, randomWord, word, alphabet, allTheWords);

    
  }
  public static ArrayList<String> fiveLetterWords(ArrayList<String> words){
    ArrayList<String> fiveLetterWords = new ArrayList<String>();
    for (String word : words) {
      if (word.length() == 5) {
        fiveLetterWords.add(word);
      }
    }
    return fiveLetterWords;
  }
  public static ArrayList<String> importFile(String fileName){
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
    return words;
  }

  public static String startWordle(ArrayList<String> words, Scanner word) {
    ArrayList<String> fiveLetterWord = fiveLetterWords(words);
System.out.print("Press Enter to Start");
    
    String enter = word.nextLine();
    return fiveLetterWord.get((int)(Math.random() * fiveLetterWord.size()));
  }

  public static String check(String word, String guess) {
    String hint = "";
    for (int i = 0; i < guess.length(); i++) {
      if (word.indexOf(guess.substring(i,i+1)) == -1) {
        hint += "x";
      } else if (word.charAt(i) == guess.charAt(i)) {
        hint += "*";
      } else {
        hint += "@";
      }
    }
    return hint;
  }

  public static void feedback(String[][] guesses, String word, Scanner typeGuess, char[] alphabet, ArrayList<String> allWords) {
    int guessCount = 0;
    boolean won = false;
    for (int i = 0; i < guesses.length; i += 2) {
      System.out.print("Please enter in your guess: ");
      String guess = typeGuess.nextLine();
      System.out.println();
      while (!isWord(guess, fiveLetterWords(allWords))) {
        guess = typeGuess.nextLine();
        System.out.println();
      }
      for (int j = 0; j < guesses[i].length; j++) {
        guesses[i][j] = guess.substring(j, j+1);
        for (int letter = 0; letter < alphabet.length; letter++) {
          if ((guess.substring(j,j+1).toUpperCase().charAt(0)) == alphabet[letter]) {
            alphabet[letter] = '#';
          }
        }
      }
      for (int k = 0; k < guesses[i].length; k++) {
        guesses[i+1][k] = check(word, guess).substring(k, k+1);
      }
      guessCount++;
      printArr(guesses);
      if (6 - guessCount == 1){
        System.out.println("You have 1 guess left");
        }else{
      System.out.println("You have " + (6 - guessCount) + " guesses left");
        }
      printAlphabet(alphabet);
      if (guess.equals(word)) {
        won = true;
        break;
      }
    }
    if (won) {
      System.out.println("YOU WIN");
      System.out.println("You used " + guessCount + " guesses.");
    } else {
      System.out.println("No more guesses");
      System.out.println("The answer was " + word);
    }
    
    
  }
  public static void printArr(String[][] guesses) {
    for (int i = 0; i < guesses.length; i++) {
      if (guesses[i][0] == null) {
        break;
      }
      System.out.print("|");
      for (int j = 0; j < guesses[i].length; j++) {
        System.out.print(guesses[i][j]);
      }
      System.out.println("|");
    }
  }

  public static void printAlphabet(char[] alphabet) {
    System.out.print("Letters left:");
    for (char letter : alphabet) {
      System.out.print(" " + letter);
    }
    System.out.println("\n");
  }

  public static boolean isWord(String guess, ArrayList<String> words) {
    boolean match = false;
    for (String word : words) {
      if (word.equals(guess)) {
        match = true;
        break;
      }
    }
    return match;
  }
}