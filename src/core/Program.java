package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import states.free.Free_Build_State;

public class Program extends StateBasedGame {
	
	private static final int FREE_BUILD_STATE_ID;
	
	static {
		FREE_BUILD_STATE_ID = 0;
	}

	public Program(String name) {
		super(name);
	}

	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Free_Build_State());
	}

	/**
	 * @return the stateID
	 */
	public static int getStateID(GameState state) {
		if (state instanceof Free_Build_State) {
			return FREE_BUILD_STATE_ID;
		} else {
			return -1;
		}
	}

}
