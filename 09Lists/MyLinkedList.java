import java.util.*;
public class MyLinkedList implements Iterable<Integer>{

    //Instance Variables
    public LNode start, index;
    public int size;

    //Constructor for LinkedList
    public MyLinkedList(){
	start = null;
	index = start;
	size = 0;
    }

    //METHODS---------------------------------------------------------------------------------

    //add method (adds to end)
    //Tested
    public int add(int value){
	index = start;
	LNode newNode = new LNode(null, value);
	if(size == 0){
	    start = newNode;
	    size++;
	    return value;
	}else{
	    while(index.getPointer() != null){
		index = index.getPointer();
	    }	
	    index.setPointer(newNode);
	    size++;
	    return value;
	}
    }

    //removes an element from the end of the linked list
    //Tested
    public int remove(){
	LNode mark = start;
	int removed;
	if(size == 0){
	    return 0;
	}
	for(int i = 0; i < size - 1; i++){
	    mark = mark.getPointer();
	}
	removed = mark.getValue();
	mark.setPointer(null);
	size--;
	return removed;
    }

    //removes an element from a specified location
    public int remove(int location){
	index = start;
	LNode skip, skipped;
	for(int i = 0; i < location - 1; i++){
	    index = index.getPointer();
	}
	skipped = index.getPointer();
	skip = skipped.getPointer();
	index.setPointer(skip);
	
	return skipped.getValue();
    }

    //returns the size of the Linked List
    //TESTED
    public int size(){
	return size;
    }
	
    //returns the data at a single node
    //First index is zero
    //TESTED
    public int get(int indx){
	if(indx < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(indx >= size){
	    throw new IndexOutOfBoundsException();
	}
	index = start;
	for(int i = 0; i < indx; i++){
	    index = index.getPointer();
	}
	return index.getValue();
    }

    //sets an index to a specified value and returns the old one
    public int set(int newValue, int indx){
	index = start;
	for(int i = 0; i < indx; i++){
	    index = index.getPointer();
	}
	int old = index.getValue();
	index.setValue(newValue);
	return old;
    }
    
    //ToString method prints out the list
    public String toString(){
	String output = "{";
	index = start;

	if(size == 0){
	    System.out.println("null");
	    return null;
	}
	
	for(int i = 0; i < size - 1; i++){
	    output = output + index.getValue() + ", ";
	    index = index.getPointer();
	}
	output = output + index.getValue() + "}";
	System.out.println(output);
	return output;
    }

    //
    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this);
    }
    
    //--------------------------------------------------------------------------------------

    //inner iterator class
    public class MyLinkedListIterator implements Iterator<Integer>{

	public MyLinkedList listIt;
	public LNode index;

	//Iterator constructor
	public MyLinkedListIterator(MyLinkedList list){
	    listIt = list;
	    index = listIt.start;
	}
	
	//accesses value at the next index for linked list
	public Integer next(){
	    try{
		index = index.getPointer();
		return index.getValue();
	    }catch(NoSuchElementException e){
		return 0;
	    }
	}

	//returns true if a given node points to another node
	public boolean hasNext(){
	    return (next() != null);
	}

	//unused, throws unsupported operation exception
	public void remove(){
	    throw new UnsupportedOperationException();
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

	list1.add(10);
	//list1.toString();
	list1.add(3);	
	list1.add(58);
	list1.add(2);
	list1.add(534);
	list1.toString();
	list1.add(5);
	list1.add(6);
	list1.add(9);
	list1.add(789);
	list1.add(78);
	list1.toString();

	list1.set(4, 10000);
	list1.toString();
	list1.set(2, 11111);
	list1.toString();
    }
}
