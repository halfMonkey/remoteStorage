package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;
	private LoginPage loginPage;

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
		driver.get("http://localhost:" + this.port + "/login");
		this.loginPage = new LoginPage(driver);
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}
	
	@Test
	public void loginWithWrongPassword() {
		this.loginPage.login("yida", "yida");
		Assertions.assertEquals(this.driver.getCurrentUrl(), "http://localhost:"+this.port+"/login?error"); 
	}
	
	@Test
	public void loginWithRightPassword() {
		this.loginPage.login("yida", "yidalove");
		Assertions.assertEquals(this.driver.getCurrentUrl(), "http://localhost:"+this.port+"/home"); 
	}
	
}
