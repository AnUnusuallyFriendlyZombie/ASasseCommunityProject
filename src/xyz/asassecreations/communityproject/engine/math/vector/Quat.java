package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

import xyz.asassecreations.communityproject.engine.math.Mathf;

public class Quat {

	public float x, y, z, w;

	/**
	 * C'tor. The quaternion will be initialized to the identity.
	 */
	public Quat() {
		super();
		setIdentity();
	}

	/**
	 * C'tor
	 *
	 * @param src
	 */
	public Quat(final Vec4 src) {
		set(src);
	}

	/**
	 * C'tor
	 *
	 */
	public Quat(final float x, final float y, final float z, final float w) {
		set(x, y, z, w);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.lwjgl.util.vector.WritableVec2f#set(float, float)
	 */
	public void set(final float x, final float y) {
		this.x = x;
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.lwjgl.util.vector.WritableVec3f#set(float, float, float)
	 */
	public void set(final float x, final float y, final float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.lwjgl.util.vector.WritableVec4#set(float, float, float, float)
	 */
	public void set(final float x, final float y, final float z, final float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Load from another Vec4
	 *
	 * @param src
	 *            The source vector
	 * @return this
	 */
	public Quat set(final Vec4 src) {
		x = src.x;
		y = src.y;
		z = src.z;
		w = src.w;
		return this;
	}

	/**
	 * Set this quaternion to the multiplication identity.
	 *
	 * @return this
	 */
	public Quat setIdentity() {
		return setIdentity(this);
	}

	/**
	 * Set the given quaternion to the multiplication identity.
	 *
	 * @param q
	 *            The quaternion
	 * @return q
	 */
	public static Quat setIdentity(final Quat q) {
		q.x = 0;
		q.y = 0;
		q.z = 0;
		q.w = 1;
		return q;
	}

	/**
	 * @return the length squared of the quaternion
	 */
	public float lengthSquared() {
		return x * x + y * y + z * z + w * w;
	}

	public float length() {
		return Mathf.sqrt(lengthSquared());
	}

	/**
	 * Normalise the source quaternion and place the result in another
	 * quaternion.
	 *
	 * @param src
	 *            The source quaternion
	 * @param dest
	 *            The destination quaternion, or null if a new quaternion is to
	 *            be created
	 * @return The normalised quaternion
	 */
	public static Quat normalise(final Quat src, Quat dest) {
		final float inv_l = 1f / src.length();

		if (dest == null) dest = new Quat();

		dest.set(src.x * inv_l, src.y * inv_l, src.z * inv_l, src.w * inv_l);

		return dest;
	}

	/**
	 * Normalise this quaternion and place the result in another quaternion.
	 *
	 * @param dest
	 *            The destination quaternion, or null if a new quaternion is to
	 *            be created
	 * @return the normalised quaternion
	 */
	public Quat normalise(final Quat dest) {
		return normalise(this, dest);
	}

	/**
	 * The dot product of two quaternions
	 *
	 * @param left
	 *            The LHS quat
	 * @param right
	 *            The RHS quat
	 * @return left dot right
	 */
	public static float dot(final Quat left, final Quat right) {
		return left.x * right.x + left.y * right.y + left.z * right.z + left.w * right.w;
	}

	/**
	 * Calculate the conjugate of this quaternion and put it into the given one
	 *
	 * @param dest
	 *            The quaternion which should be set to the conjugate of this
	 *            quaternion
	 */
	public Quat negate(final Quat dest) {
		return negate(this, dest);
	}

	/**
	 * Calculate the conjugate of this quaternion and put it into the given one
	 *
	 * @param src
	 *            The source quaternion
	 * @param dest
	 *            The quaternion which should be set to the conjugate of this
	 *            quaternion
	 */
	public static Quat negate(final Quat src, Quat dest) {
		if (dest == null) dest = new Quat();

		dest.x = -src.x;
		dest.y = -src.y;
		dest.z = -src.z;
		dest.w = src.w;

		return dest;
	}

	/**
	 * Calculate the conjugate of this quaternion
	 */
	public Quat negate() {
		return negate(this, this);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.lwjgl.util.vector.Vec#load(java.nio.FloatBuffer)
	 */
	public Quat load(final FloatBuffer buf) {
		x = buf.get();
		y = buf.get();
		z = buf.get();
		w = buf.get();
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.lwjgl.vector.Vec#scale(float)
	 */
	public Quat scale(final float scale) {
		return scale(scale, this, this);
	}

	/**
	 * Scale the source quaternion by scale and put the result in the
	 * destination
	 *
	 * @param scale
	 *            The amount to scale by
	 * @param src
	 *            The source quaternion
	 * @param dest
	 *            The destination quaternion, or null if a new quaternion is to
	 *            be created
	 * @return The scaled quaternion
	 */
	public static Quat scale(final float scale, final Quat src, Quat dest) {
		if (dest == null) dest = new Quat();
		dest.x = src.x * scale;
		dest.y = src.y * scale;
		dest.z = src.z * scale;
		dest.w = src.w * scale;
		return dest;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.lwjgl.util.vector.ReadableVec#store(java.nio.FloatBuffer)
	 */
	public Quat store(final FloatBuffer buf) {
		buf.put(x);
		buf.put(y);
		buf.put(z);
		buf.put(w);

		return this;
	}

	/**
	 * @return x
	 */
	public final float getX() {
		return x;
	}

	/**
	 * @return y
	 */
	public final float getY() {
		return y;
	}

	/**
	 * Set X
	 *
	 * @param x
	 */
	public final void setX(final float x) {
		this.x = x;
	}

	/**
	 * Set Y
	 *
	 * @param y
	 */
	public final void setY(final float y) {
		this.y = y;
	}

	/**
	 * Set Z
	 *
	 * @param z
	 */
	public void setZ(final float z) {
		this.z = z;
	}

	/*
	 * (Overrides)
	 *
	 * @see org.lwjgl.vector.ReadableVec3f#getZ()
	 */
	public float getZ() {
		return z;
	}

	/**
	 * Set W
	 *
	 * @param w
	 */
	public void setW(final float w) {
		this.w = w;
	}

	/*
	 * (Overrides)
	 *
	 * @see org.lwjgl.vector.ReadableVec3f#getW()
	 */
	public float getW() {
		return w;
	}

	public String toString() {
		return "Quat: " + x + " " + y + " " + z + " " + w;
	}

	/**
	 * Sets the value of this quaternion to the quaternion product of
	 * quaternions left and right (this = left * right). Note that this is safe
	 * for aliasing (e.g. this can be left or right).
	 *
	 * @param left
	 *            the first quaternion
	 * @param right
	 *            the second quaternion
	 */
	public static Quat mul(final Quat left, final Quat right, Quat dest) {
		if (dest == null) dest = new Quat();
		dest.set(left.x * right.w + left.w * right.x + left.y * right.z - left.z * right.y, left.y * right.w + left.w * right.y + left.z * right.x - left.x * right.z,
				left.z * right.w + left.w * right.z + left.x * right.y - left.y * right.x, left.w * right.w - left.x * right.x - left.y * right.y - left.z * right.z);
		return dest;
	}

	/**
	 *
	 * Multiplies quaternion left by the inverse of quaternion right and places
	 * the value into this quaternion. The value of both argument quaternions is
	 * preservered (this = left * right^-1).
	 *
	 * @param left
	 *            the left quaternion
	 * @param right
	 *            the right quaternion
	 */
	public static Quat mulInverse(final Quat left, final Quat right, Quat dest) {
		float n = right.lengthSquared();
		// zero-div may occur.
		n = n == 0.0 ? n : 1 / n;
		// store on stack once for aliasing-safty
		if (dest == null) dest = new Quat();
		dest.set((left.x * right.w - left.w * right.x - left.y * right.z + left.z * right.y) * n, (left.y * right.w - left.w * right.y - left.z * right.x + left.x * right.z) * n,
				(left.z * right.w - left.w * right.z - left.x * right.y + left.y * right.x) * n, (left.w * right.w + left.x * right.x + left.y * right.y + left.z * right.z) * n);

		return dest;
	}

	/**
	 * Sets the value of this quaternion to the equivalent rotation of the
	 * Axis-Angle argument.
	 *
	 * @param a1
	 *            the axis-angle: (x,y,z) is the axis and w is the angle
	 */
	public final void setFromAxisAngle(final Vec4 a1) {
		x = a1.x;
		y = a1.y;
		z = a1.z;
		final float n = (float) Math.sqrt(x * x + y * y + z * z);
		// zero-div may occur.
		final float s = (float) (Math.sin(0.5 * a1.w) / n);
		x *= s;
		y *= s;
		z *= s;
		w = (float) Math.cos(0.5 * a1.w);
	}

	/**
	 * Sets the value of this quaternion using the rotational component of the
	 * passed matrix.
	 *
	 * @param m
	 *            The matrix
	 * @return this
	 */
	public final Quat setFromMatrix(final Mat4 m) {
		return setFromMatrix(m, this);
	}

	/**
	 * Sets the value of the source quaternion using the rotational component of
	 * the passed matrix.
	 *
	 * @param m
	 *            The source matrix
	 * @param q
	 *            The destination quaternion, or null if a new quaternion is to
	 *            be created
	 * @return q
	 */
	public static Quat setFromMatrix(final Mat4 m, final Quat q) {
		return q.setFromMat(m.m00, m.m01, m.m02, m.m10, m.m11, m.m12, m.m20, m.m21, m.m22);
	}

	/**
	 * Sets the value of this quaternion using the rotational component of the
	 * passed matrix.
	 *
	 * @param m
	 *            The source matrix
	 */
	public final Quat setFromMatrix(final Mat3 m) {
		return setFromMatrix(m, this);
	}

	/**
	 * Sets the value of the source quaternion using the rotational component of
	 * the passed matrix.
	 *
	 * @param m
	 *            The source matrix
	 * @param q
	 *            The destination quaternion, or null if a new quaternion is to
	 *            be created
	 * @return q
	 */
	public static Quat setFromMatrix(final Mat3 m, final Quat q) {
		return q.setFromMat(m.m00, m.m01, m.m02, m.m10, m.m11, m.m12, m.m20, m.m21, m.m22);
	}

	/**
	 * Private method to perform the matrix-to-quaternion conversion
	 */
	private Quat setFromMat(final float m00, final float m01, final float m02, final float m10, final float m11, final float m12, final float m20, final float m21, final float m22) {

		float s;
		final float tr = m00 + m11 + m22;
		if (tr >= 0.0) {
			s = (float) Math.sqrt(tr + 1.0);
			w = s * 0.5f;
			s = 0.5f / s;
			x = (m21 - m12) * s;
			y = (m02 - m20) * s;
			z = (m10 - m01) * s;
		} else {
			final float max = Math.max(Math.max(m00, m11), m22);
			if (max == m00) {
				s = (float) Math.sqrt(m00 - (m11 + m22) + 1.0);
				x = s * 0.5f;
				s = 0.5f / s;
				y = (m01 + m10) * s;
				z = (m20 + m02) * s;
				w = (m21 - m12) * s;
			} else if (max == m11) {
				s = (float) Math.sqrt(m11 - (m22 + m00) + 1.0);
				y = s * 0.5f;
				s = 0.5f / s;
				z = (m12 + m21) * s;
				x = (m01 + m10) * s;
				w = (m02 - m20) * s;
			} else {
				s = (float) Math.sqrt(m22 - (m00 + m11) + 1.0);
				z = s * 0.5f;
				s = 0.5f / s;
				x = (m20 + m02) * s;
				y = (m12 + m21) * s;
				w = (m10 - m01) * s;
			}
		}
		return this;
	}

	public Quat clone() {

		return new Quat(x, y, z, w);

	}

}
