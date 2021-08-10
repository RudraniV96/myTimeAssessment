package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.AppointmentPage;
import pageObjects.ConfirmationPage;
import util.Context;

public class ConfirmationSteps {

    ConfirmationPage confirmationPage;
    AppointmentPage appointmentPage;

    public ConfirmationSteps(){
        confirmationPage = Context.getPageObjManager().getConfirmationPage();
        appointmentPage = Context.getPageObjManager().getAppointmentPage();
    }

    @Then("^Verify that the user is presented with a list of available time slots with at least (\\d+) entries$")
    public void verifyresultSet(int count){
        confirmationPage.verifyTitlePresent();

        Assert.assertTrue( confirmationPage.resultList(count) );
    }


    @And("^Staff selected is the staff chosen before$")
    public void verifyServiceStaffMember(){
        Assert.assertEquals( confirmationPage.getMemberName(), Context.getServiceStaffMember());
    }


    @And("^Service displayed is the one selected in the step before$")
    public void verifyServiceName(){
        Assert.assertEquals( confirmationPage.getServiceName(), Context.getServiceName());
    }


    @And("^Service price is the same as the one displayed in the step before$")
    public void verifyServicePrice(){
        Assert.assertEquals( confirmationPage.getServicePrice(), Context.getServicePrice());
    }


}
