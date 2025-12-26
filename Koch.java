/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static double param = (Math.sqrt(3) / 6);

	public static void main(String[] args) {
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}

		// Find new midpoints
		double xMidpoint1 = x1 +(x2 - x1) / 3;
		double yMidpoint1 = y1 + (y2 - y1) / 3;
		double xMidpoint2 = x1 + 2*((x2 - x1) / 3);
		double yMidpoint2 = y1 + 2*((y2 - y1) / 3);

		// find new point
		double x3 = param*(y1 - y2) + 0.5*(x1+ x2);
		double y3 = param*(x2-x1) + 0.5*(y1+y2);

		// Continue the process
		curve(n-1, x1, y1, xMidpoint1, yMidpoint1);
		curve(n-1, xMidpoint1, yMidpoint1, x3, y3);
		curve(n-1, x3, y3, xMidpoint2, yMidpoint2);
		curve(n-1, xMidpoint2, yMidpoint2, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		StdDraw.setPenColor(StdDraw.BLACK);
		// Draws a Koch snowflake of depth n
		curve(n, 0.0, 0.0, 1.0, 0.0);
		
	}
}
