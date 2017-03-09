import static java. lang. Math.*;

public class KnightsTour{

    //INSTANCE VARIABLES
    private int[][] board;

    private int solutionCount;

    private int rows;

    private int cols;

    private int counter;

    // CONSTRUCTOR
    public KnightsTour(int rows, int cols){

	if((rows <= 1) || (cols <= 1)){
	    throw new IllegalArgumentException();
	}

	this.rows = rows;
	
	this.cols = cols;
	
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
    //(it isn't occupied or visited)
    private boolean isGoodSpot(int row, int col){
	if((row > rows) || (col > cols) || (row < 0) || (col < 0)){
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

	tourHelp(rows/2, cols/2);
		
      
	/*
        for(int i = 0; i < size; i++){
	    if(board[i][col] == 0){
		addQueen(i, col);
		    if(solveH(col + 1)){
		        return true;
		    }
		removeQueen(i, col);
	    }
	}

	return false;
	*/
	    
    }

    //helper function for tourKnight
    private boolean tourHelp(int r, int c){
	if(counter == rows * cols){
	    return true;
	}

	//1
	if(isGoodSpot(rows + 2, cols + 1)){
	    addKnight(rows + 2, cols + 1);
	    return tourHelp(rows + 2, cols + 1);
	}

	//2
	if(isGoodSpot(rows + 2, cols - 1)){
	    addKnight(rows + 2, cols - 1);
	    return tourHelp(rows + 2, cols - 1);
	}

	//3
	if(isGoodSpot(rows + 1, cols + 2)){
	    addKnight(rows + 1, cols + 2);
	    return tourHelp(rows + 1, cols + 2);
	}

	//4
	if(isGoodSpot(rows + 1, cols - 2)){
	    addKnight(rows + 1, cols - 2);
	    return tourHelp(rows + 1, cols - 2);
	}

	//5
	if(isGoodSpot(rows - 2, cols + 1)){
	    addKnight(rows - 2, cols + 1);
	    return tourHelp(rows - 2, cols + 1);
	}

	//6
	if(isGoodSpot(rows - 2, cols - 1)){
	    addKnight(rows - 2, cols - 1);
	    return tourHelp(rows - 2, cols - 1);
	}

	//7
	if(isGoodSpot(rows - 1, cols + 2)){
	    addKnight(rows - 1, cols + 2);
	    return tourHelp(rows - 1, cols + 2);
	}

	//8
	if(isGoodSpot(rows - 1, cols - 2)){
	    addKnight(rows - 1, cols - 2);
	    return tourHelp(rows - 1, cols - 2);
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
	str = "|" + '\n' + str + '\n' + "|";
	return str;
    }
    
    //MAIN
    public static void main(String[]args){
	KnightsTour test = new KnightsTour(4, 4);

	test.tourKnight();
	System.out.println(test.toString());
	
	//END MAIN
    }

}
