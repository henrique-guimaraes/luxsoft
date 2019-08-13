package luxsoft.identifies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Modulo;

@RunWith(SpringRunner.class)
public class ModuloTest {

	@InjectMocks
	private Modulo modulo;

	@Test
	public void testForInvalidExpression1() {
		assertEquals(null, modulo.identifies("a%"));
	}

	@Test
	public void testForInvalidExpression2() {
		assertEquals(null, modulo.identifies("1%"));
	}

	@Test
	public void testForInvalidExpression3() {
		assertEquals(null, modulo.identifies("%a"));
	}

	@Test
	public void testForInvalidExpression4() {
		assertEquals(null, modulo.identifies("%5%"));
	}

	@Test
	public void testForInvalidExpression5() {
		assertEquals(null, modulo.identifies("+5"));
	}

	@Test
	public void testForInvalidExpression6() {
		assertEquals(null, modulo.identifies("*5"));
	}

	@Test
	public void testForInvalidExpressionUndo() {
		assertEquals(null, modulo.identifies("Undo"));
	}

	@Test
	public void testForInvalidExpressionQuit() {
		assertEquals(null, modulo.identifies("Quit"));
	}

	@Test
	public void testForValidExpression() {
		assertNotNull(modulo.identifies("%5"));
	}
}