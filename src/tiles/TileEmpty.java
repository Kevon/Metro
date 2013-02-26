package tiles;

import code.Board;

/*
 * TileEmpty is the default value of all the board's tiles, signifying a blank space
 * All of its methods are designed to inform the board that there is nothing in its x y position
 */


public class TileEmpty implements Tile{
	
	Board _board;
	
	public TileEmpty(Board b){
		_board = b;
	}

	/*
	 * Ordinarily this method would return the array value that the next tile should start with when determining its connections
	 * This value would be passed to the board which would then pass it to a new tile, but this method is designed to tell the board to stop, which it will recognize
	 */
	public int connectEdge(int i) {
		return 8;
	}

	/*
	 */
	public int callToBoard(int i, int pts, int x, int y) {
		return _board.returnPoints(0);
	}
	/*For any tile type, a certain edge "i" will always correspond to a specific edge of a tile adjacent to it, and this method creates that relationship.
	 */
	public int correspond(int i) {
		if(i == 0){
			return 5;
		}
		if(i == 1){
			return 4;
		}
		if(i == 2){
			return 7;
		}
		if(i == 3){
			return 6;
		}
		if(i == 4){
			return 1;
		}
		if(i == 5){
			return 0;
		}
		if(i == 6){
			return 3;
		}
		if(i == 7){
			return 2;
		}
		//The method wants a return statement in the event that i is some number not specified by one of the if statements, but the code doesn't allow for that, so this return line should never be read. 
		return 55555;
	}

	/*
	 * This method does not need to be used for this type of tile.
	 */
	public int newX(int j, int x) {
		return 0;
	}
	/*
	 * This method does not need to be used for this type of tile.
	 */
	public int newY(int j, int y) {
		return 0;
	}

	@Override
	public char getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLegal() {
		// TODO Auto-generated method stub
		return null;
	}
}