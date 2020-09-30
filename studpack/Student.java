package studpack;

public class Student {

    private String name;
    private int roll;
    private int[] marks = new int[3];

    public Student() {
        name = "Dummy";
        roll = 0;
        marks = new int[]{100, 100, 100};
    }

    public Student(String name, int roll, int[] marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
        this.marks = new int[]{100, 100, 100};
    }

    public String getName() {
        return name;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int totalMarks() {
        return marks[0] + marks[1] + marks[2];
    }
}
