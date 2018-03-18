import java.util.Scanner;

public class MarsExplorationSol {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int i = 0;
        int counter = 0;
        while (i < s.length()) {
            int check = i % 3;
            if ((check == 0 || check == 2) && s.charAt(i) != 'S') {
                counter++;
            }
            else if (check == 1 && s.charAt(i) != 'O') {
                counter++;
            }
            i++;
        }
        System.out.println(counter);
    }
}
