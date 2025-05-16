package healthcalc;

public class HealthAmerica implements HealthHospital{

    private HealthStatsProxy c;
    public static String[] m = new String[2];

    public HealthAmerica(HealthStatsProxy c) {
        this.c = c;
        m[0] = "pies";
        m[1] = "libras";
    }

    public int pesoIdeal(float altura, char genero) throws Exception {
        int pesoId = c.pesoIdeal(altura, genero);
        return pesoId;
    }

    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        double bmr = c.bmr(genero, edad, altura, peso);
        return bmr;
    }

    public String[] uds() {
        return m;
    }
    
}
