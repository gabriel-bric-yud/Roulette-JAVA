import java.util.Scanner;

class RoulettePocket {
	
	String color;
	
	public RoulettePocket(int num) {
		setPocketColor(num);
	}
	
	private void setPocketColor(int num) {
		if ((num >=1 && num <=11) || (num >= 19 && num <=28)) {
			color = "red";
		}
		else if ((num >=11 && num <=18) || (num >= 29 && num <=36)) {
			color = "red";
		}
		else {
			color = "green";
		}
	}
	
	public String getPocketColor() {
		return color;
	}
	
	public String toString() {
		return "Your pocket color is " + getPocketColor();
	}
}
	


public class RouletteDriver {
	
	static boolean checkStart(String start) {
		if (start.toLowerCase().equals("q")) {
			return false;
		}
		else
			return true;
	}
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter("\\R");
		
		System.out.println("Welcome to the Roulette Application!");
		System.out.println("\nPress ENTER to Start Game / Q to Quit");
		String startGame = scan.nextLine();
		
		while (checkStart(startGame)) {
			
			int playerNum = -1;
			
			while (playerNum < 0 || playerNum > 36) {
				try {
					System.out.print("Please enter a number between 0 and 36: ");
					playerNum = scan.nextInt();
					scan.nextLine();
					if (playerNum < 0 || playerNum > 36) {
						System.out.println("\nError! That number is not in range. Try again!");
						
					}
				}
				catch (Exception Err) {
					System.out.println("\nError! That is not a NUMBER. Try again!");
					scan.nextLine();
				}
				
			}
			
			RoulettePocket playerPocket = new RoulettePocket(playerNum);
			System.out.println("\n" + playerPocket.toString() + " for number " + playerNum +"!");
			System.out.println("\nPress ENTER to Play Again / Q to Quit");
			startGame = scan.nextLine();
		}
		
		scan.close();
		System.out.println("\nProgram Terminated");
	}
	
}
