package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class DataBase {

	public static void main(String[] args) throws IOException {
	
		try {
			Properties prop = new Properties();
			OutputStream output = new FileOutputStream("baseName.properties");
			
			prop.setProperty("url", "jdbc:mysql://localhost:3306/booking");
			prop.setProperty("username", "root");
			prop.setProperty("password", "");
			prop.setProperty("email", "enter your email");
			prop.setProperty("emailpass", "email pass");
			prop.store(output,null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		InputStream is = new FileInputStream("baseName.properties");
		
		prop.load(is);
			
		prop.list(System.out);

	}

}

