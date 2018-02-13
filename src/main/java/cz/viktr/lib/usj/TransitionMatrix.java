package cz.viktr.lib.usj;

public interface TransitionMatrix<T> {

	void addAllowedTransition(State<T> original, State<T> target);
	
	boolean isTransitionAllowed(State<T> original, State<T> target);
}
