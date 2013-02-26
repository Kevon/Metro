package tiles;

import code.Board;
/*
 * All comments for the many tiles can be found in the Tile Interface
 */
public class TileL implements Tile {

	char _type = 'l';
	int[] tileL = new int[8];
	Board _board;
	String _legal;
	public TileL(Board b) {
		_board = b;
		_legal = "11110101";
		tileL[0] = 3;
		tileL[1] = 4;
		tileL[2] = 2;
		tileL[3] = 1;
		tileL[4] = 1;
		tileL[5] = 2;
		tileL[6] = 4;
		tileL[7] = 3;
	}

	public int connectEdge(int i) {
		if (i != 8) {
			int answer = 0;
			int temp = tileL[i];
			for (int j = 0; j < 8; j++) {
				if (j != i && tileL[j] == temp) {
					answer = j;
				}
			}
			return answer;
		} else {
			return _board.returnPoints(0);
		}
	}

	public int callToBoard(int i, int pts, int x, int y) {

		int j = connectEdge(i);
		int X = newX(j, x);
		int Y = newY(j, y);

		int points = pts + 1;
		return _board.checkConnection(X, Y, correspond(j), points);

	}

	public int correspond(int i) {
		if (i == 0) {
			return 5;
		}
		if (i == 1) {
			return 4;
		}
		if (i == 2) {
			return 7;
		}
		if (i == 3) {
			return 6;
		}
		if (i == 4) {
			return 1;
		}
		if (i == 5) {
			return 0;
		}
		if (i == 6) {
			return 3;
		}
		if (i == 7) {
			return 2;
		}
		// The method wants a return statement in the event that i is some
		// number not specified by one of the if statements, but the code
		// doesn't allow for that, so this return line should never be read.
		return 55555;
	}

	public int newX(int j, int x) {
		if (j == 0 || j == 1 || j == 4 || j == 5) {
			return x;
		}
		if (j == 2 || j == 3) {
			return x + 1;
		}
		if (j == 6 || j == 7) {
			return x - 1;
		}
		// The method wants a return statement in the event that i is some
		// number not specified by one of the if statements, but the code
		// doesn't allow for that, so this return line should never be read.
		return 55555;
	}

	public int newY(int j, int y) {
		if (j == 2 || j == 3 || j == 6 || j == 7) {
			return y;
		}
		if (j == 4 || j == 5) {
			return y + 1;
		}
		if (j == 0 || j == 1) {
			return y - 1;
		}
		// The method wants a return statement in the event that i is some
		// number not specified by one of the if statements, but the code
		// doesn't allow for that, so this return line should never be read.
		return 55555;
	}
	public char getType (){
		return _type;
	}
	public String getLegal(){
		return _legal;
	}
}
