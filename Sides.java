public class Sides{
  public static void main(String[] args) {
    Rectangle Rect = new Rectangle();
    Rect.numberOfSides();
    Triangle Tri = new Triangle();
    Tri.numberOfSides();
    Hexagon Hex = new Hexagon();
    Hex.numberOfSides();
  }
}

public abstract class Shape{
  int sides;
  String shape_name;
  public abstract void numberOfSides();
}

public class Rectangle extends Shape{
  public Rectangle(){
  super.shape_name = "Rectangle";
  super.sides = 4;
}
  public void numberOfSides(){
    System.out.println(super.shape_name+" has "+super.sides+" sides");
  }
}

public class Triangle extends Shape{
  public Triangle(){
  super.shape_name = "Triangle";
  super.sides = 3;
}
  public void numberOfSides(){
    System.out.println(super.shape_name+" has "+super.sides+" sides");
  }
}
public class Hexagon extends Shape{
  public Hexagon(){
  super.shape_name = "Hexagon";
  super.sides = 6;
}
  public void numberOfSides(){
    System.out.println(super.shape_name+" has "+super.sides+" sides");
  }
}
