package healthcalc;

public class HealthAmerica extends HealthDecorator {

    public static String[] m = {"pies", "libras"};

    public HealthAmerica(HealthStatsProxy c) {
        super(c);
    }

    public int pesoIdeal(float altura, Gender genero) throws Exception {
        float a = altura/3.2808f;
        int p = c.pesoIdeal(a, genero); 
        return p;
    }

    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
        float a = altura/3.2808f;
        int p = (int) (peso*1000/2.20462);
        double bmr = c.bmr(genero, edad, a, p);
        msj(a, p, bmr);
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
