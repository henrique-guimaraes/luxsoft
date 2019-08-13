package luxsoft.inputs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import luxsoft.constants.Exceptions;
import luxsoft.exceptions.InvalidOperationException;

public class ResultsList {

	private ResultsList() {}

	private static List<String> results;

	public static void init(String initialInput) {
		results = new ArrayList<>();
		ResultsList.add(initialInput);
	}

	public static List<String> get() {
		return results;
	}

	public static void add(String input) {
		results.add(input);
	}

	public static void removeLast() {
		throwExeptionIfOnlyInitialInputInList();
		results.remove(results.size() - 1);
	}

	public static String getCurrentResult() {
		return results.get(results.size() - 1);
	}

	public static List<String> getCurrentResultByValuesList() {
		String[] semicolonSeparatedArray = ResultsList.getCurrentResult().split("\\s*;\\s*");
		return Arrays.stream(semicolonSeparatedArray).collect(Collectors.toList());
	}

	public static void throwExeptionIfOnlyInitialInputInList() {
		if (results.size() == 1)
			throw new InvalidOperationException(Exceptions.INVALID_UNDOING);
	}
}