package luxsoft.operates;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import luxsoft.commands.types.Adds;
import luxsoft.inputs.ResultsList;

@RunWith(SpringRunner.class)
public class AddOperationTest {

	@InjectMocks
	private Adds adds;

	@Test
	public void test() {
		ResultsList.init("33;44;3");
		adds.operates("+4");
		assertEquals(2, ResultsList.get().size());
		assertEquals("37;48;7;", ResultsList.getCurrentResult());
	}
}