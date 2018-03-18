import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckMate {

    static int waysToGiveACheck(char[][] board) {
        // Complete this function
        // Step 1: Find the positions of the white pawn and the black king
        // The white pawn is guaranteed to be in the 7th row
        int pawnFile = -1, pawnRank = 1;
        int blackKingFile = -1, blackKingRank = -1;
        int whiteKingFile = -1, whiteKingRank = -1;
        int options = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int piece = board[i][j];
                if (piece == 'k') {
                    blackKingRank = i;
                    blackKingFile = j;
                }
                if (piece == 'K') {
                    whiteKingRank = i;
                    whiteKingFile = j;
                }
            }
        }
        System.out.println("White king:: " + whiteKingRank + " " + whiteKingFile);
        List<Character> threatTracker = new ArrayList<>();
        //List<Character> chars = Arrays.asList(board[pawnRank][1]);
        if (whiteKingRank == pawnRank) {
            boolean threat = false;
            boolean wait = false;
            for (int i = 0; i < 8; i++) {
                char current = board[pawnRank][i];
                System.out.println(current + " " + threat + " " + wait);
                if (current == 'P' && !threat && !wait && board[pawnRank - 1][i] == '#') {
                    pawnFile = i;
                    break;
                } else if (current == 'K') {
                    if (!threat) wait = true;
                    else threat = false;
                } else if (current == 'q' || current == 'r') {
                    threat = true;
                    if (wait) {
                        threat = false;
                        wait = false;
                    }
                } else if (current == 'B' && threat) {
                    threat = false;
                }
            }
        }
        /*for (int i = 0; i < 8; i++) {
            char current = board[pawnRank][i];
            System.out.println(current + " current threat " + currentThreat);
            if (current == 'P' && currentThreat == '0' && board[pawnRank - 1][i] == '#') {
                //check if that opens any diagonal attack to white king
                if (i > 0 && i < 7) {
                    int tempRank = pawnRank - 1;
                    int tempLeftFile = i - 1;
                    int tempRightFile = i + 1;
                    int leftThreat = board[tempRank][tempLeftFile];
                    int rightThreat = board[tempRank][tempRightFile];
                    if ((leftThreat == 'b' || leftThreat == 'q'
                            && Math.abs(tempRank - whiteKingRank) == Math.abs(tempLeftFile - whiteKingFile))
                            || (rightThreat == 'b' || rightThreat == 'q'
                            && Math.abs(tempRank - whiteKingRank) == Math.abs(tempRightFile - whiteKingFile))) {
                        continue;
                    } else {
                        pawnFile = i;
                        break;
                    }
                } else {
                    pawnFile = i;
                    break;
                }
            } else if (whiteKingRank == pawnRank) {
                if (current == 'r' || current == 'q') {
                    currentThreat = current;
                } else if (current == 'B' || current == 'P') {
                    currentThreat = '0';
                }
            }
        }*/
        System.out.println("Pawn :: " + pawnRank + " " + pawnFile);
        if (blackKingRank == pawnRank) {
            for (int j = 0; j < 8; j++) {
                //check for blocked rook or queen
                char current = board[pawnRank][j];
                if (current != '#' && j != pawnFile) {
                    threatTracker.add(current);
                }
            }
            int victimIndex = threatTracker.indexOf('k');
            if (threatTracker.indexOf('R') != -1 && Math.abs(victimIndex - threatTracker.indexOf('R')) == 1
                    || threatTracker.indexOf('Q') != -1 && Math.abs(victimIndex - threatTracker.indexOf('Q')) == 1) {
                options = 4;
                threatTracker.clear();
            }
        } else {
            System.out.println("After same row check :: " + options);
            boolean checkRightDiagonal = Math.abs(blackKingFile - (pawnFile + 1)) == Math.abs(blackKingRank);
            boolean checkLeftDiagonal = Math.abs(blackKingFile - (pawnFile - 1)) == Math.abs(blackKingRank);
            System.out.println(checkLeftDiagonal + " " + checkRightDiagonal);
            if (checkLeftDiagonal || checkRightDiagonal && options == 0) {
                int startRank = 1;
                if (checkRightDiagonal) {
                    int startFile = pawnFile - 1;
                    while (startFile >= 0) {
                        if (board[startRank][startFile] != '#') {
                            threatTracker.add(board[startRank][startFile]);
                            if (board[startRank][startFile] == 'k') {
                                break;
                            }
                        }
                        startFile--;
                        startRank++;
                    }
                    if (threatTracker.size() == 1) {
                        options = 4;
                    }
                } else if (checkLeftDiagonal) {
                    int startFile = pawnFile + 1;
                    while (startFile <= 7) {
                        if (board[startRank][startFile] != '#') {
                            threatTracker.add(board[startRank][startFile]);
                            if (board[startRank][startFile] == 'k') {
                                break;
                            }
                        }
                        startFile++;
                        startRank++;
                    }
                    if (threatTracker.size() == 1) {
                        options = 4;
                    }
                }
                threatTracker.clear();
            }
        }

        //promoted
        pawnRank--;
        if (blackKingFile != -1 && options == 0) {
            if ((blackKingRank == 1 && Math.abs(blackKingFile - pawnFile) == 2)
                    || (blackKingRank == 2 && Math.abs(blackKingFile - pawnFile) == 1)) {
                // Knight
                options = 1;
            }
            if (options == 0 && (blackKingRank == pawnRank)) {
                for (int i = Math.min(blackKingFile, pawnFile); i < 8; i++) {
                    if (board[pawnRank][i] != '#') {
                        threatTracker.add(board[i][pawnFile]);
                        if (board[pawnRank][i] == 'P' || board[pawnRank][i] == 'k') {
                            break;
                        }
                    }
                }
                if (threatTracker.size() == 1) {
                    options = 2;
                }
                threatTracker.clear();
            }
            if (options == 0 && (Math.abs(blackKingRank - pawnRank) == Math.abs(blackKingFile - pawnFile))) {
                // Rook and Queen or Bishop and Queen
                if (blackKingFile < pawnFile) {
                    int startFile = pawnFile - 1;
                    int startRank = pawnRank + 1;
                    while (startFile >= 0) {
                        if (board[startRank][startFile] != '#') {
                            threatTracker.add(board[startRank][startFile]);
                            if (board[startRank][startFile] == 'k') {
                                break;
                            }
                        }
                        startFile--;
                        startRank++;
                    }
                    if (threatTracker.size() == 1) {
                        options = 2;
                    }
                    threatTracker.clear();
                } else if (blackKingFile > pawnFile) {
                    int startFile = pawnFile + 1;
                    int startRank = pawnRank + 1;
                    while (startFile <= 7) {
                        if (board[startRank][startFile] != '#') {
                            threatTracker.add(board[startRank][startFile]);
                            if (board[startRank][startFile] == 'k') {
                                break;
                            }
                        }
                        startFile++;
                        startRank++;
                    }
                    if (threatTracker.size() == 1) {
                        options = 2;
                    }
                    threatTracker.clear();
                }
            }
        }
        return options;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            char[][] board = new char[8][];
            for(int board_i = 0; board_i < 8; board_i++){
                board[board_i] = in.next().toCharArray();
            }
            int result = waysToGiveACheck(board);
            System.out.println(result);
        }
        in.close();
    }
}
