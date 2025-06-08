package healthcalc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class IdealWeightSteps {
    private HealthCalcImpl healthCalc;
    private Person person;
    private float result;
    private Exception exception;

    public IdealWeightSteps() {
        healthCalc = HealthCalcImpl.getInstancia();
    }

    @Given("a {word} with a height of {int} cm")
    public void aPersonWithHeight(String genderStr, int height) {
        Gender gender = genderStr.equalsIgnoreCase("man") ? Gender.MALE : Gender.FEMALE;
        person = new Person(height, 0, 0, gender);
    }

    @When("I calculate the ideal weight")
    public void iCalculateTheIdealWeight() {
        try {
            result = healthCalc.idealWeight(person);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("the result should be {float} kg")
    public void theResultShouldBe(float expectedWeight) {
        assertEquals(expectedWeight, result, 0.1);
    }

    @Then("an error should be thrown")
    public void anErrorShouldBeThrown() {
        assertNotNull(exception);
    }
}
