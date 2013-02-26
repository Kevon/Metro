package code;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import tiles.Tile;
/*
 * The TextGUI handles printing out all the UI information in the console
 */
public class TextGUI {
	char[][] _textTile = new char[4][4];
	public char[][] _textBoard;
	public char[][] _tempBoard;
	Board _board;
	boolean _active = false;
	
	public TextGUI(Board b){
		_board = b;
		_textBoard = new char[50][50];
		_tempBoard = new char[50][50];
		for(int x=1; x<49 ; x++){
			for(int y=1; y<49 ; y++){
				_textBoard[x][y] = ' ';
			}
		}
		_textBoard[22][21]='#';
		_textBoard[23][21]='#';
		_textBoard[26][21]='#';
		_textBoard[27][21]='#';
		
		_textBoard[22][28]='#';
		_textBoard[23][28]='#';
		_textBoard[26][28]='#';
		_textBoard[27][28]='#';
		
		_textBoard[21][22]='#';
		_textBoard[21][23]='#';
		_textBoard[21][26]='#';
		_textBoard[21][27]='#';
		
		_textBoard[28][22]='#';
		_textBoard[28][23]='#';
		_textBoard[28][26]='#';
		_textBoard[28][27]='#';
		
		_textBoard[0][0]=' ';
		_textBoard[0][49]=' ';
		_textBoard[49][0]=' ';
		_textBoard[49][49]=' ';
		//TOP AND BOTTOM LINES OF BOARD
		for(int x = 0 ; x<12 ; x++){
			_textBoard[4*x+1][0]=' ';
			_textBoard[4*x+2][0]='A';
			_textBoard[4*x+3][0]='B';
			_textBoard[4*x+4][0]=' ';
			
			_textBoard[4*x+1][49]=' ';
			_textBoard[4*x+2][49]='F';
			_textBoard[4*x+3][49]='E';
			_textBoard[4*x+4][49]=' ';
		}
		//LEFT AND RIGHT LINES OF BOARD
		for(int y = 0 ; y<12 ; y++){
			_textBoard[0][4*y+1]=' ';
			_textBoard[0][4*y+2]='G';
			_textBoard[0][4*y+3]='H';
			_textBoard[0][4*y+4]=' ';
			
			_textBoard[49][4*y+1]=' ';
			_textBoard[49][4*y+2]='D';
			_textBoard[49][4*y+3]='C';
			_textBoard[49][4*y+4]=' ';
		}
		
		//DONE SETTING UP BOARD
		for(int x=0; x<50; x++){
			for(int y=0; y<50; y++){
				_tempBoard[x][y]=_textBoard[x][y];
			}
		}
	}
	
