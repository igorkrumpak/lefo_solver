package si.iitech.lefo.solver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Typer {

	private Robot robot;
	
	private static final int ZERO_X = 200;
	private static final int ZERO_Y = 731;
	
	private static final int ONE_X = 190;
	private static final int ONE_Y = 618;
	
	private static final int TWO_X = 334;
	private static final int TWO_Y = 618;
	
	private static final int THREE_X = 469;
	private static final int THREE_Y = 618;
	
	private static final int FOUR_X = 190;
	private static final int FOUR_Y = 526;
	
	private static final int FIVE_X = 334;
	private static final int FIVE_Y = 526;
	
	private static final int SIX_X = 469;
	private static final int SIX_Y = 526;
	
	private static final int SEVEN_X = 190;
	private static final int SEVEN_Y = 440;
	
	private static final int EIGHT_X = 334;
	private static final int EIGHT_Y = 440;
	
	private static final int NINE_X = 469;
	private static final int NINE_Y = 440;
	
	private static final int OK_X = 404;
	private static final int OK_Y = 736;
	
	public Typer() {
		try {
			robot = new Robot();
		} catch (final AWTException e) {}
	}
	
	public void typeSolutionAndPressOK(int number) {
		char[] numbers = String.valueOf(number).toCharArray();
		for(char sign : numbers) {
			switch (sign) {
			case '0':
				robot.mouseMove(ZERO_X, ZERO_Y);
				break;
			case '1':
				robot.mouseMove(ONE_X, ONE_Y);
				break;
			case '2':
				robot.mouseMove(TWO_X, TWO_Y);
				break;
			case '3':
				robot.mouseMove(THREE_X, THREE_Y);
				break;
			case '4':
				robot.mouseMove(FOUR_X, FOUR_Y);
				break;
			case '5':
				robot.mouseMove(FIVE_X, FIVE_Y);
				break;
			case '6':
				robot.mouseMove(SIX_X, SIX_Y);
				break;
			case '7':
				robot.mouseMove(SEVEN_X, SEVEN_Y);
				break;
			case '8':
				robot.mouseMove(EIGHT_X, EIGHT_Y);
				break;
			case '9':
				robot.mouseMove(NINE_X, NINE_Y);
				break;
			}
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {e.printStackTrace();
			}
		}
		robot.mouseMove(OK_X, OK_Y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
