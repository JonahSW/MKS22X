import java.util.*;
import java.io.*;

public class Silver{
    //instance variables
    private int height;
    private int length;
    private int time;
    private char[][] field;
    private int h1;
    private int l1;
    private int h2;
    private int l2;
    private int count;
		     
    //constructor
    public Silver(String filename){
	loadSilver(filename);
    }

    //methods
    public void loadSilver(String filename){	
	try{
	    File text = new File(filename);//can be a path"/full/path/to/file.txt"
	    Scanner inf = new Scanner(text);

	    //Loads the first line of ints
	    int[] loader = new int[40];
	    int n = -1;
	    while(inf.hasNextInt()){
		n++;
		loader[n] = inf.nextInt();
	    }
	    inf.nextLine();

	    height = loader[0];
	    length = loader[1];
	    time = loader[2];
	    
	    //creates the field array
	    field = new int[height][length];
	    for(int i = 0; i < height; i++){
		for(int p = 0; p < length; p++){
		    field[i][p] = inf.nextInt();
		}
		inf.nextLine();
	    }

	    inf.nextLine();

	    //loads the coordinates
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}

	//troubleshooting print methods
	System.out.println();
    }

    //checks if space is in field and is not a tree
    public boolean isClear(int row, int col){
	if((rows > 0) && (col > 0) && (row <= height) && (col <= length) && (field[row][col] != '*')){
	    return true;
	}

	    return false;
    }

    //wrapper function executes the command
    public void travel(){
	travelUtil(h1, l1, 0);
    }

    //helper function for finding the number of paths
    public boolean travelUtil(int h, int l, int t){
	if(!(isClear(h, l))){
	    return false;
	}

	if((h == h2) && (l == l2)){
	    count++;
	}

	if(t == time){
	    return false;
	}

	return ((travelUtil(h + 1, l, t + 1) || travelUtil(h - 1, l, t + 1) ||			 travelUtil(h, l + 1, t + 1) || travelUtil(h, l - 1, t + 1));
    }
    
    //MAIN
    public static void main(String[]args){

    }
    //END MAIN
}
