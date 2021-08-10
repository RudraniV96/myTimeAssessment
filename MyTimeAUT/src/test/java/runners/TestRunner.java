package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import util.Context;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/haircutTest.feature",
        glue = {"stepDefinitions"},
        tags = {"@test"},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json",
         "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class TestRunner {

    @AfterClass
    public void writeReport(){
        Reporter.loadXMLConfig( new File(Context.getProperty("reportPath")));
    }

}


