import studpack.Result;

public class Hybrid {
    public static void main(String[] args) {
        System.out.println('\n');
        Result st1 = new Result();
        st1.displayGrade();
        st1.displayTotal();
        System.out.println('\n');

        System.out.println('\n');
        Result st2 = new Result("Niranjan B", 10);
        st2.displayGrade();
        st2.displayTotal();
        System.out.println('\n');

        System.out.println('\n');
        Result st3 = new Result("Niranjan", 15, new int[]{70, 32, 99});
        st3.displayGrade();
        st3.displayTotal();
        System.out.println('\n');

        System.out.println('\n');
        Result st4 = new Result("Neeru", 20);
        st4.setMarks(new int[]{98, 56, 77});
        st4.displayGrade();
        st4.displayTotal();
        System.out.println('\n');

        System.out.println('\n');
        Result st5 = new Result("Amal", 25);
        st5.displayGrade();
        st5.displayTotal();
        System.out.println('\n');
    }
}
