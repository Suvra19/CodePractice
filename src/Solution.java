import java.util.Scanner;

public class Solution {

    static final int columns = 6;
    static int rows = 6;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int highestSum = -70;
        int currentSum;
        for (int i = 0; i < rows && i + 3 < 7; i++) {
            for (int j = 0; j < columns && j + 3 < 7; j++) {
                currentSum = calculateSum(i, j, matrix);
                if (currentSum > highestSum) {
                    highestSum = currentSum;
                    System.out.println("Highest sum : " + highestSum);
                }
            }
        }
        System.out.println(highestSum);
    }
    /*
    * -1 -1 0 -9 -2 -2 -2 -1 -6 -8 -2 -5 -1 -1 -1 -2 -3 -4 -1 -9 -2 -4 -4 -5 -7 -3 -3 -2 -9 -9 -1 -3 -1 -2 -4 -5
    *
    * */
    private static int calculateSum(int i, int j, int[][] matrix) {
        System.out.println("Starting point :: " + i + " " + j);
        int sum = 0;
        int flag = 0;
        for (int k = i; k < i + 3; k++) {
            flag++;
            System.out.println("Row no: " + k);
            for (int m = j; m < j + 3; m++) {
                System.out.println("Column no: " + m);
                if (flag == 2) {
                    sum += matrix[i + 1][j + 1];
                    break;
                }
                sum += matrix[k][m];
            }
            System.out.println("Row sum : " + sum);
        }
        System.out.println("Total sum: " + sum);
        return sum;
    }
}
