package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
	 // UC-2
    static char[] board = new char[10];
    public static char player;
    public static char computer;
    static int currPlayer; // 0 for player and 1 for computer

    public static void makeEmpty() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public static void playerSelect() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Symbol you choose to with (X/O): ");
        String choice = scan.next();
        switch(choice) {
            case "x":
                player = 'x';
                computer = 'o';
                break;
            case "o":
                player = 'o';
                computer = 'x';
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }


    public static void showBoard() {
        System.out.println("Currently the Board Looks Like Following ");
        System.out.println(" ");
        System.out.println("\n "+ board[1] + " | "+ board[2] + " | " + board[3]);
        System.out.println("-----------");
        System.out.println(" "+ board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("-----------");
        System.out.println(" "+ board[7] + " | " + board[8] + " | " + board[9]);
        System.out.println(" ");
    }

    public static void playerTurn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the position where you want to make your move (1-9): ");

        Integer[] valid = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int pos = scan.nextInt();
        while (!checkEmpty(pos)) {
            System.out.println("Invalid Entry");
            pos = scan.nextInt(9) + 1;
        }
        if (Arrays.asList(valid).contains(pos)) {
            board[pos] = player; //UC-5
            showBoard();
            int win = winCheck(player);
            if (win == 0) {
                System.out.println("The game is not yet decided, the computer will now have a turn");
                computerMove();
            } else {
                System.out.println("Player Wins the Game");
                System.exit(0);
            }
        }
    }


    public static boolean checkEmpty(int pos) {
        if(board[pos] == ' ') {
            return true;
        }else {
            return false;
        }
    }

    public static void computerMove() {
        int move = (int) Math.floor((Math.random() * 10) % 9) + 1;

        while (!checkEmpty(move))
            move = (int) Math.floor((Math.random() * 10) % 9) + 1;
        board[move] = computer;
        showBoard();
        int win = winCheck(computer);
        if(win == 0) {
            System.out.println("The game is not yet decided, the player will now have a turn");
            playerTurn();
        }else {
            System.out.println("Computer Wins the Game");
            System.exit(0);
        }
    }


    public static void toss() {
        int result = (int) Math.floor((Math.random() * 10) % 2);
        if(result == 0) {
            System.out.println("Player goes first");
            playerTurn();
        }else {
            System.out.println("Computer goes first");
            computerMove();
        }
    }

    public static int winCheck(char symbol) {
        // horizontal
        if (board[1] == symbol && board[2] == symbol && board[3] == symbol)
            return 1;
        if (board[4] == symbol && board[5] == symbol && board[6] == symbol)
            return 2;
        if (board[7] == symbol && board[8] == symbol && board[9] == symbol)
            return 3;

        // vertical
        if (board[1] == symbol && board[4] == symbol && board[7] == symbol)
            return 4;
        if (board[2] == symbol && board[5] == symbol && board[8] == symbol)
            return 5;
        if (board[3] == symbol && board[6] == symbol && board[9] == symbol)
            return 6;

        // diagonal
        if (board[1] == symbol && board[5] == symbol && board[9] == symbol)
            return 7;

        // off diagonal
        if (board[3] == symbol && board[5] == symbol && board[7] == symbol)
            return 8;

        return 0;
    }


    public static void main(String[] args) {
        makeEmpty();
        playerSelect();
        //showBoard();
        //playerTurn();
        toss();
    }
   }
