import java.util. *;

public class Quiz2Redux{

    //Given a String, return an  ArrayList<String> that contains all of the subsets of the characters in the String

    /*
    public char[] arry;
    public int length;
    public ArrayList<String> powerSet;

    //Constructor
    public Quiz2Redux(String string){
	arry = string.toCharArray();
	length = string.length();
	this.powerSet = new ArrayList<String>();
    }

    //Methods
    public void powerset(){
	powerHelp(0, "");
    }

    //helper method for powerset 
    public void powerHelp(int index, String subset){

	if(index == length - 1){
	    powerSet.add(subset);
	    subset = subset +  arry[index];
	    powerSet.add(subset);
	    return;
	}

	//System.out.println("fsfsdf");
	powerSet.add(subset);
	    
	//recursive calls
	powerHelp(index + 1, (subset + arry[index]));
	powerHelp(index + 1, subset);

    }
    */

    //Actual Method
    public static ArrayList<String> combinations(String str){
	ArrayList<String>words = new ArrayList<String>();
	help(words, str, 0, "");
	Collections.sort(words);
	return words;
    }
  
    private static void help(ArrayList<String> words2, String str2, int index, String subset){

	//troubleshooting
	//System.out.println("current index = " + index + " : " + subset);
	if(str2 == ""){
	    words2.add(subset);
	    return;
	}
	
	//if(index == str2.length() - 1){
	if (index == str2.length()){  
	    words2.add(subset);
	    
	    return;
	}

	//adds the subset to the arraylist
		    
	//recursive calls
	help(words2, str2, index + 1, (subset + str2.charAt(index)));
	help(words2, str2, index + 1, subset);

    }
    
    //MAIN
    public static void main(String[]args){
	System.out.println(combinations("").toString());

	System.out.println(combinations("a").toString());

	System.out.println(combinations("ab").toString());

	System.out.println(combinations("abc").toString());

	System.out.println(combinations("abcd").toString());

	System.out.println(combinations("abcde").toString());

	System.out.println(combinations("abcde!").toString());

	//System.out.println(combinations("abcde9283qr8 ").toString());

	//System.out.println(combinations("applesaucees!!??e").toString());

	//System.out.println(combinations("This is a TEST").toString());
	
	/*
	Quiz2Redux test1 = new Quiz2Redux("");
	test1.powerset();
	System.out.println(test1.powerSet);
	
	Quiz2Redux test2 = new Quiz2Redux("a");
	test2.powerset();
	System.out.println(test2.powerSet);

	Quiz2Redux test3 = new Quiz2Redux("ab");
	test3.powerset();
	System.out.println(test3.powerSet);

	Quiz2Redux test4 = new Quiz2Redux("abc");
	test4.powerset();
	System.out.println(test4.powerSet);

	Quiz2Redux test5 = new Quiz2Redux("abcd");
	test5.powerset();
	System.out.println(test5.powerSet);

	Quiz2Redux test6 = new Quiz2Redux("mufin");
	test6.powerset();
	System.out.println(test6.powerSet);

	Quiz2Redux test7 = new Quiz2Redux("abczegy");
	test7.powerset();
	System.out.println(test7.powerSet);

	Quiz2Redux test8 = new Quiz2Redux("abcdefghi");
	test8.powerset();
	System.out.println(test8.powerSet);

	Quiz2Redux test9 = new Quiz2Redux("applesauce");
	test9.powerset();
	System.out.println(test9.powerSet);

	Quiz2Redux test10 = new Quiz2Redux("%^@QE");
	test10.powerset();
	System.out.println(test10.powerSet);

	Quiz2Redux test11 = new Quiz2Redux("7572rwe");
	test11.powerset();
	System.out.println(test11.powerSet);
	*/
    }
}
