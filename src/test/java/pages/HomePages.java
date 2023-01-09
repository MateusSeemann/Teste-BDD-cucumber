package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePages {
	
	WebDriver driver;
	
	final String CAMPO_BUSCA = "//*[@id=\"twotabsearchtextbox\"]";
	

	public HomePages(WebDriver driver) {
		this.driver = driver;
	}

	public void realizaBusca(String produto) {
		
		driver.findElement(By.xpath(CAMPO_BUSCA)).sendKeys(produto);
		driver.findElement(By.xpath(CAMPO_BUSCA)).sendKeys(Keys.ENTER);
	}
}
