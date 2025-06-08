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

    public int pesoIdeal(Person person) throws Exception {
        if (person.getGender() == Gender.MALE) {
            hombresIdealWeight++;
        } else {
            mujeresIdealWeight++;
        }
        alturaIdealWeight += person.getHeight();

        return c.pesoIdeal(person);
    }

    public double bmr(Person person) throws Exception {
        if (person.getGender() == Gender.MALE) {
            hombresBMR++;
        } else {
            mujeresBMR++;
        }
        this.edad += person.getAge();
        alturaBMR += person.getHeight();
        this.peso += person.getWeight();

        double valorBMR = c.bmr(person);
        this.bmr += valorBMR;
        return valorBMR;
    }

    public float alturaMedia() {
        return (alturaBMR + alturaIdealWeight) / (numTotalPacientes() + hombresIdealWeight + mujeresIdealWeight);
    }

    public float pesoMedio() {
        return peso / numTotalPacientes();
    }

    public float edadMedia() {
        return edad / numTotalPacientes();
    }

    public float bmrMedio() {
        return bmr / numTotalPacientes();
    }

    public int numSexo(Gender genero) {
        if(genero== Gender.MALE) {
            return hombresIdealWeight + hombresBMR;
        } else {
            return mujeresIdealWeight + mujeresBMR;
        }
    }

    public int numTotalPacientes() {
        return hombresBMR + mujeresBMR;
    }
}

