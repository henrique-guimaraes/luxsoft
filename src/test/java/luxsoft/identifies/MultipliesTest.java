package luxsoft.identifies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Multiplies;

@RunWith(SpringRunner.class)
public class MultipliesTest {

	@InjectMocks
	private Multiplies multiplies;

	@Test
	public void testForInvalidExpression1() {
		assertEquals(null, multiplies.identifies("a*"));
	}

	@Test
	public void testForInvalidExpression2() {
		assertEquals(null, multiplies.identifies("13*"));
	}

	@Test
	public void testForInvalidExpression3() {
		assertEquals(null, multiplies.identifies("*a"));
	}

	@Test
	public void testForInvalidExpression4() {
		assertEquals(null, multiplies.identifies("*13*"));
	}

	@Test
	public void testForInvalidExpression5() {
		assertEquals(null, multiplies.identifies("+43"));
	}

	@Test
	public void testForInvalidExpression6() {
		assertEquals(null, multiplies.identifies("%44"));
	}

	@Test
	public void testForInvalidExpressionUndo() {
		assertEquals(null, multiplies.identifies("Undo"));
	}

	@Test
	public void testForInvalidExpressionQuit() {
		assertEquals(null, multiplies.identifies("Quit"));
	}

	@Test
	public void testForValidExpression() {
		assertNotNull(multiplies.identifies("*143"));
	}
}