package controller;

import javax.swing.JOptionPane;

public class CanvasInvoker {

	private Command command;
	
	public void setCommand(Command command) {
		this.command=command;
	}
	public void runCommand() {
		EditorArea.getInstance().undoList.push(command);
		command.execute();
	}
	
	public void undo() {
    	if (!EditorArea.getInstance().undoList.isEmpty()) {
    		Command cmd=EditorArea.getInstance().undoList.pop();
    		cmd.unexecute();
    		EditorArea.getInstance().redoList.push(cmd);
    	}else {
            JOptionPane.showMessageDialog(null, "모두 실행 취소되었습니다.");
        }
    }
    
    public void redo() {
    	if (!EditorArea.getInstance().redoList.isEmpty()) {
    		Command cmd=EditorArea.getInstance().redoList.pop();
    		cmd.execute();
    		EditorArea.getInstance().undoList.push(cmd);
    	}else {
            JOptionPane.showMessageDialog(null, "모두 실행되었습니다.");
        }
    }
	
}
