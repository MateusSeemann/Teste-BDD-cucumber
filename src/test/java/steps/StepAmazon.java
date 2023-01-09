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
