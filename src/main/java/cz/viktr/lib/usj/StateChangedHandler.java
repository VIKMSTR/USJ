package cz.viktr.lib.usj;

public interface StateChangedHandler<T> {

	 void handleStateChanged(State<T> state);
}
