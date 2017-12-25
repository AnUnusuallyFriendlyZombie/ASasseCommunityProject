package xyz.asassecreations.communityproject.engine.math;

import java.util.Random;
import java.util.Stack;

public final class RNG {

	private static final Stack<Random> stack = new Stack<>();

	static {

		push(null);

	}

	public static final void push(final Random random) {

		stack.push(random == null ? new Random() : random);

	}

	public static final Random pop() {

		if (stack.isEmpty()) return null;
		return stack.pop();

	}

	public static final Random peek() {

		if (stack.isEmpty()) return null;
		return stack.peek();

	}

	public static final long nextLong() {

		return peek().nextLong();

	}

	public static final float random(final float min, final float max) {

		return rawRandom(Mathf.min(min, max), Mathf.max(min, max));

	}

	private static final float rawRandom(final float min, final float max) {

		return Mathf.map(peek().nextFloat(), 0f, 1f, min, max);

	}

	public static final boolean chance(final float percent) {

		return random(0f, 1f) <= percent;

	}

}
