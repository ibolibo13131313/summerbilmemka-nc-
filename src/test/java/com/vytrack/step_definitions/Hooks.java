package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before("@db")
    public void setupDatabase(){
        System.out.println("CONNECTİON DATABASE");
    }
    @Before
    public void setUp(){
        System.out.println(" this is coming from BEFORE ");
    }
    @After
    public void tearDown(Scenario scenario){
        //if the scenario fails take the screenshot
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }

        Driver.closeDriver();
    }
    @After("@db")
    public void tearDownDatabase(){
    System.out.println("CLOSİNG DATABASE CONNECTİO");
}


}
