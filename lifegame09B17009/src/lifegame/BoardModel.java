package lifegame;
import java.util.ArrayList;

public class BoardModel {
	
	private int cols;
	private int rows;
	private boolean[][] cells;
	private ArrayList<BoardListener>listeners;
	private ArrayList<boolean[][]> history;
	
	public BoardModel(int c, int r) {
		cols = c;
		rows = r;
		cells = new boolean[rows][cols];
		history = new ArrayList<boolean[][]>();
		listeners = new ArrayList<BoardListener>();
		
	}
	
	public int getCols() {
		return cols;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void printForDebug() {
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(cells[i][j] == false) {
					System.out.print(".");
				}else if(cells[i][j] == true) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printForDebug2(boolean[][] tmp) {
		for(int i=0;i<tmp.length;i++) {
			for(int j=0;j<tmp[i].length;j++) {
				if(cells[i][j] == false) {
					System.out.print(".");
				}else if(cells[i][j] == true) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void changeCellState(int x,int y) {
		if(cells[y][x] == false) {
			cells[y][x] = true;
		}else {
			cells[y][x] = false;
		}
		this.fireUpdate();
	}
	
	public void addListener(BoardListener listener) {
		listeners.add(listener);
	}
	
	private void fireUpdate() {
		for(BoardListener listener: listeners) {
			listener.updated(this);
		}
	}
	
	public void next() {
		boolean[][] copycells = new boolean[rows][cols];
		this.copy(cells, copycells);
		
		this.addhistory();
		
		for(int y=0; y<rows; y++) {
			for(int x=0; x<cols; x++) {
				if(copycells[y][x] == true) {
					if(this.check(copycells,y,x)<2 || this.check(copycells,y,x)>3) {
						cells[y][x]=false;
					}
				}else {
					if(3==this.check(copycells,y,x)) {
						cells[y][x]=true;
					}
				}
			}
		}
		this.fireUpdate();
	}
	
	public void undo() {
		int n = history.size();
		this.copy(history.get(n-1), cells);
		history.remove(n-1);
		this.fireUpdate();
	}
	
	public boolean isUndoable() {
		if(history.size() == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	private void copy(boolean[][] original,boolean[][] tmp) {
		for(int i=0; i< original.length; i++) {
			System.arraycopy(original[i], 0, tmp[i], 0, original[i].length);
		}
	}
	
	public void addhistory() {
		boolean[][] tmp = new boolean[rows][cols];
		for(int i=0; i< cells.length; i++) {
			System.arraycopy(cells[i], 0, tmp[i], 0, cells[i].length);
		}
	    history.add(tmp);
		if(history.size()>32) {
			history.remove(0);
		}
	}
	
	private int check(boolean[][] checkcells,int y,int x) {
		int count=0;
		for(int i=-1; i<2; i++) {
			if(0<=y+i && y+i<rows) {
				for(int j=-1; j<2; j++) {
					if(0<=x+j && x+j<cols && !(i==0 && j==0) && checkcells[y+i][x+j]==true) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public boolean isAlive(int x, int y) {
		return cells[y][x];
	}
}
