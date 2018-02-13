package cz.viktr.lib.usj.publictests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cz.viktr.lib.usj.Action;
import cz.viktr.lib.usj.MinimalProcessor;
import cz.viktr.lib.usj.NotAllowedStateException;
import cz.viktr.lib.usj.Processor;
import cz.viktr.lib.usj.State;
import cz.viktr.lib.usj.StateChangedHandler;

public class MinimalProcessorTest {

	@Test
	public void test_if_the_state_change_is_correctly_handled() throws NotAllowedStateException {
		
		State<String> initialized = new State<String>() {
			@Override
			public String stateID() {
				return "initialized";
			}
		};
		State<String> running = new State<String>() {
			@Override
			public String stateID() {
				return "running";
			}
			
			@Override
			public String toString() {
				return stateID();
			}
		};
		
		Processor<String> minimalProcessor = new MinimalProcessor<String>(initialized);
		State<String> expectedState = running;
		Action<String> run = new Action<String>() {
			
			@Override
			public State<String> targetState() {
				return running;
			}
		};
		StateChangedHandler<String> handler = new StateChangedHandler<String>() {

			@Override
			public void handleStateChanged(State<String> state) {
				 System.out.println(state.toString());
				 assertEquals(state, expectedState);
				
			}
		};
		
		minimalProcessor.subscribeToStateChange(handler);
		minimalProcessor.update(run);
		
	}

}
