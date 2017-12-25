package xyz.asassecreations.communityproject.engine.state;

public abstract class State {

	protected StateManager manager;

	void setStateManager(final StateManager manager) {

		this.manager = manager;

	}

	public abstract void init();

	public abstract void input();

	public abstract void tick();

	public abstract void render();

	public abstract void destroy();

}
