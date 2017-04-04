import java.util.*;

public class Merge{

    //Quickselect partition method to work with dutch flag
    //from in class pseudocode
    public static void quickselect(int[]ary, int target, int l, int g){
	//int l;//LT
	//int g;//GT
	int i = 0;
	int temp;
	
	while(l <= g){
	    if(ary[i] == target){
		l++;
	    }else if(ary[i] < target){
		//swap(ary, i, l);
		temp = ary[i];
		ary[i] = ary[l];
		ary[l] = temp;
		l++;
		i++;
	    }else{
		//swap(ary, i, g);
		temp = ary[i];
		ary[i] = ary[g];
		ary[g] = temp;
		g--;
	    }
	}

	//return
    }

    //two section quickselect
    //from in class pseudocode
    public static int partition(int[] ary, int target, int i, int j){
	//int i = 0;
	//int j = 0;
	int temp = 0;

	while(i <= j){
	    if(ary[i] < target){
		i++;
	    }else if(ary[i] >= target){
		    //swap(ary, i, j);
		    temp = ary[i];
		    ary[i] = ary[j];
		    ary[j] = temp;
		    j--;
		}
	}
	//swap(ary, 0, j);
	temp = ary[0];
	ary[0] = ary[j];
	ary[j] = temp;

	return i;
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
    
    //merge sort implementation function
    public static void merge(int[][] arry){

    }

    //MAIN
    public static void main(String[]args){
	int[] test1 = new int[]{8,5,6,4,1,2,9,3};

	//testing 2 section quickselect
	toString(test1);
	partition(test1, 4, 0, 8);
	toString(test1);
	
    }
    //END MAIN
}
