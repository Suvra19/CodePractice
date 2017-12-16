import java.util.Scanner;

public class ArrayManipulationSol {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] numList = new long[n];
        long highest = 0;
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            /*for (int i = a - 1; i <= b - 1; i++) {
                numList[i] += k;
                if (numList[i] > highest) {
                    highest = numList[i];
                }
            }*/
            numList[a - 1] += k;
            if (b < n) {
                numList[b] -= k;
            }
        }
        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += numList[i];
            System.out.println("Temp val : " + temp);
            if (temp > highest) {
                highest = temp;
            }
        }
        System.out.println(highest);
        in.close();
    }
}
