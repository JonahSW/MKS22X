public class LinkedList {

    //Instance Variables
    LNode start, end;

    int size;

    //Constructor for LinkedList
    public LinkedList(){

    }
    
    //Methods

    //add method (adds to end)
    public boolean add(int value){

    }

    //returns the size of the Linked List
    public int size(){

    }

    //ToString method prints out the list
    public String toString(){

	System.out.println();
    }

    //--------------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------------

    //MAIN
    public static void main(String[]arrgs){
	
    }
}
