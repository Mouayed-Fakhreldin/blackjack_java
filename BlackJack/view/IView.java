package BlackJack.view;

public interface IView
{

	public enum Input{
		PLAY, 
		HIT, 
		STAND, 
		QUIT,
		NOTANOPTION
	}
	void DisplayWelcomeMessage();
	Input  GetInput();
	void DisplayGameOver(boolean a_dealerIsWinner);
	void DisplayCard(String a_card);
	void DisplayPlayerHand(String[] a_hand, int a_score);
	void DisplayDealerHand(String[] a_hand, int a_score);
}