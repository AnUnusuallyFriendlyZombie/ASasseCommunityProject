package xyz.asassecreations.communityproject.editor;

import java.awt.Color;

import xyz.asassecreations.communityproject.engine.Renderer;
import xyz.asassecreations.communityproject.engine.state.State;

public final class EditorState extends State {

	public final void init() {

	}

	public final void input() {

	}

	public final void tick() {

	}

	public final void render() {

		Renderer.g.setColor(Color.WHITE);
		Renderer.g.drawString("Editor test", 100, 100);

	}

	public final void destroy() {

	}

}
