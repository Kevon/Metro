Metro
=====

In Metro, the players (2-8) take turns placing tiles to complete train track lines that connect to their stations, which will
  award points based on their length.  At the beginning of a player's turn, he will be shown the tile he can place for that
	turn.  The game ends when the board is full.
	
A player gets points for each tile their track touches (and gets points if the track loops back through the same tile).
	If your track ends at one of the center stations, you are awarded double points (keep in mind, none of the center stations
	belong to players, and nobody is awarded points for tracks that leave the center stations).
	
Stations are distributed clockwise and in order, starting with the station in the upper left hand corner on the north wall
	For example:
		If your game has three players, the first station belongs to player one.  The next one (to the right of the first one)
		belongs to player two, the next belongs to player three, and the next belongs to player one again.  This pattern loops
		all the way around the board until all the stations are assigned.  Make sure you pay attention to which stations belong
		to whom!
	Keep in mind, you get points for tracks LEAVING your station, not ENTERING your station.

To play this game, you will enter commands (as listed below) into the Console to interact with the game.  The Console will
	give some information, like the current players turn, and will inform you if you have made an illegal placement.
	
You have the option to use a graphical user interface or a text user interface (switching explained below).  By default
	the game uses the graphical UI, but if you use the text UI, there are different ways to read the board a tiles:
		Tiles are displayed as squares with numbers on the edges, where corresponding numbers connect.  For example:
		
		 34 
		3  2
		4  1
		 21 
		
		In this tile, the 3 connects to the other 3, the 4 to the other 4, and so on.
		All information for the game while using the text UI will be displayed in the console
		Stations are set up the same in the tui, and the letters DO NOT show which player owns them, but simply their
			input and output lanes:
			
			A is an outgoing lane, B is incoming
			D is an outgoing lane, C is incoming
			E is an outgoing lane, F is incoming
			H is an outgoing lane, G is incoming

Use the following commands to play the game:

At the beginning of the game, you will be asked to enter players.  Enter each one (2-8) and when you have entered all the
	players you wish to play with, use the command "Done," and the game will start.

place(x, y)
	This places the tile you have available to place at the given x and y position which may range from 1 to 12
	You cannot place a tile somewhere where a score of one will be returned unless that tile can't be placed anywhere else
	
commit
	After placing a tile, you must commit your decision to end your turn
	
remove
	If dissatisfied with your tile placement, the remove command will remove it and allow you to place it somewhere else
	
resign
	If you give up and just want to quit, type resign and your score will become zero and the game will end
	
save
	This will allow you to save a game part way through to load later
	If you want to be able to load that game, you MUST enter the names of the same people who played in the saved game 
		in the order that you entered them the first time (find the .txt file in the game's folder if you don't remember).
		If done successfully you will be asked if you want to load your previous game, at which point you may answer "yes" or "no"
	
		
tui
	This will allow you to switch from a graphical UI to a text based one which is printed out in the console
	
	The text UI has a few extra commands:
	
	display player
		Displays the current player
		
	display score
		Displays the current scores
		
	display board
		Displays the current board
		
	display tile
		Displays the current tile
		
	gui
		Will switch back to the graphical UI
