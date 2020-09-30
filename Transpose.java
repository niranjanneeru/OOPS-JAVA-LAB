// Aim :- Write a JAVA program to print the Transpose list upto a given Matrics.
// Input :- No Input
// Matrics is given in A[][]
//
// Output :- Fibinacci Series up to specified limit
// Logic :-  Third element = First + Second

public class Transpose{
  public static void main(String[] args){
    int[][] A={{01,02,03},{11,12,13},{21,22,23}};
    int[][] T = new int[3][3];
    for(int i =0;i<3;i++){
      for (int j = 0;j<3 ;j++ ) {
        T[j][i] = A[i][j];
      }
    }
    for(int i =0;i<3;i++){
      for (int j = 0;j<3 ;j++ ) {
        System.out.print(T[i][j]);
        System.out.print(" ");
      }
      System.out.println(" ");
    }
  }
}


// Output
/*
1 11 21
2 12 22
3 13 23
*/
