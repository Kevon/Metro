package code;
/*
 * Station is a simple class used to represent the "stations" on the board
 * It holds which player it belongs to, the x and y position of the tile it is touching, and the exact edge (and side of that edge) of that tile that it is touching
 * It also holds a boolean that keeps track of whether or not it has been completed
 */
public class Station {
	
	int _player;
	int _tileX;
	int _tileY;
	int _tileAry;
	boolean _completed;
	
	public Station(int pl, int x, int y, int ary){
		_player=pl;
		_tileX=x;
		_tileY=y;
		_tileAry=ary;
		_completed = false; 
	}
	/*
	 * will return either 1 or 2, indicating which player it belongs to
	 */
	public int getPlayer(){
		return _player;
	}
	/*
	 * Will return the x position of the tile it is touching
	 */
	public int getX(){
		return _tileX;
	}
	/*
	 * Will return the y position of the tile it is touching
	 */
	public int getY(){
		return _tileY;
	}
	/*
	 * will return an int that indicates what its "output" is
	 * The value will be the position of an array that the tile will recognize as one of its side segments
	 */
	public int getAry(){
		return _tileAry;
	}
	/*
	 * This changes the stations "completed" value to true, which means that it is a completed line
	 * This ensures that its points will not be counted again after the time it was completed
	 */
	public void complete(){
		_completed = true;
	}
	/*
	 * This returns whether or not the station has been completed so the game knows whether or not to check for points on that line
	 */
	public boolean checkComplete(){
		return _completed;
	}

}
