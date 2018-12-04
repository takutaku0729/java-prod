package lifegame;
import javax.swing.JButton;

public class Undoable implements BoardListener {
	JButton undo;
	public Undoable(JButton tmp){
		undo = tmp;
	}
	public void updated(BoardModel m) {
		undo.setEnabled(m.isUndoable());
	}

}
