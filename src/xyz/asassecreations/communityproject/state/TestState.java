package xyz.asassecreations.communityproject.state;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import xyz.asassecreations.communityproject.CommunityProject;
import xyz.asassecreations.communityproject.engine.Input;
import xyz.asassecreations.communityproject.engine.Renderer;
import xyz.asassecreations.communityproject.engine.Timings;
import xyz.asassecreations.communityproject.engine.Util;
import xyz.asassecreations.communityproject.engine.color.Colors;
import xyz.asassecreations.communityproject.engine.math.vector.Vec2;
import xyz.asassecreations.communityproject.engine.state.State;

public final class TestState extends State {

	private BufferedImage image;

	private final int mapWidth = 1000;
	private final int mapHeight = 1000;
	private final int[] tilemap = new int[mapWidth * mapHeight];
	private final Vec2 camera = new Vec2();

	public final void init() {

		image = Util.getImage("/gfx/grass.png");
		if (image == null) System.err.println("Failed to load grass texture.");

	}

	public final void input() {

		final Vec2 dir = new Vec2();

		if (Input.kc[KeyEvent.VK_W]) dir.y--;
		if (Input.kc[KeyEvent.VK_S]) dir.y++;
		if (Input.kc[KeyEvent.VK_A]) dir.x--;
		if (Input.kc[KeyEvent.VK_D]) dir.x++;

		if (dir.magnitudeSquared() != 0f) dir.normalise();

		camera.add(dir.mul(100f).mul(Timings.delta_f));

	}

	public final void tick() {

	}

	public final void render() {

		final int scale = 64;

		for (int y = 0; y < mapHeight; y++) {

			final int yy = y * scale - (int) camera.y;

			if (yy > CommunityProject.WINDOW.height) break;
			if (yy < -scale) continue;

			for (int x = 0; x < mapWidth; x++) {

				final int xx = x * scale - (int) camera.x;

				if (xx > CommunityProject.WINDOW.width) break;
				if (xx < -scale) continue;

				Renderer.g.drawImage(image, xx, yy, scale, scale, null);

			}

		}

		{

			Renderer.Color.push(Colors.WHITE);

			final int vy = 15;
			final int x = 5;
			int y = 0;

			Renderer.g.drawString("Delta: " + Timings.delta, x, y += vy);
			Renderer.g.drawString("FPS: " + Timings.fps, x, y += vy);
			Renderer.g.drawString("Frames: " + Timings.frames, x, y += vy);
			Renderer.g.drawString("Globaltime: " + Timings.globalTime, x, y += vy);
			Renderer.g.drawString("Sleep: " + Timings.sleep, x, y += vy);
			Renderer.g.drawString("Camera X: " + camera.x, x, y += vy);

			Renderer.Color.pop();

		}

	}

	public final void destroy() {

	}

}
