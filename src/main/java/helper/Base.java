package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {
	public static Properties prop;
    public static WebDriver driver;
	
	static long timeout=10;

	static {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resources/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

			//Plawright and selenium
			//Ranorex and QTP
			//TestAUtomation

		}

	}

	@Before
	public void Initalization() {
		String browserName = prop.getProperty("browser"); // ff
		switch (browserName) {

		case "chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--incognito");
			driver = new ChromeDriver(option);
			break;

		case "ff":
			FirefoxOptions option1 = new FirefoxOptions();
			option1.addArguments("--incognito");
			driver = new FirefoxDriver(option1);
			break;

		case "edge":
			driver = new EdgeDriver();
			break;
		}

		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}

	@After
	public void tearDown(Scenario s) throws IOException {

		if (s.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcSceenshot = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcSceenshot, new File("Screenshots/" + s.getName() + ".png"));

		}
		driver.quit();
	}

	public void selectDropDownValue(WebElement ele, String type, String value) {
		Select s = new Select(ele);
		switch (type) {

		case "index":
			s.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			s.selectByValue(value);
			break;
		case "visibleText":
			s.selectByVisibleText(value);
			break;

		}

	}

	public void validateText(WebElement ele, String expectedValue) {
		String actualValue = ele.getText();
		Assert.assertEquals(expectedValue, actualValue);
	}

	public void clickOnElement(WebElement ele, long timeout) {
		try {
			waitForElementClickable(ele, timeout);
			ele.click();
		} catch (Exception e) {
			waitForElementClickable(ele, timeout);
			executorClick(ele);
		}
	}

	public void waitForElementClickable(WebElement ele, long timout) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timout));
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void executorClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		js.executeScript("arguments[0].click();", ele);
	}

	public void switchFrames(String type, String value) {
		switch (type) {
		case "index":
			driver.switchTo().frame(Integer.parseInt(value));
			break;
		case "name":
			driver.switchTo().frame(value);
			break;

		}

	}

	public void selectBootStrapDropdown(WebElement e,List<WebElement> list, String expectedvalue) {
		    clickOnElement(e, timeout);
		for (WebElement ele : list) {

			String actualValue = ele.getText();
			if (actualValue.equals(expectedvalue)) {
				ele.click();
				break;
			}
		}

	}

	 public void switchWindow(String title) {
		 
	Set<String>allwindows= driver.getWindowHandles();
	
	for(String windowId:allwindows) {
		
		driver.switchTo().window(windowId);
		if(driver.getTitle().contains(title)) {
			break;
		}
	}
		 
	 }
	 
	 public void mouseHover(WebElement ele) {
		 Actions a= new Actions(driver);
		 a.moveToElement(ele).build().perform();
		 
	 }
	 public void waitForElement(WebElement ele,long timeout) {
		 WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			w.until(ExpectedConditions.visibilityOf(ele));
		}
	 
	 public void cleanAndEnterText(WebElement ele,String value) {
		 ele.clear();
		 ele.sendKeys(value);
	 }
	 
	 public void clickOnCheckBox(WebElement ele) {
		 if(!ele.isSelected()) {
			 clickOnElement(ele, timeout);
		 }
		 
		 
	 }
	 
	 }


