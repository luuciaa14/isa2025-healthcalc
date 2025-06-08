package healthcalc;

public class HealthDecorator implements HealthHospital {

    public HealthStatsProxy c;
    public static String[] m = {"centímetros", "kilogramos"};

    public HealthDecorator(HealthStatsProxy c) {
        this.c = c;
    }

    public int pesoIdeal(Person person) throws Exception {
        float a = person.getHeight()*1000;
        Person conv = new Person((int) a, 0f, 0, person.getGender());
        return c.pesoIdeal(conv);
    }

    public double bmr(Person person) throws Exception {
        float a = person.getHeight()*1000;
        int p = (int) person.getWeight()/1000;
        Person conv = new Person((int) a, p, person.getAge(), person.getGender());
        double bmr = c.bmr(conv);
        msj(a, p, bmr);
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
