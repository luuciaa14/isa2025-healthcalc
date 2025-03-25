package healthcalc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class BasalMetabolicRateSteps {
    private HealthCalcImpl healthCalc;
    private float weight;
    private int height;
    private int age;
    private char gender;
    private float result;
    private Exception exception;

    public BasalMetabolicRateSteps() {
        healthCalc = new HealthCalcImpl();
    }

    @Given("a {word} weighing {float} kg, with a height of {int} cm, and aged {int}")
    public void aPersonWithWeightHeightAge(String genderStr, float weight, int height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = genderStr.equalsIgnoreCase("man") ? 'M' : 'W';
    }

    @When("I calculate the BMR")
    public void iCalculateTheBMR() {
        try {
            result = healthCalc.basalMetabolicRate(weight, height, age, gender);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("the result should be {float} kcal\\/day")
    public void theResultShouldBe(float expectedBMR) {
        assertEquals(expectedBMR, result, 0.1);
    }

    @Given("a person weighing {float} kg")
    public void aPersonWeighing(float weight) {
        this.weight = weight;
    }

    @When("I try to calculate the BMR")
    public void iTryToCalculateTheBMR() {
        try {
            result = healthCalc.basalMetabolicRate(weight, height, age, gender);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("an error should be thrown")
    public void anErrorShouldBeThrown() {
        assertNotNull(exception);
    }
}
