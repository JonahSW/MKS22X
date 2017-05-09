import java.util.*;
public class MyLinkedList{

    //INNER CLASS LNODE---------------------------------------------------
    private class LNode{
	LNode next, prev;
	int value;

	//LNODE CONSTRUCTOR  
	public LNode(int val){
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
	
	//toString method for LNodes
	public String toString(){
	    return " " + value + " ";
	}
    }
    //END INNER CLASS-----------------------------------------------------

    //LINKED LIST
    LNode head,tail;
    int size;

    //CONSTRUCTOR
    public MyLinkedList(){
    }

    public int size(){
	return size;
    }

    

    private LNode getNthNode(int n){/*complete this*/}


  private void addAfter(LNode location, LNode toBeAdded){/*complete this*/  }


  private void remove(LNode target){/*complete this*/}


  public String toString(){ /*complete this*/  }

  public boolean add(int value){  /*complete this*/ }

  public int get(int index){/*complete this*/}


  public int set(int index, int value){/*complete this*/}

  public int indexOf(int value){/*complete this*/}

  public int remove(int index){/*complete this*/}

  public void add(int index,int value){/*complete this*/}


}
