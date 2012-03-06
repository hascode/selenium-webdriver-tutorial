package com.hascode.tutorial;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebpageTest {
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
	public void testGetTitle() {
		driver.get("http://www.dzone.com/links/index.html");
		assertEquals("dzone.com - fresh links for developers",
				driver.getTitle());
		WebElement searchBox = driver.findElement(By.id("mh_searchQuery"));
		searchBox.sendKeys("message driven beans");
		searchBox.submit();
		assertEquals("Search Results For: message driven beans",
				driver.getTitle());
	}
}
