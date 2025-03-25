Featue: Ideal Weight Calculation

	As a health calculator user
	I want to calcualte a person's ideal weight based on their height and gender
	So that I can determine if my weight is healthy according to the Lorentz formula

	SCENARIO 1: Calculate ideal weight for a male
	Given the user has entered thei height (180cm) and gender (M)
	When the system calculates the ideal weight
	Then the system should display an ideal weight of 80kg according to the Lorentz formula

	SCENARIO 2: Calculate ideal weight for a female
	Given the user has entered thei height (165cm) and gender (W)
	When the system calculates the ideal weight
	Then the system should display an ideal weight of 62.5kg according to the Lorentz formula

	SCENARIO 3: Error due to invalid height
	Given the user has entered an invalid height (20cm)
	When the system attemts to calculate the ideal weight
	Then the system should throw an exception with the message "La altura debe estar entre 30cm y 250cm"

	SCENARIO 4: Error due to invalid gender
	Given the user has enteres an invalid gender (X)
	When the system attempts to calculate the ideal weight
	Then the system should throw an exception with the message "El género debe ser M para hombres o W para mujeres. Revise mayúsculas"
