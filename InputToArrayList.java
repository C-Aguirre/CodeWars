import java.util.Scanner;
import java.util.ArrayList;

public class InputToArrayList {
	public static ArrayList getInput() { // declare new method, read, that is used to read all of the inputs
		ArrayList<String> lines = new ArrayList<String>();
		
		Scanner scan = new Scanner (System.in); // creates Scanner object
		
		try {
			String strCurrentLine = ""; // initialize current line string
			
			while (scan.hasNext())
			{
				strCurrentLine = scan.nextLine(); // set line string to nextLine
				lines.add(strCurrentLine); // add current line to our ArrayList
			}	
		} catch (Exception e){
	
			e.printStackTrace(); // pinpoint the exact line in which the method raised the exception.
			
		} finally { // clean up, after all this has been executed;
			
			scan.close(); // close the Scanner object
			
		}
		return lines;
	}
	public static void main (String[] args) {
		ArrayList<String> ourInput = getInput();
		
		for (String i: ourInput) {
			System.out.println(i);
		}
	}
}
