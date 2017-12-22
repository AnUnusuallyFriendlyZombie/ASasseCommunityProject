package xyz.asassecreations.communityproject;

import java.awt.Color;
import java.awt.Graphics2D;

public final class CommunityProject {

	private static final Window window = new Window(1280, 720, "Game");

	private CommunityProject() {

	}

	public static final void main(final String[] args) {

		while (true)
			do {

				do {

					final Graphics2D g = (Graphics2D) window.bs.getDrawGraphics();

					render(g);

					g.dispose();

				} while (window.bs.contentsRestored());

				window.bs.show();

			} while (window.bs.contentsLost());

	}

	public static final void render(final Graphics2D g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, window.width, window.height);

	}
}
