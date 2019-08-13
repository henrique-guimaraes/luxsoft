package luxsoft.identifies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Quit;

@RunWith(SpringRunner.class)
public class QuitTest {

	@InjectMocks
	private Quit quit;

	@Test
	public void testForInvalidExpression1() {
		assertEquals(null, quit.identifies("a*"));
	}

	@Test
	public void testForInvalidExpression2() {
		assertEquals(null, quit.identifies("13*"));
	}

	@Test
	public void testForInvalidExpression3() {
		assertEquals(null, quit.identifies("*a"));
	}

	@Test
	public void testForInvalidExpression4() {
		assertEquals(null, quit.identifies("*13*"));
	}

	@Test
	public void testForInvalidExpression5() {
		assertEquals(null, quit.identifies("+43"));
	}

	@Test
	public void testForInvalidExpression6() {
		assertEquals(null, quit.identifies("%44"));
	}

	@Test
	public void testForInvalidExpression7() {
		assertEquals(null, quit.identifies("*143"));
	}

	@Test
	public void testForInvalidExpressionUndo() {
		assertEquals(null, quit.identifies("Undo"));
	}

	@Test
	public void testForInvalidExpressionQuit1() {
		assertEquals(null, quit.identifies("Quita"));
	}

	@Test
	public void testForInvalidExpressionQuit2() {
		assertEquals(null, quit.identifies("Qui"));
	}

	@Test
	public void testForInvalidExpressionQuit3() {
		assertEquals(null, quit.identifies("Qui t"));
	}

	@Test
	public void testForValidExpression() {
		assertNotNull(quit.identifies("Quit"));
	}

	@Test
	public void testForValidExpression2() {
		assertNotNull(quit.identifies("quit"));
	}

	@Test
	public void testForValidExpression3() {
		assertNotNull(quit.identifies("QUIT"));
	}

	@Test
	public void testForValidExpression4() {
		assertNotNull(quit.identifies("QuIt"));
	}
}