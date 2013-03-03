package states.free;

import hud.HUD;
import node.AbstractNode;
import node.StartNode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Program;

public class Free_Build_State implements GameState {

	private static final float CAMERA_ACCELERATION;
	private static final float CAMERA_SPEED_THRESHHOLD;
	private static final float CAMERA_DAMPING_FACTOR;

	private HUD hud;
	private StartNode node;
	private boolean[] movingInDireciton;
	private float[] cameraVelocity;
	private float xOff;
	private float yOff;

	static {
		CAMERA_ACCELERATION = 0.01f;
		CAMERA_SPEED_THRESHHOLD = CAMERA_ACCELERATION * 10.0f;
		CAMERA_DAMPING_FACTOR = 0.94f;
	}

	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		hud = new HUD(new AbstractNode[] { new StartNode(0, 0) });
		node = new StartNode(300, 300);
		movingInDireciton = new boolean[4];
		for (int i = 0; i < movingInDireciton.length; i++) {
			movingInDireciton[i] = false;
		}
		cameraVelocity = new float[] { 0.0f, 0.0f };
		xOff = 0;
		yOff = 0;
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void leave(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		hud.drawHUD(g);
		g.translate(xOff, yOff);
		node.drawNode(g);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (movingInDireciton[0]) {
			cameraVelocity[0] -= CAMERA_ACCELERATION * delta;
		} else if (movingInDireciton[2]) {
			cameraVelocity[0] += CAMERA_ACCELERATION * delta;
		} else {
			cameraVelocity[0] *= CAMERA_DAMPING_FACTOR;
		}
		if (movingInDireciton[1]) {
			cameraVelocity[1] += CAMERA_ACCELERATION * delta;
		} else if (movingInDireciton[3]) {
			cameraVelocity[1] -= CAMERA_ACCELERATION * delta;
		} else {
			cameraVelocity[1] *= CAMERA_DAMPING_FACTOR;
		}
		if (Math.abs(cameraVelocity[0]) < CAMERA_SPEED_THRESHHOLD) {
			cameraVelocity[0] = 0.0f;
		}
		if (Math.abs(cameraVelocity[1]) < CAMERA_SPEED_THRESHHOLD) {
			cameraVelocity[1] = 0.0f;
		}
		xOff += cameraVelocity[0];
		yOff += cameraVelocity[1];
	}

	public int getID() {
		return Program.getStateID(this);
	}

	/* ********** Input ********* */

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
		hud.mouseWheelMoved(change);
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
	 * @param movingInDireciton
	 *            the movingInDireciton to set
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
	 * @param node
	 *            the node to set
	 */
	public void setNode(StartNode node) {
		this.node = node;
	}

	/**
	 * @return the cameraVelocity
	 */
	public float[] getCameraVelocity() {
		return cameraVelocity;
	}

	/**
	 * @param cameraVelocity
	 *            the cameraVelocity to set
	 */
	public void setCameraVelocity(float[] cameraVelocity) {
		this.cameraVelocity = cameraVelocity;
	}

	/**
	 * @return the hud
	 */
	public HUD getHud() {
		return hud;
	}

	/**
	 * @param hud
	 *            the hud to set
	 */
	public void setHud(HUD hud) {
		this.hud = hud;
	}

	/**
	 * @return the xOff
	 */
	public float getxOff() {
		return xOff;
	}

	/**
	 * @param xOff
	 *            the xOff to set
	 */
	public void setxOff(float xOff) {
		this.xOff = xOff;
	}

	/**
	 * @return the yOff
	 */
	public float getyOff() {
		return yOff;
	}

	/**
	 * @param yOff
	 *            the yOff to set
	 */
	public void setyOff(float yOff) {
		this.yOff = yOff;
	}

}
