import java.util.Scanner;

public class BetweenSetsSol {
    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int lcm = findLCM(a);
        int gcd = findGCD(b);
        int count = 0;
        for (int i = lcm, j = 2; j <= gcd; i = lcm * j, j++) {
            if (gcd % i == 0) {
                count++;
            }
        }
        return count;
    }

    private static int findGCD(int[] b) {
        int result = b[0];
        for (int i = 1; i < b.length; i++) {
            result = gcd(result, b[i]);
        }
        return result;
    }

    private static int findLCM(int[] a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            result = lcm(result, a[i]);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
