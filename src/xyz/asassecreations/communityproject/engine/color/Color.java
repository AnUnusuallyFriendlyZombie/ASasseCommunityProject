package xyz.asassecreations.communityproject.engine.color;

import xyz.asassecreations.communityproject.engine.math.Mathf;
import xyz.asassecreations.communityproject.engine.math.RNG;
import xyz.asassecreations.communityproject.engine.math.vector.Vec3;
import xyz.asassecreations.communityproject.engine.math.vector.Vec4;

public final class Color implements Cloneable {

	public static final Color randomColor(final float min, final float max) {

		return new Color(RNG.random(min, max), RNG.random(min, max), RNG.random(min, max));

	}

	private float r = 0, g = 0, b = 0, a = 1;

	public Color() {

		this(0f, 0f, 0f, 1f);

	}

	public Color(final int color) {

		this(color, 255);

	}

	public Color(final int color, final int alpha) {

		this((color & 0xFF0000) >> 16, (color & 0xFF00) >> 8, color & 0xFF, alpha);

	}

	public Color(final java.awt.Color color) {

		this(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());

	}

	public Color(final int red, final int green, final int blue) {

		this(red, green, blue, 255);

	}

	public Color(final Vec3 vector) {

		this(vector.x, vector.y, vector.z, 1f);

	}

	public Color(final Vec4 vector) {

		this(vector.x, vector.y, vector.z, vector.w);

	}

	public Color(final int red, final int green, final int blue, final int alpha) {

		this(red / 255f, green / 255f, blue / 255f, alpha / 255f);

	}

	public Color(final float red, final float green, final float blue) {

		this(red, green, blue, 1f);

	}

	public Color(final float red, final float green, final float blue, final float alpha) {

		set(red, green, blue, alpha);

	}

	public final Color brighter(final float amount) {

		r += amount;
		g += amount;
		b += amount;

		return this;

	}

	public final void clamp() {

		r = Mathf.constrain(r, 0f, 1f);
		g = Mathf.constrain(g, 0f, 1f);
		b = Mathf.constrain(b, 0f, 1f);
		a = Mathf.constrain(a, 0f, 1f);

	}

	public final Color set(final float red, final float green, final float blue, final float alpha) {

		final float nr = red == -1f ? r : red;
		final float ng = green == -1f ? g : green;
		final float nb = blue == -1f ? b : blue;
		final float na = alpha == -1f ? a : alpha;

		rawSet(nr, ng, nb, na);

		return this;

	}

	private final void rawSet(final float red, final float green, final float blue, final float alpha) {

		this.r = red;
		this.g = green;
		this.b = blue;
		this.a = alpha;

		clamp();

	}

	public final java.awt.Color awtColor() {

		clamp();

		return new java.awt.Color(r, g, b, a);

	}

	public final float getRed() {

		clamp();

		return r;

	}

	public final float getGreen() {

		clamp();

		return g;

	}

	public final float getBlue() {

		clamp();

		return b;

	}

	public final float getAlpha() {

		clamp();

		return a;

	}

	public final Color clone() {

		return new Color(r, g, b, a);

	}

	public final Vec4 asVec4() {

		return new Vec4(r, g, b, a);

	}

	public final Vec3 asVec3() {

		return new Vec3(r, g, b);

	}

	public final boolean equals(final Object object) {

		if (!(object instanceof Color)) return false;

		final Color color = (Color) object;

		if (getRed() != color.getRed()) return false;
		if (getGreen() != color.getGreen()) return false;
		if (getBlue() != color.getBlue()) return false;
		if (getAlpha() != color.getAlpha()) return false;

		return true;

	}

}
