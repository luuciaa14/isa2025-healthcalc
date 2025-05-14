package healthcalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
	
	private Vista vista;
	private HealthCalcImpl modelo = HealthCalcImpl.getInstancia();
	
	// Constructor
	public Controlador(Vista vista, HealthCalcImpl modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		// Calcular el peso ideal
		vista.getBCalcularPesoIdeal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int altura = Integer.parseInt(vista.getTfAltura().getText());
					char genero = vista.getGeneroSeleccionado();
					float pesoIdeal = modelo.idealWeight(altura, genero);
					vista.getTfPesoIdeal().setText(String.format("%.2f", pesoIdeal));
				} catch (Exception ex) {
					vista.getTfPesoIdeal().setText(ex.getMessage());
				}
			}
		});
		
		// Calcular tasa metabólica basal
		vista.getBCalcularTasaMetabolica().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float peso = Float.parseFloat(vista.getTfPeso().getText());
					int altura = Integer.parseInt(vista.getTfAltura().getText());
					int edad = Integer.parseInt(vista.getTfEdad().getText());
					char genero = vista.getGeneroSeleccionado();
					float tasaMetabolica = modelo.basalMetabolicRate(peso, altura, edad, genero);
					vista.getTfTasaMetabolica().setText(String.format("%.2f", tasaMetabolica));
				} catch (Exception ex) {
					vista.getTfTasaMetabolica().setText(ex.getMessage());
				}
			}
		});	
	}
}
