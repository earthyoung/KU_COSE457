package controller;

public class CanvasInvoker {

	private Command command;
	
	public void setCommand(Command command) {
		this.command=command;
	}
	public void runCommand() {
		command.execute();
	}
}
