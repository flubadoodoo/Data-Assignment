package node;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public abstract class AbstractFlowableNode extends AbstractNode {

	private ArrayList<AbstractNode> flowNodes;
	private int flowCounter;

	public AbstractFlowableNode(float x, float y, ArrayList<AbstractNode> flowNodes) {
		this.flowNodes = flowNodes;
		flowCounter = 0;
	}

	/**
	 * @return the time
	 */
	public float getTime(AbstractNode node) {
		return calculateTimeForFlowNode(node);
	}

	private float calculateTimeForFlowNode(AbstractNode flowNode) {
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
		for (AbstractNode node : flowNodes) {
			sumOfFlows += node.getPathCount();
		}
		return sumOfFlows;
	}
	
	public void drawNodeLine(Graphics g, float xOff, float yOff) {
		for (AbstractNode node : flowNodes) {
			g.drawGradientLine(node.getxCenter() + xOff, node.getyCenter() + yOff, Color.red, getxCenter() + xOff, getyCenter() + yOff, Color.green);
		}
	}
	
	public void addFlowNode(AbstractNode node) {
		if (!searchFlowNodeHierarchyFor(node)) {
			flowNodes.add(node);
		}
	}

	public boolean searchFlowNodeHierarchyFor(AbstractNode node) {
		if (!searchImmediateFlowNodeHierarchyFor(node)) {
			for (AbstractNode checkingNode : flowNodes) {
				if (checkingNode instanceof AbstractFlowableNode)
					return ((AbstractFlowableNode) checkingNode).searchFlowNodeHierarchyFor(node);
				else if (checkingNode instanceof AbstractNode)
					return (node == checkingNode);
			}
		}
		return true;
	}
	
	public boolean searchImmediateFlowNodeHierarchyFor(AbstractNode node) {
		for (AbstractNode checkingNode : flowNodes)
			if (node == checkingNode)
				return true;
		return false;
	}

	/**
	 * @return the flowNodes
	 */
	public ArrayList<AbstractNode> getFlowNodes() {
		return flowNodes;
	}

	/**
	 * @param flowNodes
	 *            the flowNodes to set
	 */
	public void setFlowNodes(ArrayList<AbstractNode> flowNodes) {
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
