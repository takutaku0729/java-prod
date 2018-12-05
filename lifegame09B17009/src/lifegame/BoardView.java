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
		int cellsize;
		
		if((xlen/rows*cols)<ylen) {	//横いっぱい
			cellsize = xlen/rows;
			for(int i = 0; i<(rows+1); i++) {//縦線
				g.drawLine(cellsize*i, (ylen-cellsize*cols)/2,cellsize*i, cellsize*cols+(ylen-cellsize*cols)/2);
			}
			for(int i = 0; i<(cols+1); i++) { //横線
				g.drawLine(0, cellsize*i+(ylen-cellsize*cols)/2, cellsize*rows,cellsize*i+(ylen-cellsize*cols)/2);
			}
		}else {
			cellsize = ylen/cols; //縦いっぱい
			for(int i = 0; i<(rows+1); i++) {//縦線
				g.drawLine(cellsize*i+(xlen-cellsize*rows)/2, 0, cellsize*i+(xlen-cellsize*rows)/2, cellsize*cols);
			}
			for(int i = 0; i<(cols+1); i++) { //横線
				g.drawLine((xlen-cellsize*rows)/2, cellsize*i, cellsize*rows+(xlen-cellsize*rows)/2, cellsize*i);
			}
		}
		
		/*
		
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
		*/
	}
	
}
