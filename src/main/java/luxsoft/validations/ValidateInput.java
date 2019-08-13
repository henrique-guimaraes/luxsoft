package luxsoft.validations;

import org.springframework.stereotype.Component;

import luxsoft.constants.Exceptions;
import luxsoft.constants.RegexExpressions;
import luxsoft.exceptions.InvalidInputException;

@Component
public class ValidateInput implements InputValidation {

	@Override
	public void validate(String input) throws InvalidInputException {
		if (onlyNumbersAndSemicolons(input))
			throw new InvalidInputException(Exceptions.INVALID_INPUT);
	}

	private boolean onlyNumbersAndSemicolons(String input) {
		return !input.matches(RegexExpressions.MATCHES_ONLY_NUMBERS_AND_SEMICOLONS);
	}
}