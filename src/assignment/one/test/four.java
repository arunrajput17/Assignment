package assignment.one.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class four {

	static WebDriver driver;
	static ResourceBundle readResourceBundle() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		return rb;
	}
	
	static String getValue(String key){
		ResourceBundle rb = readResourceBundle();
		String value = rb.getString(key);
	return  value;
	}	
	
	public static void clearText(String clearValue) {
		driver.findElement(By.id(clearValue)).click();
		driver.findElement(By.id(clearValue)).sendKeys(Keys.BACK_SPACE);
	}
	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(getValue("drivername"), getValue("driverpath"));
	    driver= new ChromeDriver();
		driver.get(getValue("url"));
		
		driver.findElement(By.id("TextBoxUserID")).sendKeys("manager");
	    driver.findElement(By.id("TextBoxPassword")).sendKeys("147369@");
	    driver.findElement(By.id("ButtonLogin")).click();
	    
//	    WebElement element =  driver.findElement(By.cssSelector("#Menu_mainMenu > li:nth-child(3) > a"));
//	    Action action = new Action(driver);
//	    action.moveToElement(element).perform();
	    
	    /*To access Old Main Menu*/
//	    WebElement element = driver.findElement(By.linkText("Administration"));
	    
	    /*To access New Main Menu*/
//	    WebElement element = driver.findElement(By.cssSelector("#mainMenu > li:nth-child(6) > a"));
	    WebElement element = driver.findElement(By.cssSelector("#mainMenu > li:nth-child(4) > a"));
	    Actions action = new Actions(driver);
	    action.moveToElement(element).build().perform();
	    
	    /*To open module from sub menu*/
	    driver.findElement(By.linkText("Ad Hoc Requisition Report")).click();
	    
	    driver.findElement(By.id("ddlSector")).click();
//	    driver.findElement(By.id("ddlSector")).getText();
	    Thread.sleep(3000);
	    String dd=driver.findElement(By.id("ddlSector_DropDown")).getText();
	    String x[]= dd.split("\n");
	    
	    String [] val= {"All","Ayushi","BDNET","Honeywell & (IN), inc.1"};
	    
	    List<String> val2= new ArrayList<String>();
	    val2= Arrays.asList(val);
	    
	    List<String> al = new ArrayList<String>();
	    al = Arrays.asList(x);
	    System.out.println("Actuall availble in dropdown are: " + al);
	    int alSize = al.size();
	    int valSize = val2.size();
	    if (alSize == valSize) {
	    	  for (String s: al) {
	    		  String chk = "";
//	  	    	System.out.println(s);
	  	    	for (String e:val) {
//	  	    		System.out.println(e);
	  	    		if (s.equalsIgnoreCase(e)) {
	  	    			System.out.println("Pass for "+e);
//	  	    			System.out.println(e);
	  	    			chk = e;
	  	    			continue;
	  	    		}
//	  	    		else
//	  	    		{
//	  	    			System.out.println("Fail");
//	  	    		}
	  	    	}
	  	    	if (chk.equalsIgnoreCase("") ) {
	  	    		System.out.println("Fail for "+ s);
	  	    	}
//	  	    	System.out.println("Fail");
	  	    }
	    } else 
	    {
	    	System.out.println("Fail");
	    }
	    
//	    System.out.println(al.size());
//	    System.out.println(al.get(0));
	    System.out.println("Finished");
	    
//	    System.out.println(dd);
	    
	    
	    
	    
	    
//	    Select dropdown= new Select(driver.findElement(By.id("ddlSector")));
//	    List<WebElement> alloptions = dropdown.getOptions();
//	    System.out.println(alloptions.size());
//	    System.out.println(alloptions);
	
	}

}


