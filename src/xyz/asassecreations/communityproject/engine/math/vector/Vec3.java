package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

import xyz.asassecreations.communityproject.engine.math.Mathf;

public class Vec3 {

	public static final Vec3 UP = new Vec3(0, 1, 0);
	public static final Vec3 DOWN = new Vec3(0, -1, 0);
	public static final Vec3 LEFT = new Vec3(-1, 0, 0);
	public static final Vec3 RIGHT = new Vec3(1, 0, 0);
	public static final Vec3 FORWARD = new Vec3(0, 0, -1);
	public static final Vec3 BACKWARD = new Vec3(0, 0, 1);

	public float x, y, z;

	public Vec3() {

		set(0f);

	}

	public Vec3(final float v) {

		set(v);

	}

	public Vec3(final float x, final float y, final float z) {

		set(x, y, z);

	}

	public Vec3(final Vec2 v, final float z) {

		set(v.x, v.y, z);

	}

	public Vec3(final float x, final Vec2 v) {

		set(x, v.x, v.y);

	}

	public Vec3(final Vec3 src) {

		set(src);

	}

	public final Vec3 set(final float sca) {

		this.x = sca;
		this.y = sca;
		this.z = sca;

		return this;

	}

	public Vec3 set(final float x, final float y, final float z) {

		this.x = x;
		this.y = y;
		this.z = z;

		return this;

	}

	public final Vec3 set(final Vec3 src) {

		x = src.x;
		y = src.y;
		z = src.z;

		return this;

	}

	public final float magnitudeSquared() {

		return x * x + y * y + z * z;

	}

	public final Vec3 add(final Vec3 vec) {

		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;

		return this;

	}

	public final Vec3 sub(final Vec3 vec) {

		this.x -= vec.x;
		this.y -= vec.y;
		this.z -= vec.z;

		return this;

	}

	public final Vec3 mul(final Vec3 vec) {

		this.x *= vec.x;
		this.y *= vec.y;
		this.z *= vec.z;

		return this;

	}

	public final Vec3 div(final Vec3 vec) {

		this.x /= vec.x;
		this.y /= vec.y;
		this.z /= vec.z;

		return this;

	}

	public final Vec3 add(final float sca) {

		this.x += sca;
		this.y += sca;
		this.z += sca;

		return this;

	}

	public final Vec3 sub(final float sca) {

		this.x -= sca;
		this.y -= sca;
		this.z -= sca;

		return this;

	}

	public final Vec3 mul(final float sca) {

		this.x *= sca;
		this.y *= sca;
		this.z *= sca;

		return this;

	}

	public final Vec3 div(final float sca) {

		this.x /= sca;
		this.y /= sca;
		this.z /= sca;

		return this;

	}

	public static Vec3 cross(final Vec3 left, final Vec3 right, Vec3 dest) {

		if (dest == null) dest = new Vec3();

		dest.set(left.y * right.z - left.z * right.y, right.x * left.z - right.z * left.x, left.x * right.y - left.y * right.x);

		return dest;

	}

	public final Vec3 negate() {

		x = -x;
		y = -y;
		z = -z;

		return this;

	}

	public static float dot(final Vec3 left, final Vec3 right) {

		return left.x * right.x + left.y * right.y + left.z * right.z;

	}

	public static float angle(final Vec3 a, final Vec3 b) {

		float dls = dot(a, b) / (a.magnitude() * b.magnitude());
		if (dls < -1f) dls = -1f;
		else if (dls > 1.0f) dls = 1.0f;
		return (float) Math.acos(dls);

	}

	public Vec3 load(final FloatBuffer buf) {

		x = buf.get();
		y = buf.get();
		z = buf.get();

		return this;

	}

	public Vec3 store(final FloatBuffer buf) {

		buf.put(x);
		buf.put(y);
		buf.put(z);

		return this;

	}

	public final Vec2 asVec2(final String format) {

		final char a = format.charAt(0);
		final char b = format.charAt(1);

		final Vec2 vector = new Vec2();

		if (a == 'x') vector.x = x;
		else if (a == 'y') vector.x = y;
		else if (a == 'z') vector.x = z;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;
		else if (b == 'z') vector.y = z;

		return vector;

	}

	public final Vec3 asVec3(final String format) {

		final char a = format.charAt(0);
		final char b = format.charAt(1);
		final char c = format.charAt(2);

		final Vec3 vector = new Vec3();

		if (a == 'x') vector.x = x;
		else if (a == 'y') vector.x = y;
		else if (a == 'z') vector.x = z;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;
		else if (b == 'z') vector.y = z;

		if (c == 'x') vector.z = x;
		else if (c == 'y') vector.z = y;
		else if (c == 'z') vector.z = z;

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
		else if (a == 'z') vector.x = z;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;
		else if (b == 'z') vector.y = z;

		if (c == 'x') vector.z = x;
		else if (c == 'y') vector.z = y;
		else if (c == 'z') vector.z = z;

		if (d == 'x') vector.w = x;
		else if (d == 'y') vector.w = y;
		else if (d == 'z') vector.w = z;

		return vector;

	}

	public String toString() {

		return "vec3[" + x + ", " + y + ", " + z + "]";

	}

	public final Vec3 clone() {

		return new Vec3(this);

	}

	public final float magnitude() {

		return Mathf.sqrt(magnitudeSquared());

	}

	public final Vec3 normalise() {

		final float len = magnitude();

		if (len != 0f) return mul(1f / len);

		else throw new IllegalStateException("Zero length vector");

	}

	public final Vec3 setMagnitude(final float mag) {

		return normalise().mul(mag);

	}

}
