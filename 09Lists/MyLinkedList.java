import java.util.*;
public class LinkedList implements Iterable<Integer>{

    //Instance Variables
    LNode start, end;
    int size;

    //Constructor for LinkedList
    public LinkedList(LNode start){
	this.start = start;
	size = 0;
    }

    //METHODS---------------------------------------------------------------------------------

    //add method (adds to end)
    public boolean add(int value){
	LNode newNode = new LNode(null, value);
	end.setPointer(newNode);
    }

    //removes an element from the end of the linked list
    public boolean remove(int value){

	
	start.setPointer(null)
	
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

	System.out.println();
    }

    //Iterator constructor
    public Iterator<Integer> interator(){
	return new MyLinkedListIterator(this);
    }

    //--------------------------------------------------------------------------------------

    //inner iterator class
    public class MyLinkedListIterator implements Iterator<Integer>{

	//accesses next index for linked list
	public LNode next(){

	}

	//returns true if a given node points to another node
	public boolean hasNext(){

	}

	//unused, throws unsupported operation exception
	remove(){
	    //throws unsupported operation exception
	}
    }
    
    //INNER CLASS FOR LNODE
    private class LNode implements LinkedList{

	//variables
	int value;//starts off null
	LNode pointer;//if pointer is null, it is the end of the list
	
	//Constructor for node
	private LNode(LNode point, int val){
	    pointer = point;
	    value = val;
	}

	//Accessor Methods
	public int value(){
	    return value;
	}
	public LNode pointer(){
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
	LNode start = new LNode();
	LNode end  == new LNode();
	LinkedList list1 = new LinkedList(LNode
    }
}
