import java.util.Scanner;

public class CountingValley {

    static int countingValleys(int n, String s) {
        // Complete this function
        char[] steps = s.toCharArray();
        int initial = 0;
        int count = 0;
        for (int i = 0; i < steps.length; i++) {
            if (steps[i] == 'U') {
                initial += 1;
            } else {
                initial -= 1;
                if (initial == -1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}
