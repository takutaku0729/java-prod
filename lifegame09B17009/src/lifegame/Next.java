package lifegame;
import java.awt.event.*;

public class Next implements ActionListener{
	BoardModel getmodel;
	BoardView getview;
	public Next(BoardModel model, BoardView view) {
		getmodel = model;
		getview = view;
	}
	public void actionPerformed(ActionEvent e) {
		getmodel.next();
		getview.repaint();
	}
}
