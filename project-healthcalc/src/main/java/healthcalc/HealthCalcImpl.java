package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    private static HealthCalcImpl instancia;

    private HealthCalcImpl() {}

    public static HealthCalcImpl getInstancia() {
        if (instancia == null) {
            instancia = new HealthCalcImpl();
        }
        return instancia;
    }

    public float idealWeight(int height, Gender gender) throws Exception {
        // Verificar altura
        if(height<30 || height>250){
            throw new IllegalArgumentException("La altura debe estar entre 30cm y 250 cm");
        }
        // Fórmula de Lorentz
        if(gender== Gender.MALE){
            return height-100-(height-150)/4f;
        }else{
            return height-100-(height-150)/2.5f;
        }
    }

    public float basalMetabolicRate(float weight, int height, int age, Gender gender){
        // Verificar peso
        if(weight<3 || weight>400){
            throw new IllegalArgumentException("El peso debe estar entre 3kg y 400kg");
        }
        // Verificar altura
        if(height<30 || height>250){
            throw new IllegalArgumentException("La altura debe estar entre 30cm y 250 cm");
        }
        // Verificar edad
        if(age<1 || age>120){
            throw new IllegalArgumentException("La edad debe estar entre 1 año y 120 años");
        }
        // Fórmula de Harris-Benedict
        if(gender== Gender.MALE){
            return 88.362f+13.397f*weight+4.799f*height-5.677f*age;
        }else{
            return 447.593f+9.247f*weight+3.098f*height-4.330f*age;
        }
    }
}
