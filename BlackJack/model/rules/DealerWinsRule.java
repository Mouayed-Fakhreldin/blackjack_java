package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public class DealerWinsRule implements IWinRule {

	private final int g_limit = 21;
	
	@Override
	public boolean DealerWins(Dealer a_dealer, Player a_player) {
		
		int a_dealerScore = a_dealer.CalcScore();
		int a_playerScore = a_player.CalcScore();
		
		if (a_dealerScore == a_playerScore)
			return true;
		
		if (a_dealerScore > g_limit)
			return false;
		
		if (a_playerScore > g_limit)
			return true;
		
		return a_dealerScore > a_playerScore;
		
	}

}
