package node;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

public abstract class AbstractNode {
	
	private static float radius;
	private float xCenter, yCenter;
	private Shape nodeShape;
	
	static {
		radius = 10.0f;
	}
	
	public AbstractNode() {
		setNodeShape(new Circle(getxCenter(), getyCenter(), getRadius()));
	}
	
	public void drawNode(Graphics g) {
		g.fill(getNodeShape());
	}

	/**
	 * @return the radius
	 */
	public static float getRadius() {
		return radius;
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
