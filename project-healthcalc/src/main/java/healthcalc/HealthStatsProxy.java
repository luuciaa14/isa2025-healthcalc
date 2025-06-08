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

    public int pesoIdeal(float altura, Gender genero) throws Exception {
        if (genero == Gender.MALE) {
            hombresIdealWeight++;
        } else {
            mujeresIdealWeight++;
        }
        alturaIdealWeight += altura;

        return c.pesoIdeal(altura, genero);
    }

    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception {
        if (genero == Gender.MALE) {
            hombresBMR++;
        } else {
            mujeresBMR++;
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
        return peso / (hombresBMR + mujeresBMR);
    }

    public float edadMedia() {
        return edad / (hombresBMR + mujeresBMR);
    }

    public float bmrMedio() {
        return bmr / (hombresBMR + mujeresBMR);
    }

    public int numSexoH() {
        return hombresBMR + hombresIdealWeight;
    }

    public int numSexoM() {
        return mujeresBMR + mujeresIdealWeight;
    }

    public int numTotalPacientes() {
        return hombresBMR + mujeresBMR;
    }
}

