package xyz.asassecreations.communityproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class CommunityProject {

	private static final Window window = new Window(800, 600, "Game");
	private static BufferedImage image;

	private CommunityProject() {

	}

	public static final void main(final String[] args) {

		try {

			image = ImageIO.read(Class.class.getResourceAsStream("/grass.png"));

		} catch (final IOException e) {

			e.printStackTrace();

		}

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

		final int scale = 64;

		for (int y = 0; y < 5; y++)
			for (int x = 0; x < 5; x++)
				g.drawImage(image, x * scale, y * scale, scale, scale, null);

	}
}
