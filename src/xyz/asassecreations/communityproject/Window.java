package xyz.asassecreations.communityproject;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public final class Window {

	public final int width, height;
	public final String title;

	public final JFrame frame;
	public final Canvas canvas;
	public final BufferStrategy bs;

	public Window(final int width, final int height, final String title) {

		frame = new JFrame(this.title = title);
		canvas = new Canvas();
		final Dimension dim = new Dimension(this.width = width, this.height = height);

		canvas.setMinimumSize(dim);
		canvas.setMaximumSize(dim);
		canvas.setPreferredSize(dim);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		canvas.createBufferStrategy(3);
		bs = canvas.getBufferStrategy();

	}

}
