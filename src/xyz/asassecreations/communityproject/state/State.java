package xyz.asassecreations.communityproject.state;

import java.awt.Graphics2D;

public abstract class State {

	protected StateManager manager;

	void setStateManager(final StateManager manager) {

		this.manager = manager;

	}

	public abstract void init();

	public abstract void input();

	public abstract void tick();

	public abstract void render(Graphics2D g);

	public abstract void destroy();

}
