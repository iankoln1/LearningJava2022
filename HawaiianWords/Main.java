//makeWord(String s) --> creates the response listed on the documentation
import java.util.Scanner; 
class Main {
  public static void main(String[] args){
        System.out.println("Enter the Hawaiian word you need pronounced:");
        char[]c =  { 'a', 'e', 'i', 'o', 'u', 'p', 'k', 'h', 'l', 'm', 'n', 'w', ' ', '\'' };
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        input = input.toLowerCase();
        if(isHawaiian(c,input)==true){
          System.out.println(makeWord(input));
        }
    }

    public static String makeWord(String s){
      s = s.toLowerCase();
      char[]c =  { 'a', 'e', 'i', 'o', 'u', 'p', 'k', 'h', 'l', 'm', 'n', 'w', ' ', '\'' };
      if(isHawaiian(c,s)!= true){
        return s;
      } 
      String[] vowels = { "a", "e", "i", "o", "u" };
      String[] vowelsPhonetic = { "ah", "eh", "ee", "oh", "oo" };
      String[] groups = { "ai", "ae", "ao", "au", "ei", "eu", "iu", "oi", "ou", "ui" };
      String v = s.toUpperCase() + " is pronounced ";
      String p = "";
      int i = 0;
      while(i < s.length()-1){
        String r = String.valueOf(s.charAt(i));;
        String substring = r+s.charAt(i+1);
        boolean group = false;
        for(int j = 0; j < groups.length; j++){
          if(substring.equals(groups[j])){
            p = groupVowels(substring, p);
            i++;
            group = true;
          }
        }
        if(!group){
          boolean vowel = false;
          for(int j = 0; j < vowels.length; j++){
            if(r.equals(vowels[j])){
              p += vowelsPhonetic[j] + "-";
              vowel = true;
            }
          }
          if(!vowel){
            if(r.equals("\'")||r.equals(" ")){            
              p = p.substring(0,p.length()-1);            
            }
            p = p + r;
          }
        }
        i++;
      }
      if( i != s.length()){
        String last = String.valueOf(s.charAt(s.length()-1));;
        for(int j = 0; j < vowels.length; j++){
            if(last.equals(vowels[j])){
              p += vowelsPhonetic[j] + "-";
            }
          }
      }
      p = p.substring(0, p.length()-1);
      p = p.substring(0,1).toUpperCase()+p.substring(1);
      p = v+p;
      return p;
    }

    public static boolean isHawaiian(char[] c, String s){
        for(int i = 0; i < s.length(); i++){
            boolean f = false;
            int p = 0;
            while(f == false && p < c.length) {
              if (s.charAt(i) == c[p]) {
                f = true;
              }
              p++;
            }
            if (f != true) {
              System.out.println(s.charAt(i) + " is not a Hawaiian character");
              return false;
            }
        }
        char[] v = {'a','e','i','o','u'};
        for(int i = 0; i < v.length; i++){
            if(s.charAt(s.length()-1) == v[i]){
                return true;
            }
        }
        return false;
    }

    public static String groupVowels(String s, String p) {
	    String[] groups = { "ai", "ae", "ao", "au", "ei", "eu", "iu", "oi", "ou", "ui" };
	    String[] vowelPronunciation = { "eye", "eye", "ow", "ow", "ay", "eh-oo", "ew", "oy", "ow", "ooey" };
    for(int i = 0; i < groups.length; i++){
      if(s.equals(groups[i])) {
        return p += vowelPronunciation[i] + "-";
      }
    }
    return p;
  }
}

