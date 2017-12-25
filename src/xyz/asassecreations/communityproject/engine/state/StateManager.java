package xyz.asassecreations.communityproject.engine.state;

import java.util.Stack;

public final class StateManager {

	private final Stack<State> states = new Stack<>();

	public final State peek() {

		if (states.isEmpty()) return null;
		return states.peek();

	}

	public final void push(final State state) {

		states.push(state);
		state.setStateManager(this);
		state.init();

	}

	public final State pop() {

		if (states.isEmpty()) return null;
		final State popped = states.pop();
		popped.destroy();

		return popped;

	}

	public final void input() {

		if (peek() != null) peek().input();

	}

	public final void tick() {

		if (peek() != null) peek().tick();

	}

	public final void render() {

		if (peek() != null) peek().render();

	}

}
