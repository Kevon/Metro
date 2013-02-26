package code;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/*
 * This class creates a GUI representation of the game including a window for each player
 */
public class GUI {
	Board _board;
	HashMap <String, Integer> _playerMap;
	String[] _playerArray;
	GameFrame[] _frameArray;
	public int _currentPlayer = -1;
	String _textBoard = "-----------------------------------------------------------------##----------##-----------------------------------------------------------------";
	public GUI(Board b, String[] pa, HashMap <String, Integer> pm){
		_board = b;
		_playerMap = pm;
		_playerArray = pa;
		_frameArray = new GameFrame[_playerArray.length];
		
		for(int i = 0; i < _playerArray.length; i++){
			GameFrame jf = new GameFrame(_playerArray[i]);
			_frameArray[i] = jf;
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setVisible(true);
		
			BufferedImage board = loadImage("src/Images/Board.jpg");
			
			ImageIcon iboard = new ImageIcon(board);
			JLabel lboard = new JLabel(iboard);
			lboard.setBounds(0,0,655,655);
			jf.getBoardPanel().add(lboard, new Integer(0));
			
			String playerscores = "";
			for (String s : _playerArray){
				playerscores = playerscores + s + ": " + _playerMap.get(s) + "   ";
			}
			JLabel scores = new JLabel(playerscores);
			jf.getScoresPanel().add(scores);
			
			jf.getBoardPanel().setMinimumSize(new Dimension(655, 805));
	
			jf.setMinimumSize(new Dimension(655, 655));
		}
	}

	
	private class GameFrame extends JFrame{
		JLayeredPane _boardPanel = new JLayeredPane();
		JPanel _southPanel = new JPanel();
		JPanel _scoresPanel = new JPanel();
		JPanel _tilePanel = new JPanel();
		
		private GameFrame(String name){
			super(name);
			
			this.getContentPane().setLayout(new BorderLayout());
			this.add(_boardPanel, BorderLayout.NORTH);

			_boardPanel.setPreferredSize(new Dimension(655,655));

			this.add(_southPanel, BorderLayout.SOUTH);
			_southPanel.add(_tilePanel, BorderLayout.EAST);
			_southPanel.add(_scoresPanel, BorderLayout.WEST);
			_scoresPanel.setLayout(new BoxLayout(_scoresPanel, BoxLayout.Y_AXIS));
			_southPanel.setMinimumSize(new Dimension(655, 100));
		}
		
		public JLayeredPane getBoardPanel(){
			return _boardPanel;
		}
		public JPanel getScoresPanel(){
			return _scoresPanel;
		}
		public JPanel getTilePanel(){
			return _tilePanel;
		}
	}
	
	/*
	 * This method allows the Game to communicate with the GUI by giving it commands which is denoted by the string passed in.  The mehtod returns true if it recognizes the command and false if it does not
	 */
	public boolean command(String s){
		System.out.println(_frameArray.length);
		if(s.equals("gui")){
			for(int i = 0; i<_frameArray.length; i++){
				_frameArray[i].setVisible(true);
			}
			return true;
		}
		else if(s.equals("tui")){
			for(int i = 0; i<_frameArray.length; i++){
				_frameArray[i].setVisible(false);
			}
			return true;
		}
		else if(s.equals("resign")){
			resign();
		}
		return false;
		
	}
	
	private void resign() {
		update(_textBoard);
		for(GameFrame gj : _frameArray){
			gj.getScoresPanel().add(new JLabel("The game is over!"));
			gj.repaint();
			gj.pack();
		}
	}

	/*
	 * This method passes along the string representation of the board after it changes so that the GUI can update its representation of the board
	 */
	
	public void update(String s){
		String playerscores = "";
		for (String pl : _playerArray){
			playerscores = playerscores + pl + ": " + _playerMap.get(pl) + "   ";
		}
		for(GameFrame f : _frameArray){
			JLabel scores = new JLabel(playerscores);
			
			f.getScoresPanel().removeAll();
			f.getScoresPanel().add(scores);
			
			f.repaint();
			f.pack();
		}
		
		int start=50000;
		for(int i = 0; i<40; i++){
			if(s.charAt(i)=='-'||s.charAt(i)=='a'||s.charAt(i)=='b'||s.charAt(i)=='c'||s.charAt(i)=='d'||s.charAt(i)=='e'||s.charAt(i)=='f'||s.charAt(i)=='g'||s.charAt(i)=='h'||s.charAt(i)=='i'||s.charAt(i)=='j'||s.charAt(i)=='k'||s.charAt(i)=='l'||s.charAt(i)=='m'||s.charAt(i)=='n'||s.charAt(i)=='o'||s.charAt(i)=='p'||s.charAt(i)=='q'||s.charAt(i)=='r'||s.charAt(i)=='s'||s.charAt(i)=='t'||s.charAt(i)=='u'||s.charAt(i)=='v'||s.charAt(i)=='w'||s.charAt(i)=='x'){
				if(i<start){
					start = i;
				}
			}
		}
		
		int changedPos=50000;
		int lastChangedPos = changedPos;
		String tile="";
		for(int i = 0; i<_textBoard.length(); i++){
			if(_textBoard.charAt(i)!=s.charAt(start+i)){
				changedPos=i;
				tile = ""+s.charAt(start+i);
				String newBoard="";
				for(int j=0; j<_textBoard.length(); j++){
					if(j!=changedPos){
						newBoard=newBoard+_textBoard.charAt(j);
					}
					else{newBoard=newBoard+tile;}
				}
				_textBoard=newBoard;
				if(changedPos!=50000 && changedPos!=lastChangedPos){
					int x;
					int y;
					int pixX;
					int pixY;
					y = changedPos/12;
					x = changedPos%12;
					pixX=50*x+27;
					pixY=50*y+27;
					if(!tile.equals(""+'-')){
						BufferedImage tileImage = getTileImage(tile);
						ImageIcon itile = new ImageIcon(tileImage);
						
						for(int k=0; k<_frameArray.length; k++){
							JLabel ltile = new JLabel(itile);
							ltile.setBounds(pixX,pixY,50,50);
							GameFrame gj = _frameArray[k];
							gj.getBoardPanel().add(ltile, new Integer(1));
							gj.repaint();
							gj.pack();
						}
					}
					else{
						for(int l=0; l<_frameArray.length; l++){
							GameFrame gj = _frameArray[l];
							gj.getBoardPanel().remove(gj.getBoardPanel().getComponentAt(pixX,pixY));
							gj.repaint();
							gj.pack();
						}
					}
				}
				lastChangedPos=changedPos;
			}
		}
	}
	
