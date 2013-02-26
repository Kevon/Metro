package tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import tiles.Tile;
import tiles.TileA;
import tiles.TileB;
import tiles.TileC;
import tiles.TileD;

import code.Board;
import tiles.Tile;
import tiles.TileA;
import tiles.TileB;
import tiles.TileC;
import tiles.TileD;
import tiles.TileE;
import tiles.TileEmpty;
import tiles.TileF;
import tiles.TileG;
import tiles.TileH;
import tiles.TileI;
import tiles.TileJ;
import tiles.TileK;
import tiles.TileL;
import tiles.TileM;
import tiles.TileN;
import tiles.TileO;
import tiles.TileP;
import tiles.TileQ;
import tiles.TileR;
import tiles.TileS;
import tiles.TileT;
import tiles.TileU;
import tiles.TileV;
import tiles.TileW;
import tiles.TileX;


public class BoardTests {
	public  BoardTests (){
		
	}
@Test 
public void placeTest(){
	Board testBoard = new Board();

	int x = 1;
	int y = 1;
	
	TileA testTile = new TileA(testBoard);
	testBoard.placeTile(x,y,testTile);
		assertTrue("board placement failed at "+x+", " + y, testBoard.tileAt(x,y).equals(testTile));

}
	@Test 
	public void doublePlacementTest(){
		Board testBoard = new Board();
	
		int x = 1;
		int y = 1;
		
		TileA testTile1 = new TileA(testBoard);
		TileA testTile2 = new TileA(testBoard);
	
		testBoard.placeTile(x,y,testTile1);
		boolean actual = testBoard.placeTile(x,y,testTile2);
	
		assertFalse("The board succesfully places 2 tiles on the same location, while it shouldn't have", actual);
	
	}

	@Test
	public void tileAtTest(){
		
		Board testBoard = new Board();
		
		int x = 1;
		int y = 1;
		
		TileA expected = new TileA(testBoard);
		
		testBoard.placeTile(x,y,expected);
		Tile actual = testBoard.tileAt(x,y);
		
		assertTrue("The tile at position "+x+", "+y+" was not returned properly", expected.equals(actual));
	}

	@Test
	public void removeTest(){
		Board testBoard = new Board();
		
		int x = 1;
		int y = 1;
		
		TileA testTile = new TileA(testBoard);
		testBoard.placeTile(x, y, testTile);
		Tile actual;
		actual = testBoard.remove();
		Tile expected = testTile;
		
		assertTrue("The tile was not successfully removed.", expected == actual);
	}
	
