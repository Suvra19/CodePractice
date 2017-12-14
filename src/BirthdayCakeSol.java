import java.util.Scanner;

public class BirthdayCakeSol {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        int highest = 0;
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > highest) {
                count = 1;
                highest = ar[i];
            } else if (ar[i] == highest) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
