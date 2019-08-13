package luxsoft.commands.types;

import luxsoft.commands.Command;
import luxsoft.constants.Commands;
import luxsoft.inputs.ResultsList;

public class Undo implements Command {

	@Override
	public void operates(String input) {
		ResultsList.removeLast();
	}

	@Override
	public Command identifies(String input) {
		if (Commands.UNDO.equalsIgnoreCase(input))
			return this;

		return null;
	}
}