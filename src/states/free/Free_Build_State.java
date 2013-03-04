package states.free;

import java.util.ArrayList;

import hud.HUD;
import node.AbstractNonPlaceableNode;
import node.AbstractPlaceableFlowableNode;
import node.AbstractPlaceableNode;
import node.ConnectorNode;
import node.EndNode;
import node.HUDConnectorNode;
import node.HUDEndNode;
import node.HUDRecieverWormholeNode;
import node.HUDStartNode;
import node.HUDTransmitterWormholeNode;
import node.RecieverWormholeNode;
import node.StartNode;
import node.TransmitterWormholeNode;

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
	private boolean[] movingInDireciton;
	private float[] cameraVelocity;
	private float xOff;
	private float yOff;
	private ArrayList<AbstractPlaceableNode> nodes;

	static {
		CAMERA_ACCELERATION = 0.01f;
		CAMERA_SPEED_THRESHHOLD = CAMERA_ACCELERATION * 10.0f;
		CAMERA_DAMPING_FACTOR = 0.94f;
	}

	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		hud = new HUD(new AbstractNonPlaceableNode[] { new HUDStartNode(), new HUDConnectorNode(), new HUDEndNode(), new HUDTransmitterWormholeNode(), new HUDRecieverWormholeNode() });
		movingInDireciton = new boolean[4];
		for (int i = 0; i < movingInDireciton.length; i++) {
			movingInDireciton[i] = false;
		}
		cameraVelocity = new float[] { 0.0f, 0.0f };
		xOff = 0;
		yOff = 0;
		nodes = new ArrayList<AbstractPlaceableNode>();
		nodes.add(new StartNode(0, 0));
		nodes.add(new ConnectorNode(-50, 50));
		nodes.add(new ConnectorNode(50, 50));
		
		nodes.add(new ConnectorNode(-100, 100));
		nodes.add(new ConnectorNode(0, 100));
		nodes.add(new ConnectorNode(100, 100));
		
		nodes.add(new ConnectorNode(-150, 150));
		nodes.add(new ConnectorNode(-50, 150));
		nodes.add(new ConnectorNode(50, 150));
		nodes.add(new ConnectorNode(150, 150));
		
		nodes.add(new ConnectorNode(-200, 200));
		nodes.add(new ConnectorNode(-100, 200));
		nodes.add(new ConnectorNode(0, 200));
		nodes.add(new ConnectorNode(100, 200));
		nodes.add(new ConnectorNode(200, 200));
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void leave(GameContainer container, StateBasedGame game) throws SlickException {

	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		hud.drawHUD(g);
		g.translate(xOff, yOff);
		drawNodes(g);
	}

	private void drawNodes(Graphics g) {
		for (AbstractPlaceableNode node : nodes) {
			node.drawNode(g);
		}
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		updateCamera(delta);
		updateFlowableNodes();
	}

	private void updateFlowableNodes() {
		ArrayList<AbstractPlaceableNode> transmitters = new ArrayList<AbstractPlaceableNode>();
		for (AbstractPlaceableNode node : nodes) {
			if (node instanceof AbstractPlaceableFlowableNode) {
				((AbstractPlaceableFlowableNode) node).update();
				if (node instanceof TransmitterWormholeNode) {
					transmitters.add((TransmitterWormholeNode) node);
				}
			}
		}
		for (AbstractPlaceableNode node : nodes) {
			if (node instanceof RecieverWormholeNode) {
				((RecieverWormholeNode) node).setFlowNodes(transmitters);
			}
		}
	}

	private void updateCamera(int delta) {
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
		switch (hud.getSelection()) {
		case 0:
			boolean startNodeAlreadyExists = false;
			for (AbstractPlaceableNode possibleStartNode : nodes) {
				if (possibleStartNode instanceof StartNode) {
					startNodeAlreadyExists = true;
					break;
				}
			}
			if (!startNodeAlreadyExists) {
				nodes.add(new StartNode(x - xOff, y - yOff));
			}
			break;
		case 1:
			AbstractPlaceableNode node = getSelectedNode();
			if (node == null) {
				// trying to select node
				selectNode(x, y);
			} else {
				selectNode(x, y);
				AbstractPlaceableFlowableNode connectedNode = getSelectedNodeButIgnore(node);
				if (connectedNode == null) {
					// create new node
					ConnectorNode newConnectorNode = new ConnectorNode(x - xOff, y - yOff);
					if (node instanceof AbstractPlaceableFlowableNode) {
						newConnectorNode.addFlowNode((AbstractPlaceableFlowableNode) node);
					} else {
						newConnectorNode.addFlowNode(node);
					}
					nodes.add(newConnectorNode);
					newConnectorNode.update();
					node.setSelected(false);
					newConnectorNode.setSelected(false);
				} else {
					// connect node if possible
					if (node instanceof StartNode) {
						connectedNode.addFlowNode(node);
						node.setSelected(false);
						getSelectedNode().setSelected(false);
					} else {
						if (connectedNode instanceof AbstractPlaceableFlowableNode) {
							((AbstractPlaceableFlowableNode) connectedNode).addFlowNode((AbstractPlaceableFlowableNode) node);
							connectedNode.setSelected(false);
							node.setSelected(false);
							((AbstractPlaceableFlowableNode) connectedNode).update();
						}
					}
				}
			}
			break;
		case 2:
			boolean endNodeAlreadyExists = false;
			for (AbstractPlaceableNode possibleEndNode : nodes) {
				if (possibleEndNode instanceof EndNode) {
					endNodeAlreadyExists = true;
					break;
				}
			}
			if (!endNodeAlreadyExists) {
				nodes.add(new EndNode(x - xOff, y - yOff));
			}
			break;
		case 3:
			AbstractPlaceableNode node2 = getSelectedNode();
			if (node2 == null) {
				// trying to select node
				selectNode(x, y);
			} else {
				selectNode(x, y);
				AbstractPlaceableFlowableNode connectedNode = getSelectedNodeButIgnore(node2);
				if (connectedNode == null) {
					// create new node
					TransmitterWormholeNode newTransmitter = new TransmitterWormholeNode(x - xOff, y - yOff);
					if (node2 instanceof AbstractPlaceableFlowableNode) {
						newTransmitter.addFlowNode((AbstractPlaceableFlowableNode) node2);
					} else {
						newTransmitter.addFlowNode(node2);
					}
					nodes.add(newTransmitter);
					newTransmitter.update();
					node2.setSelected(false);
					newTransmitter.setSelected(false);
				} else {
					// connect node if possible
					if (node2 instanceof StartNode) {
						connectedNode.addFlowNode(node2);
						node2.setSelected(false);
						getSelectedNode().setSelected(false);
					} else {
						if (connectedNode instanceof AbstractPlaceableFlowableNode) {
							((AbstractPlaceableFlowableNode) connectedNode).addFlowNode((AbstractPlaceableFlowableNode) node2);
							connectedNode.setSelected(false);
							node2.setSelected(false);
							((AbstractPlaceableFlowableNode) connectedNode).update();
						}
					}
				}
			}
			break;
		case 4:
			AbstractPlaceableNode node3 = getSelectedNode();
			if (node3 == null) {
				// trying to select node
				selectNode(x, y);
			} else {
				// create new node
				RecieverWormholeNode newTransmitter = new RecieverWormholeNode(x - xOff, y - yOff);
				if (node3 instanceof AbstractPlaceableFlowableNode) {
					newTransmitter.addFlowNode((AbstractPlaceableFlowableNode) node3);
					((AbstractPlaceableFlowableNode) node3).addFlowNode(newTransmitter);
				} else {
					newTransmitter.addFlowNode(node3);
				}
				nodes.add(newTransmitter);
				newTransmitter.update();
				node3.setSelected(false);
				newTransmitter.setSelected(false);
			}
			break;
		}
	}

	private AbstractPlaceableFlowableNode getSelectedNodeButIgnore(AbstractPlaceableNode ignoreNode) {
		for (AbstractPlaceableNode node : nodes) {
			if (node.isSelected() && node != ignoreNode) {
				return (AbstractPlaceableFlowableNode) node;
			}
		}
		return null;
	}

	private void selectNode(int x, int y) {
		System.out.println("(" + x + ", " + y + ")");
		for (AbstractPlaceableNode node : nodes) {
			//node.setSelected(false);
			if (node.contains(x, y, xOff, yOff)) {
				node.setSelected(true);
				break;
			}
		}
	}

	private AbstractPlaceableNode getSelectedNode() {
		for (AbstractPlaceableNode node : nodes) {
			if (node.isSelected()) {
				return node;
			}
		}
		return null;
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
