import java.util.Scanner;

public class GradingSol {

    static int[] solve(int[] grades){
       for (int i = 0; i < grades.length; i++) {
           int checkFive = 5 - grades[i] % 10;
           int checkTen = 10 - grades[i] % 10;
           if (grades[i] < 38) {
             continue;
           } else if (checkFive > 0 && checkFive < 3) {
               grades[i] += checkFive;
           } else if (checkTen > 0 && checkTen < 3) {
               grades[i] += checkTen;
           }
       }
       return grades;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}
