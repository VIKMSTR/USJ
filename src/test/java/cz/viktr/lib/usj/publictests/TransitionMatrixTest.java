package cz.viktr.lib.usj.publictests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cz.viktr.lib.usj.State;
import cz.viktr.lib.usj.TransitionMatrix;
import cz.viktr.lib.usj.TransitionMatrixImplementation;

public class TransitionMatrixTest {

	public TransitionMatrixTest() {
	}
	
	@Test
	public void test_if_the_set_transition_is_allowed() {
		TransitionMatrix<String> transitionMatrix = new TransitionMatrixImplementation<>();
		
		
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
		};
		State<String> failed = new State<String>() {
			@Override
			public String stateID() {
				return "failed";
			}
		};
		State<String> finished = new State<String>() {
			@Override
			public String stateID() {
				return "finished";
			}
		};
		
		transitionMatrix.addAllowedTransition(initialized,running);
		
		transitionMatrix.addAllowedTransition(running,finished);
		transitionMatrix.addAllowedTransition(running,failed);

		transitionMatrix.addAllowedTransition(finished, running);
		transitionMatrix.addAllowedTransition(failed, running);

		boolean allowed = transitionMatrix.isTransitionAllowed(initialized, running);
		assertTrue(allowed);
		allowed = transitionMatrix.isTransitionAllowed(running, failed);
		assertTrue(allowed);
	}

}
