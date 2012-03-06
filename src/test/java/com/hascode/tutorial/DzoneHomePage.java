package com.hascode.tutorial;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DzoneHomePage {
	@FindBy(how = How.ID, using = "mh_searchQuery")
	private WebElement searchBox;

	public void searchFor(final String term) {
		searchBox.sendKeys(term);
		searchBox.submit();
	}

}
