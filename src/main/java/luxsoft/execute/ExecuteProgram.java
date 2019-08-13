package luxsoft.execute;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import luxsoft.commands.CommandsList;
import luxsoft.constants.Exceptions;
import luxsoft.exceptions.InvalidOperationException;
import luxsoft.inputs.ResultsList;
import luxsoft.inputs.UserInputs;
import luxsoft.validations.ValidateInput;

@Component
public class ExecuteProgram {

	@Autowired
	private ValidateInput validate;

	public void execute(String initialInput) {
		try {
			validate.validate(initialInput);
			ResultsList.init(initialInput);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			this.execute(UserInputs.getUserFirstInput());
		}
		while (true) {
			executeOperations();
		}
	}

	private void executeOperations() {

		try {
			String operationInput = UserInputs.getUserOperationInput();

			CommandsList.get().stream()
						.filter(c -> Objects.nonNull(c.identifies(operationInput)))
						.findFirst()
						.orElseThrow(() -> new InvalidOperationException(Exceptions.INVALID_OPERATION))
						.operates(operationInput);

			System.out.println(ResultsList.getCurrentResult());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}