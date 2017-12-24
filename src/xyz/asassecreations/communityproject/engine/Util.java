package xyz.asassecreations.communityproject.engine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public final class Util {

	private Util() {

	}

	public static final InputStream getStream(final String path) {

		return path == null ? null : Class.class.getResourceAsStream(path);

	}

	public static final BufferedImage getImage(final String path) {

		final InputStream stream = getStream(path);
		if (stream == null) return null;

		try {

			final BufferedImage image = ImageIO.read(stream);
			image.flush();

			return image;

		} catch (final IOException e) {

			return null;

		}

	}

}
