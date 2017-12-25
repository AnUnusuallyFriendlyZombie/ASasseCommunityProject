package xyz.asassecreations.communityproject;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import xyz.asassecreations.communityproject.editor.EditorState;
import xyz.asassecreations.communityproject.engine.Timings;
import xyz.asassecreations.communityproject.engine.Window;
import xyz.asassecreations.communityproject.engine.state.StateManager;
import xyz.asassecreations.communityproject.state.TestState;

public final class CommunityProject {

	public static Window WINDOW;
	private static final StateManager manager = new StateManager();
	private static final int target_fps = 60;
	private static boolean running = true;

	private CommunityProject() {

	}

	public static final void main(final String[] args) {

		{

			final int result = JOptionPane.showConfirmDialog(null, "Open Editor?");

			if (result == JOptionPane.CLOSED_OPTION || result == JOptionPane.CANCEL_OPTION) return;
			manager.push(result == JOptionPane.YES_OPTION ? new EditorState() : new TestState());

		}

		WINDOW = new Window(800, 600, "Game");

		long lastLoopTime = System.nanoTime();
		int fps = 0;
		long lastFpsTime = System.nanoTime();

		while (running) {

			final long now = System.nanoTime();
			final long updateLength = now - lastLoopTime;

			lastFpsTime += updateLength;
			fps++;

			if (lastFpsTime >= 1000000000) {

				Timings.fps = fps;
				lastFpsTime = 0;
				fps = 0;

			}

			Timings.setDelta((now - lastLoopTime) / 1000000000d);
			Timings.setGlobalTime(Timings.globalTime + Timings.delta);

			lastLoopTime = now;

			manager.input();
			manager.tick();

			do {

				do {

					final Graphics2D g = (Graphics2D) WINDOW.bs.getDrawGraphics();

					g.setColor(Color.BLACK);
					g.fillRect(0, 0, WINDOW.width, WINDOW.height);

					manager.render(g);

					g.dispose();

				} while (WINDOW.bs.contentsRestored());

				WINDOW.bs.show();

			} while (WINDOW.bs.contentsLost());

			Timings.frames++;

			final long value = (lastLoopTime - System.nanoTime() + 1000000000l / target_fps) / 1000000;

			Timings.sleep = value;

			if (value > 0) try {

				Thread.sleep(value);

			} catch (final InterruptedException e) {

				continue;

			}

		}

		WINDOW.frame.dispose();

	}

	public static final void stop() {

		running = false;

	}

}
