package xyz.asassecreations.communityproject;

import java.awt.Color;
import java.awt.Graphics2D;

public final class CommunityProject {

	private static final Window window = new Window(800, 600, "Game");

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

		g.setColor(Color.PINK);
		g.fillRect(0, 0, window.width, window.height);

		
		
		g.setColor(Color.BLACK);
		g.fillRoundRect(57, 79, 500, 176, 32, 32);
	}
}
