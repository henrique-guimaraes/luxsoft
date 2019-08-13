package luxsoft.commands.types;

import luxsoft.commands.Command;
import luxsoft.constants.Commands;
import luxsoft.inputs.UserInputs;

public class Quit implements Command {

	@Override
	public void operates(String input) {
		UserInputs.exit();
		System.exit(0);
	}

	@Override
	public Command identifies(String input) {
		if (Commands.QUIT.equalsIgnoreCase(input))
			return this;

		return null;
	}
}