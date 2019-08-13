package luxsoft.validations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.exceptions.InvalidInputException;

@RunWith(SpringRunner.class)
public class ValidateInputTest {

	@InjectMocks
	private ValidateInput validate;

	@Test(expected = InvalidInputException.class)
	public void testForNotAllowingCommas() {
		validate.validate("34,3");
	}

	@Test(expected = InvalidInputException.class)
	public void testForNotAllowingLetters() {
		validate.validate("34a;3");
	}

	@Test(expected = InvalidInputException.class)
	public void testForNotAllowingSpecialCaracters() {
		validate.validate("34&;3");
	}

	@Test
	public void testForAllowingOnlyNumbersSeparatedBySemicolons() {
		validate.validate("34;3");
	}
}