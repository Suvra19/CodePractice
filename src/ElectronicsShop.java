import java.util.*;

public class ElectronicsShop {
    static int getMoneySpent(Integer[] keyboards, Integer[] drives, int s){
        // Complete this function
        int sum = s;
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        /*while (sum > 0) {
            for (int i = 0; i < keyboards.length; i++) {
                map.put(sum - keyboards[i], keyboards[i]);
            }
            for (int j = 0; j < drives.length; j++) {
                if (map.containsKey(drives[j])) {
                    result = sum;
                    break;
                }
            }
            if (result == -1) {
                sum--;
            } else {
                break;
            }
        }*/
        Arrays.sort(keyboards, Collections.reverseOrder());
        Arrays.sort(drives);
        for (int i = 0, j = 0; i < keyboards.length; i++) {
            for (;j < drives.length; j++) {
                if (keyboards[i] + drives[j] > sum) break;
                if (keyboards[i] + drives[j] >  result) {
                    result = keyboards[i] + drives[j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] keyboards = new Integer[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        Integer[] drives = new Integer[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
