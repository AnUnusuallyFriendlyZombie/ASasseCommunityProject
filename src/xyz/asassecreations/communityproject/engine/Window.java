package xyz.asassecreations.communityproject.engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import xyz.asassecreations.communityproject.CommunityProject;

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

		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		canvas.createBufferStrategy(3);
		bs = canvas.getBufferStrategy();

		frame.addWindowListener(new WindowListener() {

			public final void windowOpened(final WindowEvent e) {

			}

			public final void windowIconified(final WindowEvent e) {

			}

			public final void windowDeiconified(final WindowEvent e) {

			}

			public final void windowDeactivated(final WindowEvent e) {

			}

			public final void windowClosing(final WindowEvent e) {

				CommunityProject.stop();

			}

			public final void windowClosed(final WindowEvent e) {

			}

			public final void windowActivated(final WindowEvent e) {

			}

		});

		canvas.addKeyListener(new KeyListener() {

			public final void keyTyped(final KeyEvent e) {

			}

			public final void keyReleased(final KeyEvent e) {

				Input.kc[e.getKeyCode()] = false;

			}

			public final void keyPressed(final KeyEvent e) {

				Input.kc[e.getKeyCode()] = true;

			}

		});

		canvas.addMouseListener(new MouseListener() {

			public final void mouseReleased(final MouseEvent e) {

				Input.mc[e.getButton()] = false;

			}

			public final void mousePressed(final MouseEvent e) {

				Input.mc[e.getButton()] = true;

			}

			public final void mouseExited(final MouseEvent e) {

			}

			public final void mouseEntered(final MouseEvent e) {

			}

			public final void mouseClicked(final MouseEvent e) {

			}

		});

		canvas.addMouseMotionListener(new MouseMotionListener() {

			public final void mouseMoved(final MouseEvent e) {

				Input.mxc = e.getX();
				Input.myc = e.getY();

			}

			public final void mouseDragged(final MouseEvent e) {

				Input.mxc = e.getX();
				Input.myc = e.getY();

			}

		});

	}

}
