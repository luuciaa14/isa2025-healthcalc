package healthcalc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")
public class HealthCalcTest {

	@Test
	@DisplayName("Test de altura fuera del rango establecido")
	public void testInvalidHeightException(){
		// Arrange:
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		// Act & Assert (idealBodyWeight):
		assertThrows(IllegalArgumentException.class, () -> c.idealWeight(20, Gender.MALE));
		assertThrows(IllegalArgumentException.class, () -> c.idealWeight(270, Gender.MALE));
		// Act & Assert (basalMetabolicRate):
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 20, 25, Gender.MALE));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 270, 25, Gender.MALE));
	}

	@Test
	@DisplayName("Test de altura dentro del rango establecido")
	public void testValidHeightException(){
		// Arrange:
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		// Act & Assert (idealBodyWeight):
		assertDoesNotThrow(() -> c.idealWeight(30, Gender.MALE));
		assertDoesNotThrow(() -> c.idealWeight(170, Gender.MALE));
		assertDoesNotThrow(() -> c.idealWeight(250, Gender.MALE));
		// Act & Assert (basalMetabolicRate):
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 30, 25, Gender.MALE));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, Gender.MALE));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 250, 25, Gender.MALE));
	}

	@Test
	@DisplayName("Test de género no válido")
	public void testInvalidGender(){
		// Arrange:
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		
	}

	@Test
	@DisplayName("Test de género válido")
	public void testValidGender(){
		// Arrange
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		// Act & Assert (idealBodyWeight):
		assertDoesNotThrow(() -> c.idealWeight(170, Gender.MALE));
		assertDoesNotThrow(() -> c.idealWeight(170, Gender.FEMALE));
		// Act & Assert (basalMetabolicRate):
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, Gender.MALE));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, Gender.FEMALE));
	}

	@Test
	@DisplayName("Test de peso inválido")
	public void testInvalidWeight(){
		// Arrange
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		// Act & Assert:
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(2, 170, 25, Gender.MALE));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(450, 170, 25, Gender.MALE));
	}

	@Test
	@DisplayName("Test de peso válido")
	public void testValidWeight(){
		// Arrange
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		// Act & Assert:
		assertDoesNotThrow(()-> c.basalMetabolicRate(20, 170, 25, Gender.MALE));
		assertDoesNotThrow(()-> c.basalMetabolicRate(150, 170, 25, Gender.MALE));
	}

	@Test
	@DisplayName("Test de edad inválida")
	public void testInvalidAge(){
		// Arrange
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		// Act & Assert:
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 0, Gender.MALE));
		assertThrows(IllegalArgumentException.class, () -> c.basalMetabolicRate(70, 170, 130, Gender.MALE));
	}

	@Test
	@DisplayName("Test de edad válida")
	public void testValidAge(){
		// Arrange
		HealthCalcImpl c = HealthCalcImpl.getInstancia();
		// Act & Assert:
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 25, Gender.MALE));
		assertDoesNotThrow(() -> c.basalMetabolicRate(70, 170, 50, Gender.MALE));
	}

}
