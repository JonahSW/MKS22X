import java.util.*;

public class Quick{

    //implementation function for quicksort
    public static void quicksort(int[]ary){
	//calls to part()
    }

    public static int part(int[] data, int start, int end){

	int temp = 0;
	int pivot = data[start];
	int track = start;

	//tracks through the array, moving the data at the start index to the kth location in the array
	while(start < end){
	    
	    if(data[start] <= pivot){
		temp = data[start];
		data[start] = pivot;
		data[track] = temp;

		track = start;
		start++;
	    }
	}

	return pivot;
    }

    //toString method for printlng out an int array;
    public static void toString(int[] ary){
	String str = "{";
	for(int i = 0; i < ary.length - 1; i++){
	    str = str + ary[i] + ", ";
	}
	str = str + ary[ary.length - 1] + "}";
	System.out.println(str);
    }

    /*
    
    */

    //MAIN
    public static void main(String[]args){
	int[] test1 = new int[]{8,5,6,4,1,2,9,3};

	toString(test1);
	System.out.println(part(test1, 0, 7));
	toString(test1);

    }
    //END MAIN
}
