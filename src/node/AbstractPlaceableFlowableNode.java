package node;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class AbstractPlaceableFlowableNode extends AbstractPlaceableNode {

	private ArrayList<AbstractPlaceableNode> flowNodes;
	private int flowCounter;

	public AbstractPlaceableFlowableNode(float x, float y) {
		super(x, y);
		flowNodes = new ArrayList<AbstractPlaceableNode>();
		flowCounter = 0;
	}

	/**
	 * @return the time
	 */
	public float getTime(AbstractPlaceableNode node) {
		return calculateTimeForFlowNode(node);
	}

	private float calculateTimeForFlowNode(AbstractPlaceableNode flowNode) {
		if (flowNodes.contains(flowNode)) {
			return (float) Math.hypot(this.getxCenter() - flowNode.getxCenter(), this.getyCenter() - flowNode.getyCenter());
		} else {
			return 0.0f;
		}
	}
	
	public void update() {
		setFlowCounter(calculatePathCount());
	}
	
	public int getPathCount() {
		return getFlowCounter();
	}

	private int calculatePathCount() {
		int sumOfFlows = 0;
		for (AbstractPlaceableNode node : flowNodes) {
			sumOfFlows += node.getPathCount();
		}
		return sumOfFlows;
	}
	
	public void drawNode(Graphics g) {
		super.drawNode(g);
		drawNodeFlowCounter(g);
		drawNodeLine(g);
	}
	
	public void drawNodeLine(Graphics g) {
		for (AbstractPlaceableNode node : flowNodes) {
			g.drawGradientLine(node.getxCenter(), node.getyCenter(), Color.red, getxCenter(), getyCenter(), Color.green);
		}
	}
	
	public void drawNodeFlowCounter(Graphics g) {
		g.setColor(Color.yellow);
		g.drawString(String.valueOf(flowCounter), getxCenter() + getRadius(), getyCenter() + getRadius());
	}
	
	public void addFlowNode(AbstractPlaceableNode node) {
		flowNodes.add(node);
	}
	
	public void addFlowNode(AbstractPlaceableFlowableNode node) {
		if (!searchFlowNodeHierarchyFor(node) || node instanceof EndNode) {
			flowNodes.add(node);
		} else {
			node.setSelected(false);
		}
	}

	public boolean searchFlowNodeHierarchyFor(AbstractPlaceableFlowableNode node) {
		if (!node.searchImmediateFlowNodeHierarchyFor(this)) {
			boolean found = false;
			for (AbstractPlaceableNode checkingNode : node.getFlowNodes()) {
				if (checkingNode instanceof AbstractPlaceableFlowableNode)
					found = (found || ((AbstractPlaceableFlowableNode) checkingNode).searchFlowNodeHierarchyFor(this));
				else
					return (checkingNode == this);
			}
			return found;
		} else {
			return true;
		}
	}
	
	public boolean searchImmediateFlowNodeHierarchyFor(AbstractPlaceableFlowableNode node) {
		for (AbstractPlaceableNode checkingNode : node.getFlowNodes())
			if (this == checkingNode)
				return true;
		return false;
	}

	/**
	 * @return the flowNodes
	 */
	public ArrayList<AbstractPlaceableNode> getFlowNodes() {
		return flowNodes;
	}

	/**
	 * @param flowNodes
	 *            the flowNodes to set
	 */
	public void setFlowNodes(ArrayList<AbstractPlaceableNode> flowNodes) {
		this.flowNodes = flowNodes;
	}

	/**
	 * @return the flowCounter
	 */
	private int getFlowCounter() {
		return flowCounter;
	}

	/**
	 * @param flowCounter
	 *            the flowCounter to set
	 */
	public void setFlowCounter(int flowCounter) {
		this.flowCounter = flowCounter;
	}

}
