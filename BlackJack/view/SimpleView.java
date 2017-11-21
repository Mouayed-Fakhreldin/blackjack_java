package BlackJack.view;


public class SimpleView implements IView 
{

	public void DisplayWelcomeMessage()
	{
		for(int i = 0; i < 5; i++) {System.out.print("\n");}; 
		System.out.println("Hello Black Jack World");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
	}

	public Input GetInput()
	{

		int c = -1;
		try {
			c = System.in.read();
			while (c == '\r' || c =='\n') {
				c = System.in.read();
			}
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			c = 0;
		}

		switch (c) {
		case 'p':
			return Input.PLAY;
		case 'h':
			return Input.HIT;
		case 's':
			return Input.STAND;
		case 'q':
			return Input.QUIT;
		default:
			return Input.NOTANOPTION;
		}
	}

	public void DisplayCard(String a_card)
	{
		String[] a_splitted = a_card.split(",");
		System.out.println("" + a_splitted[0] + " of " + a_splitted[1]);
	}

	public void DisplayPlayerHand(String[] a_hand, int a_score)
	{
		DisplayHand("Player", a_hand, a_score);
		System.out.println("******************************************");
	}

	public void DisplayDealerHand(String[] a_hand, int a_score)
	{
		DisplayHand("Dealer", a_hand, a_score);
	}

	private void DisplayHand(String a_name, String[] a_hand, int a_score)
	{
		System.out.println(a_name + " Has: ");
		for(String c : a_hand)
		{
			DisplayCard(c);
		}
		System.out.println("Score: " + a_score);
		System.out.println("");
	}

	public void DisplayGameOver(boolean a_dealerIsWinner)
	{
		System.out.println("GameOver: ");
		if (a_dealerIsWinner)
		{
			System.out.println("Dealer Won!");
		}
		else
		{
			System.out.println("You Won!");
		}

	}
}
