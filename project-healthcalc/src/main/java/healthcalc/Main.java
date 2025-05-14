package healthcalc;

public class Main {
	
	public static void main(String[] args) {
		Vista vista = new Vista();
		HealthCalcImpl modelo = HealthCalcImpl.getInstancia();
		Controlador controlador = new Controlador(vista, modelo);
		vista.setVisible(true);
	}

}
