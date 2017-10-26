package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface IWinRule {
	public boolean DealerWins(Dealer a_dealer, Player a_player);
}
