import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DyamicArrayHR {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfSeq = in.nextInt();
        int numOfQueries = in.nextInt();
        int[][] inputArr = new int[numOfQueries][3];
        int lastAnswer = 0;
        for (int i = 0; i < numOfQueries; i++) {
            for (int j = 0; j < 3; j++) {
                inputArr[i][j] = in.nextInt();
            }
        }
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < numOfSeq; i++) {
            seqList.add(new ArrayList<>());
        }
        for (int i = 0; i < numOfQueries; i++) {
            int seq = (inputArr[i][1] ^ lastAnswer) % numOfSeq;
            if (inputArr[i][0] == 1) {
                seqList.get(seq).add(inputArr[i][2]);
            } else if (inputArr[i][0] == 2) {
                lastAnswer = seqList.get(seq).get(inputArr[i][2] % seqList.get(seq).size());
                System.out.println(lastAnswer);
            }
        }
    }
}
