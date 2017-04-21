import java.util.StringTokenizer;
import java.util.Stack;

public class Post{

    //returns true if a token is one of the four primary operations
    public static boolean isOperator(String str){
	return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")); 
    }

    //method for applying the four primary operations
    public static String applyOperation(String op, double rn, double ln){
	if(op.equals("+")){
	    return "" + (ln + rn);
	}

	if(op.equals("-")){
	    return "" + (ln - rn);
	}

	if(op.equals("*")){
	    return "" + (ln * rn);
	}

	if(op.equals("/")){
	    if(rn == 0.0){
		System.out.println("Divide by zero error. Unable to evaluate.");
		return "0";
	    }
	    
	    return "" + (ln / rn);
	}

	return "" + 0.0;
    }

    //method for evaluating a postfix string
    public static double eval(String str){
	StringTokenizer tok = new StringTokenizer(str, " ");
	Stack<String> stk = new Stack<String>();
	String current = "";
	
	while(tok.hasMoreTokens()){
	    current = tok.nextToken();
	    stk.push(current);
	    if(isOperator(current)){
		stk.push(applyOperation(stk.pop(), Double.parseDouble(stk.pop()), Double.parseDouble(stk.pop())));
	    }
	}

	double ans = Double.parseDouble(stk.pop());
	
	return ans;
    }

    //MAIN
    public static void main(String[]args){
	
	System.out.println(eval("1 2 +"));

	System.out.println(eval("3 4 *"));

	System.out.println(eval("1 2 / 8 -"));

	System.out.println(eval("8 4 /"));

	System.out.println(eval("1 2 + 7 - 8 9 + -"));

	System.out.println(eval("432 34 + 35 - 3453 + 3453 74 * 98 9 + / -"));

	System.out.println(eval("1 2 + 3 4 + 6 5 + 7 8 + 9 10 + + + + +"));

	System.out.println(eval("1 2 -"));

	System.out.println(eval("2 1 - "));

	System.out.println(eval("1 0 /"));

	System.out.println(eval("0 0 * 6 - 23  45 + 34 34 + + 83 0 +"));

	System.out.println(eval("24.35235 0.234234 +"));

	System.out.println("");

	System.out.println("0");

	System.out.println("Hello World!");

	System.out.println("0 0 0");

	System.out.println("0 +");
    }
}
