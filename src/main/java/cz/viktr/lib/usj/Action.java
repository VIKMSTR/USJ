package cz.viktr.lib.usj;

public interface Action<T> {

	State<T> targetState();
}
