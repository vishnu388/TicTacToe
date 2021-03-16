package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

	   static char[] board = new char[10];
       public static char player;
       public static char computer;

       public static void createboard() {
           for (int i = 1; i < board.length; i++) {
               board[i] = ' ';
           }
       }
 public static void playerSelect() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Symbol you choose to with (x/o): ");
        String choice = scan.next();
        switch(choice) {
            case "X":
                player = 'x';
                computer = 'o';
                break;
            case "O":
                player = 'o';
                computer = 'x';
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public static void showBoard() {
        System.out.println("Currently the Board Looks Like ");
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
        if (Arrays.asList(valid).contains(pos) && checkEmpty(pos)) {
            board[pos] = player;
            showBoard();
        }else {
            System.out.println("Invalid Choice");
            playerTurn();
        }

    }

    public static boolean checkEmpty(int pos) {
        if(board[pos] == ' ') {
            return true;
        }else {
            System.out.println("The Position you entered is already filled. Please select the position that is empty.");
            playerTurn();
        }
        return true;
    }

       public static void main(String[] args){
           createboard();
           playerSelect();
           showBoard();
			  playerTurn();
       }
   }

