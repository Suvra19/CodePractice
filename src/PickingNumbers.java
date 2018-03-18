import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PickingNumbers {

    static int pickingNumbers(int[] a) {
        // Complete this function
        List<Integer> tracker = new ArrayList<>();
        Arrays.sort(a);
        int max = 1;
        int counter = 1;
        int i = 0;
        while(i < a.length - 1) {
            if (tracker.contains(a[i])) {
                i++;
                continue;
            }
            counter = 1;
            for (int j = i + 1; j < a.length; j++) {
                System.out.println(a[i] + " " + a[j]);
                if (Math.abs(a[i] - a[j]) > 1) {
                   break;
                } else {
                    counter++;
                    continue;
                }
            }
            if (counter > max) {
                max = counter;
                System.out.println(max);
            }
            tracker.add(a[i]);
            i++;
            System.out.println(tracker.toString());
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
