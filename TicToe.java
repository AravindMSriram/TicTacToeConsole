package ticTacToe;

import java.util.Scanner;
import ticTacToe.OddOrEven;
public class TicToe {
	int [] [] grid = new int [3] [3];
	String [] responses = new String [9];
	char [] [] charGrid = new char [3][3];
	Scanner scanner = new Scanner(System.in);
	int numResponses = 0;
	
	public void getCoords(int responseNumber, int playernumber)
	{
		responses[responseNumber] = scanner.next();
		numResponses++;
	}
	public void gridConverter (int responseNumber, int playerNumber){
		int playerchar;
		if (playerNumber == 1) { playerchar = -1; }
		else { playerchar = 1;}
		
		switch (responses[responseNumber]){
		
		case "A1": if (grid [0] [0] != 1 && grid [0] [0] != -1) grid [0] [0] = playerchar;
		else this.giveErrorMessage(1);
		break;
		case "A2": if (grid [0] [1] != 1 && grid [0] [1] != -1) grid [0] [1] = playerchar;
		else this.giveErrorMessage(1);
		break;
		case "A3": if (grid [0] [2] != 1 && grid [0] [2] != -1) grid [0] [2] = playerchar;
		else this.giveErrorMessage(1);	break;
		case "B1": if (grid [1] [0] != 1 && grid [1] [0] != -1) grid [1] [0] = playerchar;
		else this.giveErrorMessage(1);
		break;
		case "B2": if (grid [1] [1] != 1 && grid [1] [1] != -1) grid [1] [1] = playerchar;
		else this.giveErrorMessage(1);
		break;
		case "B3": if (grid [1] [2] != 1 && grid [1] [2] != -1) grid [1] [2] = playerchar;
		else this.giveErrorMessage(1);
		break;
		case "C1": if (grid [2] [0] != 1 && grid [2] [0] != -1) grid [2] [0] = playerchar;
		else this.giveErrorMessage(1);
		break;
		case "C2":  if (grid [2] [1] != 1 && grid [2] [1] != -1) grid [2] [1] = playerchar;
		else this.giveErrorMessage(1);
		break;
		case "C3":  if (grid [2] [2] != 1 && grid [2] [2] != -1) grid [2] [2] = playerchar;
		else this.giveErrorMessage(1);
		break;
		
		default: this.giveErrorMessage(0);
		break;
		}
		
		
	}//end of gridConverter
	public int hasWon(){
		boolean XhasWon = false;
		boolean OhasWon = false;
		//System.out.println("hasWon has been called.");
		//boolean haswon = false;
		for(int i = 0; i<=2; i++){
			if(grid [i][0]+grid [i][1]+grid [i][2] == -3){ XhasWon = true; }
			
				if(grid [i][0]+grid [i][1]+grid [i][2] == 3){ OhasWon = true; }
				if(grid [0][i]+grid [1][i]+grid [2][i] == -3){ XhasWon = true; }
				else {
					if(grid [0][i]+grid [1][i]+grid [2][i] == 3){ OhasWon = true; }
					//else { OhasWon = false; XhasWon = false;}
			}
			
			
		}
	
		if(grid [0][0]+grid [1][1]+grid [2][2] == -3){ XhasWon = true; }
			if(grid [0][0]+grid [1][1]+grid [2][2] == 3){ OhasWon = true; }
			//else { OhasWon = false; XhasWon = false;}
		
		
		if(grid [2][0]+grid [1][1]+grid[0][2] == -3){ XhasWon = true; }
		else {
			if(grid [2][0]+grid [1][1]+grid[0][2] == 3){ OhasWon = true; }
			//else { OhasWon = false; XhasWon = false;}
		}
		
		if (OhasWon == true) {
		//	System.out.println("X has won.");
			return 1; 
		}
		else {
			if (XhasWon == true) {
				//System.out.println("O has won.");
				return 2;} 
			else {  return 0;}
		}
	// if no one wins, it returns 0, if X wins, returns 1, O wins returns 2.	
		
		
	}
	private void giveErrorMessage(int errorNumber){
		String [] errorMessages = {"You have not entered valid coordinates. Please enter valid coordinates next time.", "This Coordinate is already occupied"};
		if(numResponses>0) numResponses--;
		System.out.printf("%d \n", numResponses);
		System.out.println(errorMessages[errorNumber]);
		
		
	}
	
	private void convertGridToChars()
	{
		for(int i=0; i<= 2; i++) {
			if(grid[i][0] == 1) charGrid [i][0] = 'X'; 
			else {
				if(grid[i][0] == -1) charGrid [i][0] = 'O';
				
			}
			if(grid[i][1] == 1) charGrid [i][1] = 'X'; 
			else {
				if(grid[i][1] == -1) charGrid [i][1] = 'O';
				
			}
			if(grid[i][2] == 1) charGrid [i][2] = 'X'; 
			else {
				if(grid[i][2] == -1) charGrid [i][2] = 'O';
				
			}	
		}
		
		
		
		
	}
	public void printGridStuff()
	{
		this.convertGridToChars();
		System.out.println("\n\n");
		System.out.println("  1    2    3  ");
		System.out.printf("A %C | %C  | %C %n", charGrid[0][0], charGrid[0][1], charGrid[0][2]);
		System.out.println("----+----+----");
		System.out.printf("B %C | %C  | %C %n", charGrid[1][0], charGrid[1][1], charGrid[1][2]);
		System.out.println("----+----+----");
		System.out.printf("C %C | %C  | %C %n", charGrid[2][0], charGrid[2][1], charGrid[2][2]);
	}
	public void printDirections()
	{
		System.out.printf("Hi, welcome to TicTacToe! Type in the coordinates to place the X or O's down. (A1, B3, C2, etc.)\n Note that if you incorrectly input coordinates, you have skipped your turn. ");
	}
	
	public void endGame()
	// Puts the game together.
	{
		this.printDirections();
		int haveWon;
		
		int k = 0;
		int playerNumber;
		int responseNumber = 0;
		do {
			//this.hasWon();
			haveWon = this.hasWon();
			this.convertGridToChars();
			this.printGridStuff();
			System.out.printf("%d \n", haveWon);
			System.out.println("Enter Coordinates");
			if (OddOrEven.isEven(k) == true) playerNumber = 1;
			else playerNumber = 2;
			this.isStalemate();
			this.getCoords(responseNumber, playerNumber);
			this.gridConverter(responseNumber, playerNumber);
			haveWon = this.hasWon();
			k++; 
			
		}
		while(haveWon != 2 && haveWon != 1);
		if(haveWon == 1)
		{	
			System.out.println("\n X has won!");
			this.convertGridToChars();
			this.printGridStuff();
			System.exit(0);
			
		}
		if(haveWon == 2)
	{
			System.out.println("\n O has won!");
			this.convertGridToChars();
			this.printGridStuff();
			System.exit(0);
		}
	
	
	
	}
	public void  isStalemate() 
	{
		if(numResponses >= 9){
			System.out.println("Stalemate!");
			System.exit(0);
			
			
		}
	}
	
	

}// end class TicToe

/*



   |   |   
---+---+---
 X | O | X 
---+---+---
   |   |   

*/

