import java.io.*;
import java.util.Scanner;

public class ReadFromScanner {
	
	public static void read() { // declare new method, read, that is used to read all of the inputs
		
		Scanner scan = new Scanner (System.in); // creates Scanner object
		
		try {
			String strCurrentLine = ""; // initialize current line string
			
			while (scan.hasNext())
			{
				strCurrentLine = scan.nextLine(); // set line string to nextLine
				System.out.println(strCurrentLine); // print out the current line
				
				// code code code
			}	
		} catch (Exception e){
	
			e.printStackTrace(); // pinpoint the exact line in which the method raised the exception.
			
		} finally { // clean up, after all this has been executed;
			
			scan.close(); // close the Scanner object
		
		}
	}
	public static void main(String[] args) {
		read();
	}

}
