package lifegame;
import java.awt.event.*;

import javax.swing.SwingUtilities;

public class NewGame implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Main());
		
	}

}
