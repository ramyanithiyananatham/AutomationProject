package Example;

import java.util.List;
//import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		//"http://www.fatcow.com/"
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// we identified the dropdown menu
		WebElement dropDown = driver.findElement(By.name("country"));
		System.out.println("DropdownText " + dropDown.getText());

		Select select = new Select(dropDown);
		boolean ismultiple=select.isMultiple();
		System.out.println("ismultiple"+ismultiple);
		//select.selectByIndex(2);
		 select.selectByVisibleText("ANTARCTICA");
		// select.selectByValue("AUD");
		
		//select.getAllSelectedOptions(); for selecting all selected values
	System.out.println("Current selected Value " + select.getFirstSelectedOption().getText());//first or current selected item
		List<WebElement> alloptions = select.getOptions();// getOptions();

		int size = select.getOptions().size();

		System.out.println("size" + size);
		/*for (WebElement option : alloptions) {
			System.out.println("optionName" + option.getText());// getItem(i));
		}*/
		 for(int i=0;i<size;i++)
		   {
			   WebElement a = alloptions.get(i);
			  // String optionName = a.getText();
			   System.out.println("optionName" +a.getText());
		   }

		driver.close();
	}

}
