package org.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\file.feature" }, glue = {
		"org.stepdef" }, monochrome = true, plugin = { "pretty",
				"html:C:\\Users\\User\\eclipse-workspace\\Cucumber2\\target" }, tags = {
						"@smoke" }, strict = true, snippets = SnippetType.CAMELCASE)

public class TestRunner {

}
