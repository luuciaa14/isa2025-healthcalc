package healthcalc;

public class HealthDecorator implements HealthHospital {

    public HealthStatsProxy c;
    public static String[] m = {"centímetros", "kilogramos"};

    public HealthDecorator(HealthStatsProxy c) {
        this.c = c;
    }

    public int pesoIdeal(float altura, Gender genero) throws Exception {
        float a = altura*1000;
        return c.pesoIdeal(a, genero);
    }

    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
        float a = altura*1000;
        int p = peso/1000;
        double bmr = c.bmr(genero, edad, a, p);
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
