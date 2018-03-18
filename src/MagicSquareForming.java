import java.util.Scanner;

/*
*
4 5 8
2 4 1
1 9 7
* */

public class MagicSquareForming {

    private static final int UP = -1;
    private static final int DOWN = 1;
    private static final int RIGHT = 1;
    private static final int LEFT = -1;

    private static final String ROW_FIRST = "rowFirst";
    private static final String COLUMN_FIRST = "colFirst";

    static int formingMagicSquare(int[][] s) {
        int cost = 0;
        // Complete this function
        int cost1 = 0, cost2 = 0, cost3 = 0, cost4 = 0;
        cost1 = calcCost(s, 2, 1, UP, RIGHT, ROW_FIRST);
        //cost = Math.min(calcCost(s, 2, 1, DOWN, LEFT, ROW_FIRST), calcCost(s, 0, 1, UP, RIGHT, ROW_FIRST));
        System.out.println("Cost " + cost1);
        /*cost2 = calcCost(s, 1, 0, DOWN, LEFT, COLUMN_FIRST);
        System.out.println("Cost " + cost2);
        cost3 = calcCost(s, 1, 2, UP, RIGHT, COLUMN_FIRST);
        System.out.println("Cost " + cost3);
        cost4 = calcCost(s, 0, 1, UP, RIGHT, COLUMN_FIRST);
        System.out.println("Cost " + cost4);*/
        /*if (s[2][1] == 1) {
            System.out.println("First");
            cost = calcCost(s, 2, 1, DOWN, RIGHT, ROW_FIRST);
        } else if (s[0][1] == 1) {
            System.out.println("Second");
            cost = calcCost(s, 0, 1, UP, RIGHT, ROW_FIRST);
        } else if (s[1][0] == 1) {
            System.out.println("Third");
            cost = calcCost(s, 1, 0, DOWN, LEFT, COLUMN_FIRST);
        } else if (s[1][2] == 1) {
            System.out.println("Fourth");
            cost = calcCost(s, 1, 2, UP, RIGHT, COLUMN_FIRST);
        } else {
            System.out.println("Fifth");
            cost = Math.min(calcCost(s, 2, 1, DOWN, LEFT, ROW_FIRST), calcCost(s, 0, 1, UP, RIGHT, ROW_FIRST));
            cost = Math.min(cost, calcCost(s, 1, 0, DOWN, LEFT, COLUMN_FIRST));
            cost = Math.min(cost, calcCost(s, 1, 2, UP, RIGHT, COLUMN_FIRST));
        }*/
    /*    int currentPositionRow = 2;
        int currentPositionCol = 1;
        int prevPositionRow = currentPositionRow;
        int prevPositionCol = currentPositionCol;
        if (s[2][1] == 1) {
            cost = 0;
        } else {
            cost += Math.abs(s[2][1] - 1);
        }
        s[currentPositionRow][currentPositionCol] = 0;
        System.out.println(cost);
        for (int i = 2; i < 10; i++) {
            //one down
            System.out.println("Looking for " + i);
            currentPositionRow += 1;
            if (currentPositionRow > 2) {
                currentPositionRow = 0;
            }
            //one right
            currentPositionCol += 1;
            if (currentPositionCol > 2) {
                currentPositionCol = 0;
            }
            int currentValue = s[currentPositionRow][currentPositionCol];
            if (currentValue == 0) { //Check if position already visited
                // One up
                currentPositionRow = prevPositionRow - 1;
                currentPositionCol = prevPositionCol;
                if (currentPositionRow < 0) {
                    currentPositionRow = 2;
                }
                currentValue = s[currentPositionRow][currentPositionCol];
            }
            System.out.println("Found " + currentValue + " instead of " + i + " at " + currentPositionRow + " " + currentPositionCol);
            if (currentValue != i) {
                cost += Math.abs(s[currentPositionRow][currentPositionCol] - i);
            }
            prevPositionRow = currentPositionRow;
            prevPositionCol = currentPositionCol;
            s[currentPositionRow][currentPositionCol] = 0;
            System.out.println("Cost " + cost);
        }*/
        /*int currentPositionRow = 0;
        int currentPositionCol = 1;
        int prevPositionRow = currentPositionRow;
        int prevPositionCol = currentPositionCol;
        if (s[currentPositionRow][currentPositionCol] != 1) {
            cost += Math.abs(s[currentPositionRow][currentPositionCol] - 1);
        }
        s[currentPositionRow][currentPositionCol] = 0;
        System.out.println(cost);
        for (int i = 2; i < 10; i++) {
            //one up
            System.out.println("Looking for " + i);
            currentPositionRow -= 1;
            if (currentPositionRow < 0) {
                currentPositionRow = 2;
            }
            //one right
            currentPositionCol += 1;
            if (currentPositionCol > 2) {
                currentPositionCol = 0;
            }
            int currentValue = s[currentPositionRow][currentPositionCol];
            if (currentValue == 0) { //Check if position already visited
                // One down
                currentPositionRow = prevPositionRow + 1;
                currentPositionCol = prevPositionCol;
                if (currentPositionRow > 2) {
                    currentPositionRow = 0;
                }
                currentValue = s[currentPositionRow][currentPositionCol];
            }
            System.out.println("Found " + currentValue + " instead of " + i + " at " + currentPositionRow + " " + currentPositionCol);
            if (currentValue != i) {
                cost += Math.abs(s[currentPositionRow][currentPositionCol] - i);
            }
            prevPositionRow = currentPositionRow;
            prevPositionCol = currentPositionCol;
            s[currentPositionRow][currentPositionCol] = 0;
            System.out.println("Cost " + cost);
        }*/
        return cost;
    }

    private static int calcCost(int[][] s, int rowIndex, int columnIndex, int firstMove, int secondMove, String strategy) {
        int cost = 0;
        int currentPositionRow = rowIndex;
        int currentPositionCol = columnIndex;
        int prevPositionRow = currentPositionRow;
        int prevPositionCol = currentPositionCol;
        if (s[currentPositionRow][currentPositionCol] != 1) {
            cost += Math.abs(s[currentPositionRow][currentPositionCol] - 1);
        }
        s[currentPositionRow][currentPositionCol] = 0;
        //System.out.println(cost);
        for (int i = 2; i < 10; i++) {
            //System.out.println("Looking for " + i);
            currentPositionRow += firstMove;
            if (currentPositionRow < 0) {
                currentPositionRow = 2;
            } else if (currentPositionRow > 2) {
                currentPositionRow = 0;
            }
            currentPositionCol += secondMove;
            if (currentPositionCol > 2) {
                currentPositionCol = 0;
            } else if (currentPositionCol < 0) {
                currentPositionCol = 2;
            }

            int currentValue = s[currentPositionRow][currentPositionCol];
            if (currentValue == 0) { //Check if position already visited
                currentPositionRow = prevPositionRow - firstMove;
                currentPositionCol = prevPositionCol;
                if (currentPositionRow > 2) {
                    currentPositionRow = 0;
                } else if (currentPositionRow < 0) {
                    currentPositionRow = 2;
                }
                currentValue = s[currentPositionRow][currentPositionCol];
            }
            //System.out.println("Found " + currentValue + " instead of " + i + " at " + currentPositionRow + " " + currentPositionCol);
            if (currentValue != i) {
                cost += Math.abs(s[currentPositionRow][currentPositionCol] - i);
            }
            prevPositionRow = currentPositionRow;
            prevPositionCol = currentPositionCol;
            s[currentPositionRow][currentPositionCol] = 0;
            //System.out.println("Cost " + cost);
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