	@Test
	public void removeNothingTest(){
		Board testBoard = new Board();
		boolean worked = false;
		try{testBoard.remove();}
		catch(NoSuchElementException e){
			worked = true;
		}
		
		
		assertTrue("You shouldn't be able to remove a tile here since no tile is located here.", worked);
	}
	@Test
	public void connectionTest(){
		Board testBoard = new Board();
		
		TileA testTile1 = new TileA(testBoard);
		TileC testTile2 = new TileC(testBoard);
		
		int x1 = 1;
		int y1 = 1;
		int x2 = 2;
		int y2 = 1;
		
		testBoard.placeTile(x1, y1, testTile1);
		testBoard.placeTile(x2, y2, testTile2);
		
		int actual = testBoard.checkConnection(x1,y1,6,0);
		int expected = 2;
		
		assertTrue("The board should have acknowlegded that it was connected and counted "+expected+" points, but it actually counted "+actual+" points.", expected == actual);
	}
	@Test
	public void tileBCornerTest(){
		Board testBoard = new Board();
		
		TileB testTile1 = new TileB(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileB should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
//	@Test
//	public void TileBCornerTestNoOtherOption(){
//		Board testBoard = new Board();
//		
//		
//		TileB testTile1 = new TileB(testBoard);
//		TileA testTile2 = new TileA(testBoard);
//		
//		int x = 1;
//		int y = 1;
//		 
//		testBoard.placeTile(2, 1, testTile2);
//		testBoard.placeTile(3, 1, testTile2);
//		testBoard.placeTile(1, 2, testTile2);
//		testBoard.placeTile(2, 2, testTile2);
//		testBoard.placeTile(3, 2, testTile2);
//		testBoard.placeTile(4, 2, testTile2);
//		testBoard.placeTile(1, 3, testTile2);
//		testBoard.placeTile(2, 3, testTile2);
//		testBoard.placeTile(3, 3, testTile2);
//		testBoard.placeTile(4, 3, testTile2);
//		testBoard.placeTile(2, 4, testTile2);
//		testBoard.placeTile(3, 4, testTile2);
//		testBoard.placeTile(x, y, testTile1);
//		boolean actual = testBoard.checkLegalTile();
//	
//		assertTrue("The tile TileB should have been able to be placed in the corner, but it was not placed. We should probably fix that.", actual);
//	}
	@Test
	public void tileCCornerTest(){
		Board testBoard = new Board();
		
		TileC testTile1 = new TileC(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
//	@Test
//	public void TileCCornerTestNoOtherOption(){
//		Board testBoard = new Board();
//		
//		
//		TileC testTile1 = new TileC(testBoard);
//		TileA testTile2 = new TileA(testBoard);
//		
//		int x = 1;
//		int y = 1;
//		 
//		testBoard.placeTile(2, 1, testTile2);
//		testBoard.placeTile(3, 1, testTile2);
//		testBoard.placeTile(1, 2, testTile2);
//		testBoard.placeTile(2, 2, testTile2);
//		testBoard.placeTile(3, 2, testTile2);
//		testBoard.placeTile(4, 2, testTile2);
//		testBoard.placeTile(1, 3, testTile2);
//		testBoard.placeTile(2, 3, testTile2);
//		testBoard.placeTile(3, 3, testTile2);
//		testBoard.placeTile(4, 3, testTile2);
//		testBoard.placeTile(2, 4, testTile2);
//		testBoard.placeTile(3, 4, testTile2);
//		testBoard.placeTile(x, y, testTile1);
//		boolean actual = testBoard.checkLegalTile();
//	
//		assertTrue("The tile TileC should have been able to be placed in the corner, but it was not placed. We should probably fix that.", actual);
//	}
	@Test
	public void tileDCornerTest(){
		Board testBoard = new Board();
		
		TileD testTile1 = new TileD(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileD should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
//	@Test
//	public void tileDEdgePlaceTest(){
//		Board testBoard = new Board();
//		
//		TileD testTile1 = new TileD(testBoard);
//		
//		int x = 4;
//		int y = 3;
//		testBoard.placeTile(x, y, testTile1);
//		boolean actual = testBoard._tileIsLegal;
//	
//		assertFalse("The tile TileD should not have been able to be placed on an edge space, but it was placed. We should probably fix that.", actual);
//	}
//	@Test
//	public void TileDCornerTestNoOtherOption(){
//		Board testBoard = new Board();
//		
//		
//		TileD testTile1 = new TileD(testBoard);
//		TileA testTile2 = new TileA(testBoard);
//		
//		int x = 1;
//		int y = 1;
//		 
//		testBoard.placeTile(2, 1, testTile2);
//		testBoard.placeTile(3, 1, testTile2);
//		testBoard.placeTile(1, 2, testTile2);
//		testBoard.placeTile(2, 2, testTile2);
//		testBoard.placeTile(3, 2, testTile2);
//		testBoard.placeTile(4, 2, testTile2);
//		testBoard.placeTile(1, 3, testTile2);
//		testBoard.placeTile(2, 3, testTile2);
//		testBoard.placeTile(3, 3, testTile2);
//		testBoard.placeTile(4, 3, testTile2);
//		testBoard.placeTile(2, 4, testTile2);
//		testBoard.placeTile(3, 4, testTile2);
//		testBoard.placeTile(x, y, testTile1);
//		boolean actual = testBoard.checkLegalTile();
//	
//		assertTrue("The tile TileD should have been able to be placed in the corner, but it was not placed. We should probably fix that.", actual);
//	}
//	@Test
//	public void TileDEdgeTestNoOtherOptions(){
//		Board testBoard = new Board();
//		
//		
//		TileD testTile1 = new TileD(testBoard);
//		TileA testTile2 = new TileA(testBoard);
//		
//		int x = 1;
//		int y = 3;
//
//		testBoard.placeTile(2, 2, testTile2);
//		testBoard.placeTile(3, 2, testTile2);
//		testBoard.placeTile(2, 3, testTile2);
//		testBoard.placeTile(3, 3, testTile2);
//		testBoard.placeTile(x, y, testTile1);
//		boolean actual = testBoard.checkLegalTile();
//	
//		assertTrue("The tile TileD should have been able to be placed on an edge space, but it was not placed. We should probably fix that.", actual);
//	}
	
	@Test
	public void tileECornerTest(){
		Board testBoard = new Board();
		
		TileE testTile1 = new TileE(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileE should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileFCornerTest(){
		Board testBoard = new Board();
		
		TileF testTile1 = new TileF(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileGCornerTest(){
		Board testBoard = new Board();
		
		TileG testTile1 = new TileG(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileHCornerTest(){
		Board testBoard = new Board();
		
		TileH testTile1 = new TileH(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileICornerTest(){
		Board testBoard = new Board();
		
		TileI testTile1 = new TileI(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileJCornerTest(){
		Board testBoard = new Board();
		
		TileJ testTile1 = new TileJ(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileKCornerTest(){
		Board testBoard = new Board();
		
		TileK testTile1 = new TileK(testBoard);
		
		int x = 1;
		int y = 12;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileK should not have been able to be placed in the corner (1,12), but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileKLegalCornerTest(){
		Board testBoard = new Board();
		
		TileK testTile1 = new TileK(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile TileK should have been able to be placed in the corner (1,1), but it was not placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileLCornerTest(){
		Board testBoard = new Board();
		
		TileL testTile1 = new TileL(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileL should not have been able to be placed in the corner (1,1), but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileLLegalCornerTest(){
		Board testBoard = new Board();
		
		TileL testTile1 = new TileL(testBoard);
		
		int x = 1;
		int y = 12;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile TileL should  have been able to be placed in the corner 1,12), but it was not placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileMCornerTest(){
		Board testBoard = new Board();
		
		TileM testTile1 = new TileM(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileNCornerTest(){
		Board testBoard = new Board();
		
		TileN testTile1 = new TileN(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileOCornerTest(){
		Board testBoard = new Board();
		
		TileO testTile1 = new TileO(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tilePCornerTest(){
		Board testBoard = new Board();
		
		TileP testTile1 = new TileP(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileQCornerTest(){
		Board testBoard = new Board();
		
		TileQ testTile1 = new TileQ(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileRCornerTest(){
		Board testBoard = new Board();
		
		TileR testTile1 = new TileR(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileSCornerTest(){
		Board testBoard = new Board();
		
		TileS testTile1 = new TileS(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileTCornerTest(){
		Board testBoard = new Board();
		
		TileT testTile1 = new TileT(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileC should not have been able to be placed in the corner, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileUCornerTest(){
		Board testBoard = new Board();
		
		TileU testTile1 = new TileU(testBoard);
		
		int x = 1;
		int y = 12;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
		
		assertFalse("The tile TileU should not have been able to be placed in the corner (1,12), but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileULegalCornerTest(){
		Board testBoard = new Board();
		
		TileU testTile1 = new TileU(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile TileU should have been able to be placed in the corner (1,1), but it was not placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileVCornerTest(){
		Board testBoard = new Board();
		
		TileV testTile1 = new TileV(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileV should not have been able to be placed in the corner (1,1), but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileVLegalCornerTest(){
		Board testBoard = new Board();
		
		TileV testTile1 = new TileV(testBoard);
		
		int x = 1;
		int y = 12;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile TileV should  have been able to be placed in the corner (1,12), but it was not placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileWCornerTest(){
		Board testBoard = new Board();
		
		TileW testTile1 = new TileW(testBoard);
		
		int x = 1;
		int y = 1;
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileW should not have been able to be placed in the corner (1,1), but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileWLegalCornerTest(){
		Board testBoard = new Board();
		
		TileW testTile1 = new TileW(testBoard);
		
		int x = 1;
		int y = 12;

		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
		
		assertTrue("The tile TileW should  have been able to be placed in the corner (1,12), but it was not placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileXCornerTest(){
		Board testBoard = new Board();
		
		TileX testTile1 = new TileX(testBoard);
		
		int x = 1;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile TileX should not have been able to be placed in the corner (1,12), but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileXLegalCornerTest(){
		Board testBoard = new Board();
		
		TileX testTile1 = new TileX(testBoard);
		
		int x = 1;
		int y = 1;

		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile TileX should have been able to be placed in the corner (1,1), but it was not placed. We should probably fix that.", actual);
	}
	
	
	
	@Test
	public void tileDNorthWallTest(){
		Board testBoard = new Board();
		
		TileD testTile1 = new TileD(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileDEastWallTest(){
		Board testBoard = new Board();
		
		TileD testTile1 = new TileD(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileDSouthWallTest(){
		Board testBoard = new Board();
		
		TileD testTile1 = new TileD(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileDWestWallTest(){
		Board testBoard = new Board();
		
		TileD testTile1 = new TileD(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	@Test
	public void tileENorthWallTest(){
		Board testBoard = new Board();
		
		TileE testTile1 = new TileE(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileEEastWallTest(){
		Board testBoard = new Board();
		
		TileE testTile1 = new TileE(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileESouthWallTest(){
		Board testBoard = new Board();
		
		TileE testTile1 = new TileE(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileEWestWallTest(){
		Board testBoard = new Board();
		
		TileE testTile1 = new TileE(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	@Test
	public void tileFNorthWallTest(){
		Board testBoard = new Board();
		
		TileF testTile1 = new TileF(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileFEastWallTest(){
		Board testBoard = new Board();
		
		TileF testTile1 = new TileF(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileFSouthWallTest(){
		Board testBoard = new Board();
		
		TileF testTile1 = new TileF(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileFWestWallTest(){
		Board testBoard = new Board();
		
		TileF testTile1 = new TileF(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileGNorthWallTest(){
		Board testBoard = new Board();
		
		TileG testTile1 = new TileG(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileGEastWallTest(){
		Board testBoard = new Board();
		
		TileG testTile1 = new TileG(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileGSouthWallTest(){
		Board testBoard = new Board();
		
		TileG testTile1 = new TileG(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileGWestWallTest(){
		Board testBoard = new Board();
		
		TileG testTile1 = new TileG(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileHNorthWallTest(){
		Board testBoard = new Board();
		
		TileH testTile1 = new TileH(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileHEastWallTest(){
		Board testBoard = new Board();
		
		TileH testTile1 = new TileH(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileHSouthWallTest(){
		Board testBoard = new Board();
		
		TileH testTile1 = new TileH(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileHWestWallTest(){
		Board testBoard = new Board();
		
		TileH testTile1 = new TileH(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileINorthWallTest(){
		Board testBoard = new Board();
		
		TileI testTile1 = new TileI(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileIEastWallTest(){
		Board testBoard = new Board();
		
		TileI testTile1 = new TileI(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileISouthWallTest(){
		Board testBoard = new Board();
		
		TileI testTile1 = new TileI(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileIWestWallTest(){
		Board testBoard = new Board();
		
		TileI testTile1 = new TileI(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	@Test
	public void tileJNorthWallTest(){
		Board testBoard = new Board();
		
		TileJ testTile1 = new TileJ(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should not have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileJEastWallTest(){
		Board testBoard = new Board();
		
		TileJ testTile1 = new TileJ(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileJSouthWallTest(){
		Board testBoard = new Board();
		
		TileJ testTile1 = new TileJ(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileJWestWallTest(){
		Board testBoard = new Board();
		
		TileJ testTile1 = new TileJ(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should not have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	@Test
	public void tileMNorthWallTest(){
		Board testBoard = new Board();
		
		TileM testTile1 = new TileM(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileMEastWallTest(){
		Board testBoard = new Board();
		
		TileM testTile1 = new TileM(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileMSouthWallTest(){
		Board testBoard = new Board();
		
		TileM testTile1 = new TileM(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileMWestWallTest(){
		Board testBoard = new Board();
		
		TileM testTile1 = new TileM(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	
	@Test
	public void tileNNorthWallTest(){
		Board testBoard = new Board();
		
		TileN testTile1 = new TileN(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileNEastWallTest(){
		Board testBoard = new Board();
		
		TileN testTile1 = new TileN(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileNSouthWallTest(){
		Board testBoard = new Board();
		
		TileN testTile1 = new TileN(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileNWestWallTest(){
		Board testBoard = new Board();
		
		TileN testTile1 = new TileN(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileONorthWallTest(){
		Board testBoard = new Board();
		
		TileO testTile1 = new TileO(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileOEastWallTest(){
		Board testBoard = new Board();
		
		TileO testTile1 = new TileO(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileOSouthWallTest(){
		Board testBoard = new Board();
		
		TileO testTile1 = new TileO(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileOWestWallTest(){
		Board testBoard = new Board();
		
		TileO testTile1 = new TileO(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	
	@Test
	public void tilePNorthWallTest(){
		Board testBoard = new Board();
		
		TileP testTile1 = new TileP(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tilePEastWallTest(){
		Board testBoard = new Board();
		
		TileP testTile1 = new TileP(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tilePSouthWallTest(){
		Board testBoard = new Board();
		
		TileP testTile1 = new TileP(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tilePWestWallTest(){
		Board testBoard = new Board();
		
		TileP testTile1 = new TileP(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	
	
	@Test
	public void tileQNorthWallTest(){
		Board testBoard = new Board();
		
		TileQ testTile1 = new TileQ(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileQEastWallTest(){
		Board testBoard = new Board();
		
		TileQ testTile1 = new TileQ(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileQSouthWallTest(){
		Board testBoard = new Board();
		
		TileQ testTile1 = new TileQ(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileQWestWallTest(){
		Board testBoard = new Board();
		
		TileQ testTile1 = new TileQ(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	@Test
	public void tileRNorthWallTest(){
		Board testBoard = new Board();
		
		TileR testTile1 = new TileR(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileREastWallTest(){
		Board testBoard = new Board();
		
		TileR testTile1 = new TileR(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileRSouthWallTest(){
		Board testBoard = new Board();
		
		TileR testTile1 = new TileR(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileRWestWallTest(){
		Board testBoard = new Board();
		
		TileR testTile1 = new TileR(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileSNorthWallTest(){
		Board testBoard = new Board();
		
		TileS testTile1 = new TileS(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileSEastWallTest(){
		Board testBoard = new Board();
		
		TileS testTile1 = new TileS(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileSSouthWallTest(){
		Board testBoard = new Board();
		
		TileS testTile1 = new TileS(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileSWestWallTest(){
		Board testBoard = new Board();
		
		TileS testTile1 = new TileS(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	@Test
	public void tileTNorthWallTest(){
		Board testBoard = new Board();
		
		TileT testTile1 = new TileT(testBoard);
		
		int x = 6;
		int y = 1;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the north wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileTEastWallTest(){
		Board testBoard = new Board();
		
		TileT testTile1 = new TileT(testBoard);
		
		int x = 12;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the east wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileTSouthWallTest(){
		Board testBoard = new Board();
		
		TileT testTile1 = new TileT(testBoard);
		
		int x = 6;
		int y = 12;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertTrue("The tile should have been able to be placed on the south wall, but it was placed. We should probably fix that.", actual);
	}
	@Test
	public void tileTWestWallTest(){
		Board testBoard = new Board();
		
		TileT testTile1 = new TileT(testBoard);
		
		int x = 1;
		int y = 6;
		
		testBoard.placeTile(x, y, testTile1);
		boolean actual = testBoard._tileIsLegal;
	
		assertFalse("The tile should not have been able to be placed on the west wall, but it was placed. We should probably fix that.", actual);
	}
	
	
	
	
	
	@Test
	public void bigBoardCreationTest(){
		Board testBoard = new Board();
		TileEmpty tile = new TileEmpty(testBoard);
		
		boolean actual = true;
		
		for(int x = 1; x <= 12; x++){
			for(int y = 1; y <= 12; y++){
				if(!(testBoard.tileAt(x,y).getClass().equals(tile.getClass()))){
					// Ignore central stations.
					if (x != 6 && x != 7 && y != 6 && y != 7){
					actual = false;
					}
				}
			}
		}
		
		assertTrue("The board should have made a board that's 12 x 12 placing empty tiles in every position, but it didn't.", actual);
	}
}
