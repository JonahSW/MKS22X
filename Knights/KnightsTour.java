import static java. lang. Math.*;

public class KnightsTour{

    //INSTANCE VARIABLES
    private int[][] board;

    private int solutionCount;

    private int rows;

    private int cols;

    // CONSTRUCTOR
    public QueenBoard(int rows, int cols){

	if((rows < 1) || (cols < 1)){
	    throw new IllegalArgumentException();
	}

	this.rows = rows;
	
	this.cols = cols;
	
	board = new int[rows][cols];

	clear(board);
    }

    //METHODS

    //TESTED
     public String toString(){
	String str = "";
	
	for(int p = 0; p < rows; p++){
	    for(int i = 0; i < cols; i++){
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
	
	for(int p = 0; p < rows; p++){
	    for(int i = 0; i < cols; i++){
		str = str + board[i][p] + " ";
	    }
	    str = str + '\n';
	}
	str = "|" + '\n' + str + '\n' + "|";
	return str;
    }
    
    //MAIN
    public static void main(String[]args){
	
    //END MAIN
}
