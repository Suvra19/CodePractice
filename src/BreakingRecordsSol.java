import java.util.Scanner;

public class BreakingRecordsSol {
    static int[] getRecord(int[] s){
        // Complete this function
        int[] tracker = new int[2];
        int highest = s[0], lowest = s[0];
        for (int i = 1; i < s.length; i++) {
            if (s[i] > highest) {
                highest = s[i];
                tracker[0]++;
            } else if (s[i] < lowest) {
                lowest = s[i];
                tracker[1]++;
            }
        }
        return tracker;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
