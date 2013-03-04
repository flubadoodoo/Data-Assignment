package node;

public abstract class AbstractPlaceableNode extends AbstractNode {
	
	private boolean selected;
	private boolean highlighted;
	
	public AbstractPlaceableNode(float x, float y) {
		super();
		setxCenter(x);
		setyCenter(y);
		setSelected(false);
		setHighlighted(false);
	}
	
	public boolean contains(float x, float y, float xOff, float yOff) {
		return (x > getxCenter() - getRadius() + xOff && x < getxCenter() - getRadius() + xOff + AbstractPlaceableNode.getRadius() * 2 && y > getyCenter() - getRadius() + yOff && y < getyCenter() - getRadius() + yOff + AbstractPlaceableNode.getRadius() * 2);
	}

	public int getPathCount() {
		return 1;
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
