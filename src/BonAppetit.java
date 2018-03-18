import java.util.Scanner;

public class BonAppetit {
    static String bonAppetit(int n, int k, int b, int[] ar) {
        // Complete this function
        int sharedPrice = 0;
        for (int i = 0; i < n; i++) {
            if (i == k) {
                continue;
            }
            sharedPrice += ar[i];
        }
        int perPerson = sharedPrice / 2;
        if (perPerson == b) {
            return "Bon Appetit";
        } else {
            return Integer.toString(b - perPerson);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        String result = bonAppetit(n, k, b, ar);
        System.out.println(result);
    }
}
