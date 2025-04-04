package healthcalc;

public class Main {
	
	public static void main(String[] args) {
		Vista vista = new Vista();
		HealthCalcImpl modelo = new HealthCalcImpl();
		Controlador controlador = new Controlador(vista, modelo);
		vista.setVisible(true);
	}

}
