import java.util.*;
public class RunningMedian{

    //CURRENT BUGS: The add method does not place values properly into the top and bottom stacks, leading to errors in calculating the median
    
    //VARIABLES
    private int size;
    private double median;
    private MyHeapInt bottom, top;//bottom is maxeap, top is minheap
    
    //CONSTRUCTOR
    public RunningMedian(){
	bottom = new MyHeapInt(true);//max = true --> max heap
	top = new MyHeapInt(false);//max = false --> min heap
	size = 0;
	median = 0;
    }

    //METHODS
    //adds a new value to the heaps and places it on the bottom or top heap
    public void add(int newValue){
	if(size == 0){
	    bottom.add(newValue);
	    median = newValue;
	    size++;
	    return;
	}else{
	    if(newValue < median){
		bottom.add(newValue);
	    }else{
		top.add(newValue);
	    }
	    size++;
	}
	if(bottom.size < top.size + 1){
	    int temp = top.remove();
	    bottom.add(temp);
	}else if(top.size < bottom.size + 1){
	    int temp = bottom.remove();
	    top.add(temp);
	}
	getMedian();
    } 

    //calculates the median by taking the top of the bigger heap or averaging the top of both
    private void getMedian(){
	if(bottom.size == top.size){
	    median = (bottom.peek(1) + top.peek(1)) / 2;
	    		System.out.println("applecause");

	}else if(bottom.size > top.size){
	    median = bottom.peek(1);
	}else{
	    median = top.peek(1);
	}
    }

    //MAIN
    public static void main(String[]args){
	RunningMedian test1 = new RunningMedian();
	
	test1.add(1);
	test1.bottom.toString();
	test1.top.toString();
	System.out.println(test1.median);
	test1.add(2);
	test1.bottom.toString();
	test1.top.toString();
	System.out.println(test1.median);
	test1.add(3);
	test1.bottom.toString();
	test1.top.toString();
	System.out.println(test1.median);
	test1.add(4);
	test1.bottom.toString();
	test1.top.toString();
	System.out.println(test1.median);
	test1.add(5);
	test1.bottom.toString();
	test1.top.toString();
	System.out.println(test1.median);
    }
    //END MAIN
}
//END RUNNING MEDIAN
