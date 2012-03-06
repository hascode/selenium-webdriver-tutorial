package com.hascode.tutorial;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DzoneSearchResultsPage {
	@FindBy(how = How.ID, using = "content-inner")
	private WebElement searchResultWrapper;

	boolean containsSearchResult(final String term) {
		// for tutorial purpose only ;)
		return searchResultWrapper.getText().contains(term);
	}
}
