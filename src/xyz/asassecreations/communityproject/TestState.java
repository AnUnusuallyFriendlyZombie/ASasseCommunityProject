package xyz.asassecreations.communityproject;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import xyz.asassecreations.communityproject.state.State;

public final class TestState extends State {

	private BufferedImage image;

	public final void init() {

		try {

			image = ImageIO.read(Class.class.getResourceAsStream("/grass.png"));

		} catch (final IOException e) {

			e.printStackTrace();

		}

	}

	public final void input() {

	}

	public final void tick() {

	}

	public final void render(final Graphics2D g) {

		final int scale = 64;

		for (int y = 0; y < 5; y++)
			for (int x = 0; x < 5; x++)
				g.drawImage(image, x * scale, y * scale, scale, scale, null);

	}

	public final void destroy() {

	}

}
