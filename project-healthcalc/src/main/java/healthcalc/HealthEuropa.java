package healthcalc;

public class HealthEuropa implements HealthHospital {

    private HealthStatsProxy c;

    public HealthEuropa(HealthStatsProxy c) {
        this.c = c;
    }

    public int pesoIdeal(float altura, char genero) throws Exception {
        int pesoId = c.pesoIdeal(altura, genero);
        return pesoId;
    }

    public double bmr(char genero, int edad, float altura, int peso) {
        throw new UnsupportedOperationException("Unimplemented method 'bmr'");
    }
    
}
