package xyz.asassecreations.communityproject.engine;

public final class Timings {

	private Timings() {

	}

	public static long frames = 0;

	public static long fps = 0;

	public static double delta = 1f;
	public static float delta_f = 1f;

	public static double globalTime = 0f;
	public static float globalTime_f = 0f;

	public static long sleep = 0;

	public static final void setGlobalTime(final double globalTime) {

		Timings.globalTime = globalTime;
		globalTime_f = (float) globalTime;

	}

	public static final void setDelta(final double delta) {

		Timings.delta = delta;
		delta_f = (float) delta;

	}

}
