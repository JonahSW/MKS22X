import java.util.*;
import static java. lang. Math.*;
import java.util.Random;
public class Merge{

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

	    if(len < 1){
		return 0;
	    }

	    Random r = new Random();
	    int temp = 0;
	    int pivot = data[r.nextInt(last)];
	    //System.out.println("pivot = " + pivot);
	    
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

    //mergeSort Implementation
    public static void mergeSort(int[] ary){

	for(){

	}

    }

    public static void merge(int low, int mid, int high, int[] ary){
	int[] tempary = new int[];

	for (int i = low; i <= high; i++) {
            tempary[i] = ary[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
    
    //merges two sorted lists
    public static void merge(int[] a, int[] b, int[] res){
	int max = Math.max(a.length, b.length);
	int tracka = 0;
	int trackb = 0;
	int trackout = 0;

	while((tracka < a.length) && (trackb < b.length)){
	    if(a[tracka] > b[trackb]){
		ary[trackout] = a[tracka];
		tracka++;
		trackout++;
	    }

	    if(b[trackb] > a[tracka]){
		ary[trackout] = b[trackb];
		trackb++;
		trackout++;
	    }
	}

	for(int i = tracka; i < a.length; i++){
	    ary[trackout] = a[tracka];
	    trackout++;
	}

	for(int i = trackb; i < b.length; i++){
	    ary[trackout] = b[trackb];
	    trackout++;
	}
    }
    
    //MAIN
    public static void main(String[]args){
	int[] test1 = new int[]{0,2,4,6,8};
	int[] test2 = new int[]{1,3,5,7,9};
	int[] destination = new int[10];
	merge(test1, test2, destination);
	toString(destination);
	
	
    }
    //END MAIN
}
