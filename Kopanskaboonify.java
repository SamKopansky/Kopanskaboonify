import java.util.Scanner;
import java.util.Random;

//Sam Kopansky CS1632 
//Professor Bill Laboon 
//University of Pittsburgh
//2015

public class Kopanskaboonify
{
	public static void main(String[] args)
	{
		int guess = 0;
		int incorrect = 0;
		int correct = 0;
		int inARow = 0;
		String isItRight = "";
		String lastOutcome = "invalid string";
		
		//display starting message
		message();
		System.out.println("");
		
		while (true)
		{
			//get user input
			guess = input();
			//Kopanskaboonify
			guess = doubleIt(guess);
			guess = addRandom(guess);
			guess = root(guess);
			guess = modIt(guess);
			//output if it's correct or not
			isItRight = output(guess);
			System.out.println(isItRight);
			//add to counters
			if (isItRight.equals("Correct"))
				correct++;
			else
				incorrect++;
			//check for multiple correct or incorrect guesses
			if (lastOutcome.equals(isItRight))
				inARow++;
			else
				inARow = 1;
			lastOutcome = isItRight;
			//stop looping if 3 incorrects in a row or 5 corrects in a row
			if (areWeDoneYet(inARow, lastOutcome) == 0)
				break;
		}
		//display stats
		System.out.println(endReport(incorrect, correct, winLose()));
		
		//end of game
	}
	
	//This method gets input from the user
	public static int input()
	{
		Scanner s = new Scanner(System.in);
		int guess = 0;
		while (true)
		{
			try
			{
				System.out.print("Enter a whole number >> ");
				guess = Integer.parseInt(s.nextLine());
				break;
			}
			catch (Exception e)
			{
				System.out.println("\nNumber invalid. Please enter a whole number between -2147483648 and 2147483647\n");
			}
		}
		
		return guess;
	}
	
	//Displays game instructions
	public static String message()
	{
		String s = "The goal of Kopanskaboonify is to figure out which numbers " +
			   "are correct and which numbers are incorrect. Enter whole numbers until you win.";
		System.out.println(s);
		return s;
	}
	
	//Decides a win or loss
	public static int winLose()
	{
		Random r = new Random();
		return r.nextInt(2);
	}
	
	//Displays whether or not their input was correct or incorrect
	public static String output(int n)
	{
		if (n == 0)
			return "Incorrect";
		else if (n == 1)
			return "Correct";
		return "Oops something is wrong!";
	}
	
	//Doubles a number
	public static int doubleIt(int n)
	{
		return n * 2;
	}
	
	//Adds a random integet from 10 to 129
	public static int addRandom(int n)
	{
		Random r = new Random();
		return n + r.nextInt(120) + 10;
	}
	
	//Gets the square root of a number as an integer
	public static int root(int n)
	{
		if (n < 0)
			n = n * -1;
		
		double d = Math.sqrt(n);
		int i = (int)Math.floor(d);
		return i;
	}
	
	//Mods a number by 2
	public static int modIt(int n)
	{
		return n % 2;
	}
	
	//Displays stats at the end
	public static String endReport(int incorrect, int correct, int winOrLose)
	{
		String wOrL = "";
		if (winOrLose == 1)
			wOrL = "won!";
		else if (winOrLose == 0)
			wOrL = "lost!";
		String s = "Stats:\n" +
			   "Guesses Incorrect >> " + incorrect +
			   "\nGuesses Correct   >> " + correct +
			   "\nYou " + wOrL;
		return s;
	}
	
	//Checks if the game is over or not
	public static int areWeDoneYet(int i, String s)
	{
		if ((i == 3 && s.equals("Incorrect")) || (i == 5 && s.equals("Correct")))
			return 0;
		return 1;
	}
}

