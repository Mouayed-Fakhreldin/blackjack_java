package BlackJack.model;

public class Game implements IObservable {

	private Dealer m_dealer;
	private Player m_player;

	public Game()
	{
		m_dealer = new Dealer(new BlackJack.model.rules.RulesFactory());
		m_player = new Player();
	}


	public boolean IsGameOver()
	{
		return m_dealer.IsGameOver(m_player);
	}

	public boolean IsDealerWinner()
	{
		return m_dealer.IsDealerWinner(m_player);
	}

	public boolean NewGame()
	{
		return m_dealer.NewGame(m_player);
	}

	public boolean Hit()
	{
		return m_dealer.Hit(m_player);
	}

	public boolean Stand()
	{
		return m_dealer.stand(m_player);
	}

	public Iterable<Card> GetDealerHand()
	{
		return m_dealer.GetHand();
	}

	public Iterable<Card> GetPlayerHand()
	{
		return m_player.GetHand();
	}

	public int GetDealerScore()
	{
		return m_dealer.CalcScore();
	}

	public int GetPlayerScore()
	{
		return m_player.CalcScore();
	}

	public void AddObservers(IObserver a_observer){
		m_player.AddObservers(a_observer);
		m_dealer.AddObservers(a_observer);
	}


	@Override
	public void NotifyObservers() {
		m_player.NotifyObservers();
		m_dealer.NotifyObservers();
		
	}
}