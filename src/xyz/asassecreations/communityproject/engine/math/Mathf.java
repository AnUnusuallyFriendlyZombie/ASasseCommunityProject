package xyz.asassecreations.communityproject.engine.math;

import xyz.asassecreations.communityproject.engine.color.Color;
import xyz.asassecreations.communityproject.engine.math.vector.Vec;
import xyz.asassecreations.communityproject.engine.math.vector.Vec2;
import xyz.asassecreations.communityproject.engine.math.vector.Vec3;
import xyz.asassecreations.communityproject.engine.math.vector.Vec4;

public final class Mathf {

	public static final float E = 2.71828182f;
	public static final float PI = 3.14159265f;
	public static final float TAU = 2f * PI;

	private Mathf() {

	}

	public static final float fract(final float value) {

		return value - floor(value);

	}

	// CLAMP FUNCTIONS

	public static final float constrainMin(final float value, final float min) {

		if (value <= min) return min;
		return value;

	}

	public static final float constrainMax(final float value, final float max) {

		if (value >= max) return max;
		return value;

	}

	public static final float constrain(final float value, final float min, final float max) {

		return constrainMin(constrainMax(value, max), min);

	}

	// DISTANCE FUNCTIONS

	public static final float distance(final Vec2 a, final Vec2 b) {

		return a.clone().sub(b).magnitude();

	}

	public static final float distance(final Vec3 a, final Vec3 b) {

		return a.clone().sub(b).magnitude();

	}

	public static final float distance(final Vec4 a, final Vec4 b) {

		return a.clone().sub(b).magnitude();

	}

	@SafeVarargs
	public static final <T extends Vec> T closest(final T base, final T... comparing) {

		if (comparing.length == 0) return base;
		if (comparing.length == 1) return comparing[0];

		float closestDistanceSq = comparing[0].magnitudeSquared();
		T closest = comparing[0];

		for (int i = 1; i < comparing.length; i++) {

			final float thisDistanceSq = comparing[i].magnitudeSquared();

			if (thisDistanceSq > closestDistanceSq) continue;

			closestDistanceSq = thisDistanceSq;
			closest = comparing[i];

		}

		return closest;

	}

	// MIX FUNCTIONS

	public static final float mix(final float a, final float b, final float percent) {

		return a * (1f - percent) + b * percent;

	}

	public static final Vec2 mix(final Vec2 a, final Vec2 b, final float percent) {

		return new Vec2(mix(a.x, b.x, percent), mix(a.y, b.y, percent));

	}

	public static final Vec3 mix(final Vec3 a, final Vec3 b, final float percent) {

		return new Vec3(mix(a.x, b.x, percent), mix(a.y, b.y, percent), mix(a.z, b.z, percent));

	}

	public static final Vec4 mix(final Vec4 a, final Vec4 b, final float percent) {

		return new Vec4(mix(a.x, b.x, percent), mix(a.y, b.y, percent), mix(a.z, b.z, percent), mix(a.w, b.w, percent));

	}

	public static final Color mix(final Color a, final Color b, final float percent) {

		return new Color(mix(a.asVec4(), b.asVec4(), percent));

	}

	// COMMON MATH FUNCTIONS

	public static final float ceil(final float a) {

		return (float) Math.ceil(a);

	}

	public static final float floor(final float a) {

		return (float) Math.floor(a);

	}

	public static final float round(final float a) {

		return Math.round(a);

	}

	public static final float abs(final float value) {

		return value < 0 ? -value : value;

	}

	public static final float min(final float a, final float b) {

		return a < b ? a : b;

	}

	public static final float max(final float a, final float b) {

		return a > b ? a : b;

	}

	// TRIG FUNCTIONS

	public static final float sin(final float a) {

		return (float) Math.sin(a);

	}

	public static final float cos(final float a) {

		return (float) Math.cos(a);

	}

	public static final float tan(final float a) {

		return (float) Math.tan(a);

	}

	public static final float sinNormalized(final float a) {

		return sin(TAU * a);

	}

	public static final float cosNormalized(final float a) {

		return cos(TAU * a);

	}

	public static final float tanNormalized(final float a) {

		return tan(TAU * a);

	}

	// ANGLE FUNCTIONS

	public static final float toRadians(final float a) {

		return a / 180f * PI;

	}

	public static final float toDegrees(final float a) {

		return a * 180f / PI;

	}

	// SQRT FUNCTIONS

	public static float sqrt(final float a) {

		return (float) Math.sqrt(a);

	}

	public static float cbrt(final float a) {

		return (float) Math.cbrt(a);

	}

	public static float pow(final float a, final float b) {

		return (float) Math.pow(a, b);

	}

	// OTHER FUNCTIONS

	public static final float smoothstep(final float edge0, final float edge1, final float x) {

		final float value = constrain((x - edge0) / (edge1 - edge0), 0f, 1f);

		return value * value * (3f - 2f * value);

	}

	public static final float approach(final float current, final float goal, final float delta) {

		final float difference = goal - current;

		if (difference > delta) return current + delta;
		if (difference < -delta) return current - delta;

		return goal;

	}

	public static final float approachSmooth(final float current, final float goal, final float delta) {

		return approach(current, goal, abs(current - goal) * delta);

	}

	public static final float map(final float value, final float start1, final float end1, final float start2, final float end2) {

		return (value - start1) / (end1 - start1) * (end2 - start2) + start2;

	}

	public static final float barryCentric(final Vec3 p1, final Vec3 p2, final Vec3 p3, final Vec2 pos) {
		final float det = (p2.z - p3.z) * (p1.x - p3.x) + (p3.x - p2.x) * (p1.z - p3.z);
		final float l1 = ((p2.z - p3.z) * (pos.x - p3.x) + (p3.x - p2.x) * (pos.y - p3.z)) / det;
		final float l2 = ((p3.z - p1.z) * (pos.x - p3.x) + (p1.x - p3.x) * (pos.y - p3.z)) / det;
		final float l3 = 1.0f - l1 - l2;
		return l1 * p1.y + l2 * p2.y + l3 * p3.y;
	}

	public static float mapConstrained(final float value, final float start1, final float end1, final float start2, final float end2) {

		return constrain(map(value, start1, end1, start2, end2), start2, end2);

	}

	public static final float log(final float a, final int base) {

		return (float) (Math.log(a) / Math.log(base));

	}

	public static final float pow(final float base, final int power) {

		float total = base;

		for (int i = 1; i < power; i++)
			total *= base;

		return total;

	}

	// Smoothstep
	private static final float t(final float x, final float edge0, final float edge1) {

		return (x - edge0) / (edge1 - edge0);

	}

	public static final float smoothStep(final float x, final float edge0, final float edge1) {

		final float t = t(x, edge0, edge1);

		return 2f * pow(t, 2) * (-t + 1.5f);

	}

	public static final float smootherStep(final float x, final float edge0, final float edge1) {

		final float t = t(x, edge0, edge1);

		return 6f * pow(t, 3) * (pow(t, 2) - 2.5f * t + 5f / 3f);

	}

	public static final float smoothestStep(final float x, final float edge0, final float edge1) {

		final float t = t(x, edge0, edge1);

		return 20f * pow(t, 4) * (-pow(t, 3) + 3.5f * pow(t, 2) - 4.2f * t + 1.75f);

	}

}
