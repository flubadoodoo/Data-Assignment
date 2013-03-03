package node;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public abstract class AbstractNode {
	
	private static float radius;
	private float xCenter, yCenter;
	private boolean selected;
	private boolean highlighted;
	private Shape nodeShape;
	
	static {
		radius = 10.0f;
	}
	
	public AbstractNode(float x, float y) {
		setNodeShape(new Circle(getxCenter(), getyCenter(), getRadius()));
		setxCenter(x);
		setyCenter(y);
		setSelected(false);
		setHighlighted(false);
	}
	
	abstract public void drawNode(Graphics g);
	
	public boolean contains(float x, float y, float xOff, float yOff) {
		return (x > this.xCenter + xOff && x < this.xCenter + xOff + AbstractNode.getRadius() * 2 && y > this.yCenter + yOff && y < this.yCenter + yOff + AbstractNode.getRadius() * 2);
	}

	/**
	 * @return the radius
	 */
	public static float getRadius() {
		return radius;
	}
	
	public int getPathCount() {
		return 1;
	}

	/**
	 * @param radius the radius to set
	 */
	public static void setRadius(float radius) {
		AbstractNode.radius = radius;
	}

	/**
	 * @return the xCenter
	 */
	public float getxCenter() {
		return xCenter;
	}

	/**
	 * @param xCenter the xCenter to set
	 */
	public void setxCenter(float xCenter) {
		this.xCenter = xCenter;
		getNodeShape().setCenterX(xCenter);
	}
	
	/**
	 * @return the yCenter
	 */
	public float getyCenter() {
		return yCenter;
	}

	/**
	 * @param yCenter the yCenter to set
	 */
	public void setyCenter(float yCenter) {
		this.yCenter = yCenter;
		getNodeShape().setCenterY(yCenter);
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the highlighted
	 */
	public boolean isHighlighted() {
		return highlighted;
	}

	/**
	 * @param highlighted the highlighted to set
	 */
	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	/**
	 * @return the nodeShape
	 */
	public Shape getNodeShape() {
		return nodeShape;
	}

	/**
	 * @param nodeShape the nodeShape to set
	 */
	public void setNodeShape(Shape nodeShape) {
		this.nodeShape = nodeShape;
	}

}
