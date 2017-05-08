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

	quickHelp(ary, pivot + 1, right);
	
	quickHelp(ary, left, pivot - 1);
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
	    /*
	    wait(150);
	    System.out.println("first = " + first + "  last = " + last);
	    System.out.println("pivot index = " + ((last + first) / 2));
	    System.out.println("pivot value = " + pivot);
	    //*/

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
	}catch(IndexOutOfBoundsException e) {
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
	test3 = new int[]{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,345,34,53,5,35,3,53,5,57,57,76,76,7,85,6,45,3,3,46,567,9,9,0,99,6,7,5,3,4,46,776,6,6,3,4-345,35,3,53,5,2,45,63,464,35,35,346,45745,-45745,5474,7,47,7,7,8,9,-546,9,80,7,-98,-342,324,1};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	test3 = new int[]{34,3,53,45,-435,3,53,46,45,634,545,7,56,4,5,36,435,5,-435,-435,5,-8765,8,87,7,-7,-8765,8765,54,678,6,754,67,87,654,32,45,6789,8,765,4,567,87,654,654,654,647,654,647,8,67543};
	toString(test3);
	quicksort(test3);
	toString(test3);
	System.out.println("________________________________________________");
	//*/

	int[] test2 = new int[1000];
	Random r = new Random();

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	quicksort(test2);
	System.out.println("________________________________________________");
	test2 = new int[100000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	quicksort(test2);
	System.out.println("________________________________________________");
	test2 = new int[100000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	quicksort(test2);
	System.out.println("________________________________________________");
	test2 = new int[100000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	quicksort(test2);
	System.out.println("________________________________________________");
	test2 = new int[10000000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	quicksort(test2);
	System.out.println("________________________________________________");	
	test2 = new int[500000];

	for (int i = 0; i < test2.length; i++) {
	    test2[i] = r.nextInt();
	}
	quicksort(test2);
	System.out.println("________________________________________________");
    }
    //END MAIN
}
