import java.util.*;
import java.io.*;

public class Bronze{

    //Instance Variables
    private int rows;
    private int cols;
    private int elevation;
    private int N;
    private int[][] lake;
    private int[][] instructions;
    
    //Official Constructor
    public Bronze(String filename){
	loadLake(filename);
    }

    //Method for reading from the text file
    //UNFINISHED
    public void loadLake(String filename){
	
	try{
	    File text = new File(filename);//can be a path"/full/path/to/file.txt"
	    Scanner inf = new Scanner(text);

	    
	    //Loads the first line of ints
	    int[] loader = new int[4];
	    Scanner args = new Scanner(inf.nextLine());
	    int in = 0;
	    while(args.hasNext()){
		loader[in] = args.nextInt();
		in++;
	    }
	    
	    inf.nextLine();

	    rows = loader[0];
	    cols = loader[1];
	    elevation = loader[2];
	    N = loader[3];
	    
	    
	    //creates the lake array
	    lake = new int[rows][cols];
	    for(int i = 0; i < rows; i++){
		for(int p = 0; p < cols; p++){
		    
		    lake[i][p] = inf.nextInt();
		}
		inf.nextLine();
	    }
	    
	    //inf.nextLine();
	    //loads the instructions
	    instructions = new int[N][3];
	    for(int i = 0; i < N; i++){
		for(int p = 0; p < 3; p++){
		    instructions[i][p] = inf.nextInt();
		}
		inf.nextLine();
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}

	//troubleshooting print methods
	System.out.println(rows + " " + cols + " " + elevation + " " + N);
	System.out.println(lake[0][0] + " " + lake[0][1] + " " + lake[3][4] + " " + lake[3][5]);
	System.out.println(instructions[0][0] + " " + instructions[0][1] + " " + instructions[0][2] + " " + instructions[1][0]);
    }

    //Execute Wrapper Method
    public int execute(){

	for(int i = 0; i < N; i++){
	    executeUtil(instructions[i][0], instructions[i][1], instructions[i][2]);
	}
	return calculateVolume();
    }

    //returns true if the top left corner of a 3x3 square has a square entirely on the board
    public boolean isSafe(int row, int col){
	if((row < rows - 3) && (col < cols - 3) && (row >= 0) && (col >= 0)){
	    return true;
	}

	return false;
    }

    //Method for executing the instructions in one line
    public void executeUtil(int row, int col, int stomps){
	int down = 0;
	if(isSafe(row, col)){
	    down = hiPoint(row, col) - stomps;
	}

	for(int i = row; i < row + 3; i++){
	    for(int p = col; p < col + 3; p++){
		if(lake[i][p] >= down){
		    lake[i][p] = down;
		}
		if(lake[i][p] < 0){
		    lake[i][p] = 0;
		}
	    }
	}
    }

    //method for finding the highest point on a 3x3 section. Input is the top left of the 3x3 square
    public int hiPoint(int row, int col){
	int hi = 0;
	for(int i = row; i < row + 3; i++){
	    for(int p = col; p < col + 3; p++){
		if(lake[i][p] > hi){
		    hi = lake[i][p];
		}
	    }
	}
	return hi;
    }
	
    //calculate method for calculating volume of the lake
    public int calculateVolume(){

	int depthOfSquare;
	int depthTotal = 0;
	
	for(int i = 0; i < rows; i++){
	    for(int p = 0; p < cols; p++){

		if(lake[i][p] > elevation){
		    depthOfSquare = 0;
		}else{		
		    depthOfSquare = (elevation - lake[i][p]) * 72 * 72;
		    depthTotal = depthTotal + depthOfSquare;
		}
	    }
	}
	
	return depthTotal;
    }

    //MAIN
    public static void main(String[]args){
	Bronze test1 = new Bronze("Test1.txt");

	
    }
    //END MAIN
}
