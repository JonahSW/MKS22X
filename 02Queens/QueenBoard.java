import static java. lang. Math.*;

public class QueenBoard{

    //INSTANCE VARIABLES
    private int[][] board;

    private int solutionCount;

    private int size;

    private int tracker;
    
    private int solutionTracker;

    private boolean stoop;
    
    // CONSTRUCTOR
    public QueenBoard(int size){

	this.size = size;
	
	if(size < 1){
	    throw new IllegalArgumentException();
	}

	stoop = false;
	
	board = new int[size][size];

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
    //Solves the board, leaving it in the solved state
    //TESTED
    public boolean solve(){
	clear(board);
	
	if((size == 2) || (size == 3)){
	    return false;
	}

	if(size == 1){
	    return true;
	}

	tracker = 0;

	boolean good = solveH(0);

	if(good){
	    return good;
	}

	clear(board);

	return good;
	
	
    }
    
    //Helper function that places a queen in a column, and then moves on to
    //the next column.
    //TESTED
    private boolean solveH(int col){
	if(col == size){
	    return true;
	}	
      
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
    }

    //Adds a queen to the board and updates the int array
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
    
    //removes a queen from the board and updates the int array
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
    
    //Counts the number of possible solutions for a given board and returns it
    public int getSolutionCount(){
	if(!(stoop)){
	    return -1;
	}
	
	tracker = 0;

	clear(board);
	solutionCountH(0);
	clear(board);
	return tracker;
    }
	

    //helper function used for counting the number of solutions
    //TESTED
    public boolean solutionCountH(int col){
	if(col == size){
	    tracker = tracker + 1;
	    return false;
	}	
      
        for(int i = 0; i < size; i++){
	    if(board[i][col] == 0){
		addQueen(i, col);
		    if(solutionCountH(col + 1)){
		        return true;
		    }
		removeQueen(i, col);
	    }
	}

	return false;
    }

    //id
    public int countSolutions(){
	stoop = true;
	tracker = 0;
	clear(board);
	solutionCountH(0);
	return tracker;
	
    }

    /**toString
     *and all numbers that represent queens are replaced with 'Q' 
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
	//----------------------------------------------
	System.out.println("----------------------------------------------");
	QueenBoard test = new QueenBoard(2);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());

	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(3);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());
	
	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(4);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());

	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(5);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());

	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(6);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());

	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(7);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());

	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(8);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());

	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(9);
	
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());

	//----------------------------------------------
	System.out.println("----------------------------------------------");
	test = new QueenBoard(10);
        
	System.out.println( "--- " + test.getSolutionCount() + " ---");
	test.solve();
	
	System.out.println(test.toString());
	System.out.println(test.toStringInt());
    }
    //END MAIN
}
