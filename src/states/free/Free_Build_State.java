package states.free;

import node.StartNode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Program;

public class Free_Build_State implements GameState {

	private static final float MOVE_SPEED;
	
	private StartNode node;
	private boolean[] movingInDireciton;
	private float xOff;
	private float yOff;
	
	static {
		MOVE_SPEED = 0.1f;
	}
	
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		node = new StartNode(300, 300);
		movingInDireciton = new boolean[4];
		for (int i = 0; i < movingInDireciton.length; i++) {
			movingInDireciton[i] = false;
		}
		xOff = 0;
		yOff = 0;
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void leave(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.translate(xOff, yOff);
		node.drawNode(g);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (movingInDireciton[0]) {
			xOff -= MOVE_SPEED * delta;
		}
		if (movingInDireciton[1]) {
			yOff += MOVE_SPEED * delta;
		}
		if (movingInDireciton[2]) {
			xOff += MOVE_SPEED * delta;
		}
		if (movingInDireciton[3]) {
			yOff -= MOVE_SPEED * delta;
		}
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
	
	public void keyPressed(int key, char c) {
		switch (key) {
		case 1:
			quitProgram();
			break;
		case 32:
			movingInDireciton[0] = true;
			break;
		case 17:
			movingInDireciton[1] = true;
			break;
		case 30:
			movingInDireciton[2] = true;
			break;
		case 31:
			movingInDireciton[3] = true;
			break;
		}
	}

	public void keyReleased(int key, char c) {
		switch (key) {
		case 32:
			movingInDireciton[0] = false;
			break;
		case 17:
			movingInDireciton[1] = false;
			break;
		case 30:
			movingInDireciton[2] = false;
			break;
		case 31:
			movingInDireciton[3] = false;
			break;
		}
	}

	public void mousePressed(int button, int x, int y) {

	}

	public void mouseReleased(int button, int x, int y) {

	}

	public void mouseWheelMoved(int change) {
		
	}

	public void inputEnded() {

	}

	public void inputStarted() {

	}

	public void setInput(Input input) {

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

	/**
	 * @return the movingInDireciton
	 */
	public boolean[] getMovingInDireciton() {
		return movingInDireciton;
	}

	/**
	 * @param movingInDireciton the movingInDireciton to set
	 */
	public void setMovingInDireciton(boolean[] movingInDireciton) {
		this.movingInDireciton = movingInDireciton;
	}

	/**
	 * @return the node
	 */
	public StartNode getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(StartNode node) {
		this.node = node;
	}

}
