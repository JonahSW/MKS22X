import static java. lang. Math.*;

public class KnightsTour{

    //INSTANCE VARIABLES
    private int[][] board;

    private int solutionCount;

    private int rows;

    private int cols;

    private int counter;

    private boolean solved;

    // CONSTRUCTOR
    public KnightsTour(int rows, int cols){

	if((rows <= 1) || (cols <= 1)){
	    throw new IllegalArgumentException("Illegal board dimensions");
	}

	this.rows = rows;
	
	this.cols = cols;

	solved = false;
	
	board = new int[rows][cols];

	clear(board);
    }

    //METHODS

    //sets every location on the board to 0;
    public void clear(int[][] thing){
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		thing[r][c] = 0;
	    }
	}

	counter = 0;
    }
    
    //
    private void addKnight(int row, int col){
	counter++;
	board[row][col] = counter;
    }

    //
    private void removeKnight(int row, int col){
	counter--;
	board[row][col] = 0;
    }

    //Returns true if the knight can be moved to this location
    //(it isn't occupied or visited and is on th board)
    private boolean isGoodSpot(int row, int col){
	if((row >= rows) || (col >= cols) || (row < 0) || (col < 0)){
	    return false;
	}

	if(board[row][col] == 0){
	    return true;
	}
	
	return false;
    }

    //recursively places knights until a tour is reached or all
    //solutions have failed
    private void tourKnight(){
	counter = 0;

	//cycles through the board, tries to find a solution for
	//every possible starting location
	
	for(int r = 0; r < rows; r++){
	    for(int c = 0; c < cols; c++){
		clear(board);
		if(tourHelp(r, c)){
		    System.out.println("Solution Found for board " + rows + "x" + cols);
		    System.out.println("--------------------------------------");
		    return;
		}
	    }
	}
	
	System.out.println("This " + rows + "x" + cols + " board has no solutions");
	System.out.println("--------------------------------------");
	clear(board);
           
    }

    //method for clearing the terminal
    //use x = 1, y = 1 for the upper left;
    private static String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    //method for clearing the terminal
    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }

    //method for delaying printout to terminal
    private static void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    //helper function for tourKnight
    private boolean tourHelp(int r, int c){
	if(solved){
	    return true;
	}
	
	if(counter == (rows * cols)){
	    solved = true;
	    toString();
	    return true;
	}

	if(!(isGoodSpot(r, c))){
	    return false;
	}

	if(isGoodSpot(r, c)){
	    addKnight(r, c);

	    //go(1, 1);
	    //clearTerminal();
	    //toString();
	    //wait(1000);
	    
	    tourHelp(r + 1, c + 2);
	    tourHelp(r + 1, c - 2);
	    tourHelp(r - 1, c + 2);
	    tourHelp(r - 1, c - 2);	    
	    tourHelp(r + 2, c + 1);
	    tourHelp(r + 2, c - 1);
	    tourHelp(r - 2, c + 1);
	    tourHelp(r - 2, c - 1);

	    removeKnight(r, c);
	}
	
	return false;
    }

    //Returns and prints out the int array of board
    //
    public String toString(){
	String str = "";
	
	for(int p = 0; p < rows; p++){
	    for(int i = 0; i < cols; i++){
		str = str + board[p][i] + " ";
	    }
	    str = str + '\n';
	}
	//str = "|" + '\n' + str + '\n' + "|";

	System.out.println(str);
	return str;
    }
    
    //MAIN
    public static void main(String[]args){

	KnightsTour test = new KnightsTour(3, 4);	
	test.tourKnight();
	//-----------------------------------------------------------

	KnightsTour test1 = new KnightsTour(7, 7);	
	test1.tourKnight();
	//-----------------------------------------------------------

	KnightsTour test2 = new KnightsTour(3, 6);	
	test2.tourKnight();
	//-----------------------------------------------------------

	KnightsTour test3 = new KnightsTour(6, 6);	
	test3.tourKnight();
	//-----------------------------------------------------------

	KnightsTour test4 = new KnightsTour(5, 4);	
	test4.tourKnight();
	//-----------------------------------------------------------

	KnightsTour test5 = new KnightsTour(4, 6);	
	test5.tourKnight();
	//-----------------------------------------------------------
	//END MAIN
    }

}
