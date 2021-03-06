package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

	private Deck m_deck;
	private INewGameStrategy m_newGameRule;
	private IHitStrategy m_hitRule;
	private IWinRule m_winRule;

	public Dealer(RulesFactory a_rulesFactory) {

		m_newGameRule = a_rulesFactory.GetNewGameRule();
		m_hitRule = a_rulesFactory.GetHitRule();
		m_winRule = a_rulesFactory.GetWinRule();

		/*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
	}

	public void DealCardTo(Player a_player, boolean cardIsShown) {
		Card a_card = m_deck.GetCard();
		a_card.Show(cardIsShown);
		a_player.DealCard(a_card);
	}

	public boolean NewGame(Player a_player) {
		if (m_deck == null || IsGameOver(a_player)) {
			m_deck = new Deck();
			ClearHand();
			a_player.ClearHand();
			return m_newGameRule.NewGame(this, a_player);   
		}
		return false;
	}

	public boolean Hit(Player a_player) {
		if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver(null)) {

			this.DealCardTo(a_player, true);
			return true;
		}

		else
			return false;
	}

	public boolean stand(Player a_player) {
		if (m_deck != null) {
			ShowHand();
			while (m_hitRule.DoHit(this)) {
				DealCardTo(this, true);
			}
			return true;
		}
		return false;
	}
	
	public boolean IsDealerWinner(Player a_player) {
		return m_winRule.DealerWins(this, a_player);
	}

	public boolean IsGameOver(Player a_player) {
		
		if (a_player != null && a_player.CalcScore() > a_player.g_maxScore)
			return true;
		
		if (m_deck != null && m_hitRule.DoHit(this) != true) {
			return true;
		}
		return false;
	}

}