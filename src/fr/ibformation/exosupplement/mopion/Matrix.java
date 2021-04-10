package fr.ibformation.exosupplement.mopion;

public class Matrix {
	char[][] matrix  ;
	int countFullCell;

	public Matrix() {
		 this.matrix =new char[3][3] ;
		 this.countFullCell = 0;
	}

	
	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix ;
	}
	
	

	public int getCountFullCell() {
		return countFullCell;
	}


	public void setCountFullCell(int countFullCell) {
		this.countFullCell = countFullCell;
	}


	@Override
	public String toString() {

		StringBuilder arrayAsString = new StringBuilder();
		arrayAsString.append("----1----2----3--\n");
		for ( int i = 0 ; i <= 2 ; i++ ) {
			arrayAsString.append( (i + 1) + " " );
			for (int j = 0 ; j <= 2 ; j++) {
				arrayAsString.append("| " + matrix[i][j] + " |");
			}
			arrayAsString.append("\n-----------------\n");
		}
		return arrayAsString.toString();
	}

	
	
	
	
	
	

}
