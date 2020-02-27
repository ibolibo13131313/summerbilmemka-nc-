package com.vytrack.step_definitions;

import com.vytrack.Pages.DashboardPage;
import com.vytrack.Pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactStepDefs {

    @Then("the user should see following menu options")
    public void the_user_should_see_following_menu_options(List<String> menuOptions) {
        System.out.println("menuOptions.size = " + menuOptions.size());
        System.out.println("menuOptions = " + menuOptions);

        BrowserUtils.waitFor(2);

        DashboardPage dashboardPage = new DashboardPage();

        List<String> actualmenuOption = BrowserUtils.getElementsText(dashboardPage.menuOptions);
        System.out.println(actualmenuOption);

        Assert.assertEquals(menuOptions, actualmenuOption);
    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String, String> userdata) {
        new LoginPage().login(userdata.get("username"), userdata.get("password"));

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualfullname = dashboardPage.getUserName();
    String expectedfullname = userdata.get("firstname")+" "+userdata.get("lastname");
    Assert.assertEquals(expectedfullname,actualfullname);
    }

}