package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

import xyz.asassecreations.communityproject.engine.math.Mathf;

public class Vec4 {

	public float x, y, z, w;

	public Vec4() {

		set(0f);

	}

	public Vec4(final Vec4 src) {

		set(src);

	}

	public Vec4(final float x, final float y, final float z, final float w) {

		set(x, y, z, w);

	}

	public Vec4(final Vec2 v1, final float z, final float w) {

		set(v1.x, v1.y, z, w);

	}

	public Vec4(final float x, final Vec2 v1, final float w) {

		set(x, v1.x, v1.y, w);

	}

	public Vec4(final float x, final float y, final Vec2 v1) {

		set(x, y, v1.x, v1.y);

	}

	public Vec4(final Vec2 v1, final Vec2 v2) {

		set(v1.x, v1.y, v2.x, v2.y);

	}

	public Vec4(final Vec3 v, final float w) {

		set(v.x, v.y, v.z, w);

	}

	public Vec4(final float x, final Vec3 v) {

		set(x, v.x, v.y, v.z);

	}

	public Vec4 set(final float sca) {

		this.x = sca;
		this.y = sca;
		this.z = sca;
		this.w = sca;

		return this;

	}

	public Vec4 set(final float x, final float y, final float z, final float w) {

		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;

		return this;

	}

	public final Vec4 set(final Vec4 src) {

		x = src.x;
		y = src.y;
		z = src.z;
		w = src.w;

		return this;

	}

	public float magnitudeSquared() {

		return x * x + y * y + z * z + w * w;

	}

	public Vec4 negate() {

		this.x = -x;
		this.y = -y;
		this.z = -z;
		this.w = -w;

		return this;

	}

	public static float dot(final Vec4 left, final Vec4 right) {

		return left.x * right.x + left.y * right.y + left.z * right.z + left.w * right.w;

	}

	public static float angle(final Vec4 a, final Vec4 b) {

		float dls = dot(a, b) / (a.magnitude() * b.magnitude());

		if (dls < -1f) dls = -1f;
		else if (dls > 1.0f) dls = 1.0f;

		return (float) Math.acos(dls);

	}

	public Vec4 load(final FloatBuffer buf) {

		x = buf.get();
		y = buf.get();
		z = buf.get();
		w = buf.get();

		return this;

	}

	public Vec4 store(final FloatBuffer buf) {

		buf.put(x);
		buf.put(y);
		buf.put(z);
		buf.put(w);

		return this;

	}

	public final Vec2 asVec2(final String format) {

		final char a = format.charAt(0);
		final char b = format.charAt(1);

		final Vec2 vector = new Vec2();

		if (a == 'x') vector.x = x;
		else if (a == 'y') vector.x = y;
		else if (a == 'z') vector.x = z;
		else if (a == 'w') vector.x = w;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;
		else if (b == 'z') vector.y = z;
		else if (b == 'w') vector.y = w;

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
		else if (a == 'w') vector.x = w;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;
		else if (b == 'z') vector.y = z;
		else if (b == 'w') vector.y = w;

		if (c == 'x') vector.z = x;
		else if (c == 'y') vector.z = y;
		else if (c == 'z') vector.z = z;
		else if (c == 'w') vector.z = w;

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
		else if (a == 'w') vector.x = w;

		if (b == 'x') vector.y = x;
		else if (b == 'y') vector.y = y;
		else if (b == 'z') vector.y = z;
		else if (b == 'w') vector.y = w;

		if (c == 'x') vector.z = x;
		else if (c == 'y') vector.z = y;
		else if (c == 'z') vector.z = z;
		else if (c == 'w') vector.z = w;

		if (d == 'x') vector.w = x;
		else if (d == 'y') vector.w = y;
		else if (d == 'z') vector.w = z;
		else if (d == 'w') vector.w = w;

		return vector;

	}

	public Vec4 add(final Vec4 vec) {

		this.x += vec.x;
		this.y += vec.y;
		this.z += vec.z;
		this.w += vec.w;

		return this;

	}

	public Vec4 sub(final Vec4 vec) {

		this.x -= vec.x;
		this.y -= vec.y;
		this.z -= vec.z;
		this.w -= vec.w;

		return this;

	}

	public Vec4 mul(final Vec4 vec) {

		this.x *= vec.x;
		this.y *= vec.y;
		this.z *= vec.z;
		this.w *= vec.w;

		return this;

	}

	public Vec4 div(final Vec4 vec) {

		this.x /= vec.x;
		this.y /= vec.y;
		this.z /= vec.z;
		this.w /= vec.w;

		return this;

	}

	public Vec4 add(final float sca) {

		this.x += sca;
		this.y += sca;
		this.z += sca;
		this.w += sca;

		return this;

	}

	public Vec4 sub(final float sca) {

		this.x -= sca;
		this.y -= sca;
		this.z -= sca;
		this.w -= sca;

		return this;

	}

	public Vec4 mul(final float sca) {

		this.x *= sca;
		this.y *= sca;
		this.z *= sca;
		this.w *= sca;

		return this;

	}

	public Vec4 div(final float sca) {

		this.x /= sca;
		this.y /= sca;
		this.z /= sca;
		this.w /= sca;

		return this;

	}

	public String toString() {

		return "Vec4[" + x + ", " + y + ", " + z + ", " + w + "]";

	}

	public Vec4 clone() {

		return new Vec4(this);

	}

	public final float magnitude() {

		return Mathf.sqrt(magnitudeSquared());

	}

	public final Vec4 normalise() {

		final float len = magnitude();

		if (len != 0f) return div(len);

		else throw new IllegalStateException("Zero length vector");

	}

	public final Vec4 setMagnitude(final float mag) {

		return normalise().mul(mag);

	}

}
