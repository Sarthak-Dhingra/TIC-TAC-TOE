/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author sarth
 */
public class tictactoe {

    int[][] board = new int[3][3];

    public tictactoe() {//board[1][2]=1;board[1][0]=-1;
        System.out.println("WELCOME TO TIC-TAC-TOE\n");
    }

    public void displayBoard() {
        System.out.print("  ");
        for (int i = 0; i < 3; i++) {
            System.out.print("  " + i + " ");
        }

        for (int row = 0; row < 3; row++) {
            System.out.println("\n  -------------");

            System.out.print(row + " |");
            for (int col = 0; col < 3; col++) {
                String str = " ";
                if (board[row][col] == 1) {
                    str = "X";
                } else if (board[row][col] == -1) {
                    str = "O";
                }
                System.out.print(" " + str + " |");
            }
        }
        System.out.println("\n  -------------");

    }

    public void playerX(int row, int col) {
        board[row][col] = 1;
    }

    public void playerO(int row, int col) {
        board[row][col] = -1;
    }

    public boolean isBlank(int row, int col) {
        return (board[row][col] == 0);
    }

    public boolean isFull() {
        int flag = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 0) {
                    flag = 1;
                }
            }
            return flag != 1;
        }

        return true;
    }

    public int rowSum(int row) {
        int sum = board[row][0] + board[row][1] + board[row][2];
        return sum;
    }

    public int columnSum(int col) {
        int sum = board[0][col] + board[1][col] + board[2][col];
        return sum;
    }

    public int calcMajorD() {
        int sum = board[0][0] + board[1][1] + board[2][2];
        return sum;
    }

    public int calcMinorD() {
        int sum = board[0][2] + board[1][1] + board[2][0];
        return sum;
    }

    public int declareWinner() {
        for (int i = 0; i < 3; i++) {
            if (this.rowSum(i) == 3 || this.columnSum(i) == 3) {
                return 1;
            } else if (this.rowSum(i) == -3 || this.columnSum(i) == -3) {
                return -1;
            }
        }
        if (this.calcMajorD() == 3 || this.calcMinorD() == 3) {
            return 1;
        } else if (this.calcMajorD() == -3 || this.calcMinorD() == -3) {
            return -1;
        }
        return 0;
    }

}
