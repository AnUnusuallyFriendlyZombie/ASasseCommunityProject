package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

public class Mat3 extends Mat {

	public float m00, m01, m02, m10, m11, m12, m20, m21, m22;

	/**
	 * Constructor for Mat3. Mat is initialised to the identity.
	 */
	public Mat3() {
		super();
		setIdentity();
	}

	public Mat3(final Mat3 src) {
		super();
		load(src);
	}

	/**
	 * Load from another matrix
	 *
	 * @param src
	 *            The source matrix
	 * @return this
	 */
	public Mat3 load(final Mat3 src) {
		return load(src, this);
	}

	/**
	 * Copy source matrix to destination matrix
	 *
	 * @param src
	 *            The source matrix
	 * @param dest
	 *            The destination matrix, or null of a new matrix is to be
	 *            created
	 * @return The copied matrix
	 */
	public static Mat3 load(final Mat3 src, Mat3 dest) {
		if (dest == null) dest = new Mat3();

		dest.m00 = src.m00;
		dest.m10 = src.m10;
		dest.m20 = src.m20;
		dest.m01 = src.m01;
		dest.m11 = src.m11;
		dest.m21 = src.m21;
		dest.m02 = src.m02;
		dest.m12 = src.m12;
		dest.m22 = src.m22;

		return dest;
	}

	/**
	 * Load from a float buffer. The buffer stores the matrix in column major
	 * (OpenGL) order.
	 *
	 * @param buf
	 *            A float buffer to read from
	 * @return this
	 */
	public Mat load(final FloatBuffer buf) {

		m00 = buf.get();
		m01 = buf.get();
		m02 = buf.get();
		m10 = buf.get();
		m11 = buf.get();
		m12 = buf.get();
		m20 = buf.get();
		m21 = buf.get();
		m22 = buf.get();

		return this;
	}

	/**
	 * Load from a float buffer. The buffer stores the matrix in row major
	 * (maths) order.
	 *
	 * @param buf
	 *            A float buffer to read from
	 * @return this
	 */
	public Mat loadTranspose(final FloatBuffer buf) {

		m00 = buf.get();
		m10 = buf.get();
		m20 = buf.get();
		m01 = buf.get();
		m11 = buf.get();
		m21 = buf.get();
		m02 = buf.get();
		m12 = buf.get();
		m22 = buf.get();

		return this;
	}

	/**
	 * Store this matrix in a float buffer. The matrix is stored in column major
	 * (openGL) order.
	 *
	 * @param buf
	 *            The buffer to store this matrix in
	 */
	public Mat store(final FloatBuffer buf) {
		buf.put(m00);
		buf.put(m01);
		buf.put(m02);
		buf.put(m10);
		buf.put(m11);
		buf.put(m12);
		buf.put(m20);
		buf.put(m21);
		buf.put(m22);
		return this;
	}

	/**
	 * Store this matrix in a float buffer. The matrix is stored in row major
	 * (maths) order.
	 *
	 * @param buf
	 *            The buffer to store this matrix in
	 */
	public Mat storeTranspose(final FloatBuffer buf) {
		buf.put(m00);
		buf.put(m10);
		buf.put(m20);
		buf.put(m01);
		buf.put(m11);
		buf.put(m21);
		buf.put(m02);
		buf.put(m12);
		buf.put(m22);
		return this;
	}

	/**
	 * Add two matrices together and place the result in a third matrix.
	 *
	 * @param left
	 *            The left source matrix
	 * @param right
	 *            The right source matrix
	 * @param dest
	 *            The destination matrix, or null if a new one is to be created
	 * @return the destination matrix
	 */
	public static Mat3 add(final Mat3 left, final Mat3 right, Mat3 dest) {
		if (dest == null) dest = new Mat3();

		dest.m00 = left.m00 + right.m00;
		dest.m01 = left.m01 + right.m01;
		dest.m02 = left.m02 + right.m02;
		dest.m10 = left.m10 + right.m10;
		dest.m11 = left.m11 + right.m11;
		dest.m12 = left.m12 + right.m12;
		dest.m20 = left.m20 + right.m20;
		dest.m21 = left.m21 + right.m21;
		dest.m22 = left.m22 + right.m22;

		return dest;
	}

	/**
	 * Subtract the right matrix from the left and place the result in a third
	 * matrix.
	 *
	 * @param left
	 *            The left source matrix
	 * @param right
	 *            The right source matrix
	 * @param dest
	 *            The destination matrix, or null if a new one is to be created
	 * @return the destination matrix
	 */
	public static Mat3 sub(final Mat3 left, final Mat3 right, Mat3 dest) {
		if (dest == null) dest = new Mat3();

		dest.m00 = left.m00 - right.m00;
		dest.m01 = left.m01 - right.m01;
		dest.m02 = left.m02 - right.m02;
		dest.m10 = left.m10 - right.m10;
		dest.m11 = left.m11 - right.m11;
		dest.m12 = left.m12 - right.m12;
		dest.m20 = left.m20 - right.m20;
		dest.m21 = left.m21 - right.m21;
		dest.m22 = left.m22 - right.m22;

		return dest;
	}

