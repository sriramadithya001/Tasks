import java.util.Scanner;

class Game {
    static char[][] board = new char[1000][1000];
    static int N;
    static int ball_row, ball_col;
    static void initialize() {
	// walls
	for(int i=0;i<N;i++) {
	    for(int j=0;j<N;j++) {
		if(i==0 || j==0 || i==N-1 || j==N-1) board[i][j] = 'w';
		else board[i][j] = ' ';
	    }
	}

	// ground
	for(int j=1;j<N-1;j++) board[N-1][j] = 'g';

	// ball
	board[N-1][N/2] = 'o';
    }

    static void moveStraight() {
	for(int i=N-2;i>0;i--) {
	    if(board[i][ball_col]=='1') {board[i][ball_col] = ' ';break;}
	}
	printBoard();
    }

    static void moveLeft() {
	if(ball_col==1) return;
	board[ball_row][ball_col] = 'g';
	ball_col--;
	for(int i=N-2;i>0;i--) {
	    if(board[i][ball_col]=='1') {board[i][ball_col] = ' ';break;}
	}
	board[ball_row][ball_col] = 'o';
	printBoard();
    }

    static void moveRight() {
	if(ball_col==N-1) return;
	board[ball_row][ball_col] = 'g';
	ball_col++;
	for(int i=N-2;i>0;i--) {
	    if(board[i][ball_col]=='1') {board[i][ball_col] = ' ';break;}
	}
	board[ball_row][ball_col] = 'o';
	printBoard();
    }

    /*static void moveRight() {
	int r = ball_row, c = ball_col;
	while(c<N-2) {
	    r--;c++;
	}
	boolean hit = false;
	for(int j=N-2;j>0;j--) {
	    if(board[r][j]=='1') {
		ball_row = N-1;ball_col = j;
		board[r][j] = ' ';
	    	board[ball_row][ball_col] = 'o';
		hit = true;
		break;
	    }
	}
	if(hit==false) {
	    System.out.println("This move will lead to infinite ball movement");
	}
    }*/

    static void printBoard() {
	for(int i=0;i<N;i++) {
	    for(int j=0;j<N;j++) {
		System.out.print(board[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}

public class BricksAndBalls {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter sz : ");
	Game.N = sc.nextInt();
	Game.ball_row = Game.N-1;Game.ball_col = Game.N/2;
	Game.initialize();
	System.out.print("Enter no of bricks : ");
	int bricks = sc.nextInt();
	for(int i=0;i<bricks;i++) {
	    int x = sc.nextInt(), y = sc.nextInt();
	    Game.board[x][y] = '1';
	}
	Game.printBoard();
	System.out.println("..Game start..");
   
	// commands
	while(true) {
	    System.out.println("1. Straight");
	    System.out.println("2. Left");
	    System.out.println("3. Right");
	    System.out.println("4. Back");
	    System.out.print("Enter an option : ");
	    int option = sc.nextInt();
	    switch(option) {
		case 1:
		    Game.moveStraight();
		    break;
		case 2:
		    Game.moveLeft();
		    break;
		case 3:
		    Game.moveRight();
		    break;
		case 4:
		    System.out.println("..Game ends..");
		    break;
		default:
		    System.out.println("Enter a valid option");		
	    }
	}
    }
}