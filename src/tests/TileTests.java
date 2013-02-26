package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tiles.TileA;
import tiles.TileB;
import tiles.TileC;
import tiles.TileD;

import code.Board;

import tiles.TileE;
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


public class TileTests {

	public TileTests(){
		
	}
	
	@Test
	public void connectEdgesTestA1(){
		Board _testBoard = new Board();
		TileA tile = new TileA(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 4;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
		
	}
	
	@Test
	public void connectEdgesTestA2(){
		Board _testBoard = new Board();
		TileA tile = new TileA(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 7;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
		
	}
	
	@Test
	public void connectEdgesTestB1(){
		Board _testBoard = new Board();
		TileB tile = new TileB(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
		
	}
	
	@Test
	public void connectEdgesTestB2(){
		Board _testBoard = new Board();
		TileB tile = new TileB(_testBoard);
		int arrayValue = 4;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
		
	}
	
	@Test
	public void connectEdgesTestC1(){
		Board _testBoard = new Board();
		TileC tile = new TileC(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 6;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
		
	}
	
	@Test
	public void connectEdgesTestC2(){
		Board _testBoard = new Board();
		TileC tile = new TileC(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 5;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
		
	}
	
	@Test
	public void connectEdgesTestD1(){
		Board _testBoard = new Board();
		TileD tile = new TileD(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
		
	}
	
	@Test
	public void connectEdgesTestD2(){
		Board _testBoard = new Board();
		TileD tile = new TileD(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestE1(){
		Board _testBoard = new Board();
		TileE tile = new TileE(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 4;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestE2(){
		Board _testBoard = new Board();
		TileE tile = new TileE(_testBoard);
		int arrayValue = 3;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestF1(){
		Board _testBoard = new Board();
		TileF tile = new TileF(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestF2(){
		Board _testBoard = new Board();
		TileF tile = new TileF(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 7;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestG1(){
		Board _testBoard = new Board();
		TileG tile = new TileG(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestG2(){
		Board _testBoard = new Board();
		TileG tile = new TileG(_testBoard);
		int arrayValue = 4;
		int actual = tile.connectEdge(arrayValue);
		
		int expected =7;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestH1(){
		Board _testBoard = new Board();
		TileH tile = new TileH(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestH2(){
		Board _testBoard = new Board();
		TileH tile = new TileH(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 5;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestI1(){
		Board _testBoard = new Board();
		TileI tile = new TileI(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestI2(){
		Board _testBoard = new Board();
		TileI tile = new TileI(_testBoard);
		int arrayValue = 5;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 4;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestJ1(){
		Board _testBoard = new Board();
		TileJ tile = new TileJ(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 6;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestJ2(){
		Board _testBoard = new Board();
		TileJ tile = new TileJ(_testBoard);
		int arrayValue = 3;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestK1(){
		Board _testBoard = new Board();
		TileK tile = new TileK(_testBoard);
		int arrayValue = 0;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestK2(){
		Board _testBoard = new Board();
		TileK tile = new TileK(_testBoard);
		int arrayValue = 4;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 7;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestL1(){
		Board _testBoard = new Board();
		TileL tile = new TileL(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 6;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestL2(){
		Board _testBoard = new Board();
		TileL tile = new TileL(_testBoard);
		int arrayValue = 5;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestM1(){
		Board _testBoard = new Board();
		TileM tile = new TileM(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestM2(){
		Board _testBoard = new Board();
		TileM tile = new TileM(_testBoard);
		int arrayValue = 3;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 6;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestN1(){
		Board _testBoard = new Board();
		TileN tile = new TileN(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestN2(){
		Board _testBoard = new Board();
		TileF tile = new TileF(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 7;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestN3(){
		Board _testBoard = new Board();
		TileN tile = new TileN(_testBoard);
		int arrayValue = 6;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 5;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestO1(){
		Board _testBoard = new Board();
		TileO tile = new TileO(_testBoard);
		int arrayValue = 4;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestO2(){
		Board _testBoard = new Board();
		TileO tile = new TileO(_testBoard);
		int arrayValue = 0;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 5;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestP1(){
		Board _testBoard = new Board();
		TileP tile = new TileP(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 4;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestP2(){
		Board _testBoard = new Board();
		TileP tile = new TileP(_testBoard);
		int arrayValue = 7;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestP3(){
		Board _testBoard = new Board();
		TileP tile = new TileP(_testBoard);
		int arrayValue = 3;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestQ1(){
		Board _testBoard = new Board();
		TileQ tile = new TileQ(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 6;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestQ2(){
		Board _testBoard = new Board();
		TileQ tile = new TileQ(_testBoard);
		int arrayValue = 5;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestQ3(){
		Board _testBoard = new Board();
		TileQ tile = new TileQ(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestR1(){
		Board _testBoard = new Board();
		TileR tile = new TileR(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestR2(){
		Board _testBoard = new Board();
		TileR tile = new TileR(_testBoard);
		int arrayValue = 2;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 5;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestR3(){
		Board _testBoard = new Board();
		TileR tile = new TileR(_testBoard);
		int arrayValue = 6;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestS1(){
		Board _testBoard = new Board();
		TileS tile = new TileS(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 6;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestS2(){
		Board _testBoard = new Board();
		TileS tile = new TileS(_testBoard);
		int arrayValue = 7;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestS3(){
		Board _testBoard = new Board();
		TileS tile = new TileS(_testBoard);
		int arrayValue = 5;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 4;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestT1(){
		Board _testBoard = new Board();
		TileT tile = new TileT(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 4;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestT2(){
		Board _testBoard = new Board();
		TileT tile = new TileT(_testBoard);
		int arrayValue = 3;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestT3(){
		Board _testBoard = new Board();
		TileT tile = new TileT(_testBoard);
		int arrayValue = 6;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 7;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestU1(){
		Board _testBoard = new Board();
		TileU tile = new TileU(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestU2(){
		Board _testBoard = new Board();
		TileU tile = new TileU(_testBoard);
		int arrayValue = 6;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestU3(){
		Board _testBoard = new Board();
		TileU tile = new TileU(_testBoard);
		int arrayValue = 5;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 0;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestV1(){
		Board _testBoard = new Board();
		TileV tile = new TileV(_testBoard);
		int arrayValue = 6;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 1;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestV2(){
		Board _testBoard = new Board();
		TileV tile = new TileV(_testBoard);
		int arrayValue = 0;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 5;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestV3(){
		Board _testBoard = new Board();
		TileV tile = new TileV(_testBoard);
		int arrayValue = 4;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestW1(){
		Board _testBoard = new Board();
		TileW tile = new TileW(_testBoard);
		int arrayValue = 1;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 4;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestW2(){
		Board _testBoard = new Board();
		TileW tile = new TileW(_testBoard);
		int arrayValue = 5;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestW3(){
		Board _testBoard = new Board();
		TileW tile = new TileW(_testBoard);
		int arrayValue = 0;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 7;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestX1(){
		Board _testBoard = new Board();
		TileX tile = new TileX(_testBoard);
		int arrayValue = 4;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 1;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestX2(){
		Board _testBoard = new Board();
		TileX tile = new TileX(_testBoard);
		int arrayValue = 0;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 3;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
	@Test
	public void connectEdgesTestX3(){
		Board _testBoard = new Board();
		TileF tile = new TileF(_testBoard);
		int arrayValue = 7;
		int actual = tile.connectEdge(arrayValue);
		
		int expected = 2;
		
		assertTrue("TileA should connect edge number "+arrayValue+1+" to edge number "+expected+1+", but it connected it to edge number "+actual+1+".",actual == expected);
	}
}
