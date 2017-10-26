package BlackJack.model;

public interface IObservable {
	public void AddObservers(IObserver observer);
	public void NotifyObservers();
}
