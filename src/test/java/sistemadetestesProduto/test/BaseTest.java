package sistemadetestesProduto.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest{
	
	protected static WebDriver driver;
	//private static final String URL_BASE = "https://www.google.com";
	private static final String URL_BASE = "file:///C:/Users/Walla/OneDrive/Documents/Testes%20de%20Software/testes/selenium-lab-main/sistema/produtos.html";
	private static final String PATH_DRIVE = "src/test/resources/chromedriver.exe";
	
	@BeforeClass
	public static void iniciar() {
		System.setProperty("webdriver.chrome.driver.exe", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@AfterClass
	public static void finalizar() {
		driver.quit();
	}
	
}