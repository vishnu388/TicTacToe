package TicTacToe;

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

	    public static void main(String[] args){
	        createboard();
			  playerSelect();
	    }
	}
