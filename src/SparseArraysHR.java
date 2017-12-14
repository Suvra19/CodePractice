import java.util.Scanner;

public class SparseArraysHR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfStrings = in.nextInt();
        String[] inputStrings = new String[numOfStrings];
        in.nextLine();
        for (int i = 0; i < numOfStrings; i++) {
            inputStrings[i] = in.nextLine();
        }
        int numOfQueries = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numOfQueries; i++) {
             String queryString = in.nextLine();
             int count = 0;
             if (!queryString.isEmpty()) {
                 count = search(queryString, inputStrings);
             }
             System.out.println(count);
        }

    }

    private static int search(String queryString, String[] inputStrings) {
        int counter = 0;
        for (int  i = 0; i < inputStrings.length; i++) {
            if (inputStrings[i].equals(queryString)) {
                counter++;
            }
        }
        return counter;
    }
}
