package states.free;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Program;

public class Free_Build_State implements GameState {

	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void leave(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	}
	
	public int getID() {
		return Program.getStateID(this);
	}

	/* ********** Input ********* */

	public void mouseClicked(int button, int x, int y, int clickCount) {

	}

	public void mouseDragged(int oldx, int oldy, int newx, int newy) {

	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy) {

	}

	public void mousePressed(int button, int x, int y) {

	}

	public void mouseReleased(int button, int x, int y) {

	}

	public void mouseWheelMoved(int change) {
		System.out.println(change);
	}

	public void inputEnded() {

	}

	public void inputStarted() {

	}

	public void setInput(Input input) {

	}

	public void keyPressed(int key, char c) {
		switch (key) {
		case 1:
			quitProgram();
			break;
		}
	}

	public void keyReleased(int key, char c) {

	}

	/* ********** ^ Input ^ ********* */

	private void quitProgram() {
		System.exit(0);
	}

	/* ********** Unused ********** */

	public boolean isRenderPaused() {

		return false;
	}

	public boolean isUpdatePaused() {

		return false;
	}

	public void pauseRender() {

	}

	public void pauseUpdate() {

	}

	public void setRenderPaused(boolean arg0) {

	}

	public void setUpdatePaused(boolean arg0) {

	}

	public void unpauseRender() {

	}

	public void unpauseUpdate() {

	}

	public boolean isAcceptingInput() {
		return true;
	}

	public void controllerButtonPressed(int controller, int button) {

	}

	public void controllerButtonReleased(int controller, int button) {

	}

	public void controllerDownPressed(int controller) {

	}

	public void controllerDownReleased(int controller) {

	}

	public void controllerLeftPressed(int controller) {

	}

	public void controllerLeftReleased(int controller) {

	}

	public void controllerRightPressed(int controller) {

	}

	public void controllerRightReleased(int controller) {

	}

	public void controllerUpPressed(int controller) {

	}

	public void controllerUpReleased(int controller) {

	}

}
