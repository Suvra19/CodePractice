import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class SockMerchant {
    static int sockMerchant(int n, int[] ar) {
        // Complete this function
       /*Map<Integer, Integer> sockMap = new HashMap<>();
       for (int i = 0; i < n; i++) {
            if (sockMap.containsKey(ar[i])) {
                int count = sockMap.get(ar[i]);
                sockMap.put(ar[i], ++count);
            } else {
                sockMap.put(ar[i], 1);
            }
       }
       int result = 0;
       for (Integer key : sockMap.keySet()) {
           int val = sockMap.get(key);
           if (val / 2 > 0) {
               result += val / 2;
           }
       }
       return result;*/
       Set<Integer> colorSet = new HashSet<>();
       int pairs = 0;

       for (int i = 0; i < n; i++) {
           if (!colorSet.contains(ar[i])) {
               colorSet.add(ar[i]);
           } else {
               pairs++;
               colorSet.remove(ar[i]);
           }
       }
       return pairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
