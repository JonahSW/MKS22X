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
	    int[] loader = new int[3];
	    Scanner args = new Scanner(inf.nextLine());
	    int in = 0;
	    while(args.hasNext()){
		loader[in] = args.nextInt();
		in++;
	    }
	    
	    height = loader[0];
	    length = loader[1];
	    time = loader[2];

	    //creates the field array
	    field = new char[height][length];
	    String str = "";
	    for(int i = 0; i < height; i++){
		String line = inf.nextLine();
		str = str + line;		
	    }
	    
	    for(int i = 0; i < height; i++){
		field[i] = str.substring(0, length).toCharArray();
		str = str.substring(length);
	    }

	    //loads the start and end coordinates
	    int[] loader2 = new int[4];
	    int in2 = 0;
	    while(inf.hasNextInt()){
		loader2[in2] = inf.nextInt();
		in2++;
	    }
	    h1 = loader2[0];
	    l1 = loader2[1];
	    h2 = loader2[2];
	    l2 = loader2[3];

	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}

	//troubleshooting print methods	
	System.out.println(height + " " + length + " " + time);
	System.out.println(h1 + " " + l1 + " " + h2 + " " + l2);
	toString();
    }

    //prints out an array
     public String toString(){
	String str = "";
	
	for(int p = 0; p < height; p++){
	    for(int i = 0; i < length; i++){
		
		if((p == h1) && ( i == l1)){
		    str = str + 'S' + " ";
		}else if((p == h2) && ( i == l2)){
		    str = str + 'E' + " ";
		}else{
		str = str + field[p][i] + ' ';
		}
	    }
	    str = str + '\n';
	}
	System.out.println('\n' + str);
	return str;
    }

    //checks if space is in field and is not a tree
    public boolean isClear(int row, int col){
	if((row > 0) && (col > 0) && (row <= height) && (col <= length) && (field[row][col] != '*')){
	    return true;
	}
	    return false;
    }

    //wrapper function executes the command
    public int travel(){
	travelUtil(h1, l1, 0);

	System.out.println(count);
	return count;
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

	return (travelUtil(h + 1, l, t + 1) || travelUtil(h - 1, l, t + 1) ||			 travelUtil(h, l + 1, t + 1) || travelUtil(h, l - 1, t + 1) ||
		travelUtil(h, l, t + 1));
    }
    
    //MAIN
    public static void main(String[]args){
	Silver test1 = new Silver("Test1.txt");
	test1.travel();

	Silver test2 = new Silver("Test2.txt");
	test2.travel();
    }
    //END MAIN
}
