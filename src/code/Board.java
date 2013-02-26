package code;
import java.util.NoSuchElementException;

import tiles.Tile;
import tiles.TileCenter;
import tiles.TileEmpty;


/*The Board keeps track of tiles and their locations and is responsible for connecting lines of tiles
 *The board's array stars with all values set to TileEmpty's
 */
public class Board {
	
	public boolean _tileIsLegal = false;
	Tile[][] _board;
	int _currentX;
	int _currentY;
	
	public Board(){
		
		_board = new Tile[14][14];
		for(int x = 1 ; x<13 ; x++){
			for(int y = 1 ; y<13 ; y++){
				_board[x][y] = new TileEmpty(this);
			}
		}
		_board[6][6] = new TileCenter(this);
		_board[6][7] = new TileCenter(this);
		_board[7][6] = new TileCenter(this);
		_board[7][7] = new TileCenter(this);
	}
	/*
	 * The boolean tileIsLegal keeps track of whether or not the current tile placement is in accordance with the rules
	 * This method returns its value so that the Game class can know whether or not it can commit that current placement
	 */
	public boolean checkLegalTile(){
		return _tileIsLegal;
	}
	
	/*This method places a given tile at the given x and y position if and only if the x and y values are actual board positions and the tile already there is empty
	 * The method then checks whether or not that placement was a legal move or not, stores that information so that the game knows whether or not it can commit that move
	 * It returns true if the tile was successfully placed, even if it was an illegal placement, and returns false if the tile was not place(i.e. there was already a tile there or the given x and y were not legitimate values)
	 */
	public boolean placeTile(int x, int y, Tile tile) {
		TileEmpty empty = new TileEmpty(this);
		if(x>0 && x<13 && y>0 && y <13 && (!(x==6&&y==6)) && (!(x==6&&y==7)) && (!(x==7&&y==6)) && (!(x==7&&y==7))){
			if(tileAt(x,y).getClass().equals(empty.getClass())){
				_board[x][y]=tile;
				_currentX = x;
				_currentY = y;
				setTileIsLegal(x, y, tile);
				
				return true;
			}
		}
		return false;
	}
	
