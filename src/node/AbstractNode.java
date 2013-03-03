package node;

public abstract class AbstractNode {
	
	private static float radius;
	private float xCenter, yCenter;
	private boolean selected;
	private boolean highlighted;
	
	static {
		radius = 5.0f;
	}

	/**
	 * @return the radius
	 */
	public static float getRadius() {
		return radius;
	}
	
	public int getFlowCount() {
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

}
