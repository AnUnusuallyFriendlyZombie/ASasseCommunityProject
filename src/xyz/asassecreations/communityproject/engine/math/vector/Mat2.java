package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

public final class Mat2 extends Mat {

	public float m00, m01, m10, m11;

	/**
	 * Constructor for Mat2. The matrix is initialised to the identity.
	 */
	public Mat2() {
		setIdentity();
	}

	/**
	 * Constructor
	 */
	public Mat2(final Mat2 src) {
		load(src);
	}

	/**
	 * Load from another matrix
	 *
	 * @param src
	 *            The source matrix
	 * @return this
	 */
	public Mat2 load(final Mat2 src) {
		return load(src, this);
	}

	/**
	 * Copy the source matrix to the destination matrix.
	 *
	 * @param src
	 *            The source matrix
	 * @param dest
	 *            The destination matrix, or null if a new one should be
	 *            created.
	 * @return The copied matrix
	 */
	public static Mat2 load(final Mat2 src, Mat2 dest) {
		if (dest == null) dest = new Mat2();

		dest.m00 = src.m00;
		dest.m01 = src.m01;
		dest.m10 = src.m10;
		dest.m11 = src.m11;

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
		m10 = buf.get();
		m11 = buf.get();

		return this;
	}

	/**
	 * Load from a float buffer. The buffer stores the matrix in row major
	 * (mathematical) order.
	 *
	 * @param buf
	 *            A float buffer to read from
	 * @return this
	 */
	public Mat loadTranspose(final FloatBuffer buf) {

		m00 = buf.get();
		m10 = buf.get();
		m01 = buf.get();
		m11 = buf.get();

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
		buf.put(m10);
		buf.put(m11);
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
		buf.put(m01);
		buf.put(m11);
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
	public static Mat2 add(final Mat2 left, final Mat2 right, Mat2 dest) {
		if (dest == null) dest = new Mat2();

		dest.m00 = left.m00 + right.m00;
		dest.m01 = left.m01 + right.m01;
		dest.m10 = left.m10 + right.m10;
		dest.m11 = left.m11 + right.m11;

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
	public static Mat2 sub(final Mat2 left, final Mat2 right, Mat2 dest) {
		if (dest == null) dest = new Mat2();

		dest.m00 = left.m00 - right.m00;
		dest.m01 = left.m01 - right.m01;
		dest.m10 = left.m10 - right.m10;
		dest.m11 = left.m11 - right.m11;

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
	public static Mat2 mul(final Mat2 left, final Mat2 right, Mat2 dest) {
		if (dest == null) dest = new Mat2();

		final float m00 = left.m00 * right.m00 + left.m10 * right.m01;
		final float m01 = left.m01 * right.m00 + left.m11 * right.m01;
		final float m10 = left.m00 * right.m10 + left.m10 * right.m11;
		final float m11 = left.m01 * right.m10 + left.m11 * right.m11;

		dest.m00 = m00;
		dest.m01 = m01;
		dest.m10 = m10;
		dest.m11 = m11;

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
	public static Vec2 transform(final Mat2 left, final Vec2 right, Vec2 dest) {
		if (dest == null) dest = new Vec2();

		final float x = left.m00 * right.x + left.m10 * right.y;
		final float y = left.m01 * right.x + left.m11 * right.y;

		dest.x = x;
		dest.y = y;

		return dest;
	}

	/**
	 * Transpose this matrix
	 *
	 * @return this
	 */
	public Mat transpose() {
		return transpose(this);
	}

	/**
	 * Transpose this matrix and place the result in another matrix.
	 *
	 * @param dest
	 *            The destination matrix or null if a new matrix is to be
	 *            created
	 * @return the transposed matrix
	 */
	public Mat2 transpose(final Mat2 dest) {
		return transpose(this, dest);
	}

	/**
	 * Transpose the source matrix and place the result in the destination
	 * matrix.
	 *
	 * @param src
	 *            The source matrix or null if a new matrix is to be created
	 * @param dest
	 *            The destination matrix or null if a new matrix is to be
	 *            created
	 * @return the transposed matrix
	 */
	public static Mat2 transpose(final Mat2 src, Mat2 dest) {
		if (dest == null) dest = new Mat2();

		final float m01 = src.m10;
		final float m10 = src.m01;

		dest.m01 = m01;
		dest.m10 = m10;

		return dest;
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
	 * Invert the source matrix and place the result in the destination matrix.
	 *
	 * @param src
	 *            The source matrix to be inverted
	 * @param dest
	 *            The destination matrix or null if a new matrix is to be
	 *            created
	 * @return The inverted matrix, or null if source can't be reverted.
	 */
	public static Mat2 invert(final Mat2 src, Mat2 dest) {
		/*
		 * inv(A) = 1/det(A) * adj(A);
		 */

		final float determinant = src.determinant();
		if (determinant != 0) {
			if (dest == null) dest = new Mat2();
			final float determinant_inv = 1f / determinant;
			final float t00 = src.m11 * determinant_inv;
			final float t01 = -src.m01 * determinant_inv;
			final float t11 = src.m00 * determinant_inv;
			final float t10 = -src.m10 * determinant_inv;

			dest.m00 = t00;
			dest.m01 = t01;
			dest.m10 = t10;
			dest.m11 = t11;
			return dest;
		} else return null;
	}

	/**
	 * Returns a string representation of this matrix
	 */
	public String toString() {
		final StringBuilder buf = new StringBuilder();
		buf.append(m00).append(' ').append(m10).append(' ').append('\n');
		buf.append(m01).append(' ').append(m11).append(' ').append('\n');
		return buf.toString();
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
	 * Negate this matrix and stash the result in another matrix.
	 *
	 * @param dest
	 *            The destination matrix, or null if a new matrix is to be
	 *            created
	 * @return the negated matrix
	 */
	public Mat2 negate(final Mat2 dest) {
		return negate(this, this);
	}

	/**
	 * Negate the source matrix and stash the result in the destination matrix.
	 *
	 * @param src
	 *            The source matrix to be negated
	 * @param dest
	 *            The destination matrix, or null if a new matrix is to be
	 *            created
	 * @return the negated matrix
	 */
	public static Mat2 negate(final Mat2 src, Mat2 dest) {
		if (dest == null) dest = new Mat2();

		dest.m00 = -src.m00;
		dest.m01 = -src.m01;
		dest.m10 = -src.m10;
		dest.m11 = -src.m11;

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
	 * Set the source matrix to be the identity matrix.
	 *
	 * @param src
	 *            The matrix to set to the identity.
	 * @return The source matrix
	 */
	public static Mat2 setIdentity(final Mat2 src) {
		src.m00 = 1.0f;
		src.m01 = 0.0f;
		src.m10 = 0.0f;
		src.m11 = 1.0f;
		return src;
	}

	/**
	 * Set this matrix to 0.
	 *
	 * @return this
	 */
	public Mat setZero() {
		return setZero(this);
	}

	public static Mat2 setZero(final Mat2 src) {
		src.m00 = 0.0f;
		src.m01 = 0.0f;
		src.m10 = 0.0f;
		src.m11 = 0.0f;
		return src;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.lwjgl.vector.Mat#determinant()
	 */
	public float determinant() {
		return m00 * m11 - m01 * m10;
	}

	public Mat2 clone() {

		return new Mat2(this);

	}

}
