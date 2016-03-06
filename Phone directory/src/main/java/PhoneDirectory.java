import java.io.*;
import java.util.*;

public class PhoneDirectory {
	String getInfo;      //to return getNumber(name)
	
	 /* @throws IOException if an input or output exception occurred
     * @param name  the name to be added in the directory
     * @param number the number to be added for that entry
     */	
	
	public void addEntry(String name, String number) throws IOException{
		
		Properties myProperty = new Properties();
		OutputStream output = new FileOutputStream("src/main/resources/phone.properties", true);
		
		myProperty.setProperty(name, number);
		
		myProperty.store(output, null);  //store value
		output.close();
}
	
	 /* @throws IOException if an input or output exception occurred
     * @param name     the name to be deleted from the directory
     */
	
	public void deleteEntry(String name) throws IOException{
		
		Properties myProperty = new Properties();
		
		InputStream input = new FileInputStream("src/main/resources/phone.properties");   //deleting
		myProperty.load(input);
		myProperty.remove(name);
		input.close();
		
		OutputStream output = new FileOutputStream("src/main/resources/phone.properties"); //after deletion
		myProperty.store(output, null);
		output.close();
		
	}
	
	 /* @throws IOException if an input or output exception occurred
     * @param name     the name whose number is queried from the directory
     */
	
//this lets you input a person's name and get their phone number
	public String getNumber(String name) throws IOException{
		
		Properties myProperty = new Properties();
		InputStream input = new FileInputStream("src/main/resources/phone.properties");
		myProperty.load(input);
		getInfo = myProperty.getProperty(name);
		input.close();
		
		System.out.println(getInfo);
		return getInfo;
		
	}
	
	/* @throws IOException if an input or output exception occurred
     * @param name     the name whose number needs to be changed from the directory
     * @param number   the new number
     */	
	
//this changes the phone number of people	
	public void changeEntry(String name, String number) throws IOException{
		
		Properties myProperty = new Properties();
		
		InputStream input = new FileInputStream("src/main/resources/phone.properties");
		myProperty.load(input);
		myProperty.replace(name, number);
		input.close();
		
		OutputStream output = new FileOutputStream("src/main/resources/phone.properties"); 
		myProperty.store(output, null);
		output.close();
	}

}