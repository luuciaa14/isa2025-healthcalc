package healthcalc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class IdealWeightSteps {
    private HealthCalcImpl healthCalc;
    private int height;
    private char gender;
    private float result;
    private Exception exception;

    public IdealWeightSteps() {
        healthCalc = new HealthCalcImpl();
    }

    @Given("a {word} with a height of {int} cm")
    public void aPersonWithHeight(String genderStr, int height) {
        this.height = height;
        this.gender = genderStr.equalsIgnoreCase("man") ? 'M' : 'W';
    }

    @When("I calculate the ideal weight")
    public void iCalculateTheIdealWeight() {
        try {
            result = healthCalc.idealWeight(height, gender);
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
