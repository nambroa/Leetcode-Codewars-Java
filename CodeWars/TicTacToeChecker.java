package CodeWars;

/*
If we were to set up a Tic-Tac-Toe game, we would want to know whether the board's current state is solved, wouldn't we?
Our goal is to create a function that will check that for us!

Assume that the board comes in the form of a 3x3 array, where the value is 0 if a spot is empty,
1 if it is an "X", or 2 if it is an "O", like so:

[[0, 0, 1],     [[ ,  , X],
 [0, 1, 2], -->  [ , X, O],
 [2, 1, 0]]      [O, X,  ]

We want our function to return:

-1 if the board is not yet finished AND no one has won yet (there are empty spots),
1 if "X" won,
2 if "O" won,
0 if it's a cat's game (i.e. a draw).

You may assume that the board passed in is valid in the context of a game of Tic-Tac-Toe.
 */

/*
First of all, how do you win tic tac toe? You need 3 in a row of X or O. They can also be diagonal.

We should scan the board for win conditions. We can have an additional function checkWin(X) or checkWin(O) that checks
exactly that. It will scan the board twice. It will have lots of ifs, each if a win condition.
For example board[0][0] == board[0][1] == board[0][2] && board[0][0] == 1 --> means X won
This function takes linear time complexity in relation to the board size.

Assuming there are no winners, we now have to check for tie. Tie means:
1 ) No winners
2 ) No empty spots

So to check that, we just check if there are any empty spots, so board[i][j] == 0 for all i j. If there are any, we
return -1 and if there are none we return 0.

In total complexity is about O(4N) which is O(N) and space complexity is O(1).
 */

public class TicTacToeChecker {

    public static boolean checkWin(int[][] board, int value) {
        // Check rows horizontally
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == value && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }

        // Check rows vertically.
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == value && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return true;
            }
        }

        // Check rows diagonally.
        if (board[0][0] == value && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        return board[0][2] == value && board[0][2] == board[1][1] && board[0][2] == board[2][0]; // Last diagonal.

    }

    public static int isSolved(int[][] board) {
        // Check if X or O has won.
        if (checkWin(board, 1)) {
            return 1;
        }
        if (checkWin(board, 2)) {
            return 2;
        }

        // Check empty spots
        for(int[] row: board){
            for(int value:row){
                if(value == 0){
                    return -1;
                }
            }
        }

        // Board has no empty spots nor winners. Its a tie!
        return 0;
    }
}
