package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


import tiles.Tile;
import tiles.TileA;
import tiles.TileB;
import tiles.TileC;
import tiles.TileD;
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

/*
 * The game handles constructing the board and reading the console commands, then calling methods on the board and GUI when the appropriate commands are given
 * The game also determines when the game has completed and calls the appropriate methods on GUI to display the winner and then terminates the program
 * The game constructor has two booleans that are supposed to be true when playing, but need to  be false when testing
 */
public class Game {
	
	GUI _graphicalUI;
	int _playerNumber;
	Scanner _consoleReader;
	public Stack<Tile> _tileStack;
	LinkedList<Station> _stationList;
	public int _player1 = 0;
	public int _player2 = 0;
	public Board _board;
	String _textBoard="";
	String _tempTextBoard="";
	public String _currentPlayer;
	public Tile _currentTile;
	TextGUI _textUI;
	boolean _infWhile;
	public boolean _introLoop;
	boolean _loaded = false;
	int _currentPlayerNumber= 0;

	public LinkedList<String> _playerList = new LinkedList<String>();
	String[] _playerArray;
	public HashMap <String, Integer> _playerMap = new HashMap <String, Integer>();
	
	public Game(boolean a, boolean b){
		//SET UP INITIAL PLAYERS
		_introLoop = b;
		_infWhile = a;
		_consoleReader = new Scanner(System.in);
		
		System.out.println("Enter player name: ");
		while(_introLoop){
			String command = _consoleReader.nextLine();
			if(!command.equals("Done")){
				if(_playerList.size()<9){
					_playerMap.put(command, 0);
					_playerList.add(command);
				}
				else{
					if(_playerList.size()>1){
						System.out.println("Game is full");
					}
					else{System.out.println("Not enough players");}
				}
			}
			else{_introLoop = false;}
		}
		
		_playerNumber = _playerList.size();
		_playerArray = new String[_playerNumber];
		Iterator<String> tempIt = _playerList.iterator();
		for(int i = 0; i<_playerNumber ; i++){
			_playerArray[i]=tempIt.next();
		}
		
		//INITIAL PLAYERS SET UP COMPLETE
		
		//SET UP GAME COMPONENTS
		_stationList = new LinkedList<Station>();
		_textUI = new TextGUI(_board);
		_graphicalUI = new GUI(_board, _playerArray, _playerMap);
		setUpStations(_playerNumber);
		_currentPlayer = _playerList.getFirst();
		_board = new Board();
		load();
		//STUFF THAT SHOULD NOT HAPPEN IF A GAME LOADS
		if(!_loaded){
			_textBoard = "-----------------------------------------------------------------##----------##-----------------------------------------------------------------";
			for(int i = 0; i<_playerNumber ; i++){
				_textBoard = "0 "+_textBoard;
			}
			
			_tileStack = new Stack<Tile>();
			for(int i = 0 ; i<6 ; i++){
				_tileStack.push(new TileA(_board));
				_tileStack.push(new TileB(_board));
				_tileStack.push(new TileC(_board));
				_tileStack.push(new TileD(_board));
				_tileStack.push(new TileE(_board));
				_tileStack.push(new TileF(_board));
				_tileStack.push(new TileG(_board));
				_tileStack.push(new TileH(_board));
				_tileStack.push(new TileI(_board));
				_tileStack.push(new TileJ(_board));
				_tileStack.push(new TileK(_board));
				_tileStack.push(new TileL(_board));
				_tileStack.push(new TileM(_board));
				_tileStack.push(new TileN(_board));
				_tileStack.push(new TileO(_board));
				_tileStack.push(new TileP(_board));
				_tileStack.push(new TileQ(_board));
				_tileStack.push(new TileR(_board));
				_tileStack.push(new TileS(_board));
				_tileStack.push(new TileT(_board));
				_tileStack.push(new TileU(_board));
				_tileStack.push(new TileV(_board));
				_tileStack.push(new TileW(_board));
				_tileStack.push(new TileX(_board));
			}
			Collections.shuffle(_tileStack);
			_currentTile = _tileStack.pop();
		}
		////////////////////////////////////////
		
		_textUI.displayPlayer(_currentPlayer);
		_textUI.displayScore(_playerMap, _playerArray);
		_textUI.displayBoard();
		if(_currentTile!=null){
			_textUI.displayTile(_currentTile);
		}
		_graphicalUI.startTurn(_currentTile.getType()+"");
		
		
		/*
		 * this while loop is meant to be infinite, although a game can be constructed with this loop inactive, which is only done for testing purposes, as the tests would not run due to the infinite loop
		 *this loop is always checking what the most recently read value from the console was to determine what the game should do
		 *many commands are regulated to the GUI to print out information that is concurrent with what is happening behind the scenes with the game and the board
		 */
		String command;
		while(_infWhile){
			command = _consoleReader.nextLine();
			if(command.equals("commit")){
				if(commit()){
					_textUI.commit();
					_textUI.displayPlayer(_currentPlayer);
					_textUI.displayScore(_playerMap, _playerArray);
					_textUI.displayBoard();
					_textBoard = _tempTextBoard;
					_tempTextBoard = "";
					_graphicalUI.update(_textBoard);
					if(_tileStack.size()>3){
						_textUI.displayTile(_currentTile);
						_graphicalUI.startTurn(_currentTile.getType()+"");
					}
					else{
						_textUI.declareWinner(_playerMap, _playerArray);
						_graphicalUI.startTurn("$");
						_infWhile=false;
					}
				}
			}
			else if(command.equals("save")){
				save();
			}
			else if(command.equals("tui")){
				_textUI.activate();
				_graphicalUI.command("tui");
				_textUI.displayPlayer(_currentPlayer);
				_textUI.displayScore(_playerMap, _playerArray);
				_textUI.displayBoard();
				_textUI.displayTile(_currentTile);
				
			}
			else if(command.equals("gui")){
				_textUI.deactivate();
				_graphicalUI.command("gui");
			}
			else if(command.equals("remove")){
				_textUI.remove();
				_tempTextBoard = "";
				remove();
				_graphicalUI.update(_textBoard);
			}
			else if(command.length()>=11 && command.charAt(0)=='p' && command.charAt(1)=='l' && command.charAt(2)=='a' && command.charAt(3)=='c' && command.charAt(4)=='e' && command.charAt(5)=='('&&command.charAt(command.length()-1)==')'){
				int x;
				int y;
				if(command.charAt(7)!=','&&command.charAt(8)==','){
					x = 10+Character.getNumericValue(command.charAt(7));
				}
				else if(command.charAt(7)==','){
					x = Character.getNumericValue(command.charAt(6));
				}
				else{
					x = 0;
				}
				if(command.charAt(7)!=',' &&command.charAt(8)==','){
					if(command.charAt(11)!=')'&& command.charAt(12)==')'){
						y = 10+Character.getNumericValue(command.charAt(11));
					}
					else if(command.charAt(11)==')'){
						y = Character.getNumericValue(command.charAt(10));
					}
					else{y = 0;
					}
				}
				else{
					if(command.charAt(10)!=')'&&command.charAt(11)==')'){
						y = 10+Character.getNumericValue(command.charAt(10));
					}
					else if(command.charAt(10)==')'){
						y = Character.getNumericValue(command.charAt(9));
					}
					else{y = 0;}
				}
				
				
				try{
					Tile placed = _currentTile;
					if(place(x,y)){
						_textUI.placeTile(x, y, placed);
//						int numSpaces = 0;
//						int numChars = 0;
//						while(numSpaces<_playerNumber){
//							if(_textBoard.charAt(numChars)==' '){
//								numSpaces++;
//							}
//							numChars++;
//						}
//						
//						int charTilePosition = (numChars-1)+(12*(y-1))+(x);
//						char tileType = placed.getType();
//						for(int i = 0; i<_textBoard.length(); i++){
//							if(i == charTilePosition){
//								_tempTextBoard = _tempTextBoard+tileType;
//							}
//							else{
//								_tempTextBoard = _tempTextBoard +_textBoard.charAt(i);
//							}
//						}
//						_graphicalUI.update(_tempTextBoard);
					}
					else{
						_textUI.cantPlace();
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					_textUI.remove();
					_textUI.cantPlace();
				}
				
			}
			else if(command.equals("display score")){
				_textUI.displayScore(_playerMap, _playerArray);
			}
			else if(command.equals("display tile")){
				if(_currentTile!=null){
					_textUI.displayTile(_currentTile);
				}
				else{
					_textUI.alreadyPlace();
				}
			}	
			else if(command.equals("resign")){
				_playerMap.put(_currentPlayer, 0);
				_textUI.resign(_playerMap, _playerArray);
				_graphicalUI.command("resign");
				_infWhile=false;
			}
			else if(command.equals("display player")){
				_textUI.displayPlayer(_currentPlayer);
			}
			else if(command.equals("display board")){
				_textUI.displayBoard();
			}
			else{
				System.err.println("I'm sorry, I didn't quite catch that. Try again!");
			}
		}
	} 
	
	
	private void load() {
		String fileName = "";
		for(String s : _playerArray){
			fileName = fileName+s+" ";
		}
		
		fileName = fileName+".txt";
		Scanner scanner;
			try {
				scanner = new Scanner(new java.io.File(fileName));
				boolean loadLoop = true;
				System.out.println("Would you like to load your previous game?");
				System.out.println("yes or no:");
				while(loadLoop){
					
					String command = _consoleReader.nextLine();
					
					
					if(command.equals("yes")){
						loadLoop = false;
						String tempTextBoard=scanner.next();
						for(int i = 0; i<tempTextBoard.length(); i++){
							if(tempTextBoard.charAt(i)!='_'){
								_textBoard=_textBoard+tempTextBoard.charAt(i);
							}
							else{_textBoard = _textBoard+' ';}
						}
						
						int start =50000;
						for(int i = 0; i<40; i++){
							if(_textBoard.charAt(i)=='-'||_textBoard.charAt(i)=='a'||_textBoard.charAt(i)=='b'||_textBoard.charAt(i)=='c'||_textBoard.charAt(i)=='d'||_textBoard.charAt(i)=='e'||_textBoard.charAt(i)=='f'||_textBoard.charAt(i)=='g'||_textBoard.charAt(i)=='h'||_textBoard.charAt(i)=='i'||_textBoard.charAt(i)=='j'||_textBoard.charAt(i)=='k'||_textBoard.charAt(i)=='l'||_textBoard.charAt(i)=='m'||_textBoard.charAt(i)=='n'||_textBoard.charAt(i)=='o'||_textBoard.charAt(i)=='p'||_textBoard.charAt(i)=='q'||_textBoard.charAt(i)=='r'||_textBoard.charAt(i)=='s'||_textBoard.charAt(i)=='t'||_textBoard.charAt(i)=='u'||_textBoard.charAt(i)=='v'||_textBoard.charAt(i)=='w'||_textBoard.charAt(i)=='x'){
								if(i<start){
									start = i;
								}
							}
						}
						String guiTextBoard = "";
						for(int i = start; i<_textBoard.length(); i++){
							guiTextBoard = guiTextBoard+_textBoard.charAt(i);
							if(_textBoard.charAt(i)!='-'){
								int y = ((i-start)/12)+1;
								int x = ((i-start)%12)+1;
								
								if(_textBoard.charAt(i)=='a'){
									_board.placeTile(x,y,new TileA(_board));
								}
								if(_textBoard.charAt(i)=='b'){
									_board.placeTile(x,y,new TileB(_board));
								}
								if(_textBoard.charAt(i)=='c'){
									_board.placeTile(x,y,new TileC(_board));
								}
								if(_textBoard.charAt(i)=='d'){
									_board.placeTile(x,y,new TileD(_board));
								}
								if(_textBoard.charAt(i)=='e'){
									_board.placeTile(x,y,new TileE(_board));
								}
								if(_textBoard.charAt(i)=='f'){
									_board.placeTile(x,y,new TileF(_board));
								}
								if(_textBoard.charAt(i)=='g'){
									_board.placeTile(x,y,new TileG(_board));
								}
								if(_textBoard.charAt(i)=='h'){
									_board.placeTile(x,y,new TileH(_board));
								}
								if(_textBoard.charAt(i)=='i'){
									_board.placeTile(x,y,new TileI(_board));
								}
								if(_textBoard.charAt(i)=='j'){
									_board.placeTile(x,y,new TileJ(_board));
								}
								if(_textBoard.charAt(i)=='k'){
									_board.placeTile(x,y,new TileK(_board));
								}
								if(_textBoard.charAt(i)=='l'){
									_board.placeTile(x,y,new TileL(_board));
								}
								if(_textBoard.charAt(i)=='m'){
									_board.placeTile(x,y,new TileM(_board));
								}
								if(_textBoard.charAt(i)=='n'){
									_board.placeTile(x,y,new TileN(_board));
								}
								if(_textBoard.charAt(i)=='o'){
									_board.placeTile(x,y,new TileO(_board));
								}
								if(_textBoard.charAt(i)=='p'){
									_board.placeTile(x,y,new TileP(_board));
								}
								if(_textBoard.charAt(i)=='q'){
									_board.placeTile(x,y,new TileQ(_board));
								}
								if(_textBoard.charAt(i)=='r'){
									_board.placeTile(x,y,new TileR(_board));
								}
								if(_textBoard.charAt(i)=='s'){
									_board.placeTile(x,y,new TileS(_board));
								}
								if(_textBoard.charAt(i)=='t'){
									_board.placeTile(x,y,new TileT(_board));
								}
								if(_textBoard.charAt(i)=='u'){
									_board.placeTile(x,y,new TileU(_board));
								}
								if(_textBoard.charAt(i)=='v'){
									_board.placeTile(x,y,new TileV(_board));
								}
								if(_textBoard.charAt(i)=='w'){
									_board.placeTile(x,y,new TileW(_board));
								}
								if(_textBoard.charAt(i)=='x'){
									_board.placeTile(x,y,new TileX(_board));
								}
							}
						}
						_graphicalUI.update(_textBoard);
						
						
						String tempTUI = scanner.next();
						String TUI = "";
						for(int i = 0; i<tempTUI.length(); i++){
							if(tempTUI.charAt(i)!='-'){
								TUI = TUI+tempTUI.charAt(i);
							}
							else{TUI = TUI+' ';}
						}
						int x = 0;
						int y = 0;
						for(int i = 0; i<TUI.length(); i++){
							if(x<50){
								_textUI._tempBoard[x][y]=TUI.charAt(i);
								x++;
							}
							else{
								x = 0;
								y++;
								_textUI._tempBoard[x][y]=TUI.charAt(i);
								x++;
							}
						}
						_textUI._textBoard = _textUI._tempBoard;
						
						String tiles = scanner.next();
						Stack<Tile> tempStack = new Stack<Tile>();
						for(int i = 0; i<tiles.length(); i++){
							if(tiles.charAt(i)=='a'){
								tempStack.push(new TileA(_board));
							}
							if(tiles.charAt(i)=='b'){
								tempStack.push(new TileB(_board));
							}
							if(tiles.charAt(i)=='c'){
								tempStack.push(new TileC(_board));
							}
							if(tiles.charAt(i)=='d'){
								tempStack.push(new TileD(_board));
							}
							if(tiles.charAt(i)=='e'){
								tempStack.push(new TileE(_board));
							}
							if(tiles.charAt(i)=='f'){
								tempStack.push(new TileF(_board));
							}
							if(tiles.charAt(i)=='g'){
								tempStack.push(new TileG(_board));
							}
							if(tiles.charAt(i)=='h'){
								tempStack.push(new TileH(_board));
							}
							if(tiles.charAt(i)=='i'){
								tempStack.push(new TileI(_board));
							}
							if(tiles.charAt(i)=='j'){
								tempStack.push(new TileJ(_board));
							}
							if(tiles.charAt(i)=='k'){
								tempStack.push(new TileK(_board));
							}
							if(tiles.charAt(i)=='l'){
								tempStack.push(new TileL(_board));
							}
							if(tiles.charAt(i)=='m'){
								tempStack.push(new TileM(_board));
							}
							if(tiles.charAt(i)=='n'){
								tempStack.push(new TileN(_board));
							}
							if(tiles.charAt(i)=='o'){
								tempStack.push(new TileO(_board));
							}
							if(tiles.charAt(i)=='p'){
								tempStack.push(new TileP(_board));
							}
							if(tiles.charAt(i)=='q'){
								tempStack.push(new TileQ(_board));
							}
							if(tiles.charAt(i)=='r'){
								tempStack.push(new TileR(_board));
							}
							if(tiles.charAt(i)=='s'){
								tempStack.push(new TileS(_board));
							}
							if(tiles.charAt(i)=='t'){
								tempStack.push(new TileT(_board));
							}
							if(tiles.charAt(i)=='u'){
								tempStack.push(new TileU(_board));
							}
							if(tiles.charAt(i)=='v'){
								tempStack.push(new TileV(_board));
							}
							if(tiles.charAt(i)=='w'){
								tempStack.push(new TileW(_board));
							}
							if(tiles.charAt(i)=='x'){
								tempStack.push(new TileX(_board));
							}
						}
						_tileStack = new Stack<Tile>();
						while(!tempStack.isEmpty()){
							_tileStack.push(tempStack.pop());
						}
						
						String cT = scanner.next();
						char cTChar = cT.charAt(0);
						if(Character.getNumericValue(cTChar)==1){
							_currentTile = _tileStack.pop();
						}
						
						_currentPlayer = scanner.next();
						String cPN = scanner.next();
						char cPNChar = cPN.charAt(0);
						_currentPlayerNumber = Character.getNumericValue(cPNChar);
						_graphicalUI._currentPlayer = _currentPlayerNumber-1;
						_loaded = true;
					}
					else if(command.equals("no")){
						loadLoop=false;
					}
					else{
						System.err.println("I'm sorry, I didn't quite catch that. Try again!");
					}
				}
			}
			catch (FileNotFoundException e) {
				//DO NOTHING
			}
	}

	private void save() {
		String fileName = "";
		String tileList = "";
		for(String s : _playerArray){
			fileName = fileName+s+" ";
		}
		File f = new File(fileName+".txt");
		try {
			PrintStream ps = new PrintStream(f);
			String tempTextBoard = "";
			for(int i = 0; i<_textBoard.length() ; i++){
				if(_textBoard.charAt(i)!=' '){
					tempTextBoard = tempTextBoard+_textBoard.charAt(i);
				}
				else{tempTextBoard= tempTextBoard+'_';}
			}
			ps.println(tempTextBoard);
			ps.print('\n');
			for(int y = 0; y<50 ; y++){
				for(int x = 0; x<50 ; x++){
					if(_textUI._tempBoard[x][y]!=' '){
						ps.print(_textUI._tempBoard[x][y]);
					}
					else{ps.print('-');}
				}
			}
			for(Tile t : _tileStack){
				tileList=tileList+t.getType();
			}
			ps.print('\n');
			ps.println(tileList);
			if(_currentTile == null){
				ps.println('0');
			}
			else{ps.println('1');}
			ps.println(_currentPlayer);
			ps.println(_currentPlayerNumber);
			
			
			ps.close();
		}
		catch (FileNotFoundException e) {
			// DO NOTHING
		}
	}

	private void setUpStations(int players){
		int playerCheck=1;
		for(int x =1; x<13; x++){
			switch(playerCheck){
				case 1:
					_stationList.add(new Station(1,x,1,0));
					playerCheck = 2;
					break;
				case 2:
					_stationList.add(new Station(2,x,1,0));
					if(players == 2){playerCheck = 1;}
					else{playerCheck = 3;}
					break;
				case 3:
					_stationList.add(new Station(3,x,1,0));
					if(players == 3){playerCheck = 1;}
					else{playerCheck = 4;}
					break;
				case 4:
					_stationList.add(new Station(4,x,1,0));
					if(players == 4){playerCheck = 1;}
					else{playerCheck = 5;}
					break;
				case 5:
					_stationList.add(new Station(5,x,1,0));
					if(players == 5){playerCheck = 1;}
					else{playerCheck = 6;}
					break;
				case 6:
					_stationList.add(new Station(6,x,1,0));
					if(players == 6){playerCheck = 1;}
					else{playerCheck = 7;}
					break;
				case 7:
					_stationList.add(new Station(7,x,1,0));
					if(players == 7){playerCheck = 1;}
					else{playerCheck = 8;}
					break;
				case 8:
					_stationList.add(new Station(8,x,1,0));
					playerCheck = 1;
					break;
			}
		}
		for(int y=1; y<13; y++){
			switch(playerCheck){
				case 1:
					_stationList.add(new Station(1,12,y,2));
					playerCheck = 2;
					break;
				case 2:
					_stationList.add(new Station(2,12,y,2));
					if(players == 2){playerCheck = 1;}
					else{playerCheck = 3;}
					break;
				case 3:
					_stationList.add(new Station(3,12,y,2));
					if(players == 3){playerCheck = 1;}
					else{playerCheck = 4;}
					break;
				case 4:
					_stationList.add(new Station(4,12,y,2));
					if(players == 4){playerCheck = 1;}
					else{playerCheck = 5;}
					break;
				case 5:
					_stationList.add(new Station(5,12,y,2));
					if(players == 5){playerCheck = 1;}
					else{playerCheck = 6;}
					break;
				case 6:
					_stationList.add(new Station(6,12,y,2));
					if(players == 6){playerCheck = 1;}
					else{playerCheck = 7;}
					break;
				case 7:
					_stationList.add(new Station(7,12,y,2));
					if(players == 7){playerCheck = 1;}
					else{playerCheck = 8;}
					break;
				case 8:
					_stationList.add(new Station(8,12,y,2));
					playerCheck = 1;
					break;
				}
			}
			for(int x =12; x>0; x--){
				switch(playerCheck){
					case 1:
						_stationList.add(new Station(1,x,12,4));
						playerCheck = 2;
						break;
					case 2:
						_stationList.add(new Station(2,x,12,4));
						if(players == 2){playerCheck = 1;}
						else{playerCheck = 3;}
						break;
					case 3:
						_stationList.add(new Station(3,x,12,4));
						if(players == 3){playerCheck = 1;}
						else{playerCheck = 4;}
						break;
					case 4:
						_stationList.add(new Station(4,x,12,4));
						if(players == 4){playerCheck = 1;}
						else{playerCheck = 5;}
						break;
					case 5:
						_stationList.add(new Station(5,x,12,4));
						if(players == 5){playerCheck = 1;}
						else{playerCheck = 6;}
						break;
					case 6:
						_stationList.add(new Station(6,x,12,4));
						if(players == 6){playerCheck = 1;}
						else{playerCheck = 7;}
						break;
					case 7:
						_stationList.add(new Station(7,x,12,4));
						if(players == 7){playerCheck = 1;}
						else{playerCheck = 8;}
						break;
					case 8:
						_stationList.add(new Station(8,x,12,4));
						playerCheck = 1;
						break;
				}
			}
			for(int y=12; y>0; y--){
				switch(playerCheck){
					case 1:
						_stationList.add(new Station(1,1,y,6));
						playerCheck = 2;
						break;
					case 2:
						_stationList.add(new Station(2,1,y,6));
						if(players == 2){playerCheck = 1;}
						else{playerCheck = 3;}
						break;
					case 3:
						_stationList.add(new Station(3,1,y,6));
						if(players == 3){playerCheck = 1;}
						else{playerCheck = 4;}
						break;
					case 4:
						_stationList.add(new Station(4,1,y,6));
						if(players == 4){playerCheck = 1;}
						else{playerCheck = 5;}
						break;
					case 5:
						_stationList.add(new Station(5,1,y,6));
						if(players == 5){playerCheck = 1;}
						else{playerCheck = 6;}
						break;
					case 6:
						_stationList.add(new Station(6,1,y,6));
						if(players == 6){playerCheck = 1;}
						else{playerCheck = 7;}
						break;
					case 7:
						_stationList.add(new Station(7,1,y,6));
						if(players == 7){playerCheck = 1;}
						else{playerCheck = 8;}
						break;
					case 8:
						_stationList.add(new Station(8,1,y,6));
						playerCheck = 1;
						break;
				}
		}
		
	}
	
	/*
	 * This is the method called when the player inputs commit
	 * First it checks to make sure the current tile placement is legal
	 * If so, for each of the stations, if they have not yet been completed, it checks to see how many points they return, which in most cases will be zero
	 * If a station was completed and did return points, the playe that the station belongs to is given those points and the station is then considered "complete" which means it will not return points anymore durring the game
	 */
	public boolean commit(){
		
		if(_board.checkLegalTile()){
			
			for(Station s : _stationList){
				if(!s.checkComplete()){
					int playerNum = s.getPlayer();
					int points = _board.checkConnection(s.getX(),s.getY(),s.getAry(),0);
					String player = _playerArray[playerNum-1];
					Integer prevPoints = _playerMap.get(player);
					Integer newPoints = prevPoints + points;
					_playerMap.put(player, newPoints);
					if(points>0){
						s.complete();
					}
					
					int numSpaces=0;
					int numChars=0;
					int charToStart=0;
					while (numSpaces< playerNum){
						if(numSpaces< playerNum-1){
							numChars++;
						}
						if(_tempTextBoard.charAt(charToStart)==' '){
							numSpaces++;
						}
						charToStart++;
					}
					charToStart--;
					
					String sNewPoints = newPoints.toString();
					String tempTempTextBoard = "";
					for(int i=0; i<numChars; i++){
						tempTempTextBoard = tempTempTextBoard + _tempTextBoard.charAt(i);
					}
					tempTempTextBoard = tempTempTextBoard + sNewPoints;
					for(int i=charToStart; i<_tempTextBoard.length(); i++){
						tempTempTextBoard = tempTempTextBoard + _tempTextBoard.charAt(i);
					}
					_tempTextBoard = tempTempTextBoard;
				}
				else{
					
				}
			}
			_board.commit();
			_currentPlayerNumber++;
			if(_currentPlayerNumber<_playerNumber){
				_currentPlayer = _playerArray[_currentPlayerNumber];
			}
			else{
				_currentPlayerNumber = 0;
				_currentPlayer = _playerArray[0];
			}
			if(_tileStack.size()>0){
			_currentTile = _tileStack.pop();
			}
			return true;
		}
		else{
			_textUI.cantPlace();
			return false;
		}
		
	}
	/*
	 * places the tile at the given x and y positions as long as there is a tile available to place
	 * passes the command onto board, which may or may not place it depending on the whether the given x and y values are "legal"
	 * changes the state of the current tile to indicate that there is no current tile, as it has been placed
	 * returns true if the tile was placed successfully and false if not
	 */
	public boolean place (int x, int y){
		if(_currentTile != null){
			if(_board.placeTile(x, y, _currentTile)){
				Tile placed = _currentTile;
				int numSpaces = 0;
				int numChars = 0;
				while(numSpaces<_playerNumber){
					if(_textBoard.charAt(numChars)==' '){
						numSpaces++;
					}
					numChars++;
				}
				
				int charTilePosition = (numChars-1)+(12*(y-1))+(x);
				char tileType = placed.getType();
				for(int i = 0; i<_textBoard.length(); i++){
					if(i == charTilePosition){
						_tempTextBoard = _tempTextBoard+tileType;
					}
					else{
						_tempTextBoard = _tempTextBoard +_textBoard.charAt(i);
					}
				}
				_graphicalUI.update(_tempTextBoard);
				_currentTile = null;
				return true;
			}
			
		}
		else{
			_textUI.alreadyPlace();
		}
		return false;
	}
	
	/*
	 * removes the tile that was currently placed if and only if a tile has already been placed
	 * passes the remove command onto board
	 * makes the value of the current tile that of the tile that was removed
	 */
	public void remove(){
		if(_currentTile==null){
			_currentTile = _board.remove();
		}
		else{
			_textUI.haventPlace();
		}
	}

}
