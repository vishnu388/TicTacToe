public class TicTacToe {

	  static char[] board = new char[10];
	    public static void createboard() {
	        for (int i = 1; i < board.length; i++) {
	            board[i] = ' ';
	        }
	    }

	    public static void main(String[] args){
	    	System.out.println("Welcome To Tic Tac Toe Game");
	        createboard();
	    }
	}
