package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoBuscaPage {

	WebDriver driver;

	final String PRODUTO_BUSCA = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/div[4]/div/a[1]/span/span[1]";

	public ResultadoBuscaPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clicarProduto() {

		driver.findElement(By.xpath(PRODUTO_BUSCA)).click();
	}
}
