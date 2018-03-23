package T7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
	
	int rows,columns;
	public enum Cell{WALL,OPEN,CORRECT,VISITED};
	private Position currentP,goal;
	Cell[][] mazeMatrix;
	
	
	public Maze(){
		try{
			BufferedReader in = new BufferedReader(
                                new FileReader("src/T7/Labyrint.txt"));
			rows = Integer.parseInt(in.readLine())+2;
			columns = Integer.parseInt(in.readLine())+2;
			mazeMatrix = new Cell[rows][columns];
			for(int j=0;j<columns;j++){
				mazeMatrix[0][j] = Cell.WALL;
				mazeMatrix[rows-1][j] = Cell.WALL;
			}
			for(int i=1;i<rows-1;i++){
				mazeMatrix[i][0] = Cell.WALL;
				mazeMatrix[i][columns-1] = Cell.WALL;
			}
			for(int i=1;i<rows-1;i++){
				String s = in.readLine();
				for(int j=1;j<columns-1;j++){
					mazeMatrix[i][j]=Cell.OPEN;
					if(s.charAt(j-1)=='*')
						mazeMatrix[i][j]=Cell.WALL;
					else if(s.charAt(j-1)=='g'){
						goal = new Position(i,j);
					}
					else if(s.charAt(j-1)=='s'){
						currentP = new Position(i,j);
					}
				}
			}
			in.close();
		}catch(IOException e){
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	private class Position{
		int row,column;
		public Position(int r, int c){
			row=r;
			column=c;
		}
		
		public boolean equals(Position p){
			return (row==p.row&&column==p.column);
		}
	}
	
	public boolean solve(){
		return solve(currentP);
	}
	
        /**
         * Recursive method solve() to find a path through.
         * pre: Possible path cells are represented by Cell.OPEN: 1;
         *      walls are represented by Cell.WALL: 0
         * post: If a path is found, all cells on it are set to Cell.CORRECT: 2;
         *      all cells that were visited but not on the path are set to Cell.VISITED: 3.
         * @param p The current position by (Cell[][]) mazeMatrix[i][j].
         * @return true if a path through mazeMatrix[i][j] is found; otherwise, false.
         */
	private boolean solve(Position p){
		// Algoritm for finding the goal from cell p.
                if (p.row < 0 || p.column < 0
                        || p.row > rows || p.column > columns) {
                    // Cell is out of bounds.
                    return false;
                } else if (mazeMatrix[p.row][p.column] != Cell.OPEN) {
                    // Cell is on wall or dead end.
                    return false;
                } else if (p.equals(goal)) {  
                    // Now current p is at the brim of maze.
                    // Cell is on the path and is maze exit.
                    mazeMatrix[p.row][p.column] = Cell.CORRECT;
                    return true;
                } else {
                    // Tentatively mark cell as on path.
                    mazeMatrix[p.row][p.column] = Cell.CORRECT;
                    //Attempt to find a path from each neighbor cell.
                    /**
                     * p can not go diagonally, so:
                     * _|*|_
                     * *|p|*
                     * -|*|-
                     */
                    Position up = new Position(p.row - 1, p.column);
                    Position down = new Position(p.row + 1, p.column);
                    Position left = new Position(p.row, p.column - 1);
                    Position right = new Position(p.row, p.column + 1);
                    
                    if (solve(up) || solve(down) || solve(left) || solve(right)) {
                        return true;
                    } else {
                        // Dead end.
                        // Reset the cell from temporary CORRECT to VISITED.
                         mazeMatrix[p.row][p.column] = Cell.VISITED;
                         return false;
                    }
                }
	}
	
	public void print(){
		for(int i=1;i<rows-1;i++){
			for(int j=1;j<columns-1;j++)
				System.out.print(mazeMatrix[i][j].ordinal());
			System.out.println();
		}
	}
}
