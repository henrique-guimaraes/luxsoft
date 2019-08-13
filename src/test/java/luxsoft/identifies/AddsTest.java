package luxsoft.identifies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Adds;

@RunWith(SpringRunner.class)
public class AddsTest {

	@InjectMocks
	private Adds adds;

	@Test
	public void testForInvalidExpression1() {
		assertEquals(null, adds.identifies("a+"));
	}

	@Test
	public void testForInvalidExpression2() {
		assertEquals(null, adds.identifies("1+"));
	}

	@Test
	public void testForInvalidExpression3() {
		assertEquals(null, adds.identifies("+a"));
	}

	@Test
	public void testForInvalidExpression4() {
		assertEquals(null, adds.identifies("+3+"));
	}

	@Test
	public void testForInvalidExpression5() {
		assertEquals(null, adds.identifies("%3"));
	}

	@Test
	public void testForInvalidExpression6() {
		assertEquals(null, adds.identifies("*3"));
	}

	@Test
	public void testForInvalidExpressionUndo() {
		assertEquals(null, adds.identifies("Undo"));
	}

	@Test
	public void testForInvalidExpressionQuit() {
		assertEquals(null, adds.identifies("Quit"));
	}

	@Test
	public void testForValidExpression() {
		assertNotNull(adds.identifies("+3"));
	}
}