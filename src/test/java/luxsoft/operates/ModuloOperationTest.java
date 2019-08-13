package luxsoft.operates;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Modulo;
import luxsoft.inputs.ResultsList;

@RunWith(SpringRunner.class)
public class ModuloOperationTest {

	@InjectMocks
	private Modulo modulo;

	@Test
	public void test() {
		ResultsList.init("4;5;6;7");
		modulo.operates("%3");
		assertEquals(2, ResultsList.get().size());
		assertEquals("1;2;0;1;", ResultsList.getCurrentResult());
	}
}