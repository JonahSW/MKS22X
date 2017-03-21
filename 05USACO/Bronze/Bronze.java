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
	    }
	    
	    //inf.nextLine();
	    //loads the instructions
	    instructions = new int[N][3];
	    for(int i = 0; i < N; i++){
		for(int p = 0; p < 3; p++){
		    instructions[i][p] = inf.nextInt();
		}
	    }

	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}
    }

    //Execute Wrapper Method
    public int execute(){
	//toString(rows, cols, lake);
	for(int i = 0; i < N; i++){
	    executeUtil(instructions[i][0], instructions[i][1], instructions[i][2]);
	    //toString(rows, cols, lake);
	}

	int output = calculateVolume();
	System.out.println(output);
	return output;
    }

    //returns true if the top left corner of a 3x3 square has a square entirely on the board
    public boolean isSafe(int row, int col){
		
	if((row <= rows - 3) && (col <= cols - 3) && (row >= 0) && (col >= 0)){
	    return true;
	}

	return false;
    }

    //Method for executing the instructions in one line
    public void executeUtil(int row, int col, int stomps){
	int down = 0;

	//toString(rows, cols, lake);
	
	if(isSafe(row, col)){
	    down = hiPoint(row, col) - stomps;
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

	//toString(rows, cols, lake);
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
		    depthOfSquare = (elevation - lake[i][p]);
		    //System.out.println(depthOfSquare);
		    depthTotal = depthTotal + depthOfSquare;
		}
	    }
	}
	
	return depthTotal * 5184;
    }

    //toString method for int arrays
    public void toString(int x, int y, int[][] arry){
	String str = "";
	for(int i = 0; i < x; i++){
	    for(int p = 0; p < y; p++){
		str = str + arry[i][p] + " ";
	    }
	    str = str + '\n';
	}

	System.out.println(str);
    }

    
    //MAIN
    public static void main(String[]args){
	Bronze test1 = new Bronze("Test1.txt");
	test1.execute();
	//-------------------------------------

	///*
	Bronze test2 = new Bronze("Test2.txt");
	test2.execute();
	//-------------------------------------

	Bronze test3 = new Bronze("Test3.txt");
	test3.execute();
	//-------------------------------------

	Bronze test4 = new Bronze("Test4.txt");
	test4.execute();
	//-------------------------------------

	Bronze test5 = new Bronze("Test5.txt");
	test5.execute();
	//-------------------------------------

	Bronze test6 = new Bronze("Test6.txt");
	test6.execute();
	//-------------------------------------

	Bronze test7 = new Bronze("Test7.txt");
	test7.execute();
	//-------------------------------------

	Bronze test8 = new Bronze("Test8.txt");
	test8.execute();
	//-------------------------------------

	Bronze test9 = new Bronze("Test9.txt");
	test9.execute();
	//-------------------------------------

	Bronze test10 = new Bronze("Test10.txt");
	test10.execute();
	//-------------------------------------
	//*/
    }
    //END MAIN
}
