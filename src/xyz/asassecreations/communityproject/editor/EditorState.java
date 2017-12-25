package xyz.asassecreations.communityproject.editor;

import java.awt.Color;
import java.awt.Graphics2D;

import xyz.asassecreations.communityproject.engine.state.State;

public final class EditorState extends State {

	public final void init() {

	}

	public final void input() {

	}

	public final void tick() {

	}

	public final void render(final Graphics2D g) {

		g.setColor(Color.WHITE);
		g.drawString("Editor test", 100, 100);

	}

	public final void destroy() {

	}

}
