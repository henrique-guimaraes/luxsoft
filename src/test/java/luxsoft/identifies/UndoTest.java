package luxsoft.identifies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Undo;

@RunWith(SpringRunner.class)
public class UndoTest {

	@InjectMocks
	private Undo undo;

	@Test
	public void testForInvalidExpression1() {
		assertEquals(null, undo.identifies("a*"));
	}

	@Test
	public void testForInvalidExpression2() {
		assertEquals(null, undo.identifies("13*"));
	}

	@Test
	public void testForInvalidExpression3() {
		assertEquals(null, undo.identifies("*a"));
	}

	@Test
	public void testForInvalidExpression4() {
		assertEquals(null, undo.identifies("*13*"));
	}

	@Test
	public void testForInvalidExpression5() {
		assertEquals(null, undo.identifies("+43"));
	}

	@Test
	public void testForInvalidExpression6() {
		assertEquals(null, undo.identifies("%44"));
	}

	@Test
	public void testForInvalidExpression7() {
		assertEquals(null, undo.identifies("*143"));
	}

	@Test
	public void testForInvalidExpressionUndo() {
		assertEquals(null, undo.identifies("Quit"));
	}

	@Test
	public void testForInvalidExpressionQuit1() {
		assertEquals(null, undo.identifies("Undo o"));
	}

	@Test
	public void testForInvalidExpressionQuit2() {
		assertEquals(null, undo.identifies("Und"));
	}

	@Test
	public void testForInvalidExpressionQuit3() {
		assertEquals(null, undo.identifies("Und o"));
	}

	@Test
	public void testForValidExpression() {
		assertNotNull(undo.identifies("Undo"));
	}

	@Test
	public void testForValidExpression2() {
		assertNotNull(undo.identifies("undo"));
	}

	@Test
	public void testForValidExpression3() {
		assertNotNull(undo.identifies("UNDO"));
	}

	@Test
	public void testForValidExpression4() {
		assertNotNull(undo.identifies("Undo"));
	}
}