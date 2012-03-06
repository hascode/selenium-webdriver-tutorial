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
		driver.get("http://www.hascode.com/");
		assertEquals("hasCode.com", driver.getTitle());
		WebElement searchBox = driver.findElement(By.id("s"));
		searchBox.sendKeys("ejb");
		searchBox.submit();
		assertEquals("hasCode.com » Search Results » ejb", driver.getTitle());
	}
}
