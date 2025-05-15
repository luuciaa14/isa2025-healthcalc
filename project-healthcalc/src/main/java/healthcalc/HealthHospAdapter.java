package healthcalc;

public class HealthHospAdapter implements HealthHospital {

    private static HealthCalc c;

    private HealthHospAdapter() {
        c = HealthCalcImpl.getInstancia();
    }

    public int pesoIdeal(char genero, float altura) {
        
        float cm = altura*100;

        try{
            float pesoId = c.idealWeight((int) cm, genero);
            return (int) pesoId;
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public double bmr(char genero, int edad, float altura, int peso){

        float cm = altura*100;
        float kg = peso/1000;

        try{
            float bmr = c.basalMetabolicRate(kg, (int) cm, edad, genero);
            return (double) bmr;
        } catch (Exception e){
            System.err.println("Error: " + e.getLocalizedMessage());
            e.printStackTrace();
            return -1;
        }
    }
    
}
