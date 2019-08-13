package luxsoft.validations;

import luxsoft.exceptions.InvalidInputException;

public interface InputValidation {
	public void validate(String input) throws InvalidInputException;
}