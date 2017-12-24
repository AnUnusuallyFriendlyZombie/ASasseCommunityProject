package xyz.asassecreations.communityproject.state;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import xyz.asassecreations.communityproject.engine.Util;
import xyz.asassecreations.communityproject.engine.state.State;

public final class TestState extends State {

	private BufferedImage image;

	public final void init() {

		image = Util.getImage("/gfx/grass.png");
		if (image == null) System.err.println("Failed to load grass texture.");

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
