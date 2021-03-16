package TicTacToe;

public class TicTacToe {

		//Method to initialize array elements
	    public static void createBorad() {
	            char [] board = new char[10];
	            for (int index = 1; index < board.length; index++){
	                board[index] = ' ';
	            }
	    }

	    //main method to execute the program
	    public static void main(String [] args){
	        System.out.println("Welcome to Tic Tac Toe Game.");
	        //calling method to create board
	        createBorad();
	    }

	}
