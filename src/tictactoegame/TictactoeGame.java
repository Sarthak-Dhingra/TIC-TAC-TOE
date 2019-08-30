/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.Scanner;

/**
 *
 * @author sarth
 */
public class TictactoeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        tictactoe game = new tictactoe();
        Scanner in = new Scanner(System.in);
        game.displayBoard();
        int turn = 1;
        while (true) {
            System.out.println("Player " + (turn == 1 ? "X" : "O"));
            System.out.println("Enter row:");
            int row = in.nextInt();
            System.out.println("Enter column:");
            int col = in.nextInt();
            if (row < 3 && row >= 0 && col < 3 && col >= 0) {

                if (game.isBlank(row, col)) {
                    if (turn == 1) {
                        game.playerX(row, col);
                    } else {
                        game.playerO(row, col);
                    }
                    game.displayBoard();
                    if (game.declareWinner() == 1) {
                        System.out.println("Player X won");
                        break;
                    } else if (game.declareWinner() == -1) {
                        System.out.println("Player O won");
                        break;
                    }

                    turn = -turn;
                } else {
                    System.out.println("Box is already occupied ,try again");
                }

                if (game.isFull()) {
                    System.out.println("Its a tie!You both are losers.");
                    break;
                }

            } else {
                System.out.println("Invaid position.Please try again!");
            }

        }

    }
}
