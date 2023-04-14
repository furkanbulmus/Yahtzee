import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public File file_highscore = new File("highScoreTable.txt");  
	public static SingleLinkedList highScore = new SingleLinkedList();

	public static void main(String[] args) throws InterruptedException {
		
		SingleLinkedList player_1 = new SingleLinkedList();
		SingleLinkedList player_2 = new SingleLinkedList();
		File file = new File("highScoreTable.txt");
		String winnerName = "";
		int dice = 0;
		int scorePlayer1 = 0;
		int scorePlayer2 = 0;
		int size1 = 0;
		int size2 = 0;
		int switchSize1;
		int switchSize2;
		int winnerScore = 0;
		boolean matchCtrl = false;
		boolean drawCtrl = false;
		
		Scanner name = new Scanner(System.in);
		System.out.print("Please enter the player 1 name: ");  // Here we get the player names.
		String player1Name = name.nextLine();
		System.out.print("Please enter the player 2 name: ");
		String player2Name = name.nextLine();
		System.out.println(""); 
		
		for(int i = 1; i < 11; i++) {
			System.out.println("Turn: " + i);
			
			RollTheDice(dice, player_1); // This function allows us to roll 3 dice.
			size1 += 3; 
			System.out.print(player1Name + ": ");
			player_1.display();  // We show the dice that the player rolls.
			System.out.println("    Score: " + scorePlayer1);
			Thread.sleep(500);
			
			player_1.Search6ConsecutiveNumbers(); // These two functions check for number matches 
			player_1.Search4SameNumbers();           // and delete any matching numbers.
			switchSize1 = size1 - player_1.size();
			
			switch (switchSize1) {  // After the numbers are cleared, the score is calculated.
			case 0:
				break;
			case 4:
				scorePlayer1 += 10;
				size1 = player_1.size();
				matchCtrl = true;
				break;
			case 6:
				scorePlayer1 += 30;
				size1 = player_1.size();
				matchCtrl = true;
				break;
			case 8:
				scorePlayer1 += 20;
				size1 = player_1.size();
				matchCtrl = true;
				break;
			case 12:
				scorePlayer1 += 60;
				size1 = player_1.size();
				matchCtrl = true;
				break;
			}
			
			RollTheDice(dice, player_2);  // The same operations are done for the second player.
			size2 += 3;
			System.out.print(player2Name + ": ");
			player_2.display();
			System.out.println("    Score: " + scorePlayer2);
			Thread.sleep(500);
			
			player_2.Search6ConsecutiveNumbers();
			player_2.Search4SameNumbers();
			switchSize2 = size2 - player_2.size();
			
			switch (switchSize2) {
			case 0:
				break;
			case 4:
				scorePlayer2 += 10;
				size2 = player_2.size();
				matchCtrl = true;
				break;
			case 6:
				scorePlayer2 += 30;
				size2 = player_2.size();
				matchCtrl = true;
				break;
			case 8:
				scorePlayer2 += 20;
				size2 = player_2.size();
				matchCtrl = true;
				break;
			case 12:
				scorePlayer2 += 60;
				size2 = player_2.size();
				matchCtrl = true;
				break;
			}
			
			if (matchCtrl == true) {  // If there is a match, the numbers are reprinted.
				Thread.sleep(1000);
				System.out.println("");
				System.out.print(player1Name + ": ");
				player_1.display();
				System.out.println("    Score: " + scorePlayer1);
				System.out.print(player2Name + ": ");
				player_2.display();
				System.out.println("    Score: " + scorePlayer2);
			}
			
			System.out.println("");
			matchCtrl = false;
			
			Thread.sleep(1000);
		}
		
		System.out.println("GAME IS OVER");
		System.out.println("");
		Thread.sleep(500);
		
		if (scorePlayer1 < scorePlayer2) {  // The winning player is determined.
			System.out.println("The winner is: " + player2Name);
			System.out.println("CONGRATULATIONS");
			System.out.println("");
			winnerName = player2Name;
			winnerScore = scorePlayer2;
		}
		else if (scorePlayer1 > scorePlayer2) {
			System.out.println("The winner is: " + player1Name);
			System.out.println("CONGRATULATIONS");
			System.out.println("");
			winnerName = player1Name;
			winnerScore = scorePlayer1;
		}
		else {
			System.out.println("DRAW");
			System.out.println("");
			drawCtrl = true;
		} 
		
		if (drawCtrl == true) {
			highScore.highScoreSorting(player1Name, scorePlayer1);
			highScore.highScoreSorting(player2Name, scorePlayer2);
			HighScoreTable(file);
		}
		else {
			highScore.highScoreSorting(winnerName, winnerScore);
			HighScoreTable(file);
		}
	}
	
	public static void RollTheDice(int dice, SingleLinkedList SLL) {
		Random rnd = new Random();
		
		for (int i = 1; i < 4; i++) {
			dice = rnd.nextInt(6) + 1;  // Random numbers from 1 to 6 are selected 3 times.
			SLL.add(dice);  // The resulting numbers are printed in a linked list.
		}
	}
	
	public static void HighScoreTable (File file) {
		Object nameAndScore[] = new Object[2];
		String score_1 = "";
		int score = 0;
		
		try {
			Scanner in = new Scanner(file);  // We scan the high score file and place it in the linked list sequentially.
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if (line != null) {
					nameAndScore = line.split(" ");  
					score_1 = (String) nameAndScore[1];
					score = Integer.parseInt(score_1);
					highScore.highScoreSorting(nameAndScore[0], score);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		highScore.displayHighScore();
	}
	
	
}
