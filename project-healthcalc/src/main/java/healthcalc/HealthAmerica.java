package healthcalc;

public class HealthAmerica extends HealthDecorator {

    public static String[] m = {"pies", "libras"};

    public HealthAmerica(HealthStatsProxy c) {
        super(c);
    }

    public int pesoIdeal(Person person) throws Exception {
        float a = person.getHeight()/3.2808f;
        Person conv = new Person((int) a, 0f, 0, person.getGender());
        return c.pesoIdeal(conv);
    }

    public double bmr(Person person) throws Exception {
        float a = person.getHeight()/3.2808f;
        float p = person.getWeight()*1000/2.20462f;
        Person conv = new Person((int) a, p, person.getAge(), person.getGender());
        double bmr = c.bmr(conv);
        msj(a, (int) p, bmr);
        return bmr;
    }

    public void msj(float altura, int peso, double bmr) {
        System.out.println("Para una altura de " + altura + " " + 
        m[0].toString() + " y " + peso + " " + m[1].toString() + 
        " su BMR es de " + Double.toString(bmr));
    }

    public String[] uds() {
        return m;
    }
    
}
