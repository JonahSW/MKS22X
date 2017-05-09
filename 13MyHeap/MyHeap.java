import java.util.*;
public class MyHeap{
    //Constructs a heap of Strings data structure using an array
    //Contains methods: add, remove, resize, peek(looks at top), push forward, push back, toString
    //This is a MaxHeap (largest element on top)

    //VARIABLES
    public String[] arry;
    public int size;
    
    //CONSTRUCTOR
    public MyHeap(){
	arry = new String[11];
	size = 0;
	arry[0] = "" + size;
    }

    //temporary testing constructor
    public MyHeap(String[] ary){
	arry = ary;
	size = ary.length - 1;
	arry[0] = "" + size;
    }

    //METHODS
    //adds a String to the top of the heap, returns false if it fails
    public boolean add(String str){
	
	if(size == arry.length){
	    resize();
	}

	size++;
	arry[size] = str;

	if(size == 1){
	    arry[size] = str;
	    return true;
	}
	
	int tracker = size;
	while(str.compareTo(peek(tracker)) > 0){
	    tracker = pushForward(size);
	}

	//used for testing
	return false;
    }

    //Removes a String from the top of the heap, returns false if it fails
    public boolean remove(){


	size--;
	return false;
    }

    //Resizes the array if the need arises
    public void resize(){
	String[] newArry = new String[size * 2];

	newArry[0] = "" + size;
	
	for(int i = 1; i < arry.length; i++){
	    newArry[i] = arry[i];
	}
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
	}catch{(IndexOutOfBoundsException() e)
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


	String[] stuff = new String[]{null,"7","6","5","4","3","2","1","0","-1","-2","-3","-4","-5","-6","-7"};
	MyHeap test2 = new MyHeap(stuff);
	test2.toString();
	test2.pushForward(4);
	test2.toString();
	

				  
	//END MAIN
    }
    //END CLASS MYHEAP
}
