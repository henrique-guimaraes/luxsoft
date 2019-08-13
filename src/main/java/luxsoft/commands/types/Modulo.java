package luxsoft.commands.types;

import java.util.List;

import luxsoft.commands.Command;
import luxsoft.constants.Commands;
import luxsoft.constants.RegexExpressions;
import luxsoft.inputs.ResultsList;

public class Modulo implements Command {

	@Override
	public void operates(String input) {

		StringBuilder newResultSb = new StringBuilder();
		List<String> lastResult = ResultsList.getCurrentResultByValuesList();

		for (int i = 0; i < lastResult.size(); i++) {
			newResultSb.append(String.valueOf(
							Integer.valueOf(lastResult.get(i)) % 
							Integer.valueOf(input.substring(1, input.length())))).append(";");
		}
		ResultsList.add(newResultSb.toString());
	}

	@Override
	public Command identifies(String input) {
		if (input.charAt(0) == Commands.MODULO
				&& input.substring(1, input.length()).matches(RegexExpressions.MATCHES_ONLY_NUMBERS))
			return this;

		return null;
	}
}