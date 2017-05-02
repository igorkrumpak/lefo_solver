package si.iitech.lefo.solver;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.axet.lookup.OCR;

import si.iitech.lefo.Main;

public class Reader {
	
	private static final String FONT = "font_lefo";
	private static final int PROBLEM_X = 128;
	private static final int PROBLEM_Y = 314;

	private static final int PROBLEM_WIDTH = 500;
	private static final int PROBLEM_HEIGHT = 70;
	
	private final Rectangle PROBLEM_RECTANGLE = new Rectangle(PROBLEM_X, PROBLEM_Y, PROBLEM_WIDTH, PROBLEM_HEIGHT); 
	
	private boolean printPictures = true;
	private Robot robot;
	private long counter;
	
	public Reader() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public String readProblem() {
		OCR api = getApi();
		return readValueFromLocationOnScreen(api);
	}

	
	private OCR getApi() {
		OCR api = new OCR(0.70f);
		api.loadFontsDirectory(Main.class, new File("fonts"));
		return api;
	}
	
	private String readValueFromLocationOnScreen(OCR api)  {
		BufferedImage bufferedImage = robot.createScreenCapture(PROBLEM_RECTANGLE);
		String finalText = "";
		try {
			finalText = api.recognize(bufferedImage, FONT);
		} catch(Exception e) {
		}
		if(printPictures) {
			 File outputfile = new File(counter++ + "image.jpg");
			 try {
				ImageIO.write(bufferedImage, "jpg", outputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return finalText;
	}
}
