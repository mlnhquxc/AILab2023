package Lab6_HillClimbing_SA_8Queens;

public class Queen implements Cloneable{
	private int row;
	private int column;

	public Queen(int row, int column){
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		row++;
		if(row==Node.N) {
			row=0;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Queen(row, column);
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		if(row==q.getRow()) return true;
		if(column==q.getColumn()) return true;
		if(Math.abs(row-q.getRow())==Math.abs(column-q.getColumn())) return true;
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
