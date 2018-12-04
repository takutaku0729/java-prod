package lifegame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class BoardView extends JPanel {
	BoardModel view;
	int cols,rows;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BoardView(BoardModel board) {
		view = board;
		cols = view.getCols();
		rows = view.getRows();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		int xlen = this.getWidth();
		int ylen = this.getHeight();
		int centeringx = (xlen-ylen)/2;
		int centeringy = (ylen-xlen)/2;
		if(xlen >= ylen) {
			for(int i = 0; i<(rows+1); i++) {
				g.drawLine((ylen/rows)*i+centeringx, 0, (ylen/rows)*i+centeringx, (ylen/cols)*cols);
			}
			for(int i = 0; i<(cols+1); i++) {
				g.drawLine(centeringx, (ylen/cols)*i, (ylen/rows)*rows+centeringx,(ylen/cols)*i);
			}
		}else {
			for(int i = 0; i<11; i++) {
				g.drawLine((xlen/rows)*i, centeringy, (xlen/rows)*i, (xlen/cols)*cols+centeringy);
			}
			for(int i = 0; i<11; i++) {
				g.drawLine(0, (xlen/cols)*i+centeringy, (xlen/rows)*rows,(xlen/cols)*i+centeringy);
			}
		}
		for(int i = 0; i < cols; i++) {
			for(int j = 0; j<rows; j++) {
				if(view.isAlive(i,j)==true) {
					if(xlen>=ylen) {
						g.fillRect((ylen/rows)*i+centeringx, (ylen/cols)*j, ylen/rows, ylen/cols);
					}
					else {
						g.fillRect((xlen/rows)*i, (xlen/cols)*j+centeringy, xlen/rows, xlen/cols);
					}
				}
			}
		}
	}
	
}
