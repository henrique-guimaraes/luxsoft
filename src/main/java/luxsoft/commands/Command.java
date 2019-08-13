package luxsoft.commands;

public interface Command {
	abstract void operates(String input);
	abstract Command identifies(String input);
}