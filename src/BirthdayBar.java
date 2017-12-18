import java.util.Scanner;

public class BirthdayBar {
    static int solve(int n, int[] s, int d, int m) {
        // Complete this function
        /*int result = 0;
        for (int i = 0; i <= n - m; i++) {
            int sum = s[i];
            for (int j = 1; j < m; j++) {
                sum += s[i + j];
                if (sum > d) {
                    break;
                }
            }
            if (sum == d) {
                result++;
            }
        }
        return result;*/

        // Using sliding window problem
        int result = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += s[i];
        }
        if (sum == d) {
            result++;
        }

        for (int i = m; i < n; i++) {
            sum += s[i] - s[i - m];
            if (sum == d) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
