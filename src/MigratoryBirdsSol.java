import java.util.Scanner;

public class MigratoryBirdsSol {
    private static final int MAX_TYPE = 5;
    static int migratoryBirds(int n, int[] ar) {
        // Complete this function
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(ar[i] % n)]++;
        }
        int result = 0;
        int max = newArray[0];
        for (int i = 1; i < n; i++) {
            if (newArray[i] > max) {
                max = newArray[i];
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
