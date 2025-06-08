package healthcalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAltura;
	private JTextField tfPeso;
	private JTextField tfEdad;
	private JTextField tfPesoIdeal;
	private JTextField tfTasaMetabolica;
	private JButton bCalcularPesoIdeal;
	private JButton bCalcularTasaMetabolica;
	private JButton bMujer;
	private JButton bHombre;
	private Gender generoSeleccionado = Gender.MALE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("Health calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 396);
		contentPane = new JPanel();
		contentPane.setToolTipText("");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenero = new JLabel("Género");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGenero.setBounds(86, 71, 81, 25);
		contentPane.add(lblGenero);
		
		bMujer = new JButton("Mujer");
		bMujer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bMujer.setBounds(20, 104, 98, 25);
		contentPane.add(bMujer);
		
		bHombre = new JButton("Hombre");
		bHombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bHombre.setBounds(124, 104, 98, 25);
		contentPane.add(bHombre);
		
		bMujer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generoSeleccionado = Gender.FEMALE;
                bMujer.setBackground(Color.LIGHT_GRAY);
                bHombre.setBackground(null);
            }
        });
		
		bHombre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generoSeleccionado = Gender.MALE;
                bHombre.setBackground(Color.LIGHT_GRAY);
                bMujer.setBackground(null);
            }
        });
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAltura.setBounds(263, 71, 81, 25);
		contentPane.add(lblAltura);
		
		tfAltura = new JTextField();
		tfAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		tfAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAltura.setBounds(247, 107, 50, 19);
		contentPane.add(tfAltura);
		tfAltura.setColumns(10);
		
		JLabel lblcm1 = new JLabel("cm");
		lblcm1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcm1.setBounds(307, 110, 45, 13);
		contentPane.add(lblcm1);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPeso.setBounds(376, 71, 81, 25);
		contentPane.add(lblPeso);
		
		tfPeso = new JTextField();
		tfPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPeso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPeso.setBounds(362, 107, 50, 19);
		contentPane.add(tfPeso);
		tfPeso.setColumns(10);
		
		JLabel lblkg1 = new JLabel("kg");
		lblkg1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblkg1.setBounds(422, 104, 45, 25);
		contentPane.add(lblkg1);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdad.setBounds(488, 71, 50, 25);
		contentPane.add(lblEdad);
		
		tfEdad = new JTextField();
		tfEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		tfEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEdad.setBounds(467, 107, 50, 19);
		contentPane.add(tfEdad);
		tfEdad.setColumns(10);
		
		JLabel lblAnios = new JLabel("años");
		lblAnios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnios.setBounds(527, 104, 45, 25);
		contentPane.add(lblAnios);
		
		bCalcularPesoIdeal = new JButton("Peso ideal");
		bCalcularPesoIdeal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bCalcularPesoIdeal.setBounds(73, 192, 149, 25);
		contentPane.add(bCalcularPesoIdeal);
		
		tfPesoIdeal = new JTextField();
		tfPesoIdeal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPesoIdeal.setEditable(false);
		tfPesoIdeal.setBounds(86, 237, 96, 19);
		contentPane.add(tfPesoIdeal);
		tfPesoIdeal.setColumns(10);
		
		JLabel lblkg2 = new JLabel("kg");
		lblkg2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblkg2.setBounds(192, 234, 43, 25);
		contentPane.add(lblkg2);
		
		bCalcularTasaMetabolica = new JButton("Tasa metabólica basal");
		bCalcularTasaMetabolica.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bCalcularTasaMetabolica.setBounds(283, 194, 255, 21);
		contentPane.add(bCalcularTasaMetabolica);
		
		tfTasaMetabolica = new JTextField();
		tfTasaMetabolica.setEditable(false);
		tfTasaMetabolica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfTasaMetabolica.setBounds(340, 237, 127, 19);
		contentPane.add(tfTasaMetabolica);
		tfTasaMetabolica.setColumns(10);
	}
	
	public JTextField getTfAltura() {
        return tfAltura;
    }

    public JTextField getTfPeso() {
        return tfPeso;
    }

    public JTextField getTfEdad() {
        return tfEdad;
    }

    public JTextField getTfPesoIdeal() {
        return tfPesoIdeal;
    }

    public JTextField getTfTasaMetabolica() {
        return tfTasaMetabolica;
    }

    public JButton getBCalcularPesoIdeal() {
        return bCalcularPesoIdeal;
    }

    public JButton getBCalcularTasaMetabolica() {
        return bCalcularTasaMetabolica;
    }
    
    public Gender getGeneroSeleccionado() {
    	return generoSeleccionado;
    }

	public Person getPerson() { // MODIFICADA
		int altura = Integer.parseInt(getTfAltura().getText());
		float peso = Float.parseFloat(getTfPeso().getText());
		int edad = Integer.parseInt(getTfEdad().getText());
		return new Person(altura, peso, edad, generoSeleccionado);
	}
	
}
