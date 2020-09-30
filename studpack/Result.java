package studpack;

public class Result extends Student implements Sports {
    private int total;

    public Result() {
        total = super.totalMarks() + grade * 10;
    }

    public Result(String name, int roll, int[] marks) {
        super(name, roll, marks);
        total = super.totalMarks() + grade * 10;
    }

    public Result(String name, int roll) {
        super(name, roll);
        total = super.totalMarks() + grade * 10;
    }

    public void displayTotal() {
        updateGrade();
        System.out.println("Total Marks Obtained by " + super.getName() + " is " + total);
    }

    public void displayGrade() {
        System.out.println("Grade in Sports for " + super.getName() + " is " + grade);
    }

    public void updateGrade() {
        total = super.totalMarks() + grade * 10;
    }
}
