import java.util.*;

public class KBTest
{
	public static void main(String[] args)
	{
		int[] tests = new int[13];
		tests[0] = messageTest();
		tests[1] = inputTest();
		tests[2] = winLoseTest();
		tests[3] = outputIncorrectTest();
		tests[4] = outputCorrectTest();
		tests[5] = doubleItTest();
		tests[6] = addRandomTest();
		tests[7] = positiveRootTest();
		tests[8] = negativeRootTest();
		tests[9] = modItTest();
		tests[10] = notifyTest();
		tests[11] = continueGameTest();
		tests[12] = dontContinueGameTest();
		for (int i = 0; i < 13; i++)
		{
			if (tests[i] == 0)
				System.out.println(i + "th Test Successful");
			else
				System.out.println(i + "th Test Faliure");
		}
		
		
		
	}

	//This tests FUN-INPUT. If there are no cast issues, then an integer was entered.
	public static int inputTest()
	{
		try
		{
			int guess = input();
		}
		catch (Exception e)
		{
			return 1;
		}
		return 0;
	}
	
	//This tests FUN-MESSAGE. This checks to make sure the message is written correctly.
	public static int messageTest()
	{
		String s = "The goal of Kopanskaboonify is to figure out which numbers " +
			   "are correct and which numbers are incorrect. Enter whole numbers until you win.";
		if (s.equals(message()))
			return 0;
		return 1;
	}
	
	//This tests FUN-WIN-LOSE. This checks to make sure a win or a loss is decided
	public static int winLoseTest()
	{
		int wOrL = winLose();
		if (wOrL == 1 || wOrL == 0)
			return 0;
		return 1;
	}
	
	//This tests FUN-OUTPUT. If a 0 is entered, output should be "Incorrect"
	public static int outputIncorrectTest()
	{
		String s = output(0);
		if (s.equals("Incorrect"))
			return 0;
		return 1;
	}
	
	//This tests FUN-OUTPUT. If a 1 is entered, output should be "Correct"
	public static int outputCorrectTest()
	{
		String s = output(1);
		if (s.equals("Correct"))
			return 0;
		return 1;
	}
	
	//The next 5 tests test the individual parts of FUN-EQUATION
	
	//Checks that a number is doubled
	public static int doubleItTest()
	{
		int i = doubleIt(5);
		if (i == 10)
			return 0;
		return 1;
	}
	
	//Checks that a random number of the correct value is added
	public static int addRandomTest()
	{
		int i = addRandom(0);
		if (i >= 10 && i <= 129)
			return 0;
		return 1;
	}
	
	//Checks that a rounded down square root takes place for a positive integer
	public static int positiveRootTest()
	{
		int i = root(10);
		System.out.println(i);
		if (i == 3)
			return 0;
		return 1;
	}
	
	//Checks that a rounded down square root takes place for a negative integer
	public static int negativeRootTest()
	{
		int i = root(-10);
		if (i == 3)
			return 0;
		return 1;
	}
	
	//Checks that a mod of 2 correctly takes place
	public static int modItTest()
	{
		int i = modIt(3);
		if (i == 1)
			return 0;
		return 1;
	}
	
	//This tests FUN-NOTIFY. Makes sure all pieces of the requirement are included
	public static int notifyTest()
	{
		int incorrect = 3;
		int correct = 2;
		int won = 1;
		String s = endReport(incorrect, correct, won).toLowerCase();
		if (s.contains("incorrect") && s.contains("correct") && s.contains("won"))
			return 0;
		return 1;
	}
	
	//This tests FUN-CONTINUE. Sees if either 5 correct or 3 incorrect guesses have been made
	public static int continueGameTest()
	{
		int inARow = 2;
		int continueGame = areWeDoneYet(inARow, "Correct");
		if (continueGame == 1)
			return 0;
		return 1;
	}
	
	//This tests FUN-CONTINUE. Sees if either 5 correct or 3 incorrect guesses have been made
	public static int dontContinueGameTest()
	{
		int inARow = 3;
		int continueGame = areWeDoneYet(inARow, "Incorrect");
		if (continueGame == 0)
			return 0;
		return 1;
	}
	
	/********************************** HERE ARE THE ACTUAL METHODS ***********************************/
	/********************************** HERE ARE THE ACTUAL METHODS ***********************************/
	/********************************** HERE ARE THE ACTUAL METHODS ***********************************/
	
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
	
	public static String message()
	{
		String s = "The goal of Kopanskaboonify is to figure out which numbers " +
			   "are correct and which numbers are incorrect. Enter whole numbers until you win.";
		System.out.println(s);
		return s;
	}
	
	public static int winLose()
	{
		Random r = new Random();
		return r.nextInt(2);
	}
	
	public static String output(int n)
	{
		if (n == 0)
			return "Incorrect";
		else if (n == 1)
			return "Correct";
		return "Oops something is wrong!";
	}
	
	public static int doubleIt(int n)
	{
		return n * 2;
	}
	
	public static int addRandom(int n)
	{
		Random r = new Random();
		return n + r.nextInt(120) + 10;
	}
	
	public static int root(int n)
	{
		if (n < 0)
			n = n * -1;
		
		double d = Math.sqrt(n);
		int i = (int)Math.floor(d);
		return i;
	}
	
	public static int modIt(int n)
	{
		return n % 2;
	}
	
	public static String endReport(int incorrect, int correct, int winOrLose)
	{
		String wOrL = "";
		if (winOrLose == 1)
			wOrL = "won!";
		else if (winOrLose == 0)
			wOrL = "lost!";
		String s = "Stats:\n" +
			   "Guesses Incorrect >> " + incorrect +
			   "\nGuesses Correct   >>" + correct +
			   "\nYou " + wOrL;
		return s;
	}
	
	public static int areWeDoneYet(int i, String s)
	{
		if ((i == 3 && s.equals("Incorrect")) || (i == 5 && s.equals("Correct")))
			return 0;
		return 1;
	}
}
