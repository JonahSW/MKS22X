import java.util.*;
public class MyLinkedList implements Iterable<Integer>{

    //Instance Variables
    LNode start, index;
    int size;

    //Constructor for LinkedList
    public MyLinkedList(){
	start = null;
	index = start;
	size = 0;
    }

    //METHODS---------------------------------------------------------------------------------

    //add method (adds to end)
    public boolean add(int value){

	size++;
	
	if(size == 1){
	    start.setValue(value);
	    start.setPointer(null);
	    return true;
	}else{
	    LNode newNode = new LNode(null, value);
	    while(index.getPointer() != null){
		index = index.getPointer();
	    }	
	    index.setPointer(newNode);
	    return true;
	}

	return false;
    }

    //removes an element from the end of the linked list
    public boolean remove(){
	LNode mark = start;
	LNode target;
	
	//NEEDS TO ACCESS THE ELEMENT JUST BEFORE TE+HE END
	target.setPointer(null);
	
	return false;
    }

    //removes an element from a specified location
    public boolean remove(int value, int location){
	return false;
    }

    //returns the size of the Linked List
    public int size(){
	int size;

	return size;
    }
	
    //returns the data at a single node
    public int get(int index){

	return -1;
    }
    
    //ToString method prints out the list
    public String toString(){
	String output = "{";
	index = start;
	for(int i = 0; i < size; i++){
	    output = output + index.getValue() + ", ";
	    index = index.getPointer();
	}
	output = output + index.getPointer() + "}";
	System.out.println(output);
	return output;
    }


    //--------------------------------------------------------------------------------------

    //inner iterator class
    public class MyLinkedListIterator implements Iterator<Integer>{

	//Iterator constructor
	public Iterator<LNode> interator(){
	    return new MyLinkedListIterator(this);
	}
	
	//accesses next index for linked list
	public LNode next(){
	    return getPointer();
	}

	//returns true if a given node points to another node
	public boolean hasNext(){
	    return (next != null);
	}

	//unused, throws unsupported operation exception
	public void remove(){
	    throw new UnsupportedOperationException();
	    //throws unsupported operation exception
	}
    }
    
    //INNER CLASS FOR LNODE
    private class LNode extends LinkedList{

	//variables
	int value;//starts off null
	LNode pointer;//if pointer is null, it is the end of the list
	
	//Constructor for node
	private LNode(LNode point, int val){
	    pointer = point;
	    value = val;
	}

	//Accessor Methods
	public int getValue(){
	    return value;
	}
	public LNode getPointer(){
	    return pointer;
	}

	//Mutator Methods
	public void setValue(int num){
	    value = num;
	}
	public void setPointer(LNode n){
	    pointer = n;
	}
    }
    //END OF LNODE INNER CLASS
    
    //MAIN
    public static void main(String[]arrgs){
	MyLinkedList list1 = new MyLinkedList();
	list1.toString();
	list1.add(1);
	list1.toString();
	list1.add(2);
	list1.toString();
	list1.add(3);
	list1.toString();
    }
}
