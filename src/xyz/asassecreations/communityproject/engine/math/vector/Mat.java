package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

public abstract class Mat {

	/**
	 * Constructor for Mat.
	 */
	protected Mat() {
		super();
	}

	/**
	 * Set this matrix to be the identity matrix.
	 *
	 * @return this
	 */
	public abstract Mat setIdentity();

	/**
	 * Invert this matrix
	 *
	 * @return this
	 */
	public abstract Mat invert();

	/**
	 * Load from a float buffer. The buffer stores the matrix in column major
	 * (OpenGL) order.
	 *
	 * @param buf
	 *            A float buffer to read from
	 * @return this
	 */
	public abstract Mat load(FloatBuffer buf);

	/**
	 * Load from a float buffer. The buffer stores the matrix in row major
	 * (mathematical) order.
	 *
	 * @param buf
	 *            A float buffer to read from
	 * @return this
	 */
	public abstract Mat loadTranspose(FloatBuffer buf);

	/**
	 * Negate this matrix
	 *
	 * @return this
	 */
	public abstract Mat negate();

	/**
	 * Store this matrix in a float buffer. The matrix is stored in column major
	 * (openGL) order.
	 *
	 * @param buf
	 *            The buffer to store this matrix in
	 * @return this
	 */
	public abstract Mat store(FloatBuffer buf);

	/**
	 * Store this matrix in a float buffer. The matrix is stored in row major
	 * (maths) order.
	 *
	 * @param buf
	 *            The buffer to store this matrix in
	 * @return this
	 */
	public abstract Mat storeTranspose(FloatBuffer buf);

	/**
	 * Transpose this matrix
	 *
	 * @return this
	 */
	public abstract Mat transpose();

	/**
	 * Set this matrix to 0.
	 *
	 * @return this
	 */
	public abstract Mat setZero();

	/**
	 * @return the determinant of the matrix
	 */
	public abstract float determinant();

	public abstract Mat clone();

}