	private void setTileIsLegal(int x, int y, Tile t){
		if((x==1||x==12||y==1||y==12)){
			
			if(y==1 && x>1 && x<12){
				if(t.getLegal().charAt(0)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) && (t.getLegal().charAt(1)=='0' || eastWallCheck()) && (t.getLegal().charAt(2)=='0' || southWallCheck()) && (t.getLegal().charAt(3)=='0' || westWallCheck()) && (t.getLegal().charAt(6)=='0' || southEastCheck()) && (t.getLegal().charAt(7)=='0' || southWestCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
			
			if(x==12 && y>1 && y<12){
				if(t.getLegal().charAt(1)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) && (t.getLegal().charAt(0)=='0' || northWallCheck()) && (t.getLegal().charAt(2)=='0' || southWallCheck()) && (t.getLegal().charAt(3)=='0' || westWallCheck()) && (t.getLegal().charAt(4)=='0' || northWestCheck()) && (t.getLegal().charAt(7)=='0' || southWestCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
			
			if(y==12 && x>1 && x<12){
				if(t.getLegal().charAt(2)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) &&(t.getLegal().charAt(0)=='0' || northWallCheck()) &&  (t.getLegal().charAt(1)=='0' || eastWallCheck()) && (t.getLegal().charAt(3)=='0' || westWallCheck()) && (t.getLegal().charAt(4)=='0' || northWestCheck()) && (t.getLegal().charAt(5)=='0' || northEastCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
			
			if(x==1 && y>1 && y<12){
				if(t.getLegal().charAt(3)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) && (t.getLegal().charAt(0)=='0' || northWallCheck()) && (t.getLegal().charAt(1)=='0' || eastWallCheck()) && (t.getLegal().charAt(2)=='0' || southWallCheck()) && (t.getLegal().charAt(5)=='0' || northEastCheck()) && (t.getLegal().charAt(6)=='0' || southEastCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
			
			if(x==1 && y==1){
				if(t.getLegal().charAt(4)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) && (t.getLegal().charAt(0)=='0' || northWallCheck()) && (t.getLegal().charAt(1)=='0' || eastWallCheck()) && (t.getLegal().charAt(2)=='0' || southWallCheck()) && (t.getLegal().charAt(3)=='0' || westWallCheck()) && (t.getLegal().charAt(5)=='0' || northEastCheck()) && (t.getLegal().charAt(6)=='0' || southEastCheck()) && (t.getLegal().charAt(7)=='0' || southWestCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
			
			if(x==12 && y==1){
				if(t.getLegal().charAt(5)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) && (t.getLegal().charAt(0)=='0' || northWallCheck()) && (t.getLegal().charAt(1)=='0' || eastWallCheck()) && (t.getLegal().charAt(2)=='0' || southWallCheck()) && (t.getLegal().charAt(3)=='0' || westWallCheck()) && (t.getLegal().charAt(4)=='0' || northWestCheck()) && (t.getLegal().charAt(6)=='0' || southEastCheck()) && (t.getLegal().charAt(7)=='0' || southWestCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
			
			if(x==12 && y==12){
				if(t.getLegal().charAt(6)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) && (t.getLegal().charAt(0)=='0' || northWallCheck()) && (t.getLegal().charAt(1)=='0' || eastWallCheck()) && (t.getLegal().charAt(2)=='0' || southWallCheck()) && (t.getLegal().charAt(3)=='0' || westWallCheck()) && (t.getLegal().charAt(4)=='0' || northWestCheck()) && (t.getLegal().charAt(5)=='0' || northEastCheck()) && (t.getLegal().charAt(7)=='0' || southWestCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
			
			if(x==1 && y==12){
				if(t.getLegal().charAt(7)=='1'){
					_tileIsLegal=true;
				}
				else if( (middleCheck()) && (t.getLegal().charAt(0)=='0' || northWallCheck()) && (t.getLegal().charAt(1)=='0' || eastWallCheck()) && (t.getLegal().charAt(2)=='0' || southWallCheck()) && (t.getLegal().charAt(3)=='0' || westWallCheck()) && (t.getLegal().charAt(4)=='0' || northWestCheck()) && (t.getLegal().charAt(5)=='0' || northEastCheck()) && (t.getLegal().charAt(6)=='0' || southEastCheck())){
					_tileIsLegal=true;
				}
				else{
					_tileIsLegal=false;
				}
			}
		}
		else{
			_tileIsLegal=true;
		}
	}
	
	/*This method will return the tile at the given x and y position.  
	 * Whatever calls this method must ensure that it only calls if the x and y values given are between 1 and 4
	 */
	public Tile tileAt(int x, int y) {
		return _board[x][y];
	}
	
	/*This removes the tile that was just placed which is at the current x and y values and returns that tile so that it is available to the player to place elsewhere
	 *Throws a NoSuchElementException if there is no currently placed tile
	 */
	public Tile remove(){
		if(_currentX>0 && _currentX<13 && _currentY>0 && _currentY<13){	
			Tile returnTile = _board[_currentX][_currentY];
			_board[_currentX][_currentY] = new TileEmpty(this);
			_currentX = 0;
			_currentY = 0;
			_tileIsLegal = false;
			return returnTile;
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	/*This method has the tile at point x and y run its callToBoard method, which will in turn have the board call this method on the tile the current tile connects to, keeping track of the points all the way
	 * This method is recursive, and when a tile calls it, it will pass the points it was given on, and if the given x or y postion is out of the legitimate placing bounds, the game recognizes that it has hit the edge of the board and returns the points it has
	 */
	public int checkConnection(int x, int y, int i, int points) {
		if(x<1 || x > 12 || y < 1 || y > 12){
			return returnPoints(points);
		}
		if((x==6&&y==6)||(x==7&&y==6)||(x==6&&y==7)||(x==7&&y==7)){
			return 2*returnPoints(points);
		}
		else{
			Tile current = tileAt(x,y);
			return current.callToBoard(i, points, x, y);
		}
	}
	
	/*This will be called when the commit command is given
	 * This sets the values of the x and y values of the current tile to 0 which indicates that there is no currently placed tile (as it is a new turn)
	 * This sets the value of whether or not the current tile placement is legal to false, which means that, since a tile hasn't been placed yet, the game can't commit again
	 */
	public void commit(){
		_currentX = 0;
		_currentY = 0;
		_tileIsLegal = false;
	}
	/*This is a rather superfluous method so that we can make returning points work with the mildly recursive system we set up.
	 * It returns the value passed along to it and is used by the empty tile class to tell the board to just return 0 points
	 */
	public int returnPoints(int pts){
		return pts;
	}

	private boolean northWestCheck(){
		TileEmpty empty = new TileEmpty(this);
		if(tileAt(1,1).getClass().equals(empty.getClass())){
			return false;
		}
		return true;
	}
	
	private boolean northEastCheck(){
		TileEmpty empty = new TileEmpty(this);
		if(tileAt(12,1).getClass().equals(empty.getClass())){
			return false;
		}
		return true;
	}
	
	private boolean southEastCheck(){
		TileEmpty empty = new TileEmpty(this);
		if(tileAt(12,12).getClass().equals(empty.getClass())){
			return false;
		}
		return true;
	}
	
	private boolean southWestCheck(){
		TileEmpty empty = new TileEmpty(this);
		if(tileAt(1,12).getClass().equals(empty.getClass())){
			return false;
		}
		return true;
	}
	
	private boolean westWallCheck(){
		TileEmpty empty = new TileEmpty(this);
		for(int y = 2; y<12; y++){
			if(tileAt(1,y).getClass().equals(empty.getClass())){
				return false;
			}
		}
		return true;
	}
	
	private boolean southWallCheck(){
		TileEmpty empty = new TileEmpty(this);
		for(int x = 2; x<12; x++){
			if(tileAt(x,12).getClass().equals(empty.getClass())){
				return false;
			}
		}
		return true;
	}
	
	private boolean eastWallCheck(){
		TileEmpty empty = new TileEmpty(this);
		for(int y = 2; y<12; y++){
			if(tileAt(12,y).getClass().equals(empty.getClass())){
				return false;
			}
		}
		return true;
	}
	
	private boolean northWallCheck(){
		TileEmpty empty = new TileEmpty(this);
		for(int x = 2; x<12; x++){
			if(tileAt(x,1).getClass().equals(empty.getClass())){
				return false;
			}
		}
		return true;
	}
	
	private boolean middleCheck(){
		TileEmpty empty = new TileEmpty(this);
		for(int x = 2; x<12 ; x++){
			for(int y = 2; y<12 ; y++){
				if(tileAt(x,y).getClass().equals(empty.getClass())){
					return false;
				}
			}
		}
		return true;
	}
}
