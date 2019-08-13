package luxsoft.operates;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Adds;
import luxsoft.commands.types.Undo;
import luxsoft.inputs.ResultsList;

@RunWith(SpringRunner.class)
public class UndoOperationTest {

	@InjectMocks
	private Undo undo;

	@InjectMocks
	private Adds adds;

	@Test
	public void test() {
		ResultsList.init("20;1;4;9");
		adds.operates("+5");
		assertEquals(2, ResultsList.get().size());
		assertEquals("25;6;9;14;", ResultsList.getCurrentResult());

		undo.operates("Undo");
		assertEquals(1, ResultsList.get().size());
		assertEquals("20;1;4;9", ResultsList.getCurrentResult());
	}
}