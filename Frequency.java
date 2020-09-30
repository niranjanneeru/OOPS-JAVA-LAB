// Aim :- Write a JAVA program to print the Frequency of a character in a string.
// Input :- No Input
// String and Character
// Output :- Integer Indicating Frequency of the chrarcter
// Logic :-  Searching

public class Frequency{
  public static void main(String[] args){
    String string = "javacpython";
    char c = 'a';
    int count = 0;
    for (int i=0;i<string.length();i++) {
      if(string.charAt(i)==c){
        count++;
      }
    }
    System.out.println(count);
  }
}


// Output
/*
2
*/
