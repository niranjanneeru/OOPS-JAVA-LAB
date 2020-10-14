package exceptions;

public class A{
  public static void main(String args[]){
    int a = 20;
    int c = 0;
    try{
      c = a/0;
      System.out.println(c);
    }finally {
      System.out.println("This will execute");
    }
  }
}
