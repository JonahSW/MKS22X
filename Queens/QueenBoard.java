public class QueenBoard{

    //INSTANCE VARIABLES
    private int[][]board;

    private int solutionCount;

    private int size = board.length;

    // CONSTRUCTOR
    public QueenBoard(int size){
	if(size < 1){
	    throw new IllegalArgumentException();
	}
	
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    //
    public boolean solve(){
	if((size == 2) || (size == 3)){
	    return false;
	}

	return solveH(0);
    }
    
    //
    private boolean solveH(int col){

	if(board[size - 1] != 0){
	    return false
	}

	addQueen[size - [col
    }

    //
    private void addQueen(r, c){
	board[r][c] = -1;
    }
    
    //
    private void removeQueen(r, c){
	board[r][c] == 0;
    }
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.

     *The board should be reset after this is run.    

     */

    public int getSolutionCount(){
    	return -1;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	return "";
    }
}