	/*
	 * This method is used to display the tile that a player is able to place at the beginning of his turn based upon the string passed in which will be the type of a tile.
	 */
	
	public void startTurn(String s){
		if(s.equals("$")){
			LinkedList<Integer> scoresList = new LinkedList<Integer>();
			for(String p : _playerArray){
				scoresList.add(_playerMap.get(p));
			}
			Collections.sort(scoresList);
			Integer highest = scoresList.getLast();
			String winner = "";
			for(String p : _playerArray){
				if(highest == _playerMap.get(p)){
					winner = p;
				}
			}
			for(GameFrame gf : _frameArray){
				gf.getScoresPanel().add(new JLabel(winner+ " is the winner!"));
				gf.repaint();
				gf.pack();
			}
		}
		else{
			BufferedImage tile = getTileImage(s);
			
			ImageIcon itile = new ImageIcon(tile);
			JLabel ltile = new JLabel(itile);
			if(_currentPlayer<_playerArray.length-1){
				_currentPlayer++;
			}
			else{_currentPlayer=0;}
			_frameArray[_currentPlayer].getTilePanel().removeAll();
			_frameArray[_currentPlayer].getTilePanel().add(ltile);
			_frameArray[_currentPlayer].repaint();
			_frameArray[_currentPlayer].pack();
		}
	}
	
	private BufferedImage getTileImage(String l){
		BufferedImage tile = null;
		if (l.equals("a")){
			tile = loadImage("src/Images/A.png");
		}
		if (l.equals("b")){
			tile = loadImage("src/Images/B.png");
		}
		if (l.equals("c")){
			tile = loadImage("src/Images/C.png");
		}
		if (l.equals("d")){
			tile = loadImage("src/Images/D.png");
		}
		if (l.equals("e")){
			tile = loadImage("src/Images/E.png");
		}
		if (l.equals("f")){
			tile = loadImage("src/Images/F.png");
		}
		if (l.equals("g")){
			tile = loadImage("src/Images/G.png");
		}
		if (l.equals("h")){
			tile = loadImage("src/Images/H.png");
		}
		if (l.equals("i")){
			tile = loadImage("src/Images/I.png");
		}
		if (l.equals("j")){
			tile = loadImage("src/Images/J.png");
		}
		if (l.equals("k")){
			tile = loadImage("src/Images/K.png");
		}
		if (l.equals("l")){
			tile = loadImage("src/Images/L.png");
		}
		if (l.equals("m")){
			tile = loadImage("src/Images/M.png");
		}
		if (l.equals("n")){
			tile = loadImage("src/Images/N.png");
		}
		if (l.equals("o")){
			tile = loadImage("src/Images/O.png");
		}
		if (l.equals("p")){
			tile = loadImage("src/Images/P.png");
		}
		if (l.equals("q")){
			tile = loadImage("src/Images/Q.png");
		}
		if (l.equals("r")){
			tile = loadImage("src/Images/R.png");
		}
		if (l.equals("s")){
			tile = loadImage("src/Images/S.png");
		}
		if (l.equals("t")){
			tile = loadImage("src/Images/T.png");
		}
		if (l.equals("u")){
			tile = loadImage("src/Images/U.png");
		}
		if (l.equals("v")){
			tile = loadImage("src/Images/V.png");
		}
		if (l.equals("w")){
			tile = loadImage("src/Images/W.png");
		}
		if (l.equals("x")){
			tile = loadImage("src/Images/X.png");
		}
		return tile;
	}
	
	private BufferedImage loadImage(String filePath) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(filePath));
		}
		catch (IOException e) {
			System.err.println("I could not load the file \'"+filePath+"'.  Sorry.");
		}
		return img;
	}
}
