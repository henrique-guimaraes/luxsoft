package luxsoft.operates;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Multiplies;
import luxsoft.inputs.ResultsList;

@RunWith(SpringRunner.class)
public class MultipliesOperationTest {

	@InjectMocks
	private Multiplies multiplies;

	@Test
	public void test() {
		ResultsList.init("20;1;4;9");
		multiplies.operates("*5");
		assertEquals(2, ResultsList.get().size());
		assertEquals("100;5;20;45;", ResultsList.getCurrentResult());
	}
}