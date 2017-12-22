package xyz.asassecreations.communityproject;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public final class CommunityProject {

	private CommunityProject() {

	}

	public static final void main(final String[] args) {

		final int width = 1280;
		final int height = 720;

		final JFrame frame = new JFrame();
		final Canvas canvas = new Canvas();
		final Dimension dim = new Dimension(width, height);

		canvas.setMinimumSize(dim);
		canvas.setMaximumSize(dim);
		canvas.setPreferredSize(dim);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		// frame.setUndecorated(true);
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		canvas.createBufferStrategy(3);
		final BufferStrategy bs = canvas.getBufferStrategy();

		while (true)
			do {

				do {

					final Graphics2D g = (Graphics2D) bs.getDrawGraphics();

					g.setColor(Color.BLACK);
					g.fillRect(0, 0, width, height);

					g.setColor(Color.WHITE);
					g.fillRect(100, 100, 100, 100);

					g.dispose();

				} while (bs.contentsRestored());

				bs.show();

			} while (bs.contentsLost());

	}

}
