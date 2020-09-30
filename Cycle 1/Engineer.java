public class Engineer extends Employee{

  public static void main(String[] args){
    Engineer engg = new Engineer();
    engg.display();
    engg.calcSalary();
  }
	void calcSalary()
	{
		System.out.println("The salary of the Engineer is 20000");
	}
}
public class Employee{
	void display()
	{
		System.out.println("The name of the class is Employee");
	}
	void calcSalary()
	{
		System.out.println("The salary of the Employee is 10000");
	}
}
