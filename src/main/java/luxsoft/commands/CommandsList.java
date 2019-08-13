package luxsoft.commands;

import java.util.ArrayList;
import java.util.List;

import luxsoft.commands.types.Adds;
import luxsoft.commands.types.Modulo;
import luxsoft.commands.types.Multiplies;
import luxsoft.commands.types.Quit;
import luxsoft.commands.types.Undo;

public class CommandsList {

	private CommandsList() {}

	private static List<Command> commands;

	public static void init() {
		commands = new ArrayList<>();
		commands.add(new Adds());
		commands.add(new Modulo());
		commands.add(new Multiplies());
		commands.add(new Quit());
		commands.add(new Undo());
	}

	public static List<Command> get() {
		return commands;
	}
}