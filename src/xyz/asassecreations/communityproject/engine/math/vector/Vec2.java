package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

import xyz.asassecreations.communityproject.engine.math.Mathf;

public class Vec2 {

	public static final Vec2 UP = new Vec2(0, 1);
	public static final Vec2 DOWN = new Vec2(0, -1);
	public static final Vec2 LEFT = new Vec2(-1, 0);
	public static final Vec2 RIGHT = new Vec2(1, 0);

	public float x, y;

	public Vec2() {

		set(0f);

	}

	public Vec2(final float sca) {

		set(sca);

	}

	public Vec2(final float x, final float y) {

		set(x, y);

	}

	public Vec2(final Vec2 vec) {

		set(vec);

	}

	public final Vec2 set(final float sca) {

		return set(sca, sca);

	}

	public final Vec2 set(final float x, final float y) {

		this.x = x;
		this.y = y;

		return this;

	}

	public final Vec2 set(final Vec2 vec) {

		return set(vec.x, vec.y);

	}

	public final float magnitudeSquared() {

		return x * x + y * y;

	}

	public final Vec2 load(final FloatBuffer buf) {

		x = buf.get();
		y = buf.get();

		return this;

	}

	public final Vec2 store(final FloatBuffer buf) {

		buf.put(x);
		buf.put(y);

		return this;

	}

	public final Vec2 negate() {

		return mul(-1f);

	}

	public final Vec2 add(final float sca) {

		this.x += sca;
		this.y += sca;

		return this;

	}

	public final Vec2 sub(final float sca) {

		this.x -= sca;
		this.y -= sca;

		return this;

	}

	public final Vec2 mul(final float sca) {

		this.x *= sca;
		this.y *= sca;

		return this;

	}

	public final Vec2 div(final float sca) {

		this.x /= sca;
		this.y /= sca;

		return this;

	}

	public final Vec2 add(final Vec2 vec) {

		this.x += vec.x;
		this.y += vec.y;

		return this;

	}

	public final Vec2 sub(final Vec2 vec) {

		this.x -= vec.x;
		this.y -= vec.y;

		return this;

	}

	public final Vec2 mul(final Vec2 vec) {

		this.x *= vec.x;
		this.y *= vec.y;

		return this;

	}

	public final Vec2 div(final Vec2 vec) {

		this.x /= vec.x;
		this.y /= vec.y;

		return this;

	}

	public final Vec2 clone() {

		return new Vec2(this);

	}

	public static float dot(final Vec2 left, final Vec2 right) {

		return left.x * right.x + left.y * right.y;

	}

	public final float magnitude() {

		return Mathf.sqrt(magnitudeSquared());

	}

	public final Vec2 normalise() {

		final float len = magnitude();

		if (len != 0f) return div(len);
		else throw new IllegalStateException("Zero length vector");

	}

	public final Vec2 setMagnitude(final float mag) {

		return normalise().mul(mag);

	}

	public static float angle(final Vec2 a, final Vec2 b) {

		float dls = dot(a, b) / (a.magnitude() * b.magnitude());

		if (dls < -1f) dls = -1f;
		else if (dls > 1.0f) dls = 1f;

		return (float) Math.acos(dls);

	}

	public final Vec2 asVec2(final String format) {

		final char a = format.charAt(0);
		final char b = format.charAt(1);

		final Vec2 vector = new Vec2();

		if (a == 'x') vector.x = x;
		else if (a == 'y') vector.x = y;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;

		return vector;

	}

	public final Vec3 asVec3(final String format) {

		final char a = format.charAt(0);
		final char b = format.charAt(1);
		final char c = format.charAt(2);

		final Vec3 vector = new Vec3();

		if (a == 'x') vector.x = x;
		else if (a == 'y') vector.x = y;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;

		if (c == 'x') vector.z = x;
		else if (c == 'y') vector.z = y;

		return vector;

	}

	public final Vec4 asVec4(final String format) {

		final char a = format.charAt(0);
		final char b = format.charAt(1);
		final char c = format.charAt(2);
		final char d = format.charAt(3);

		final Vec4 vector = new Vec4();

		if (a == 'x') vector.x = x;
		else if (a == 'y') vector.x = y;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;

		if (c == 'x') vector.z = x;
		else if (c == 'y') vector.z = y;

		if (d == 'x') vector.w = x;
		else if (d == 'y') vector.w = y;

		return vector;

	}

	public final String toString() {

		return "Vec2[" + x + ", " + y + "]";

	}

}
