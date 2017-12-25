package xyz.asassecreations.communityproject.engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Stack;

import xyz.asassecreations.communityproject.engine.color.Colors;

public final class Renderer {

	public static final class Constants {

		public static xyz.asassecreations.communityproject.engine.color.Color DEFAULT_COLOR = Colors.BLACK;

	}

	public static Graphics2D g;
	public static int width, height;

	private Renderer() {

	}

	public static final class Color {

		private static final Stack<xyz.asassecreations.communityproject.engine.color.Color> stack = new Stack<>();

		public static final xyz.asassecreations.communityproject.engine.color.Color peek() {

			if (stack.isEmpty()) return Constants.DEFAULT_COLOR;
			return stack.peek();

		}

		public static final void push(xyz.asassecreations.communityproject.engine.color.Color color) {

			if (color == null) color = Constants.DEFAULT_COLOR;

			stack.push(color);
			g_set(color);

		}

		public static final xyz.asassecreations.communityproject.engine.color.Color pop() {

			if (stack.isEmpty()) return Constants.DEFAULT_COLOR;

			final xyz.asassecreations.communityproject.engine.color.Color oldColor = stack.pop();
			g_set(peek());
			return oldColor;

		}

		public static final void g_set(final xyz.asassecreations.communityproject.engine.color.Color color) {

			g.setColor(color.awtColor());

		}

	}

	public static final void begin() {

		Color.stack.clear();
		Color.g_set(Constants.DEFAULT_COLOR);

	}

	public static final void clear() {

		g.fillRect(0, 0, width, height);

	}

	public static final void fillRect(final float x, final float y, final float w, final float h) {

		g.fillRect(Math.round(x), Math.round(y), Math.round(w), Math.round(h));

	}

	public static final void drawRect(final float x, final float y, final float w, final float h) {

		g.drawRect(Math.round(x), Math.round(y), Math.round(w), Math.round(h));

	}

	public static final void fillOval(final float x, final float y, final float w, final float h) {

		g.fillOval(Math.round(x), Math.round(y), Math.round(w), Math.round(h));

	}

	public static final void drawOval(final float x, final float y, final float w, final float h) {

		g.drawOval(Math.round(x), Math.round(y), Math.round(w), Math.round(h));

	}

	public static final void drawImage(final BufferedImage image, final float x, final float y, final float w, final float h) {

		g.drawImage(image, Math.round(x), Math.round(y), Math.round(w), Math.round(h), null);

	}

	public static final void drawImage(final BufferedImage image, final float x, final float y) {

		g.drawImage(image, Math.round(x), Math.round(y), null);

	}

}
