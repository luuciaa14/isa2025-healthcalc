package healthcalc;

public class HealthHospAdapter implements HealthHospital {

    private static HealthCalcImpl c;

    private HealthHospAdapter() {
        c = HealthCalcImpl.getInstancia();
    }

    public int pesoIdeal(Person person) {
        
        float cm = person.getHeight()*100;
        Person adap = new Person((int) cm, 0f, 0, person.getGender());

        try{
            float pesoId = c.idealWeight(adap);
            return (int) pesoId;
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public double bmr(Person person){

        float cm = person.getHeight()*100;
        float kg = person.getWeight()/1000;
        Person adap = new Person((int) cm, kg, person.getAge(), person.getGender());

        try{
            return c.basalMetabolicRate(adap);
        } catch (Exception e){
            System.err.println("Error: " + e.getLocalizedMessage());
            e.printStackTrace();
            return -1;
        }
    }
    
}
