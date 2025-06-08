package healthcalc;

public class HealthEuropa extends HealthDecorator {

    public static String[] m = {"metros", "gramos"};

    public HealthEuropa(HealthStatsProxy c) {
        super(c);
    }

    public int pesoIdeal(float altura, Gender genero) throws Exception {
        int pesoId = c.pesoIdeal(altura, genero);
        return pesoId;
    }

    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
        double bmr = c.bmr(genero, edad, altura, peso);
        msj(altura, peso, bmr);
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
