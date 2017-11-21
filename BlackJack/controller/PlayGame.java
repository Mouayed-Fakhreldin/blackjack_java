package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.view.IView.Input;
import java.util.ArrayList;

import BlackJack.model.Card;
import BlackJack.model.Game;
import BlackJack.model.IObserver;

public class PlayGame implements IObserver {
	private Game a_game;
	private IView a_view;

	
	public PlayGame(Game a_game, IView a_view) {
		this.a_game = a_game;
		this.a_view = a_view;
		this.a_game.AddObservers(this);
	}

	public boolean Play() {
		this.a_view.DisplayWelcomeMessage();
		Input input = a_view.GetInput();
		switch (input) {
		case PLAY:
			a_game.NewGame();
			return true;
		case HIT:
			a_game.Hit();
			return true;
		case STAND:
			a_game.Stand();
			return true;
		case QUIT:
			return false;
		default:
			return true;
		}
	}

	@Override
	public void NewCardDealt() {
		try {
			a_view.DisplayDealerHand(HandToStringArray(a_game.GetDealerHand()), a_game.GetDealerScore());
			a_view.DisplayPlayerHand(HandToStringArray(a_game.GetPlayerHand()), a_game.GetPlayerScore());

			if (a_game.IsGameOver()) {
				a_view.DisplayGameOver(a_game.IsDealerWinner());
			}
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private String[] HandToStringArray(Iterable<Card> a_hand) {
		ArrayList<String> list = new ArrayList<String>();
		for (Card c:a_hand) {
			String s = c.GetValue().toString();
			s += ",";
			s += c.GetColor().toString();
			list.add(s);
		}
		String[] ss = new String[list.size()];
		ss = list.toArray(ss);
		return ss;
	}
}