	/*
	 * converts the given Tile into a text based representation used for displaying the tile or adding it to the text based board
	 */
	public void setTextTile(Tile t){
		_textTile[0][0]=' ';
		_textTile[3][0]=' ';
		_textTile[3][3]=' ';
		_textTile[0][3]=' ';
		_textTile[1][1]=' ';
		_textTile[1][2]=' ';
		_textTile[2][1]=' ';
		_textTile[2][2]=' ';
		
		_textTile[1][0]='3';
		_textTile[3][1]='2';
		_textTile[2][3]='1';
		_textTile[0][2]='4';
		
		int a = t.connectEdge(1);
		int b = t.connectEdge(3);
		int c = t.connectEdge(5);
		int d = t.connectEdge(7);
		
		if (a==0){_textTile[2][0]='3';}
		if (a==2){_textTile[2][0]='2';}
		if (a==4){_textTile[2][0]='1';}
		if (a==6){_textTile[2][0]='4';}
		
		if (b==0){_textTile[3][2]='3';}
		if (b==2){_textTile[3][2]='2';} 
		if (b==4){_textTile[3][2]='1';} 
		if (b==6){_textTile[3][2]='4';} 
		
		if (c==0){_textTile[1][3]='3';}
		if (c==2){_textTile[1][3]='2';} 
		if (c==4){_textTile[1][3]='1';} 
		if (c==6){_textTile[1][3]='4';}
		
		if (d==0){_textTile[0][1]='3';}
		if (d==2){_textTile[0][1]='2';} 
		if (d==4){_textTile[0][1]='1';} 
		if (d==6){_textTile[0][1]='4';}
		
	}
	/*
	 * prints out the tile that is currently available for placing
	 */
	public void displayTile(Tile t){
		setTextTile(t);
		for(int y = 0; y<4 ; y++){
			print('\n');
			for(int x = 0; x<4 ; x++){
				print(_textTile[x][y]);
			}
		}
		print('\n');
	}
	/*
	 * this displays the current score
	 */
	public void displayScore(HashMap<String, Integer> pm, String[] pa){
		for(String p : pa){
			int score = pm.get(p);
			print(p+": "+score+"   ");
		}
		print('\n');
	}
	/*
	 * this prints out the winning player if the other player resigns the game
	 */
	public void resign(HashMap<String, Integer> pm, String[] pl){
		print("The game is over:");
		displayScore(pm, pl);
	}
	/*
	 * This displays the player who's turn it is
	 */
	public void displayPlayer(String pl){
		System.out.println("It is "+pl+"'s turn."+'\n');
	}
	/*
	 * this displays how the board currently looks
	 */
	public void displayBoard(){
		for(int y = 0; y<50 ; y++){
			print('\n');
			for(int x = 0; x<50 ; x++){
				print(_tempBoard[x][y]);
			}
		}
		print('\n');
	}
	
	/*
	 * this permanently changes the representation of the board to how it looks with the tile placed that turn
	 */
	public void commit(){
		for(int x=0; x<50; x++){
			for(int y=0; y<50; y++){
				_textBoard[x][y]=_tempBoard[x][y];
			}
		}
	}
	
	/*
	 * This alters the text based representation of the board to include a new given tile that is placed at a given position
	 * This is done in a temporary way so that the tile can be easily removed before committing
	 */
	public void placeTile(int x, int y, Tile t){
		if(t!=null){
			setTextTile(t);
			for(int tx = 0; tx<4 ; tx++){
				for(int ty = 0; ty<4; ty++){
					_tempBoard[4*(x-1)+1+tx][4*(y-1)+1+ty]= _textTile[tx][ty];
				}
			}
		}
		else{
		}
	}
	
	/*
	 * This alters the text based representation of the board to no longer include the tile that was previously placed
	 */
	public void remove(){
		for(int x=0; x<50; x++){
			for(int y=0; y<50; y++){
				_tempBoard[x][y]=_textBoard[x][y];
			}
		}
	}
	/*
	 * This method prints out the winner and the final scores based on the values given to it representing the scores of the two players
	 */
	public void declareWinner(HashMap<String, Integer> pm, String[] pl) {
		LinkedList<Integer> scoresList = new LinkedList<Integer>();
		for(String s : pl){
			scoresList.add(pm.get(s));
		}
		Collections.sort(scoresList);
		Integer highest = scoresList.getLast();
		String winner = "";
		for(String s : pl){
			if(highest == pm.get(s)){
				winner = s;
			}
		}
		printLN("The winner is "+winner+"!");
	}
	
	/*
	 * The following three methods are simply output lines for a few different scenarios in which a player tries to do something that can't be done
	 */
	public void cantPlace(){
		System.out.println("You can't place that tile there!");
	}
	public void alreadyPlace(){
		System.out.println("You have already placed a tile!");
	}
	public void haventPlace(){
		System.out.println("You haven't placed a tile yet!");
	}
	
	/*
	 * The activate and deactivate change the boolean that signifies whether or not the Text UI is the currently active UI
	 */
	public void activate(){
		_active = true;
	}
	public void deactivate(){
		_active = false;
	}
	
	private void printLN(String s){
		if(_active){
			System.out.println(s);
		}
	}
	private void print(String s){
		if(_active){
			System.out.print(s);
		}
	}
	private void print(char c){
		if(_active){
			System.out.print(c);
		}
	}
	
	
}
