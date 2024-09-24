import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start the game \" index [1,3] \" ");
        char[][] board = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
        int totalMove = 0;
        char winner = ' ';
        System.out.println("Player_X");
        char player = 'X';
        while (totalMove < 10 && winner == ' ') {
            System.out.println("Enter indeces of player " + player);
            int r = sc.nextInt();
            int c = sc.nextInt();
            if (!makeMove(board, player, r, c)) {
                continue;
            }
            totalMove++;

            printBoard(board);
            winner = getWin(board, player);
            if (checkWin(winner, totalMove)) {
                break;
            }
            player = switchPlayer(player);
        }
        System.out.println("Re run the program for re-match");
        sc.close();
    }

    public static boolean checkWin(char winner, int totalMoves) {
        if (winner == 'X') {
            System.out.println("Player X won");
            return true;
        } else if (winner == 'O') {
            System.out.println("Player O won");
            return true;
        } else if (totalMoves == 9) {
            System.out.println("It is a draw");
            return true;
        }

        return false;
    }

    public static char switchPlayer(char player) {
        if (player == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    public static char getWin(char[][] board, char ch) {
        // check row and column
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == ch && board[i][1] == ch && board[i][2] == ch) {
                return ch;
            }
            if (board[0][i] == ch && board[1][i] == ch && board[2][i] == ch) {
                return ch;
            }
        }
        // check diognal
        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) {
            return ch;
        } else if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) {
            return ch;
        }
        return ' ';
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean makeMove(char[][] board, char m, int i, int j) {
        if (3 < i || i < 1 || 3 < j || j < 1) {
            System.out.println("Invalid index \"out of range\" ");
            return false;
        }
        if (board[i - 1][j - 1] != '_') {
            System.out.println("Invalid index \" already occupied\" ");
            return false;
        }
        board[i - 1][j - 1] = m;
        return true;
    }
}
