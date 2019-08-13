package luxsoft.constants;

import luxsoft.inputs.ResultsList;

public class Exceptions {
	private Exceptions() {}

	public static final String INVALID_INPUT = "Invalid input. The system can only operate with numbers separated by semicolons. (Example: 43;4;2) \n";
	public static final String INVALID_UNDOING = "You have already done all possible reverts. There is only one element in List: "+ ResultsList.getCurrentResult();
	public static final String INVALID_OPERATION = "This operation is invalid.";
}