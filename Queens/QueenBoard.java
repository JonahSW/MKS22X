 import static java. lang. Math.*;

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
        if(col == size){
	    return false;
	}

	for(int i = 0; i < size; i++){	    
	    if(board[col][i] == 0){
		addQueen(col, i);
		return solveH(col + 1);
	    }
	}
	
	return false;
	
    }

    //
    //TESTED
    private void addQueen(int r, int c){
	if((r >= size) || (c >= size)){
	    throw new IllegalArgumentException();
	}	
	if(board[r][c] != 0){
	    System.out.println("Cannot add Queen to " + r + ", " + c);
	    return;
	}
	//Horizontal and vertical
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
	//Diagonals
        for(int i = 1; i <= min(r, c); i++){
	    board[r - i][c - i] = board[r - i][c - i] + 1;
	}
	for(int i = 1; i < min(size - r, size - c); i++){
	    board[r + i][c + i] = board[r + i][c + i] + 1;
	}
	for(int i = 1; i < min(r + 1, size - c); i++){
	    board[r - i][c + i] = board[r - i][c + i] + 1;
	}
	for(int i = 1; i < min(size - r, c + 1); i++){
	    board[r + i][c - i] = board[r + i][c - i] + 1;
	}
	//adds the queen
	board[r][c] = -1;
	
    }
    
    //
    //TESTED
    private void removeQueen(int r, int c){
	if((r >= size) || (c >= size)){
	    throw new IllegalArgumentException();
	}
	if(board[r][c] != -1){
	    System.out.println("Cannot remove Queen from " + r + ", " + c);
	    return;
	}
	//Horizontal and vertical
	for(int i = 0; i < size; i++){
	    if(board[i][c] != -1){
		board[i][c] = board[i][c] - 1;
	    }
	}
	for(int i = 0; i < size; i++){
	    if(board[r][i] != -1){
		board[r][i] = board[r][i] - 1;
	    }	
	}
	//Diagonals
        for(int i = 1; i <= min(r, c); i++){
	    board[r - i][c - i] = board[r - i][c - i] - 1;
	}
	for(int i = 1; i < min(size - r, size - c); i++){
	    board[r + i][c + i] = board[r + i][c + i] - 1;
	}
	for(int i = 1; i < min(r + 1, size - c); i++){
	    board[r - i][c + i] = board[r - i][c + i] - 1;
	}
	for(int i = 1; i < min(size - r, c + 1); i++){
	    board[r + i][c - i] = board[r + i][c - i] - 1;
	}
	//removes the queen
	board[r][c] = 0;
    }
    
    /**
     *@return the number of solutions found, or -1 if the board was never solved.

     *The board should be reset after this is run.    

     */

    //TESTED
    public static int factorial(int n){
	int sum = 1;

	if(n == 0){
	    return 0;
	}

	for(int i = 1; i <= n; i++){
	    sum = i * sum;
	}

	return sum;
    }
    
    //
    public int getSolutionCount(){
    	return -1;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    //TESTED
     public String toString(){
	String str = "";
	
	for(int p = 0; p < size; p++){
	    for(int i = 0; i < size; i++){
		if(board[i][p] == -1){
		    str = str + " " + 'Q'; 
		}
		if(board[i][p] == 0){
		    str = str + " " + '-'; 
		}
		if(board[i][p] > 0){
		    str = str + " " + '+'; 
		}
	    }
	    str = str + '\n';
	}
	str = "|" + '\n' + str + '\n' + "|";
	return str;
     }

    //Returns and prints out the int array of board
    //TESTED
    public String toStringInt(){
	String str = "";
	
	for(int p = 0; p < size; p++){
	    for(int i = 0; i < size; i++){
		str = str + board[i][p] + " ";
	    }
	    str = str + '\n';
	}
	str = "|" + '\n' + str + '\n' + "|";
	return str;
    }
    
    //MAIN
    public static void main(String[]args){
	QueenBoard test = new QueenBoard(4);
	
	test.solveH(0);
	
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());
    }
    //END MAIN
}
