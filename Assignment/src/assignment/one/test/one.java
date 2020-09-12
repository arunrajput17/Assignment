package assignment.one.test;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class one {
	
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
		
		driver.findElement(By.id("TextBoxUserID")).sendKeys("joexrm");
	    driver.findElement(By.id("TextBoxPassword")).sendKeys("1qaz!QAZ");
	    driver.findElement(By.id("ButtonLogin")).click();
	    
//	    WebElement element =  driver.findElement(By.cssSelector("#Menu_mainMenu > li:nth-child(3) > a"));
//	    Action action = new Action(driver);
//	    action.moveToElement(element).perform();
	    
	    /*To access Old Main Menu*/
//	    WebElement element = driver.findElement(By.linkText("Administration"));
	    
	    /*To access New Main Menu*/
	    WebElement element = driver.findElement(By.cssSelector("#mainMenu > li:nth-child(6) > a"));
	    Actions action = new Actions(driver);
	    action.moveToElement(element).build().perform();
	    
	    /*To open module from sub menu*/
//	    driver.findElement(By.linkText("Create a Requisition")).click();
	    driver.findElement(By.linkText("T&E Entry by Admin")).click();
//	    driver.findElement(By.linkText("Online Survey Configuration")).click();
	    
	
		// Select values in Employee Type drop down
		driver.findElement(By.id("ddlEmpType")).click();
		driver.findElement(By.id("ddlEmpType")).sendKeys("Non Light Industrial)");
		driver.findElement(By.id("ddlEmpType")).sendKeys(Keys.ENTER);
		
		//Select values in Employee drop down 
		Thread.sleep(5000);
		driver.findElement(By.id("ddlEmployee")).click();
		driver.findElement(By.id("ddlEmployee")).sendKeys("Rahul, Sharma (27002)");
		driver.findElement(By.id("ddlEmployee")).sendKeys(Keys.ENTER);
		
		//Select values in Weekending Date drop down 
		Thread.sleep(5000);
		driver.findElement(By.id("ddlWeekendDate")).click();
		driver.findElement(By.id("ddlWeekendDate")).sendKeys("09/26/2019");
		driver.findElement(By.id("ddlWeekendDate")).sendKeys(Keys.ENTER);
		    
		Thread.sleep(5000);
		driver.findElement(By.id("btnProceed")).click();
		
		driver.findElement(By.id("tdBillableTime")).click();
		
		Thread.sleep(3000);
		
		
		/*Friday*/
		clearText("grdTimeEntry_childGrid_0_txtFri_0");
		driver.findElement(By.id("grdTimeEntry_childGrid_0_txtFri_0")).sendKeys("2.00");
		
		/*Saturday*/
		clearText("grdTimeEntry_childGrid_0_txtSat_0");
		driver.findElement(By.id("grdTimeEntry_childGrid_0_txtSat_0")).sendKeys("12.00");
		
		/*Sunday*/
		clearText("grdTimeEntry_childGrid_0_txtSun_0");
		driver.findElement(By.id("grdTimeEntry_childGrid_0_txtSun_0")).sendKeys("14.00");
		
		/*Monday*/
		clearText("grdTimeEntry_childGrid_0_txtMon_0");
		driver.findElement(By.id("grdTimeEntry_childGrid_0_txtMon_0")).sendKeys("15.00");
		
		/*Tuesday*/
		clearText("grdTimeEntry_childGrid_0_txtTue_0");
		driver.findElement(By.id("grdTimeEntry_childGrid_0_txtTue_0")).sendKeys("16.00");
		
		/*Wednesday*/
		clearText("grdTimeEntry_childGrid_0_txtWed_0");
		driver.findElement(By.id("grdTimeEntry_childGrid_0_txtWed_0")).sendKeys("17.00");
		
		/*Thursday*/
		clearText("grdTimeEntry_childGrid_0_txtThu_0");
		driver.findElement(By.id("grdTimeEntry_childGrid_0_txtThu_0")).sendKeys("18.00");
		
		WebElement StTotal =driver.findElement(By.id("grdTimeEntry_childGrid_0_lblTotalSTH"));	    
	    String StTotalText = StTotal.getText().trim();
	    System.out.print(StTotalText);
	    
		WebElement OtTotal =driver.findElement(By.id("grdTimeEntry_childGrid_0_lblTotalSTH"));	    
	    String OtTotalText = OtTotal.getText().trim();
	    System.out.print(OtTotalText);
	    
		WebElement DtTotal =driver.findElement(By.id("grdTimeEntry_childGrid_0_lblTotalSTH"));	    
	    String DtTotalText = DtTotal.getText().trim();
	    System.out.print(DtTotalText);
	    
		
		driver.findElement(By.id("btnSaveAsDraft")).click();
	
		
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(5000);
		
		if(alertMessage.equalsIgnoreCase("You cannot enter more than 24 hours in a day.")) {
	    	System.out.print("Pass");
	    	alert.accept();
	    }
	    else {
	    	System.out.print("Fail");
	    }
		
		
		
		System.out.println("Done till here");
	
	    
//	    Select drpCLP = new Select(driver.findElement(By.id("ddlEmpType")));
//	    Thread.sleep(3000);
//	    drpCLP.selectByValue("Light Industrial");
////	    drpCLP.findElement(By.cssSelector("#ddlEmpType_DropDown > div > ul > li:nth-child(2)")).click();
//	    drpCLP.selectByVisibleText("Light Industrial");
	    
	    
	    

//	    /*To fetch the label name on screen*/
////	    WebElement Label1 =driver.findElement(By.cssSelector("#frmOnlineSurvey > table:nth-child(23) > tbody > tr > td > table > tbody > tr:nth-child(12) > td.newformlabel"));
//	    WebElement Label1 =driver.findElement(By.cssSelector("#frmOnlineSurvey > table:nth-child(23) > tbody > tr > td > table > tbody > tr:nth-child(5) > td.newformlabel"));
//
//	    System.out.print(Label1.getText());
//	    
//	    String LblText = Label1.getText().trim();
//	    /*To verify that the label name on screen is correct*/
//	    if(LblText.equalsIgnoreCase("After End of Assignment")) {
//	    	System.out.print("Pass");
//	    }
//	    else {
//	    	System.out.print("Fail");
//	    }
//	    
	    

//	    driver.findElement(By.linkText("Configuring the online survey")).click();
	    
//	   List<WebElement> elements =  driver.findElements(By.className("newtabletext"));
//	  System.out.println(elements.size());
	

	}

}
