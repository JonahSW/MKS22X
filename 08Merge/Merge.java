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
  
    //mergeSort Implementation
    public static void mergeSort(int[] ary){
	
    }

    public static void mergeHelp(int[] ary1, int[]ary2){
	if((ary1.length == 1) && (ary2.length == 1)){
	    merge(ary1, ary2);
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
		//System.out.println("poof" + a[tracka]);
		tracka++;
		trackout++;
	    }else if(b[trackb] < a[tracka]){
		ary[trackout] = b[trackb];
		//System.out.println("puff" + b[trackb]);
		trackb++;
		trackout++;
	    }else{
		//System.out.println("piff" + a[tracka] + b[trackb]);
		ary[trackout] = a[tracka];
		trackout++;
		tracka++;
		ary[trackout] = b[trackb];
		trackout++;
		trackb++;
	    }
	}

	//System.out.println(b.length + " " + trackb);
	//System.out.println(a.length + " " + tracka);
	
	if(0 == (b.length - trackb)){
	    for(int i = tracka; i < a.length; i++){
		ary[trackout] = a[i];
		trackout++;
		//System.out.println("pooffer" + a[tracka] + ary[trackout]);//
	    }
	}else if(0 == (a.length - tracka)){
	    for(int i = trackb; i < b.length; i++){
		ary[trackout] = b[i];
		trackout++;
		//System.out.println("puffer" + b[trackb] + ary[trackout]);//
	    }
	}
	return ary;
    }
    
    //MAIN
    public static void main(String[]args){
	int[] test1 = new int[]{0,2,4};
	int[] test2 = new int[]{1,3,5};

	//System.out.println(Arrays.toString(test1));
	//System.out.println(Arrays.toString(test2));

	System.out.println(Arrays.toString(merge(test1, test2)));

	///*
	test1 = new int[]{0,2,4,6,8};
	test2 = new int[]{1,3,5,7,9};
	System.out.println(Arrays.toString(merge(test1, test2)));

	test1 = new int[]{-2,-1,1,2,3,4,4,4,6,7,9,10};
	test2 = new int[]{1,2,12,111,119};
	System.out.println(Arrays.toString(merge(test1, test2)));

	test1 = new int[]{-4,-2,0,10,60,82};
	test2 = new int[]{0,1,3,9};
	System.out.println(Arrays.toString(merge(test1, test2)));
	
	test1 = new int[]{8};
	test2 = new int[]{9};
	System.out.println(Arrays.toString(merge(test1, test2)));

	test1 = new int[]{8};
	test2 = new int[]{-3,1,5,7,9};
	System.out.println(Arrays.toString(merge(test1, test2)));

	test1 = new int[]{-234,-23,-2,1,3,4,4,5,7,7,8,9,10};
	test2 = new int[]{-1,3,5,7,9,23,42};
	System.out.println(Arrays.toString(merge(test1, test2)));
	//*/
	
    }
    //END MAIN
}
