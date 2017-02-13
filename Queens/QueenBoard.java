public class QueenBoard{

    //INSTANCE VARIABLES
    private int[][] board;

    private int solutionCount;

    private int size;

    // CONSTRUCTOR
    public QueenBoard(int size1){

	if(size1 < 1){
	    throw new IllegalArgumentException();
	}

	size = size1;
	
	board = new int[size1][size1];

	clear(board);
    }

    //METHODS

    //sets every location on the board to 0;
    public void clear(int[][] thing){
	for(int r = 0; r < size; r++){
	    for(int c = 0; c < size; c++){
		thing[c][r] = 0;
	    }
	}
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

	if(size == 1){
	    return true;
	}

	return solveH(0);
    }
    
    //
    private boolean solveH(int col){
	
	for(int row = 0; row < col; row++){
	    if(board[col][row] == 0){
		addQueen(row, col);
		return true;
	    }
	}

	return false;
    }

    //
    private void addQueen(int r, int c){
	board[r][c] = -1;

	for(int i = 0; i < size; i++){
	    if(board[i][c] != -1){
		board[i][c] = board[i][c] + 1;
	    }
	}
	
	for(int i = 0; i < size; i++){
	    if(board[r][i] != -1){
		board[r][i] = board[r][i] + 1;
	    }	
	
    }
    
    //
    private void removeQueen(int r, int c){
	board[r][c] = 0;
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
	String str = "";
	
	for(int p = 0; p < size; p++){
	    for(int i = 0; i < size; i++){
		if(board[p][i] == -1){
		    str = str + " " + 'Q'; 
		}
		if(board[p][i] == 0){
		    str = str + " " + '-'; 
		}
		if(board[p][i] > 0){
		    str = str + " " + '+'; 
		}
	    }
	    str = str + '\n';
	}
	str = "|" + '\n' + str + '\n' + "|";
	return str;
    }

    //MAIN
    public static void main(String[]args){
	QueenBoard test = new QueenBoard(8);

	test.addQueen(4, 6);
	
	System.out.println(test.toString());
    }
    //END MAIN
}
