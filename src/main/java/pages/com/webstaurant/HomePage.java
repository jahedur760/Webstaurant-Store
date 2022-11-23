package pages.com.webstaurant;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "searchval")
	WebElement SearchInput;

	@FindBy(xpath = "//button[@value=\"Search\"]" )//(//a[@data-testid="itemDescription"])
	WebElement SearchButton;

	@FindBy(xpath = "(//a[@data-testid=\"itemDescription\"])")
	List<WebElement> SearchResult;

	@FindBy(xpath = "//div[@id=\"paging\"]/nav/ul/li[last()]")
	WebElement Pagination;

	@FindBy(xpath = "(//div[@id=\"ProductBoxContainer\"])[60]/child::div[4]/form/div/div/input[2]")
	WebElement AddLastItem;

	@FindBy(xpath = "//footer/button[@aria-label=\"Submit Feedback\"]")
	WebElement AddToCart;

	@FindBy(xpath = "//a[text()=\"View Cart\"]")
	WebElement ViewCart;

	@FindBy(xpath = "//button[text()=\"Empty Cart\"]")
	WebElement EmptyCart;

	@FindBy(xpath = "//button[text()=\"Empty\"]")
	WebElement EmptyTextBtn;
	
	@FindBy(xpath = "//p[@class=\"header-1\"]")
	WebElement EmptyText;
	
	@FindBy(xpath = "//h1")
	WebElement CartText;


	public void SearchProduct(String search) {
		SearchInput.sendKeys(search);
	}

	public void SearchSubmitButton() {
		SearchButton.click();

	}

	public List<String> Verify_Search_Result() {
		//int inc = 1;
		List<String> string = new ArrayList<String>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 60; j++) {
				string.add(SearchResult.get(j).getText());	
				//inc++;
			}
			if (i<8) {
				Pagination.click();
			}
		}
		return string;	
	}


	public void AddLastItem() {
		AddLastItem.click();

	}

	public void AddToCart() {
		AddToCart.click();

	}

	public void CartList() {
		ViewCart.click();

	}

	public void EmptyCart() {
		EmptyCart.click();

	}
	
	public void ClickEmptyTextBtn() {
		EmptyTextBtn.click();

	}

	public String VerifyEmptyText() {
		return EmptyText.getText();

	}
	
	public String VerifyCartText() {
		return CartText.getText();

	}

}
