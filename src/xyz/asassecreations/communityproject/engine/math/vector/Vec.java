package xyz.asassecreations.communityproject.engine.math.vector;

import java.nio.FloatBuffer;

import xyz.asassecreations.communityproject.engine.math.Mathf;

public abstract class Vec {

	protected Vec() {

	}

	public abstract float magnitudeSquared();

	public abstract Vec load(FloatBuffer buf);

	public abstract Vec store(FloatBuffer buf);

	public abstract Vec negate();

	public abstract Vec add(float sca);

	public abstract Vec sub(float sca);

	public abstract Vec mul(float sca);

	public abstract Vec div(float sca);

	public abstract Vec add(Vec vec);

	public abstract Vec sub(Vec vec);

	public abstract Vec mul(Vec vec);

	public abstract Vec div(Vec vec);

	public abstract Vec clone();

	public final float magnitude() {

		return Mathf.sqrt(magnitudeSquared());

	}

	public final Vec normalise() {

		final float len = magnitude();

		if (len != 0f) return mul(1f / len);

		else throw new IllegalStateException("Zero length vector");

	}

	public final Vec setMagnitude(final float mag) {

		return normalise().mul(mag);

	}

}
