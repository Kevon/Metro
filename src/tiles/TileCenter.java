package tiles;

import code.Board;

/*
 * this is a class that represents the center stations just to allow the game to know that tiles can't be placed in those positions.  Its methods do nothing and are never called.
 */
public class TileCenter implements Tile {

	public TileCenter(Board b){
		
	}
	@Override
	public int connectEdge(int i) {
		return 0;
	}

	@Override
	public int callToBoard(int i, int pts, int x, int y) {
		return 0;
	}

	@Override
	public int correspond(int i) {
		return 0;
	}

	@Override
	public int newX(int j, int x) {
		return 0;
	}

	@Override
	public int newY(int j, int y) {
		return 0;
	}

	@Override
	public char getType() {
		return 0;
	}

	@Override
	public String getLegal() {
		// TODO Auto-generated method stub
		return null;
	}

}
