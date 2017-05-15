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
    //TESTED with double
    public int add(int value){
	index = start;
	LNode newNode = new LNode(null, null, value);
	if(size == 0){
	    start = newNode;
	    size++;
	    return value;
	}else{
	    while(index.getPointer() != null){
		index = index.getPointer();
	    }	
	    index.setPointer(newNode);
	    newNode.setPrevious(index);
	    size++;
	    return value;
	}
    }

    //Adds a value at a given index
    public void add(int indx, int newValue){
	index = start;
	if(indx < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(indx > size){
	    throw new IndexOutOfBoundsException();
	}
	LNode newNode = new LNode(null, null, newValue);
	if(size == 0){
	    start = newNode;
	    size++;
	}else if(indx == 0){
	    start = newNode;
	    start.setPointer(index);
	    index.setPrevious(start);
	    size++;
	}else if(indx == size){
	    for(int i = 0; i < size - 1; i++){
		index = index.getPointer();
	    }
	    index.setPointer(newNode);
	    newNode.setPrevious(index);
	    size++;
	}else{
	    for(int i = 0; i < indx; i++){
		index = index.getPointer();
	    }
	    LNode temp = index.getPointer();
	    index.setPointer(newNode);
	    newNode.setPrevious(index);
	    newNode.setPointer(temp);
	    temp.setPrevious(newNode);
	    size++;
	}
    }

    //removes an element from the end of the linked list
    //TESTED
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
    //TESTED
    public int remove(int location){
	index = start;
	if(location < 0){
	    throw new IndexOutOfBoundsException();
	}
	if(location >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode skip, skipped;
	if(location == 0){
	    skipped = start;
	    start = start.getPointer();
	    size--;
	    return skipped.getValue();
	}
	if(location == (size() - 1)){
	    for(int i = 0; i < size() - 2; i++){
		index = index.getPointer();
	    }
	    skipped = index.getPointer();
	    index.setPointer(null);
	    size--;
	    return skipped.getValue();
	}
	for(int i = 0; i < location - 1; i++){
	    index = index.getPointer();
	}
	skipped = index.getPointer();
	skip = skipped.getPointer();
	index.setPointer(skip);
	size--;
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
	if(indx > size){
	    throw new IndexOutOfBoundsException();
	}
	index = start;
	for(int i = 0; i < indx; i++){
	    index = index.getPointer();
	}
	return index.getValue();
    }

    //sets an index to a specified value and returns the old one
    public int set(int indx, int newValue){
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
	LNode previous;//if previous is null, it's the beginning of the list;
	
	//Constructor for node
	private LNode(LNode point,LNode prev, int val){
	    pointer = point;
	    previous = prev;
	    value = val;
	}

	//Accessor Methods
	public int getValue(){
	    return value;
	}
	public LNode getPointer(){
	    return pointer;
	}
	public LNode getPrevious(){
	    return previous;
	}

	//Mutator Methods
	public void setValue(int num){
	    value = num;
	}
	public void setPointer(LNode n){
	    pointer = n;
	}
	public void setPrevious(LNode prev){
	    previous = prev;
	}
    }
    //END OF LNODE INNER CLASS
    
    //MAIN
    public static void main(String[]arrgs){
	MyLinkedList list1 = new MyLinkedList();

	list1.add(1);
	list1.add(2);
	list1.add(3);
	list1.add(4);
	list1.add(5);
	list1.toString();

	MyLinkedList list2 = new MyLinkedList();
	list2.add(0, 1);
	//	System.out.println(list2.get(0));
	list2.add(1, 2);
	list2.add(2, 3);
	list2.add(3, 4);
	list2.add(4, 5);
	list2.add(2, 666);
	list2.toString();
	System.out.println(list2.get(5));
	list2.add(5, 7);
	list2.add(0, 666);
	list2.toString();
    }
}
