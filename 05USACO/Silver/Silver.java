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
		
		if((p == h1 - 1) && ( i == l1 - 1)){
		    str = str + 'S' + " ";
		}else if((p == h2 - 1) && ( i == l2 - 1)){
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
	if((row >= 0) && (col >= 0) && (row < height) && (col < length) && (field[row][col] != '*')){
	    return true;
	}

	return false;
    }

    //wrapper function executes the command
    public int travel(){
	travelUtil(h1 - 1, l1 - 1 , 0);

	//System.out.println(isClear(2, 0));
	//System.out.println(isClear(0, 2));
	//System.out.println(isClear(0, 3));
	//System.out.println(isClear(3, 0));
	
	//System.out.println(field[0][0]);
	//System.out.println(field[0][1]);
	//System.out.println(field[0][2]);
	//System.out.println(field[2][0]);
	//System.out.println(field[0][3]);
	
	//System.out.println(field[0][3]);
	//System.out.println(field[0][4]);

	System.out.println(count);
	return count;
    }

    //helper function for finding the number of paths
    public boolean travelUtil(int h, int l, int t){
	if(!(isClear(h, l))){
	    return false;
	}

	//field[h][l] = 'x';
	//toString();

	if((t == time) && (h == h2 - 1) && (l == l2 - 1)){
	    count++;
	    return false;
	}

	if(t == time){
	    return false;
	}

	return (travelUtil(h + 1, l, t + 1) || travelUtil(h - 1, l, t + 1) ||			 travelUtil(h, l + 1, t + 1) || travelUtil(h, l - 1, t + 1) ||
		travelUtil(h, l, t + 1));
    }

    //isClear function for travelUtilFast
    public boolean isClearF(int h, int l, int[][]trackField){
	if((h >= 0) && (l >= 0) && (h < height) && (l < length) && (int[h][l]) !< 0){
	    return true;
	}

	return false;
    }
    
    //helper function for finding the number of paths FAST ALGORITHM
    //non-recursive
    //still need to study the algorithm
    public boolean travelUtilFast(int h, int l, int t){
	int trackField = new int[height][length];
	for(int i = 0; i < height; i++){
	    for(int p = 0; p < length; p++){
		if(field[h][l] == '*'){
		    trackField[h][l] = -1;
		}
	    }
	}

	if(){
	}
	//
    }
    
    //MAIN
    public static void main(String[]args){
	Silver test1 = new Silver("Test1.txt");
	test1.travel();

	Silver test2 = new Silver("Test2.txt");
	test2.travel();

	Silver test3 = new Silver("Test3.txt");
	test3.travel();

	Silver test4 = new Silver("Test4.txt");
	test4.travel();

	Silver test5 = new Silver("Test5.txt");
	test5.travel();

	//-------------------------------------------------

	Silver test6 = new Silver("ctravel.1.in");
	test6.travel();

	Silver test7 = new Silver("ctravel.2.in");
	test7.travel();

	Silver test8 = new Silver("ctravel.3.in");
	test8.travel();

	Silver test9 = new Silver("ctravel.4.in");
	test9.travel();

	Silver test10 = new Silver("ctravel.5.in");
	test10.travel();

	Silver test11 = new Silver("ctravel.6.in");
	test11.travel();

	Silver test12 = new Silver("ctravel.7.in");
	test12.travel();

	Silver test13 = new Silver("ctravel.8.in");
	test13.travel();

	Silver test14 = new Silver("ctravel.9.in");
	test14.travel();

	Silver test15 = new Silver("ctravel.10.in");
	test15.travel();
    }
    //END MAIN
}
