// Write a Java program which creates
// a class named 'Employee' having the following
// members: Name, Age, Phone number, Address, Salary.
// It also has a method named 'printSalary( )' which prints the salary of the Employee.
// Two classes 'Officer' and 'Manager' inherits the 'Employee' class.
// The 'Officer' and 'Manager' classes have data members 'specialization' and 'department' respectively.
// Now, assign name, age, phone number, address and salary to an officer and a manager by making an object of both of these classes and print the same.
import java.text.NumberFormat;

public class Employee {
    private String name;
    private int age;
    private long phoneNumber;
    private String address;
    private long salary;

    public static void main(String[] args) {
        Officer officerTest = new Officer("Neeru", 19, 7_560_809_515L, "Coding Crew Trivandrum Kerala India", 8_000_000L, "Data Science");
        Manager managerTest = new Manager("Niranjan B", 18, 8_075_145_852L, "Anonymous Trivandrum Kerala India", 800_000_000L, "Software Development");
        officerTest.printData();
        System.out.println("");
        managerTest.printData();
    }

    public Employee(String name, int age, long phoneNumber, String address, long salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public long getSalary() {
        return salary;
    }

    public void printSalary() {

        System.out.println("Salary :- " + NumberFormat.getInstance().format(this.salary));
    }
}

public class Officer extends Employee {
    private String specialization;

    public Officer(String name, int age, long phoneNumber, String address, long salary, String specialization) {
        super(name, age, phoneNumber, address, salary);
        this.specialization = specialization;
    }

    public void printData() {
        System.out.println("Name :- " + this.getName());
        System.out.println("Age :- " + this.getAge());
        System.out.println("Conatact :- " + this.getPhoneNumber());
        System.out.println("Address :- " + this.getAddress());
        System.out.println("Address :- " + this.specialization);
        super.printSalary();
    }
}

public class Manager extends Employee {
    private String department;

    public Manager(String name, int age, long phoneNumber, String address, long salary, String department) {
        super(name, age, phoneNumber, address, salary);
        this.department = department;
    }

    public void printData() {
        System.out.println("Name :- " + this.getName());
        System.out.println("Age :- " + this.getAge());
        System.out.println("Conatact :- " + this.getPhoneNumber());
        System.out.println("Address :- " + this.getAddress());
        System.out.println("Address :- " + this.department);
        super.printSalary();
    }
}

/*
Name :- Neeru
Age :- 19
Conatact :- 7560809515
Address :- Coding Crew Trivandrum Kerala India
Address :- Data Science
Salary :- 8000000

Name :- Niranjan B
Age :- 18
Conatact :- 8075145852
Address :- Anonymous Trivandrum Kerala India
Address :- Software Development
Salary :- 800000000
*/
