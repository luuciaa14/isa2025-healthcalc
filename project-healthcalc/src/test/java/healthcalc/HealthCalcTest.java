package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	@Test
	@DisplayName("Test de altura fuera del rango establecido")
	public void testInvalidHeightException(){
		// Arrange:
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert:
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(20, 'M'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(270, 'M'));
	}

	@Test
	@DisplayName("Test de altura dentro del rango establecido")
	public void testValidHeightException(){
		// Arrange:
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert:
		assertDoesNotThrow(() -> c.idealBodyWeight(30, 'M'));
		assertDoesNotThrow(() -> c.idealBodyWeight(170, 'M'));
		assertDoesNotThrow(() -> c.idealBodyWeight(250, 'M'));
	}

	@Test
	@DisplayName("Test de género no válido")
	public void testInvalidGender(){
		// Arrange:
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert:
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'A'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'B'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'm'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'w'));
	}

}
