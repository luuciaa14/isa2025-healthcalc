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
		// Act & Assert (idealBodyWeight):
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(20, 'M'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(270, 'M'));
		// Act & Assert (basalMetabolicRate):
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 20, 25, 'M'));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 270, 25, 'M'));
	}

	@Test
	@DisplayName("Test de altura dentro del rango establecido")
	public void testValidHeightException(){
		// Arrange:
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert (idealBodyWeight):
		assertDoesNotThrow(() -> c.idealBodyWeight(30, 'M'));
		assertDoesNotThrow(() -> c.idealBodyWeight(170, 'M'));
		assertDoesNotThrow(() -> c.idealBodyWeight(250, 'M'));
		// Act & Assert (basalMetabolicRate):
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 30, 25, 'M'));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, 'M'));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 250, 25, 'M'));
	}

	@Test
	@DisplayName("Test de género no válido")
	public void testInvalidGender(){
		// Arrange:
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert (idealBodyWeight):
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'A'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'B'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'm'));
		assertThrows(IllegalArgumentException.class, () -> c.idealBodyWeight(170, 'w'));
		// Act & Assert (basalMetabolicRate):
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 25, 'A'));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 25, 'B'));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 25, 'm'));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 25, 'w'));
	}

	@Test
	@DisplayName("Test de género válido")
	public void testValidGender(){
		// Arrange
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert (idealBodyWeight):
		assertDoesNotThrow(() -> c.idealBodyWeight(170, 'M'));
		assertDoesNotThrow(() -> c.idealBodyWeight(170, 'W'));
		// Act & Assert (basalMetabolicRate):
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, 'M'));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, 'W'));
	}

	@Test
	@DisplayName("Test de peso inválido")
	public void testInvalidWeight(){
		// Arrange
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert:
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(2, 170, 25, 'M'));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(450, 170, 25, 'M'));
	}

	@Test
	@DisplayName("Test de peso válido")
	public void testValidWeight(){
		// Arrange
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert:
		assertDoesNotThrow(()-> c.basalMetabolicRate(20, 170, 25, 'M'));
		assertDoesNotThrow(()-> c.basalMetabolicRate(150, 170, 25, 'M'));
	}

	@Test
	@DisplayName("Test de edad inválida")
	public void testInvalidAge(){
		// Arrange
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert:
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 0, 'M'));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 130, 'M'));
	}

	@Test
	@DisplayName("Test de edad válida")
	public void testValidAge(){
		// Arrange
		HealthCalcImpl c = new HealthCalcImpl();
		// Act & Assert:
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, 'M'));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 50, 'M'));
	}

}
