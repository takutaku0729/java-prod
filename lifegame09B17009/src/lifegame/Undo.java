package lifegame;
import java.awt.event.*;

public class Undo implements ActionListener {
	BoardModel getmodel;
	BoardView getview;
	public Undo(BoardModel model, BoardView view) {
		getmodel = model;
		getview = view;
	}
	public void actionPerformed(ActionEvent e) {
		getmodel.undo();
		getview.repaint();
	}

}
