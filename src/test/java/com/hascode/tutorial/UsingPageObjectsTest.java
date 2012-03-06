package com.hascode.tutorial;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingPageObjectsTest {
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test
	public void testSearchDzone() {
		driver.get("http://www.dzone.com/links/index.html");
		DzoneHomePage homePage = PageFactory.initElements(driver,
				DzoneHomePage.class);
		homePage.searchFor("message driven beans");
		DzoneSearchResultsPage resultsPage = PageFactory.initElements(driver,
				DzoneSearchResultsPage.class);
		assertTrue(resultsPage
				.containsSearchResult("Message Driven Beans in Java EE 6"));
	}
}
