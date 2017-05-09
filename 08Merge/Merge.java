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
  
    //mergeSort Implementation
    public static int[] mergeSort(int[] ary){

	if(ary.length < 2){
	    return ary;
	}

	int[] aryfront = Arrays.copyOfRange(ary, 0, ary.length / 2);
	int[] aryback = Arrays.copyOfRange(ary, ary.length / 2, ary.length);

	return mergeHelp(aryfront, aryback);
    }

    //helper function for mergeSort
    public static int[] mergeHelp(int[] ary1, int[]ary2){

	int[] ary1front = Arrays.copyOfRange(ary1, 0, ary1.length / 2);
	int[] ary1back = Arrays.copyOfRange(ary1, ary1.length / 2, ary1.length);
	int[] ary2front = Arrays.copyOfRange(ary2, 0, ary2.length / 2);
	int[] ary2back = Arrays.copyOfRange(ary2, ary2.length / 2, ary2.length);

	return merge(mergeHelpHelp(ary1, ary1front, ary1back), mergeHelpHelp(ary2, ary2front, ary2back));
    }

    //Helper function for mergeHelp, returns either the base case or the next round of recursion
    public static int[] mergeHelpHelp(int[] ary, int[] ary1f, int[]ary1b){
	if(ary.length == 1){
	    return ary;	 
	}else{
	    return mergeHelp(ary1f, ary1b);
	}
    }
    
    //merges two sorted lists arrays
    public static int[] merge(int[] a, int[] b){
	int max = Math.max(a.length, b.length);
	int tracka = 0;
	int trackb = 0;
	int trackout = 0;
	int[]ary = new int[(a.length + b.length)];

	while((tracka < a.length) && (trackb < b.length)){
	    if(a[tracka] < b[trackb]){
		ary[trackout] = a[tracka];
		tracka++;
		trackout++;
	    }else if(b[trackb] < a[tracka]){
		ary[trackout] = b[trackb];
		trackb++;
		trackout++;
	    }else{
		ary[trackout] = a[tracka];
		trackout++;
		tracka++;
		ary[trackout] = b[trackb];
		trackout++;
		trackb++;
	    }
	}
	
	if(0 == (b.length - trackb)){
	    for(int i = tracka; i < a.length; i++){
		ary[trackout] = a[i];
		trackout++;
	    }
	}else if(0 == (a.length - tracka)){
	    for(int i = trackb; i < b.length; i++){
		ary[trackout] = b[i];
		trackout++;
	    }
	}
	return ary;
    }
    
    //MAIN
    public static void main(String[]args){

    }
    //END MAIN
}
