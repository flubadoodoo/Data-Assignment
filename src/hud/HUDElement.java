package hud;

import org.newdawn.slick.Graphics;

import node.AbstractNode;

public class HUDElement {
	
	private AbstractNode node;
	
	public HUDElement(AbstractNode node, float xCenter, float yCenter) {
		this.node = node;
		node.setxCenter(xCenter);
		node.setyCenter(yCenter);
	}
	
	public void drawElement(Graphics g) {
		node.drawNode(g);
	}

	/**
	 * @return the node
	 */
	public AbstractNode getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(AbstractNode node) {
		this.node = node;
	}

}
