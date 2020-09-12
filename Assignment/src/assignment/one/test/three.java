package assignment.one.test;

import java.io.IOException;
//import java.sql.SQLException;
import java.util.ArrayList;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.brainmentors.dao.UserDAO;
import assignment.dto.AssignmentDTO;
import assignment.utils.ExcelReader;
import assignment.utils.ExcelWriter;

public class three {
//	private static Logger logger = Logger.getLogger(LoginTest.class);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		WebDriver driver = new ChromeDriver();
		//driver.findElement(By.id("")).sendKeys(String.valueOf(9999.20));
//		 Excel Reader Code
		try {
			int sheetNumber = 0;
			ArrayList<AssignmentDTO> users = ExcelReader.readXLS(sheetNumber);
			System.out.println("Users are "+users);  // users.toString()
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		ExcelWriter.writeXLS(0,1,1, "done");
		
//		String value="tttttttttt";
//		ExcelWriter objexl= new ExcelWriter();
//		objexl.writeXLS(0,1,1,value);
		
		// DB Reader Code
//		logger.debug("Inside LoginTest");
//		UserDAO userDAO = new UserDAO();
//		try {
//			ArrayList<User> users = userDAO.getUsers();
//			System.out.println("Users are "+users);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			logger.error(e);
//			e.printStackTrace();
//		} catch (SQLException e) {
//			logger.error(e);
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		logger.debug("Exit LoginTest");

	}

}

