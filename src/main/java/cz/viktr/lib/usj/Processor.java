package cz.viktr.lib.usj;

public interface Processor<T> {

	void subscribeToStateChange(StateChangedHandler<T> handler);
	
	void update(Action<T> action) throws NotAllowedStateException;
}
