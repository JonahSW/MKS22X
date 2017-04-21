import java.util.*;
import static java. lang. Math.*;
import java.util.Random;

public class Quick{

    //method for delaying printout to terminal
    private static void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    //toString method for printlng out an int array;
    public static void toString(int[] ary){
	String str = "{";
	for(int i = 0; i < ary.length - 1; i++){
	    str = str + ary[i] + ", ";
	}
	if(ary.length < 1){
	    System.out.println("{}");
	}else{
	    str = str + ary[ary.length - 1] + "}";
	    System.out.println(str);
	}
    }

    //implementation function for quicksort
    public static void quicksort(int[] data){
	quickHelp(data, 0, data.length - 1);
    }

    //helper function for quicksort;
    public static void quickHelp(int[] ary, int left, int right){
	if(ary.length <= 1){
	    return;
	}

	if(right - left < 2){
	    return;
	}

	int pivot = part(ary, left, right);

	quickHelp(ary, pivot, right);
	
	quickHelp(ary, left, pivot);
    }
    
    //return the value that is the kth smallest value of the array. 
    //use your partition method to help you accomplish this.
    //if a partition returns k, then the kth smallest element is at index k + 1
    //In case of an error, returns 0;
    //TESTED
    public static int quickSelect(int []data, int k){
	
	int len = data.length;
	int track = part(data, 0, len - 1);
	int tracklow = 0;
	int trackhigh = len - 1;
	int counter = 0;
	
	//handles bad inputs
	if((k > len) || (k < 1)){
	    System.out.println("No such element");
	    return 0;
	}
	if(track == -1){
	    System.out.println("Illegal Index Error");
	    return 0;
	}

	if(k == len){
	    int max = data[0];
	    int mark = 0;
	    int temp = 0;
	    for(int i = 1; i < len; i++){
		if(data[i] > max){
		    max = data[i];
		    mark = i;
		}
	    }
	    temp = data[len - 1];
	    data[len - 1] = max;
	    data[mark] = temp;
	    return max;
	}

	while(track != k - 1){ //7th smallest element is in index 6
	    //wait(100);
	    counter++;
	    
	    if(track < k - 1){
		//System.out.println("poof");
		tracklow = track;
		track = part(data, track, trackhigh);
	    }
	    else{
		//System.out.println("puff");
		trackhigh = track;
		track = part(data, tracklow, track);
	    }

	    if(counter > ((len * Math.log(len)) + 1)){
		return data[track];
	    }
	    
	}

	return data[track];
    }

    //Partition method
    //TESTED
    //if all elements are the same, pivots at last index
    public static int part(int[] data, int first, int last){
	try {
	    int len = data.length;

	    Random r = new Random();
	    int temp = 0;
	    int pivot = data[(last + first) / 2];
	    ///*
	    wait(150);
	    System.out.println("first = " + first + "  last = " + last);
	    System.out.println("pivot index = " + ((last + first) / 2));
	    System.out.println("pivot value = " + pivot);
	    ///*
	    while(first <= last){
		for(int f = first; data[f] < pivot; f++){
		    first++;
		}
		for(int l = last; data[l] > pivot; l--){
		    last--;
		}
		if (first < last)
		    {
			temp = data[first];
			data[first] = data[last];
			data[last] = temp;
		    }
		if(data[first] == data[last]){
		    first++;
		}
	    }
	} catch(IndexOutOfBoundsException e) {
	    System.out.println("Illegal Index");
	    return -1;
	}
	return last;
    }

    //dutch flag partition
    public static int partition(int[] data, int lt, int gt){

	int i = lt;

	try {
	    int v = data[(gt + lt) / 2];
	    int temp = 0;

	    if(gt < lt){
		System.out.println("Illegal Index Error");
		return -1;
	    }
	
	    while(i <= gt){
		if(data[i] == v){
		    i++;
		}else if(data[i] < v){
		    temp = data[i];
		    data[i] = data[lt];
		    data[lt] = temp;
		    lt++;
		    i++;
		}else{
		    temp = data[i];
		    data[i] = data[gt];
		    data[gt] = temp;
		    gt--;
		}
	    }
	} catch(IndexOutOfBoundsException e) {
	    System.out.println("Illegal Index Error");
	    return -1;
	}

	return i;
    }

