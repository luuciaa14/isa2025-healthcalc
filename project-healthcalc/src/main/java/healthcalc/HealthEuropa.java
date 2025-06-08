package healthcalc;

public class HealthEuropa extends HealthDecorator {

    public static String[] m = {"metros", "gramos"};

    public HealthEuropa(HealthStatsProxy c) {
        super(c);
    }

    public int pesoIdeal(Person person) throws Exception {
        return c.pesoIdeal(person);
    }

    public double bmr(Person person) throws Exception {
        double bmr = c.bmr(person);
        msj(person.getHeight(), (int) person.getWeight(), bmr);
        return bmr;
    }

    public void msj(float altura, int peso, double bmr) {
        System.out.println("Para una altura de " + altura + " " + 
        m[0].toString() + " y " + peso + " " + m[1].toString() + 
        " su BMR es de " + Double.toString(bmr));
    }

    public String[] m() {
        return m;
    }
    
}
