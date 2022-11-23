package webstaurant.com.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.com.webstaurant.HomePage;
import utils.TestData;

public class Test_webstaurant {
	WebDriver driver = new ChromeDriver(); 
	static TestData testdata;
	String arr[] = new String[2];

	HomePage homePage = new HomePage(driver);

	@BeforeClass
	public void BeforeTest() throws IOException {
		testdata = new TestData();
		driver.get(testdata.property.getProperty("baseUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void search_work_table() throws IOException {
		testdata = new TestData();
		homePage.SearchProduct(testdata.property.getProperty("validSearch"));
		homePage.SearchSubmitButton();

		for (String word : homePage.Verify_Search_Result()) {
			String [] words = word.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (testdata.property.getProperty("wordContain").equals(words[i])) {
					assertEquals(words[i], testdata.property.getProperty("wordContain"));
				}

			}

		}

	}

	@Test(priority = 2)
	public void add_last_item_to_cart() throws IOException {
		homePage.AddLastItem();
		homePage.AddToCart();
		homePage.CartList();
		assertEquals(homePage.VerifyCartText(), testdata.property.getProperty("pageCart"));

	}

	@Test(priority = 3)
	public void clear_cart_items() throws IOException {
		homePage.EmptyCart();
		homePage.ClickEmptyTextBtn();
		assertEquals(homePage.VerifyEmptyText(), testdata.property.getProperty("emptyText"));

	}

	@AfterClass
	public void AfterTest() {
		driver.close();
	}

}
