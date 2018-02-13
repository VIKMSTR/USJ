package cz.viktr.lib.usj;

public class NotAllowedStateException extends Exception {

	private State<?> originalState;
	private State<?> targetState;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1772962097153878113L;

	
	public NotAllowedStateException(String message, State<?> originalState, State<?> targetState) {
		super(message);
		this.originalState = originalState;
		this.targetState = targetState;
	}

	public NotAllowedStateException(Throwable cause, State<?> originalState, State<?> targetState) {
		super(cause);
		this.originalState = originalState;
		this.targetState = targetState;
	}

	public NotAllowedStateException(String message, Throwable cause, State<?> originalState, State<?> targetState) {
		super(message, cause);
		this.originalState = originalState;
		this.targetState = targetState;
	}

	public NotAllowedStateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace, State<?> originalState, State<?> targetState) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.originalState = originalState;
		this.targetState = targetState;
	}

}
