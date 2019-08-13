package luxsoft.inputs;

import java.util.Objects;
import java.util.Scanner;

import luxsoft.constants.SystemMessages;

public class UserInputs {

	private UserInputs() {}

	private static Scanner scan;

	public static String getUserFirstInput() {
		System.out.println(SystemMessages.INPUT_INSTRUCTIONS);
		if (Objects.isNull(scan))
			scan = new Scanner(System.in);

		return getInput();
	}

	public static String getUserOperationInput() {
		System.out.println(SystemMessages.COMMANDS_INSTRUCTIONS);
		return getInput();
	}

	private static String getInput() {

		return scan.nextLine();
	}

	public static void exit() {
		scan.close();
	}
}