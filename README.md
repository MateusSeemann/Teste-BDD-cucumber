#language:pt
Funcionalidade: testes exemplo cucumber
Cenário: teste cucumber Amazon
Dado que esteja na pagina: "http://www.amazon.com.br"
Quando fizer a busca pelo produto: "Iphone 11"

#HomePages

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

#ResultadoPages.Java

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

#StepAmazon

package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.HomePages;
import pages.ResultadoBuscaPage;

public class StepAmazon {
	WebDriver driver;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Dado("que esteja na pagina: {string}")
	public void que_esteja_na_pagina(String url) {
		driver.get(url);
	}

	@Quando("fizer a busca pelo produto: {string}")
	public void fizer_a_busca_pelo_produto(String produto) {
		
		HomePages homePages = new HomePages(driver);
		homePages.realizaBusca(produto);
		
	}

}
