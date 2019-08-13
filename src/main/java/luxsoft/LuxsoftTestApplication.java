package luxsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import luxsoft.commands.CommandsList;
import luxsoft.execute.ExecuteProgram;
import luxsoft.inputs.UserInputs;

@SpringBootApplication
public class LuxsoftTestApplication implements ApplicationRunner {

	@Autowired
	private ExecuteProgram program;

	public static void main(String[] args) {
		SpringApplication.run(LuxsoftTestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		CommandsList.init();
		program.execute(UserInputs.getUserFirstInput());
	}
}
