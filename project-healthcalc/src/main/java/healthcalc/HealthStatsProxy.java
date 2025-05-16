package healthcalc;

public class HealthStatsProxy implements HealthHospital, HealthStats {

    private HealthHospital c;
    private float alturaIdealWeight;
    private float alturaBMR;
    private float peso;
    private float edad;
    private float bmr;
    private int hombresIdealWeight;
    private int mujeresIdealWeight;
    private int hombresBMR;
    private int mujeresBMR;

    public HealthStatsProxy(HealthHospital c) {
        this.c = c;
        alturaIdealWeight = 0;
        alturaBMR = 0;
        peso = 0;
        edad = 0;
        bmr = 0;
        hombresIdealWeight = 0;
        mujeresIdealWeight = 0;
        hombresBMR = 0;
        mujeresBMR = 0;
    }

    public int pesoIdeal(float altura, char genero) throws Exception {

        if (genero == 'M') {
            hombresIdealWeight++;
        } else {
            mujeresIdealWeight++;
        }
        alturaIdealWeight += altura;

        return c.pesoIdeal(altura, genero);
    }

    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        if (genero == 'M') {
            hombresIdealWeight++;
        } else {
            mujeresIdealWeight++;
        }
        this.edad += edad;
        alturaBMR += altura;
        this.peso += peso;
        bmr += c.bmr(genero, edad, altura, peso);

        return c.bmr(genero, edad, altura, peso);
    }

    public float alturaMedia() {
        float alturaM = (alturaBMR + alturaIdealWeight) / (mujeresIdealWeight + hombresIdealWeight + mujeresBMR + hombresBMR);
        return alturaM;
    }

    public float pesoMedio() {
        float pesoM = peso / (hombresBMR + mujeresBMR);
        return pesoM;
    }

    public float edadMedia() {
        float edadM = edad / (hombresBMR + mujeresBMR);
        return edadM;
    }

    public float bmrMedio() {
        float bmrM = bmr / (hombresBMR + mujeresBMR);
        return bmrM;
    }

    public int numHombres() {
        int numH = hombresBMR + hombresIdealWeight;
        return numH;
    }

    public int numMujeres() {
        int numM = mujeresBMR + mujeresIdealWeight;
        return numM;
    }

    public int numHM() {
        int HM = hombresBMR + mujeresBMR;
        return HM;
    }
    
}
