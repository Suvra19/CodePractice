import java.util.Scanner;

public class RevisedRoullete {

    static int[] revisedRussianRoulette(int[] doors) {
        // Complete this function
        int min = 0;
        int max = 0;
        int pairs = 0;
        int[] result = new int[2];
        for (int i = 0; i < doors.length; i++) {
            int current = doors[i];
            if (current == 1) {
                max++;
                System.out.println(current + ": " + max);
                if (i + 1 < doors.length && doors[i + 1] == 1) {
                   pairs++;
                   max++;
                   i++;
                }
            }
        }
        System.out.println(pairs + " " + max);
        if (pairs == 0) {
            min = max;
        } else { /*if ((max % 2) == 0 && pairs < (max / 2)){
            int numOfMissedOnes = (max / 2) - min;
            min = min + numOfMissedOnes;
        } else {
            min = pairs + (max % 2);*/
            int remainingOnes = max - (pairs * 2);
            min = pairs + remainingOnes;
        }
        result[0] = min;
        result[1] = max;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");
        in.close();
    }
}

//0 1 1 0 1 1 1 1 0 0 0 1 1 0 1 1 1 0 0 0 0 0 0 0 1 1 1 1 0 0 0 1 0 0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 0
// 1 0 1 0 1 0 1 0 1 0
// 0 1 1 0 1 1 1 1 0 0
// 0 1 0 0 1 1 1 1 0 0
// 0 1 1 0 1 1 1 1 0 1
// 0 1 1 0 1 1 1 1 1 0
// 0 1 1 0 0 1 1 1 1 1 0
// 1 1 1 1 1 1 1 1 1 1