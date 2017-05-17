import java.util.*;
public class MyHeap{
    //Constructs a heap of Strings data structure using an array
    //Contains methods: add, remove, resize, peek(looks at top), push forward, push back, toString
    //This is a MaxHeap (largest element on top)

    //VARIABLES
    public String[] arry;
    public int size;
    public boolean max = true;
    //CONSTRUCTOR
    //default max heap
    public MyHeap(){
	arry = new String[11];
	size = 0;
	arry[0] = "" + size;
    }

    //Max or Min Heap    //max heap when max is true
    public MyHeap(boolean max){
	arry = new String[11];
	size = 0;//size is 0 when array has an int at start, size is # elements in heap, excluding the size
	arry[0] = "" + size;
	this.max = max;
    }

    //METHODS
    //adds a String to the top of the heap, returns false if it fails
    public boolean add(String str){
	size++;
	arry[0] = size + "";
	if(size >= arry.length - 1){
	    resize();
	}
	if(size == 1){
	    arry[size] = str;
	    return true;
	}
	arry[size] = str;
	
	int tracker = size;
	//the problem is here, tracker is not being used properly
	if(max){
	    while(str.compareTo(peek(tracker)) > 0){
		tracker = pushForward(size);
	    }
	}else{
	    while(str.compareTo(peek(tracker)) > 0){
		tracker = pushBack(size);
	    }
	}
	//used for testing
	return false;
    }

    //Removes a String from the top of the heap, returns false if it fails
    public boolean remove(){
	String out = arry[1];

	//Code to push the next highest or lowest back into place
	size--;
	arry[0] = size + "";
	return false;
    }

    //Resizes the array if the need arises
    public void resize(){
	String[] newArry = new String[size * 2];

	newArry[0] = "" + size;
	
	for(int i = 1; i < arry.length; i++){
	    newArry[i] = arry[i];
	}
	arry = newArry;
    }

    //Returns the string at a given index
    public String peek(int i){
	return arry[i];
    }

    //switches a root with it parent
    //returns the new index of the root
    public int pushForward(int r){
	int childInt = r;
	int parentInt = r / 2;
	String temp;

	try{
	    temp = arry[parentInt];
	    arry[parentInt] = arry[childInt];
	    arry[childInt] = temp;
	}catch(IndexOutOfBoundsException e){
	    	}
	return parentInt;
    }

    //switches a parent with its root
    //returns the new index of the parent
    public int pushBack(int c){
	int parentInt = c;
	int childInt = -1;
	String temp;

	if(arry[c * 2 + 1] != null){
	    childInt = c * 2 + 1;
	}else{
	    childInt = c * 2;
	}
	
	temp = arry[parentInt];
	arry[parentInt] = arry[childInt];
	arry[childInt] = temp;
	return childInt;
    }

    //
    public String toString(){
	String out = "{";
	for(int i = 0; i < arry.length - 1; i++){
	    out = out + arry[i] + ", ";
	}
	out = out + arry[arry.length - 1] + "}";

	System.out.println(out);
	return out;
    }

    //MAIN
    public static void main(String[]args){
	MyHeap test1 = new MyHeap();
	test1.toString();
	test1.add("1");
	test1.toString();
	test1.add("2");
	test1.toString();
	test1.add("3");
	test1.add("4");
	test1.add("5");
	test1.add("6");
	test1.add("7");
	test1.add("8");
	test1.add("9");
	test1.toString();


				  
	//END MAIN
    }
    //END CLASS MYHEAP
}
