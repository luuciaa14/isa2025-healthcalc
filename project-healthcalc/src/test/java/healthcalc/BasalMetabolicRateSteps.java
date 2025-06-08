package healthcalc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class BasalMetabolicRateSteps {
    private HealthCalcImpl healthCalc;
    private Person person;
    private float result;
    private Exception exception;

    public BasalMetabolicRateSteps() {
        healthCalc = HealthCalcImpl.getInstancia();
    }

    @Given("a {word} weighing {float} kg, with a height of {int} cm, and aged {int}")
    public void aPersonWithWeightHeightAge(String genderStr, float weight, int height, int age) {
        Gender gender = genderStr.equalsIgnoreCase("man") ? Gender.MALE : Gender.FEMALE;
        person = new Person(height, weight, age, gender);
    }

    @When("I calculate the BMR")
    public void iCalculateTheBMR() {
        try {
            result = healthCalc.basalMetabolicRate(
                person.getWeight(),
                person.getHeight(),
                person.getAge(),
                person.getGender()
            );
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
        person = new Person(0, weight, 0, Gender.MALE);
    }

    @When("I try to calculate the BMR")
    public void iTryToCalculateTheBMR() {
        try {
            result = healthCalc.basalMetabolicRate(
                person.getWeight(),
                person.getHeight(),
                person.getAge(),
                person.getGender() 
            );
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("an error should be thrown")
    public void anErrorShouldBeThrown() {
        assertNotNull(exception);
    }
}
