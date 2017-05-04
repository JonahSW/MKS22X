import java.util.*;
public class MyHeap{
    //Constructs a heap of Strings data structure using an array
    //Contains methods: add, remove, resize, peek(looks at top), push forward, push back, toString

    //VARIABLES
    boolean fullRoot;
    public String[] arry;
    public int size;
    
    //CONSTRUCTOR
    public MyHeap(){
	arry = new String[11];
	size = 0;
	arr[0] = size;
	fullRoot = false;
    }

    //METHODS
    //adds a String to the top of the heap, returns false if it fails
    public boolean add(String str){
	if(str.compareTo(peek(size)) >= 0){
	    
	}

	size++;
	if((size % 2) != 0){
	    fullRoot = false;
	}
    }

    //Removes a String from the top of the heap, returns false if it fails
    public boolean remove(){


	size--;
	if((size % 2) == 0){
	    fullRoot = true;
	}
    }

    //Resizes the array if the need arises
    public void resize(){
	String[] newArry = new String[size * 2];

	newArry[0] = size;
	
	for(int i = 1; i < arry.length; i++){
	    newArry[i] == arry[i];
	}
    }

    //Returns the string at a given index
    public String peek(int i){
	return arry[i];
    }

    //
    public void pushForward(int i){
	childInt = i;
	parentInt = i / 2;
	String temp;
	
	temp = arry[parentInt];
	arry[parentInt] = arry[childInt];
	arry[childInt] = temp;
    }

    //
    public void pushBack(int i){
	parentInt = i;
	if((2 * i)
	childInt1 = i;
	String temp;
	
	temp = arry[parentInt];
	arry[parentInt] = arry[childInt];
	arry[childInt] = temp;
    }

    //
    toString(){
	int counter = 1;
	System.out.println(arry[1])

	for(int i = 0; i < arry.length; i++){
	    
	}
    }
}
