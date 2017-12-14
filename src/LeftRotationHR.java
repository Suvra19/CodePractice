import java.util.Scanner;

public class LeftRotationHR {
    static int[] leftRotation(int[] a, int d) {
        // Complete this function
        /*for (int i = 0; i < d; i++) {
            int[] tempArr = new int[a.length];
            for (int j = 0, k = -1; j <  a.length; j++, k++) {
                if (k < 0) {
                    tempArr[a.length - 1] = a[j];
                } else {
                    tempArr[k] = a[j];
                }
            }
            for (int m = 0; m < a.length; m++) {
                a[m] = tempArr[m];
            }
        }*/
        /*for (int i = 0; i < d; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                int temp = a[j];
                if (j == 0) {
                    a[j] = a[a.length - 1];
                    a[a.length - 1] = temp;
                } else {
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }*/
        int[] tempArr = new int[a.length];
        for (int j = 0; j < a.length; j++) {
            tempArr[(j + a.length - d) % a.length] = a[j];
        }
        for (int m = 0; m < a.length; m++) {
            a[m] = tempArr[m];
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
