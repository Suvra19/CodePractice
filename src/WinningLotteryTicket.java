/*
import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

*/
/*
*
5
5559948277
012334556
56789
123456879
129300455

* *//*


public class WinningLotteryTicket {

    private static List<Integer> digits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    static long winningLotteryTicket(String[] tickets) {
        List<Integer> missing;
        List<Integer> present;
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[][] matrix = new long[tickets.length][10];
        for (int i = 0; i < tickets.length; i++) {
            String id = tickets[i];
            int digitCount = 0;
            missing = new ArrayList<>();
            missing.addAll(digits);
            present = new ArrayList<>();
            for (int j = 0; j < id.length() && digitCount <= 10; j++) {
                int index = Character.getNumericValue(id.charAt(j));
                if (matrix[i][index] == 1) {
                    continue;
                }
                digitCount++;
                present.add(index);
                matrix[i][index] = 1;
            }
            missing.removeAll(present);
            map.put(i, missing);
        }
        long result = 0;
        for (int i = 0; i < tickets.length; i++) {
            List<Integer> missingVals = map.get(i);
            int k = 0;
            for (int j = i + 1; j < tickets.length && missingVals.size() > 0;) {
                int indexNum = missingVals.get(k);
                if (matrix[j][indexNum] == 1) {
                    k++;
                } else {
                    j++;
                }
                if (k == missingVals.size()) {
                    result++;
                    j++;
                    k = 0;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] tickets = new String[n];
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            tickets[tickets_i] = in.next();
        }
        long result = winningLotteryTicket(tickets);
        System.out.println(result);
        in.close();
    }
}

*/
/*
* - - - - - - x x x -
* x x - x - - x - - -
* - - - - - - - x x x
* x x x x x - - - - -
* x - - - - - - - - -
* */
