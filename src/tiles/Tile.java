package tiles;
/*
 * Tile is a class that represents the tiles that can be placed upon the board durring play
 */
public interface Tile {

	
	/* The connectEdge method takes in an int variable that is the index position from an adjacent tile that signifies the connection. 
	 * This method returns the array position of the edge that the given edge i connects to internally 
	 */
	public int connectEdge(int i);
	
	
	/*Each tile responds differently to this method due to its different connection types, but for each one, it is told which position it is starting at, figures out what that point connects to, then figures out which tile it leads into and has the board call this method again on that new tile.
	 *Its return type will eventually signify the points earned, but the final value of those points will eventually be returned by board as it is passed along through many tiles
	 */  
	public int callToBoard(int i, int pts, int x, int y);
	
	
	/*For any tile type, a certain edge "i" will always correspond to a specific edge of a tile adjacent to it, and this method creates that relationship and returns that value
	 */
	public int correspond(int i);
	
	
	/*
	 * This method takes in an int to signify which array position is the tile's "output" and an int to signify the current x position and determines what the x value of the next tile should be.
	 */
	public int newX(int j, int x);
	
	
	/*
	 * This method takes in an int to signify which array position is the tile's "output" and an int to signify the current y position and determines what the y value of the next tile should be.
	 */
	public int newY(int j, int y);
	
	
	/*
	 * This method returns the tiles type, ranging from a to x
	 */
	public char getType();
	
	
	/*
	 * This method returns a tiles "legal" string, which denotes through ones and zeros the kinds of positions that kind of tile may or may not be placed
	 */
	public String getLegal();
	
}
