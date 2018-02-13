package cz.viktr.lib.usj;

import java.util.ArrayList;
import java.util.List;

/***
 * A state processor that does not have TransitionMatrix.
 * That means, that every transition is allowed
 * @author viktr
 *
 */
public class MinimalProcessor<T> implements Processor<T> {

	
	private List<StateChangedHandler<T>> subscribers;
	private State<T> currentState;
	public MinimalProcessor(State<T> initialState) {
		subscribers = new ArrayList<>();
		currentState = initialState;
	}

	@Override
	public void subscribeToStateChange(StateChangedHandler<T> handler) {
		subscribers.add(handler);
		
	}

	@Override
	public void update(Action<T> action) throws NotAllowedStateException {
		this.currentState = action.targetState();
		subscribers.stream().forEach(x -> x.handleStateChanged(currentState));
	}

}
