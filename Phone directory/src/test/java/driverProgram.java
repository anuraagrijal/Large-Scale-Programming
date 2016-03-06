import java.io.IOException;

public class driverProgram {
	public static void main(String[] args) throws IOException{
		PhoneDirectory directoryObject = new PhoneDirectory();
		directoryObject.addEntry("Sam", "99842044677"); //adding to phone.properties
		directoryObject.getNumber("Sam");      //adding to directory
		directoryObject.changeEntry("Sam", "12345");  //change
	}
}
