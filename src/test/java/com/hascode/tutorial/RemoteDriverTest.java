package com.hascode.tutorial;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;

import com.google.common.io.Files;

public class RemoteDriverTest {
	private static SeleniumServer server;

	@BeforeClass
	public static void setUpTest() throws Exception {
		RemoteControlConfiguration conf = new RemoteControlConfiguration();
		conf.setPort(4444);
		conf.setDebugURL("/wd/hub");
		server = new SeleniumServer(conf);
		server.start();
	}

	@AfterClass
	public static void tearDownTest() {
		server.stop();
	}

	@Test
	public void testTakeScreenshot() throws IOException {
		WebDriver driver = new RemoteWebDriver(new URL(
				"http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());

		driver.get("http://www.dzone.com/");

		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File screenshot = ((TakesScreenshot) augmentedDriver)
				.getScreenshotAs(OutputType.FILE);
		assertNotNull(screenshot);
		assertTrue(screenshot.exists());
		assertTrue(Files.toByteArray(screenshot).length > 0);
		driver.close();
	}
}
