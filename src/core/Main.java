package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

public class Main {
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer program = new AppGameContainer(new Program("Data Assignment"));
		program.setDisplayMode(1280, 720, false);
		program.setTargetFrameRate(60);
		program.setVSync(true);
		program.setVerbose(false);
		Log.setVerbose(false);
		program.start();
	}

}