	/**
	 * Multiply the right matrix by the left and place the result in a third
	 * matrix.
	 *
	 * @param left
	 *            The left source matrix
	 * @param right
	 *            The right source matrix
	 * @param dest
	 *            The destination matrix, or null if a new one is to be created
	 * @return the destination matrix
	 */
	public static Mat3 mul(final Mat3 left, final Mat3 right, Mat3 dest) {
		if (dest == null) dest = new Mat3();

		final float m00 = left.m00 * right.m00 + left.m10 * right.m01 + left.m20 * right.m02;
		final float m01 = left.m01 * right.m00 + left.m11 * right.m01 + left.m21 * right.m02;
		final float m02 = left.m02 * right.m00 + left.m12 * right.m01 + left.m22 * right.m02;
		final float m10 = left.m00 * right.m10 + left.m10 * right.m11 + left.m20 * right.m12;
		final float m11 = left.m01 * right.m10 + left.m11 * right.m11 + left.m21 * right.m12;
		final float m12 = left.m02 * right.m10 + left.m12 * right.m11 + left.m22 * right.m12;
		final float m20 = left.m00 * right.m20 + left.m10 * right.m21 + left.m20 * right.m22;
		final float m21 = left.m01 * right.m20 + left.m11 * right.m21 + left.m21 * right.m22;
		final float m22 = left.m02 * right.m20 + left.m12 * right.m21 + left.m22 * right.m22;

		dest.m00 = m00;
		dest.m01 = m01;
		dest.m02 = m02;
		dest.m10 = m10;
		dest.m11 = m11;
		dest.m12 = m12;
		dest.m20 = m20;
		dest.m21 = m21;
		dest.m22 = m22;

		return dest;
	}

	/**
	 * Transform a Vector by a matrix and return the result in a destination
	 * vector.
	 *
	 * @param left
	 *            The left matrix
	 * @param right
	 *            The right vector
	 * @param dest
	 *            The destination vector, or null if a new one is to be created
	 * @return the destination vector
	 */
	public static Vec3 transform(final Mat3 left, final Vec3 right, Vec3 dest) {
		if (dest == null) dest = new Vec3();

		final float x = left.m00 * right.x + left.m10 * right.y + left.m20 * right.z;
		final float y = left.m01 * right.x + left.m11 * right.y + left.m21 * right.z;
		final float z = left.m02 * right.x + left.m12 * right.y + left.m22 * right.z;

		dest.x = x;
		dest.y = y;
		dest.z = z;

		return dest;
	}

	/**
	 * Transpose this matrix
	 *
	 * @return this
	 */
	public Mat transpose() {
		return transpose(this, this);
	}

	/**
	 * Transpose this matrix and place the result in another matrix
	 *
	 * @param dest
	 *            The destination matrix or null if a new matrix is to be
	 *            created
	 * @return the transposed matrix
	 */
	public Mat3 transpose(final Mat3 dest) {
		return transpose(this, dest);
	}

	/**
	 * Transpose the source matrix and place the result into the destination
	 * matrix
	 *
	 * @param src
	 *            The source matrix to be transposed
	 * @param dest
	 *            The destination matrix or null if a new matrix is to be
	 *            created
	 * @return the transposed matrix
	 */
	public static Mat3 transpose(final Mat3 src, Mat3 dest) {
		if (dest == null) dest = new Mat3();
		final float m00 = src.m00;
		final float m01 = src.m10;
		final float m02 = src.m20;
		final float m10 = src.m01;
		final float m11 = src.m11;
		final float m12 = src.m21;
		final float m20 = src.m02;
		final float m21 = src.m12;
		final float m22 = src.m22;

		dest.m00 = m00;
		dest.m01 = m01;
		dest.m02 = m02;
		dest.m10 = m10;
		dest.m11 = m11;
		dest.m12 = m12;
		dest.m20 = m20;
		dest.m21 = m21;
		dest.m22 = m22;
		return dest;
	}

	/**
	 * @return the determinant of the matrix
	 */
	public float determinant() {
		final float f = m00 * (m11 * m22 - m12 * m21) + m01 * (m12 * m20 - m10 * m22) + m02 * (m10 * m21 - m11 * m20);
		return f;
	}

	/**
	 * Returns a string representation of this matrix
	 */
	public String toString() {
		final StringBuilder buf = new StringBuilder();
		buf.append(m00).append(' ').append(m10).append(' ').append(m20).append(' ').append('\n');
		buf.append(m01).append(' ').append(m11).append(' ').append(m21).append(' ').append('\n');
		buf.append(m02).append(' ').append(m12).append(' ').append(m22).append(' ').append('\n');
		return buf.toString();
	}

