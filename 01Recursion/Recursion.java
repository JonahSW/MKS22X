import static java.lang.Math.*;

public class Recursion{ 
    //Returns name for grading purposes
    public static String name(){
	return "SachsWetstone,Jonah";
    }

    //returns true if the percentage difference between
    //two values is less than nine decimal places
    public static boolean closeEnough(double a, double b){
	if((max(a, b) / min(a, b)) < 1.000000001){
	    return true;
	}
	
	return false;
    }

    //the recursive call of the square root function
    private static double recursqrt(double n, double guess){
	if(closeEnough(guess * guess, n)){
	    return guess;
	}
	
	return recursqrt(n, ((n / guess) + guess) / 2);
    }

    //Checks if the number is greater thatn zero, then
    //calls the recursive  method
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}

	if(n == 0){
	    return 0;
	}

	return recursqrt(n, n / 2);
    }

    //MAIN
    public static void main(String[]args){

	/*
	System.out.println(closeEnough(1.000000001, 1.000000000001));
	System.out.println(closeEnough(1345, 123523));
	System.out.println(closeEnough(1.345, 1.345));
	System.out.println(closeEnough(0.0001, 0.0001));
	*/
	///*
	System.out.println(sqrt(100));
	System.out.println(sqrt(4));
	System.out.println(sqrt(64));
	System.out.println(sqrt(1));
        System.out.println(sqrt(0));
	System.out.println(sqrt(256));
	System.out.println(sqrt(-2));
	//*/
    }//Closes Main


}
