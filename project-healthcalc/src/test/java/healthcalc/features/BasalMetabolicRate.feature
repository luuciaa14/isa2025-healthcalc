Feature: Basal Metabolic Rate Calcualtion

	As a health calculator user
	I want to calculate a person's basal metabolic rate based on their weight, height, age and gender
	So that I can determine the number of calories I need to mantain my body at rest

	SCENARIO 1: Calculate BMR for a male
	Given the user has entered their weight (70kg), height (175cm), age (30 years) and gender (M)
	When the system calculates the basal metabolic rate
	Then the system should display a BMR of 1.786 kcal/day using the Harris-benedict formula

	SCENARIO 2: Calculate BMR for a female
	Given the user has entered their weight (60kg), height (160cm), age (28 years) and gender (W)
	When the system calculates the basal metabolic rate
	Then the system should display a BMR of 1.414 kcal/day using the Harris-benedict formula

	SCENARIO 3: Error due to invalid weight
	Given the user has entered an invalid weight (1kg)
	When the system attempts to calculate the basal metabolic rate
	Then the system should throw an exception with the message "El peso debe estar entre 3kg y 400kg"

	SCENARIO 4: Error due to invalid height
	Given the user has entered an invalid height (10cm)
	When the system attempts to calculate the basal metabolic rate
	Then the system should throw an exception with the message "La altura debe estar entre 30cm y 250cm"

	SCENARIO 5: Error due to invalid age
	Given the user has entered an invalid age (0 years)
	When the system attempts to calculate the basal metabolic rate
	Then the system should throw an exception with the message "La edad debe estar entre 1 año y 120 años"

	SCENARIO 6: Error due to invalig gender
	Given the user has entered an invalid gender (X)
	When the system attempts to calculate the basal metabolic rate
	Then the system should throw an exception with the message "El género debe ser M para hombres o W para mujeres. Revise mayúsculas"
