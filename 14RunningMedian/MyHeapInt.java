import java.util.*;
public class MyHeapInt{
    //Constructs a heap of Strings data structure using an array
    //Contains methods: add, remove, resize, peek(looks at top), push forward, push back, toString
    //CURRENT BUGS - there appears to be an error with the pushUp and pushDown methods that occurs only after resizing the array, but I do not seem to be able to replicate it on demand
    //This is a MaxHeap (largest element on top)

    //VARIABLES
    public int[] arry;
    public int size;
    public boolean max = true;
    
    //CONSTRUCTOR
    //default max heap
    public MyHeapInt(){
	arry = new int[11];
	size = 0;
	arry[0] = size;
    }

    //Max or Min Heap
    //max heap when max is true
    public MyHeapInt(boolean max){
	arry = new int[11];
	size = 0;//size is 0 when array has an int at start, size is # elements in heap, excluding the size at the start of the array
	arry[0] = size;
	this.max = max;
    }

    //METHODS
    //adds a String to the top of the heap, returns false if it fails
    public void add(int num){
	size++;
	arry[0] = size;
	if(size >= arry.length - 1){
	    resize();
	}
	arry[size] = num;
	pushUp();
	//System.out.print("The size of the array is " +  size);
	//System.out.println(" and the data at node size is " + peek(size));
    }

    //Removes a int from the top of the heap, returns the removed String
    public int remove(){
	int outed = arry[1];
	if(size <= 0){
	    throw new IndexOutOfBoundsException();
	}
	arry[1] = arry[size];//pulls the last element and places it up front
	arry[size] = 0;
	pushDown();
	size--;
	arry[0] = size;
	return outed;
    }

    //Resizes the array if the need arises
    public void resize(){
	int[] newArry = new int[size + 10];
	for(int i = 0; i < arry.length; i++){
	    newArry[i] = arry[i];
	}
	arry = newArry;
	//System.out.println("RESIZED!!!");
    }

    //Returns the string at a given index
    public int peek(int i){
	if(i <= 0){
	    throw new NoSuchElementException();
	}
	return arry[i];
    }

    //switches a root with its parent until it is in the proper place
    //returns the new index of the root
    public int pushUp(){
	//System.out.println("I just pushed up!");
	int tracker = size;
	if(max){
	    while((tracker > 1) && (peek(tracker) < peek(tracker / 2))){
		swap(tracker, tracker / 2);
		tracker = tracker / 2;
	    }
	}else{
	    while((tracker > 1) && (peek(tracker) < peek(tracker / 2))){
		swap(tracker, tracker / 2);
		tracker = tracker / 2;
	    }
	}
	return tracker;
    }

    //switches a parent with its root until it is in the proper place
    //returns the new index of the parent
    public int pushDown(){
	//System.out.println("I just pushed down!");
	int tracker = 1;

	if(max){
	    while((tracker * 2) + 1 <= size){
		if((peek(tracker) >= peek(tracker * 2)) && 
		   (peek(tracker) >= peek((tracker * 2) + 1))){
		    return tracker;
		}else if(peek(tracker) < peek((tracker * 2) + 1)){
		    swap(tracker, (tracker * 2) + 1);
		}else{
		    swap(tracker, tracker * 2);
		}
	    }
	    return tracker;
	}else{
	    while((tracker * 2) + 1 <= size){
		if((peek(tracker) <= peek(tracker * 2)) && 
		   (peek(tracker) <= peek((tracker * 2) + 1))){
		    return tracker;
		}else if(peek(tracker) > peek((tracker * 2) + 1)){
		    swap(tracker, (tracker * 2) + 1);
		}else{
		    swap(tracker, tracker * 2);
		}
	    }
	    return tracker;
	}
    }

    //Method for swapping two indices in arry
    public void swap(int a, int b){
	int temp = arry[a];
	arry[a] = arry[b];
	arry[b] = temp;
    }
    
    //Overrides toString() method
    public String toString(){
	String out = "{";
	for(int i = 0; i < arry.length - 1; i++){
	    out = out + arry[i] + ", ";
	}
	out = out + arry[arry.length - 1] + "}";

	System.out.println(out);
	return out;
    }

    //custom toString method
    public void toStringPyramid(){
	int pyramidLevel = 1;
	//int spaceIterate = 
    }

    //MAIN
    public static void main(String[]args){
	//END MAIN
    }
    //END CLASS MYHEAP
}