	/**
	 * Invert this matrix
	 *
	 * @return this if successful, null otherwise
	 */
	public Mat invert() {
		return invert(this, this);
	}

	/**
	 * Invert the source matrix and put the result into the destination matrix
	 *
	 * @param src
	 *            The source matrix to be inverted
	 * @param dest
	 *            The destination matrix, or null if a new one is to be created
	 * @return The inverted matrix if successful, null otherwise
	 */
	public static Mat3 invert(final Mat3 src, Mat3 dest) {
		final float determinant = src.determinant();

		if (determinant != 0) {
			if (dest == null) dest = new Mat3();
			/*
			 * do it the ordinary way
			 *
			 * inv(A) = 1/det(A) * adj(T), where adj(T) = transpose(Conjugate
			 * Mat)
			 *
			 * m00 m01 m02 m10 m11 m12 m20 m21 m22
			 */
			final float determinant_inv = 1f / determinant;

			// get the conjugate matrix
			final float t00 = src.m11 * src.m22 - src.m12 * src.m21;
			final float t01 = -src.m10 * src.m22 + src.m12 * src.m20;
			final float t02 = src.m10 * src.m21 - src.m11 * src.m20;
			final float t10 = -src.m01 * src.m22 + src.m02 * src.m21;
			final float t11 = src.m00 * src.m22 - src.m02 * src.m20;
			final float t12 = -src.m00 * src.m21 + src.m01 * src.m20;
			final float t20 = src.m01 * src.m12 - src.m02 * src.m11;
			final float t21 = -src.m00 * src.m12 + src.m02 * src.m10;
			final float t22 = src.m00 * src.m11 - src.m01 * src.m10;

			dest.m00 = t00 * determinant_inv;
			dest.m11 = t11 * determinant_inv;
			dest.m22 = t22 * determinant_inv;
			dest.m01 = t10 * determinant_inv;
			dest.m10 = t01 * determinant_inv;
			dest.m20 = t02 * determinant_inv;
			dest.m02 = t20 * determinant_inv;
			dest.m12 = t21 * determinant_inv;
			dest.m21 = t12 * determinant_inv;
			return dest;
		} else return null;
	}

	/**
	 * Negate this matrix
	 *
	 * @return this
	 */
	public Mat negate() {
		return negate(this);
	}

	/**
	 * Negate this matrix and place the result in a destination matrix.
	 *
	 * @param dest
	 *            The destination matrix, or null if a new matrix is to be
	 *            created
	 * @return the negated matrix
	 */
	public Mat3 negate(final Mat3 dest) {
		return negate(this, this);
	}

	/**
	 * Negate the source matrix and place the result in the destination matrix.
	 *
	 * @param src
	 *            The source matrix
	 * @param dest
	 *            The destination matrix, or null if a new matrix is to be
	 *            created
	 * @return the negated matrix
	 */
	public static Mat3 negate(final Mat3 src, Mat3 dest) {
		if (dest == null) dest = new Mat3();

		dest.m00 = -src.m00;
		dest.m01 = -src.m02;
		dest.m02 = -src.m01;
		dest.m10 = -src.m10;
		dest.m11 = -src.m12;
		dest.m12 = -src.m11;
		dest.m20 = -src.m20;
		dest.m21 = -src.m22;
		dest.m22 = -src.m21;
		return dest;
	}

	/**
	 * Set this matrix to be the identity matrix.
	 *
	 * @return this
	 */
	public Mat setIdentity() {
		return setIdentity(this);
	}

	/**
	 * Set the matrix to be the identity matrix.
	 *
	 * @param m
	 *            The matrix to be set to the identity
	 * @return m
	 */
	public static Mat3 setIdentity(final Mat3 m) {
		m.m00 = 1.0f;
		m.m01 = 0.0f;
		m.m02 = 0.0f;
		m.m10 = 0.0f;
		m.m11 = 1.0f;
		m.m12 = 0.0f;
		m.m20 = 0.0f;
		m.m21 = 0.0f;
		m.m22 = 1.0f;
		return m;
	}

	/**
	 * Set this matrix to 0.
	 *
	 * @return this
	 */
	public Mat setZero() {
		return setZero(this);
	}

	/**
	 * Set the matrix matrix to 0.
	 *
	 * @param m
	 *            The matrix to be set to 0
	 * @return m
	 */
	public static Mat3 setZero(final Mat3 m) {
		m.m00 = 0.0f;
		m.m01 = 0.0f;
		m.m02 = 0.0f;
		m.m10 = 0.0f;
		m.m11 = 0.0f;
		m.m12 = 0.0f;
		m.m20 = 0.0f;
		m.m21 = 0.0f;
		m.m22 = 0.0f;
		return m;
	}

	public Mat3 clone() {
		return new Mat3(this);
	}

}
