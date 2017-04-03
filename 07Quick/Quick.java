import java.util.*;

public class Quick{

    //implementation function for quicksort
    public static void quicksort(int[]ary){
	//calls to part()
    }

    public static int part(int[] data, int start, int end){
	int len = (end - start);
	int pivot = data[len / 2];
	int temp;
	
	for(int i = 0; i < len; i++){
	    if(data[i] < pivot){
		temp = data[i];
		data[i] = data[0];
		data[0] = temp;
	    }
	    if(data[i] > pivot){
		temp = data[i];
		data[i] = data[len - 1];
		data[len - 1] = temp;
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
	System.out.println(part(test1, 0, 8));
	toString(test1);

    }
    //END MAIN
}
