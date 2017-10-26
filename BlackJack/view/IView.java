package BlackJack.view;

public interface IView
{
  void DisplayWelcomeMessage();
  int  GetInput();
  void DisplayGameOver(boolean a_dealerIsWinner);
  void DisplayCard(String a_card);
  void DisplayPlayerHand(String[] a_hand, int a_score);
  void DisplayDealerHand(String[] a_hand, int a_score);
}