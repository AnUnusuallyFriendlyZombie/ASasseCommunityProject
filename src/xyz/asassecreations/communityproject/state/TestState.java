package xyz.asassecreations.communityproject.state;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import xyz.asassecreations.communityproject.CommunityProject;
import xyz.asassecreations.communityproject.engine.Input;
import xyz.asassecreations.communityproject.engine.Timings;
import xyz.asassecreations.communityproject.engine.Util;
import xyz.asassecreations.communityproject.engine.state.State;

public final class TestState extends State {

	private BufferedImage image;

	private final int mapWidth = 1000;
	private final int mapHeight = 1000;
	private final int[] tilemap = new int[mapWidth * mapHeight];
	private float cx = 0, cy = 0;

	public final void init() {

		image = Util.getImage("/gfx/grass.png");
		if (image == null) System.err.println("Failed to load grass texture.");

	}

	public final void input() {

		float vx = 0;
		float vy = 0;

		if (Input.kc[KeyEvent.VK_W]) vy--;
		if (Input.kc[KeyEvent.VK_S]) vy++;
		if (Input.kc[KeyEvent.VK_A]) vx--;
		if (Input.kc[KeyEvent.VK_D]) vx++;

		vx *= 100f;
		vy *= 100f;

		cx += vx * Timings.delta_f;
		cy += vy * Timings.delta_f;

	}

	public final void tick() {

	}

	public final void render(final Graphics2D g) {

		final int scale = 64;

		for (int y = 0; y < mapHeight; y++) {

			final int yy = y * scale - (int) cy;

			if (yy > CommunityProject.WINDOW.height) break;
			if (yy < -scale) continue;

			for (int x = 0; x < mapWidth; x++) {

				final int xx = x * scale - (int) cx;

				if (xx > CommunityProject.WINDOW.width) break;
				if (xx < -scale) continue;

				g.drawImage(image, xx, yy, scale, scale, null);

			}

		}

	}

	public final void destroy() {

	}

}