    //MAIN
    public static void main(String[]args){

	///*
	int[] test3 = new int[]{4,5,6,3,2,8,1,0,9,7};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{12,0,3,-5,5,4,-1,15,1,-4,11,10,2,14,9,-2,8,6,-3,7,13};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{4};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{4423,4,324,2303,234,23,-4,465,57,65,8,768,78,75463,5,235436,456,-54,666,546,3405,506,56,7,54765,55,-6,3,2,-82,1,0,9,79};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{-4,44,444,-4444,44444,444444,-4444444,44444444,5,55,555,5555,55555,-555555,55555555,-555555555};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{0,1,2,3,4,5,6,7,8,9};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{9,8,7,6,5,4,3,2,1,0};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	//test3 = new int[]{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	//*/
	
	/*
	int[] test1 = new int[]{4,6,7,5,2,3,1,9,0,8};
	toString(test1);
	System.out.println("7th element: " + quickSelect(test1, 7));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{9,2,1,0,3,7,5,6,4,8};
	toString(test1);
	System.out.println("5th element: " + quickSelect(test1, 5));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{2,6,7,57,3324,-6,34242,-463,10,4,3,1,9,0,8};
	toString(test1);
	System.out.println("9th element: " + quickSelect(test1, 9));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{2,6,78};
	toString(test1);
	System.out.println("7th element: " + quickSelect(test1, 7));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{2,6,78};
	toString(test1);
	System.out.println("0th element: " + quickSelect(test1, 0));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{5,2,6,8,9};
	toString(test1);
	System.out.println("4th element: " + quickSelect(test1, 4));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{5,2,6,8,9};
	toString(test1);
	System.out.println("5th element: " + quickSelect(test1, 5));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{5,-3,2,25,6,3,7,-5,0};
	toString(test1);
	System.out.println("1th element: " + quickSelect(test1, 1));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{12,15,90,-3,2,5,6,3,7,-5,0};
	toString(test1);
	System.out.println("8th element: " + quickSelect(test1, 8));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{};
	toString(test1);
	System.out.println("1th element: " + quickSelect(test1, 1));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{2,1,2};
	toString(test1);
	System.out.println("2th element: " + quickSelect(test1, 2));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
	toString(test1);
	System.out.println("7th element: " + quickSelect(test1, 7));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{6,3,2,5,3,2,5,2,4,2,-435,3,8678,6,0,-676,8,7,56,876,6,-3,7,6,3,3,-3,8,77,678,5,8,57,58,5};
	toString(test1);
	System.out.println("17th element: " + quickSelect(test1, 17));
	toString(test1);
	System.out.println("________________________________________________");
	System.out.println("________________________________________________");
	System.out.println("________________________________________________");
	int[] test2 = new int[1000];
	Random r = new Random();

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	System.out.println("1000th element: " + quickSelect(test2, 1000));
	System.out.println("________________________________________________");
	test2 = new int[100000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	System.out.println("73529th element: " + quickSelect(test2, 73529));
	System.out.println("________________________________________________");
	test2 = new int[100000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	System.out.println("73634th element: " + quickSelect(test2, 73634));
	System.out.println("________________________________________________");
	test2 = new int[100000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	System.out.println("92th element: " + quickSelect(test2, 92));
	System.out.println("________________________________________________");
	test2 = new int[100000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	System.out.println("8935th element: " + quickSelect(test2, 8935));
	System.out.println("________________________________________________");	
	test2 = new int[500000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	System.out.println("273539th element: " + quickSelect(test2, 273539));
	System.out.println("________________________________________________");
	//*/

	//-------------------------------------------------------------------------
	
	/*
	int[] test1 = new int[]{7,8,5,6,4,1,2,9,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 3, 8));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,1,2,9,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 8));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 2));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 5));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{0,1,0,1,0,1,1,0,0,0};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 9));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{0,92,-3,6,43,-43,27,7,8,5,6,4,1,2,9,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 15));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 5));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 0));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 0));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 3, 3));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 3, 243));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 3, 20));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
	toString(test1);
	System.out.println("pivot location: " + part(test1, 0, 3));
	toString(test1);

	System.out.println("________________________________________________");
	System.out.println("________________________________________________");
	System.out.println("________________________________________________");
	int[] test2 = new int[1000];
	Random r = new Random();

	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + part(test2, 0, 999));
	System.out.println("________________________________________________");

	test2 = new int[100000];
	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + part(test2, 0, 99999));
	System.out.println("________________________________________________");

	test2 = new int[1000000];
	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + part(test2, 0, 999999));
	System.out.println("________________________________________________");

	test2 = new int[10000000];
	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + part(test2, 4353955, 9072904));
	System.out.println("________________________________________________");
	//*/

	//---------------------------------------------------------------------------

	/*
	int[] test1 = new int[]{7,8,5,6,4,1,2,9,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 8));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,1,2,9,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 5));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 2));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 5));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{0,1,0,1,0,1,1,0,0,0};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 9));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{0,1,0,1,0,1,1,0,0,0};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 2, 6));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{0,92,-3,6,43,-43,27,7,8,5,6,4,1,2,9,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 12));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{0,92,-3,6,43,-43,27,7,8,5,6,4,1,2,9,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 4, 9));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 1, 4));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 0));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 0));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 3, 3));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{7,8,5,6,4,3};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 243));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 3, 20));
	toString(test1);
	System.out.println("________________________________________________");
	test1 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
	toString(test1);
	System.out.println("pivot location: " + partition(test1, 0, 6));
	toString(test1);

	System.out.println("________________________________________________");
	System.out.println("________________________________________________");
	System.out.println("________________________________________________");
	int[] test2 = new int[1000];
	Random r = new Random();
	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + partition(test2, 0, 999));
	System.out.println("________________________________________________");
	test2 = new int[100000];
	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + partition(test2, 0, 99949));
	System.out.println("________________________________________________");
	test2 = new int[1000000];
	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + partition(test2, 0, 996699));
	System.out.println("________________________________________________");
	test2 = new int[10000000];
	for(int i = 0; i < test2.length; i++){
	    test2[i] = r.nextInt();
	}
	System.out.println("pivot location: " + partition(test2, 23424, 9072904));
	System.out.println("________________________________________________");
	//*/
    }
    //END MAIN
}
