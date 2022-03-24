package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.Constants;

public class Base {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver;
	public static Properties prop;
	public static String filepath = System.getProperty("user.dir")+"\\src\\main\\java\\Base\\config.properties";
	
	public Base()
	{
		prop = new Properties();
		tdriver = new ThreadLocal<WebDriver>();
		
		try {
			FileInputStream FIS = new FileInputStream(filepath);
			prop.load(FIS);
			}
			catch (FileNotFoundException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	

	public static WebDriver initialize(String browserName)
	{
		String url = prop.getProperty("url");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
	    File file  = new File(prop.getProperty("chromepath"));
	    String chromeAbsolutePath = file.getAbsolutePath();
	    		
		System.setProperty("webdriver.chrome.driver", chromeAbsolutePath);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			File edgefile  = new File(prop.getProperty("edgepath"));
		    String edgeAbsolutePath = edgefile.getAbsolutePath();
		    		
		System.setProperty("webdriver.edge.driver",edgeAbsolutePath);
		driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{

			File geckofile  = new File(prop.getProperty("firefoxpath"));
		    String geckoAbsolutePath = geckofile.getAbsolutePath();
		System.setProperty("webdriver.gecko.driver",geckoAbsolutePath);
		driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.getPageLoadTimeOut()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.getimplicitWait()));
		driver.get(url);
		
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver()
	{
	
		tdriver.set(driver);
		return tdriver.get();
	}

}
