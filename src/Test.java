import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
	
	public static int subsequence(String testWord, String actualWord) {
		
		String tWord = testWord;
		String aWord = actualWord;			
		boolean noMatch = true;
		int index = 0;
		int counter1= 0;
		int counter = 0;
		
		for(int i = 0; i < aWord.length(); i++) {			
			char charOne = aWord.charAt(i);
			for(int j = index; j < tWord.length(); j++) {
				char charTwo = tWord.charAt(j);
				counter1++;
				if(charOne == charTwo) {
					index = counter1;
					counter++;
					noMatch = false;
					break;
				} else {
					noMatch = true;
				}
			}
			if(noMatch) {
				break;
			}
		}
	return aWord.length() - counter;
	}
	
	public static void main(String[] args) throws IOException, ParseException {	
		
		String testWord = "michael";
		String actualWord = "michael";
		
		System.out.println(subsequence(testWord, actualWord));
			
	}
}

