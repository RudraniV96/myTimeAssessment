package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.Context;


public class StepsHook {

    @Before
    public void setup(){
        Context.initialize();
        Context.getDriver().get( Context.getProperty("url"));

    }

    @After
    public void tearDown(){
        Context.getDriver().quit();
    }
}
