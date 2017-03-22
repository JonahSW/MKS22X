import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;
    private String filename;
    private int height = 0;
    private int length = 0;
    private int startx;
    private int starty;
    private int endx;
    private int endy;
    
    
    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */

    public Maze(String filename){
	this.filename = filename;
	maze = loadMaze();
    }

    //animates the solve
    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    //Wait method for delaying prints
    private static void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    
    //method for loading the maze into an array
    public char[][] loadMaze(){
	String str = "";
	char[][] load;
	int len = 0;
	boolean s = false;
	boolean en = false;
	
	try{
	    File text = new File(filename);//can be a path"/full/path/to/file.txt"
	    Scanner inf = new Scanner(text);

	    //finds the dimensions of the maze, and loads it into a string
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		height++;
		len = line.length();		
		str = str + line;		
	    }
	    length = len;
	    System.out.println("L = " + length + " H = " + height);
	}catch(FileNotFoundException e){
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}

	//creates the char array
	load = new char[height][length];

	//try/catch catches any indexoutofbounds errors in the case of a bad maze
	try{
	    //loads the maze into the char array
	    for(int i = 0; i < height; i++){
		load[i] = str.substring(0, length).toCharArray();
		str = str.substring(length);
	    }
	    //Finds the start and end location
	    for(int i = 0; i < height; i++){
		for(int p = 0; p < length; p++){
		    if(load[i][p] == 'S'){
			startx = i;
			starty = p;
			s = true;
		    }
		    if(load[i][p] == 'E'){
			endx = i;
			endy = p;
			en = true;
		    }
		}
	    }

	    System.out.println("S = (" + startx + "," + starty + ") " +
			       " E = (" + endx + ',' + endy + ')');

	    if(!(s && en)){
		System.out.println("Invalid Maze: Missing start or end");
		System.exit(1);
	    }

	    //checks that the border is valid
	    for(int i = 0; i < height; i++){
		if(load[i][0] != '#'){
		    System.out.println("Invalid Maze: Border contains breaks");
		    System.exit(1);
		}
	    }
	    for(int i = 0; i < height; i++){
		if(load[i][length - 1] != '#'){
		    System.out.println("Invalid Maze: Border contains breaks");
		    System.exit(1);
		}
	    }
	    for(int i = 0; i < length; i++){
		if(load[0][i] != '#'){
		    System.out.println("Invalid Maze: Border contains breaks");
		    System.exit(1);
		}
	    }
	    for(int i = 0; i < length; i++){
		if(load[height - 1][i] != '#'){
		    System.out.println("Invalid Maze: Border contains breaks");
		    System.exit(1);
		}
	    }
	}catch(IndexOutOfBoundsException e){
	    System.out.println("The maze could not be loaded into an array");
	    System.exit(1);
	}
	
	return load;
    }

    //prints out an array
     public String toString(){
	String str = "";
	
	for(int p = 0; p < height; p++){
	    for(int i = 0; i < length; i++){
		str = str + maze[p][i] + ' ';
	    }
	    str = str + '\n';
	}
	System.out.println('\n' + str);
	return str;
    }

    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	maze[startx][starty] = ' ';
        if(solveH(startx, starty)){
	    return true;
	}
	toString();
	System.out.println("This maze has no solutions");
	return false;
    }

    /*
      Recursive Solve function:
      A solved maze has a path marked with '@' from S to E.
      Returns true when the maze is solved,
      Returns false when the maze has no solution.
      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solveH(int x, int y){
        if(animate){
            System.out.print("\033[2J\033[1;1H"+this);
            wait(0);
	    toString();
	    System.out.println("currently at " + x + ", " + y);
        }
	
	//checks if the maze is solved
	if((x == endx) && (y == endy)){
	    toString();
	    return true;
	}

	//checks if the spot is available
	if(maze[x][y] != ' '){
	    return false;
	}

	//marks the spot as part of the path and tries the four directions from that spot
	maze[x][y] = '@';
	if(solveH(x + 1, y) || solveH(x, y + 1) ||
	   solveH(x - 1, y) || solveH(x, y - 1)){
	    return true;
	}

	//backtracking, marks the spot as visited
	maze[x][y] = '.';
	return false;
    }

    //MAIN
    public static void main(String[]args){
	
	Maze test1 = new Maze("MazeEZ.txt");
	test1.setAnimate(false);
	test1.solve();

	System.out.println("--------------------------------------------------");
	
	Maze test2 = new Maze("MazeMed.txt");
        test2.setAnimate(false);
	test2.solve();

	System.out.println("--------------------------------------------------");
	
	Maze test3 = new Maze("Maze.txt");
        test3.setAnimate(false);
	test3.solve();

	System.out.println("--------------------------------------------------");
	
	Maze test4 = new Maze("Test.txt");
        test4.setAnimate(false);
	test4.solve();

	System.out.println("--------------------------------------------------");

	Maze test5 = new Maze("Maze1.txt");
        test5.setAnimate(false);
	test5.solve();

	System.out.println("--------------------------------------------------");

	Maze test6 = new Maze("Test2.txt");
        test6.setAnimate(false);
	test6.solve();

	System.out.println("--------------------------------------------------");

	Maze test7 = new Maze("break.txt");
        test7.setAnimate(false);
	test7.solve();

	System.out.println("--------------------------------------------------");

	Maze test8 = new Maze("test3.txt");
        test8.setAnimate(false);
	test8.solve();

	System.out.println("--------------------------------------------------");

	
    }
    //END

}
