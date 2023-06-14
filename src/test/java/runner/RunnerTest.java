package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Features", glue = {"steps"},
        monochrome = true, plugin = {"pretty", "junit:target/Reports/JUnitReports/JUnitReports.xml",
        "json:target/Reports/JsonReports/JsonReport.json",
        "html:target/Reports/HtmlReports/HtmlReports/"})
public class RunnerTest {
}
