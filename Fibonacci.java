// Aim :- Write a JAVA program to print the Fibonacci list upto a given number.
// Input :- No Input
// Limit is specified
// Output :- Fibinacci Series up to specified limit
// Logic :-  Third element = First + Second

public class Fibonacci{
  public static void main(String[] args){
    int n = 100;
    int first = 0;
    int second = 1;
    int third = 0;
    System.out.println(first);
    System.out.println(second);
    while(third<=n){
      third = first + second;
      first = second;
      second = third;
      if(third <= n ){
      System.out.println(third);
    }
    }
  }
}


// Output
/*0
1
1
2
3
5
8
13
21
34
55
89
*/
