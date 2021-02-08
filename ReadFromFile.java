import java.io.*;

public class ReadFromFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader objReader = null; // initialize the object reader
		try {
			String strCurrentLine = ""; // initialize current line string
			
			objReader = new BufferedReader(new FileReader("")); // insert your path (CODEWARS = input.txt)
			
			while ((strCurrentLine = objReader.readLine()) != null){ // set strCurrentLine to the next line; while line read is not equal to null
				System.out.println(strCurrentLine); // print out the current line 
				
				// code code code
			}
		
		} catch (IOException e){
			e.printStackTrace(); // pinpoint the exact line in which the method raised the exception.
		} finally { // clean up
			try {
				if (objReader != null) { // if there are still lines to be read, 
					objReader.close(); // close the object Reader
				}
			} catch (IOException ex) {
				ex.printStackTrace(); // pinpoint the exact line in which the method raised the exception
			}
			
		}
	}

}
