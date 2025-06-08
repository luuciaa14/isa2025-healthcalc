package healthcalc;

public interface HealthStats {

    public float alturaMedia();
    public float pesoMedio();
    public float edadMedia();
    public float bmrMedio();
    public int numSexo(Gender genero);
    public int numTotalPacientes();
    
}
