package hud;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import node.AbstractNonPlaceableNode;

public class HUD {
	
	private static final float TOP_MARGIN;
	private static final float LEFT_SIDE_MARGIN;
	private static final float HUD_ELEMENT_BLOCK_DIMENSION;
	
	private HUDElement[] elements;
	private int selection;
	
	static {
		TOP_MARGIN = 35.0f;
		LEFT_SIDE_MARGIN = 10.0f;
		HUD_ELEMENT_BLOCK_DIMENSION = 50.0f;
	}
	
	public HUD(AbstractNonPlaceableNode[] elements) {
		this.elements = new HUDElement[elements.length];
		for (int i = 0; i < elements.length; i++) {
			this.elements[i] = new HUDElement(elements[i], LEFT_SIDE_MARGIN + HUD_ELEMENT_BLOCK_DIMENSION / 2.0f + (i * HUD_ELEMENT_BLOCK_DIMENSION), TOP_MARGIN + HUD_ELEMENT_BLOCK_DIMENSION / 2.0f);
		}
	}
	
	public void drawHUD(Graphics g) {
		g.setLineWidth(1);
		for (int i = 0; i < elements.length; i++) {
			g.setColor(new Color(1f, 1f, 1f, 0.3f));
			g.drawRect(10 + i * HUD_ELEMENT_BLOCK_DIMENSION, 35, HUD_ELEMENT_BLOCK_DIMENSION, HUD_ELEMENT_BLOCK_DIMENSION);
			if (getSelection() == i) {
				g.fillRect(10 + i * HUD_ELEMENT_BLOCK_DIMENSION, 35, HUD_ELEMENT_BLOCK_DIMENSION, HUD_ELEMENT_BLOCK_DIMENSION);
			}
			for (HUDElement element : elements) {
				element.drawElement(g);
			}
		}
	}
	
	public void mouseWheelMoved(int amount) {
		if (amount < 0) {
			setSelection(getSelection() + 1);
		} else {
			setSelection(getSelection() - 1);
		}
	}

	/**
	 * @return the elements
	 */
	public HUDElement[] getElements() {
		return elements;
	}

	/**
	 * @param elements the elements to set
	 */
	public void setElements(HUDElement[] elements) {
		this.elements = elements;
	}

	/**
	 * @return the selection
	 */
	public int getSelection() {
		return selection;
	}

	/**
	 * @param selection the selection to set
	 */
	public void setSelection(int selection) {
		if (selection < 0) {
			this.selection = 0;
		} else if (selection >= this.elements.length) {
			this.selection = this.elements.length - 1;
		} else {
			this.selection = selection;
		}
	}

}
