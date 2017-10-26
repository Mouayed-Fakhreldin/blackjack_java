package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.model.Card;

public class Soft17HitStrategy implements IHitStrategy {

	private final int g_hitLimit = 17;
	
	@Override
	public boolean DoHit(Player a_dealer) {
		
		if (a_dealer.CalcScore() > g_hitLimit)
			return false;
		
		else if (a_dealer.CalcScore() < g_hitLimit)
			return true;
		
		else if (a_dealer.CalcScore() == g_hitLimit) {
			for (Card a_card:a_dealer.GetHand())
				if (a_card.GetValue() == Card.Value.Ace)
					return true;
		}
		
		return false;
	}
}
