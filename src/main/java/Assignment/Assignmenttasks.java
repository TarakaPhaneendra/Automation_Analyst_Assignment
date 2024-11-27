package Assignment;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.*;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Assignmenttasks {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		//Task 1
		//Navigate to the FitPeo Homepage
		driver.navigate().to("https://www.fitpeo.com/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Remote Patient Monitoring (RPM) - fitpeo.com";
		Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");




		// Task 2
		//Navigate to the Revenue Calculator page
		driver.navigate().to("https://fitpeo.com/revenue-calculator");
		String actualurl = driver.getCurrentUrl();

		String expectedurl = "https://fitpeo.com/revenue-calculator";
		Assert.assertEquals(actualurl, expectedurl, "Page title does not match!");





		//Task 3
		//Scroll Down to the slider action
		WebElement s = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19'])[3]"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(s).perform();







		//Task 4
		//Adjust the slider
		
		WebElement slider = driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']/input"));

		Actions action = new Actions(driver);
		action.clickAndHold(slider).moveByOffset(94, 0).release().perform();

		//Task 5
		//Validate slider value
		WebElement c =driver.findElement(By.id(":R57alklff9da:"));
		c.clear();
		
		c.click();

		//In this website robert class is working not the automation code such as clear and sendkeys
		for(int i=0;i<4;i++) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		}

		// Entering value 560 by using robert class because selenium and Javascript is not handling in it
		Robot robot = new Robot();

		// Simulate typing "Hello"
		robot.keyPress(KeyEvent.VK_5);
		robot.keyRelease(KeyEvent.VK_5);
		robot.keyPress(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_6);
		robot.keyPress(KeyEvent.VK_0);
		robot.keyRelease(KeyEvent.VK_0);

		WebElement textbox = driver.findElement(By.xpath("//*[@id=':R57alklff9da:']"));




		//Task 6
		//validating slider value
		String actualtextboxvalue = textbox.getAttribute("value");
		String expectedtextboxvalue = "560";
		Assert.assertEquals(actualtextboxvalue, expectedtextboxvalue, "Not correct slider value");



		//Task 7
		//Clicking CPT codes

		//Typing value as 620 in slider text
		WebElement c1 =driver.findElement(By.id(":R57alklff9da:"));
		c1.clear();
		
		c1.click();

		//In this website robert class is working not the automation code such as clear and sendkeys
		for(int i=0;i<4;i++) {
			Robot robot1 = new Robot();
			robot1.keyPress(KeyEvent.VK_BACK_SPACE);
			robot1.keyRelease(KeyEvent.VK_BACK_SPACE);
		}

		// Entering value 560 by using robert class because selenium and Javascript is not handling in it
		Robot robot1 = new Robot();

		// Simulate typing "Hello"
		robot1.keyPress(KeyEvent.VK_8);
		robot1.keyRelease(KeyEvent.VK_8);
		robot1.keyPress(KeyEvent.VK_2);
		robot1.keyRelease(KeyEvent.VK_2);
		robot1.keyPress(KeyEvent.VK_0);
		robot1.keyRelease(KeyEvent.VK_0);

		//check box names 
		String[] values = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};

		for(int i=0;i<values.length;i++) {

			List<WebElement> counttotalvalues = driver.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt']"));
			for(int j=1;i<counttotalvalues.size();j++) {
				WebElement value = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt'])["+j+"]"));
				Actions actions1 = new Actions(driver);
				actions1.scrollToElement(value).perform();
				

				if((value.getText()).equals(values[i])) {

					driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])["+j+"]")).click();
					break;

				}
			}

		}

		//Task 8
		//Validate Total Recurring Reimbursement
		WebElement TR = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]"));
		String ActualTR = TR.getText();
		String ExpectedTR = "$110700";
		Assert.assertEquals(ActualTR, ExpectedTR, "Not a Total Recurring Reimbursement");

		//Task 9
		//Verifying that the header displaying Total Recurring Reimbursement for all patients Per Month : $110700
		WebElement TR1 = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]"));
		String ActualTR1 = TR1.getText();
		String ExpectedTR1 = "$110700";
		Assert.assertEquals(ActualTR1, ExpectedTR1, "Not a Total Recurring Reimbursement");

driver.close();

	}
}
