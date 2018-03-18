import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

/*
*
5
129300455
5559948277
012334556
56789
123456879


* */

public class WinningLotteryTicket2 {

    private static List<Character> digits = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    static long winningLotteryTicket(String[] tickets) {
        List<Character> missing;
        List<Character> present;
        Map<Integer, List<Character>> map = new HashMap<>();
        int[][] matrix = new int[tickets.length][10];
        for (int i = 0; i < tickets.length; i++) {
            String id = tickets[i];
            missing = new ArrayList<>();
            missing.addAll(digits);
            present = new ArrayList<>();
            for (int j = 0; j < id.length(); j++) {
                present.add(id.charAt(j));
            }
            missing.removeAll(present);
            map.put(i, missing);
        }
        long result = 0;
        for (int i = 0; i < tickets.length; i++) {
            String tkt;
            List<Character> missingVals = map.get(i);
            int k = 0;
            for (int j = i + 1; j < tickets.length && missingVals.size() > 0;) {
                tkt = tickets[j];
                char num = missingVals.get(k);
                if (tkt.contains(String.valueOf(num))) {
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
        Set<Character> testSet;
        String input;
        for(int tickets_i = 0; tickets_i < n; tickets_i++){
            String rawTicket = in.next();
            char[] rawArray = rawTicket.toCharArray();
            Arrays.sort(rawArray);
            input = "";
            testSet = new HashSet<>();
            for (int i = 0; i < rawArray.length; i++) {
                char ch = rawArray[i];
                if (testSet.add(ch)) {
                   input += ch;
                }
            }
            tickets[tickets_i] = input;
        }
        long result = winningLotteryTicket(tickets);
        System.out.println(result);
        in.close();
    }
}

/*
 * - - - - - - x x x -
 * x x - x - - x - - -
 * - - - - - - - x x x
 * x x x x x - - - - -
 * x - - - - - - - - -
 * */