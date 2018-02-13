package cz.viktr.lib.usj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransitionMatrixImplementation<T> implements TransitionMatrix<T> {

	public Map<State<T>, List<State<T>>> stateMap;

	public TransitionMatrixImplementation() {
		stateMap = new HashMap<>();
	}

	@Override
	public void addAllowedTransition(State<T> original, State<T> target) {
		if (original == null || target == null) {
			return;
		}
		if(stateMap.containsKey(original)) {
			stateMap.get(original).add(target);
		}else {
		    stateMap.put(original,new ArrayList<State<T>>() {{add(target);}});
		}
	}

	@Override
	public boolean isTransitionAllowed(State<T> original, State<T> target) {
		if (original == null || target == null) {
			return false;
		}
		if(stateMap.containsKey(original)){
			return stateMap.get(original).contains(target);
		}
		return false;
	}

}
