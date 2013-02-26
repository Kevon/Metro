package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.EmptyStackException;

import org.junit.Test;

import tiles.Tile;
import tiles.TileEmpty;

import code.Game;

public class GameTests {

	@Test
	public void startScore(){
		Game testGame = new Game(false,true);
		int actual1 = testGame._player1;
		int actual2 = testGame._player2;
		int expected = 0;
				
		assertTrue("The start score for each player should be 0, buit it is actially "+actual1+" and "+actual2,(expected == actual1)&&(expected == actual2));
	}
	
	@Test
	public void removeTile(){
		
		Game testGame = new Game(false,true);

		int x = 2;
		int y = 2;
		
		TileEmpty tile = new TileEmpty(testGame._board);
		
		testGame.place(x,y);
		
		testGame.remove();
		
		testGame.commit();
		
		boolean actual;
		if(testGame._board.tileAt(x,y).getClass().equals(tile.getClass()) == true){
			actual = true;
		}
		else{
			actual = false;
		}
		
		assertTrue("The placed tile should have been removed from the board, but it wasn't. :<", actual);
	}
	
	@Test
	public void returnToStack(){
		Game testGame = new Game(false,true);

		int x = 2;
		int y = 2;
		
		Tile tile = testGame._tileStack.peek();
		
		testGame.place(x,y);
		
		testGame.remove();
		
		Tile tile2 = testGame._tileStack.peek();
		
		testGame.commit();
		
		assertTrue("The placed tile should have been placed back into the stack, but it wasn't. :<", tile.equals(tile2));
	}
	
	@Test
	public void playerTest(){
		Game testGame = new Game(false,true);

		int x = 2;
		int y = 2;
		
		String initialPlayer = testGame._currentPlayer;
		testGame.place(x,y);
		testGame.commit();
		
		String nextPlayer = testGame._currentPlayer;
		
		boolean actual = initialPlayer.equals(nextPlayer);
		
		assertFalse("The game should have switched players, but it didn't. After the first turn, the game thinks it is player "+nextPlayer+"'s turn.", actual);
	}
	
	@Test
	public void placeTest(){
		Game testGame = new Game(false,true);

		int x = 2;
		int y = 2;
		
		TileEmpty tile = new TileEmpty(testGame._board);
		
		testGame.place(x,y);
		
		testGame.commit();
		
		assertFalse("There should have been a tile placed at (2, 2), but there is still an empty tile at that position.", testGame._board.tileAt(x,y).getClass().equals(tile));
	}
	
	@Test
	public void currentTileToNull(){
		Game testGame = new Game(false,true);

		
		int x = 2;
		int y = 2;
		
		testGame.place(x,y);
		
		Tile actual = testGame._currentTile;
		
		assertNull("The current tile should have been set to null, but it wasnt. Oh no!", actual);
	}
	
	@Test
	public void doublePlaceTest(){
		Game testGame = new Game(false,true);
		
		int x = 2;
		int y = 2;
		
		testGame.place(x,y);
		testGame.commit();
		testGame.place(x,y);
		boolean actual = testGame.commit();
		boolean expected = false;
		
		assertTrue("The 2nd player shouldn't have been able to place a tile on the same spot, but he (or she, we're politically correct over here) was able to.", expected == actual);
	}
	
	@Test
	public void doublePlacetestSamePlayer(){
		Game testGame = new Game(false,true);
		TileEmpty tile = new TileEmpty(testGame._board);

		
		int a = 2;
		int b = 3;
		
		testGame.place(a,a);
		testGame.remove();
		testGame.place(b,b);
		testGame.commit();

		boolean actual;
		if(testGame._board.tileAt(a,a).getClass().equals(tile.getClass()) == true){
			actual = true;
		}
		else{
			actual = false;
		}
		
		assertTrue("Player 1 should have been able to place a tile at one spot, and then moved the same tile to a different spot before commiting, leaving the original spot to be empty... Something went wrong here, and I have no idea what it is.", actual);
	}
	
	
	
	
}
