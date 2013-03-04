package hud;

import org.newdawn.slick.Graphics;

import node.AbstractNonPlaceableNode;

public class HUDElement {
	
	private AbstractNonPlaceableNode node;
	
	public HUDElement(AbstractNonPlaceableNode elements, float xCenter, float yCenter) {
		this.node = elements;
		elements.setxCenter(xCenter);
		elements.setyCenter(yCenter);
	}
	
	public void drawElement(Graphics g) {
		node.drawNode(g);
	}

	/**
	 * @return the node
	 */
	public AbstractNonPlaceableNode getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(AbstractNonPlaceableNode node) {
		this.node = node;
	}

}
