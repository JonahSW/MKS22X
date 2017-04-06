public class LinkedList implements Iterable<Integer>{

    //Instance Variables
    LNode start, end;
    DNode stat, end;

    int size;

    //Constructor for LinkedList
    public LinkedList(){

    }
    
    //METHODS-----------------------------

    //add method (adds to end)
    public boolean add(int value){

    }

    //add method for doubly linked lists
    public boolean add(){
	return false;
    }

    //removes an element
    public boolean remove(){
	return false;
    }

    //removes an element from a specified location
    public boolean remove(){
	return false;
    }

    //returns the size of the Linked List
    public int size(){
	int size;

	//for(int i = 

	return size;
    }
	
    //returns the data at a songle node
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

	//accesses next index for doubly linked list
	public DNode next(){

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
	LNode pointer;//negative value implies end of list
	int tag;//1 = start, -1 = end, 0 = mid
	
	//Constructor for node
	private LNode(LNode point, int tag1){
	    pointer = point;
	    tag = tag1;
	}

	//Accessor Methods
	public int value(){
	    return value;
	}
	public LNode pointer(){
	    return pointer;
	}
	public int tag(){
	    return tag;
	}
    }
    //END OF LNODE INNER CLASS
    //doubly linked lists class
    //INNER CLASS FOR DNODE
    private class DNode implements LinkedList{

	//variables
	int value;//starts off null
	DNode next;//negative value implies end of list
	DNode prev;//negative value implies front of list
	int tag;//1 = start, -1 = end, 0 = mid
	
	//Constructor for node
	private DNode(DNode point1, DNode point2, int tag1){
	    next = point1;
	    prev = point2;
	    tag = tag1;
	    
	}

	//Accessor Methods
	public int value(){
	    return value;
	}
	public DNode next(){
	    return next;
	}
	public DNode prev(){
	    return prev;
	}
	public int tag(){
	    return tag;
	}
    }
    //END OF DNODE INNER CLASS
    //--------------------------------------------------------------------------------------

    //MAIN
    public static void main(String[]arrgs){
	
    }
}
