package node;

import java.util.ArrayList;

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
		setFlowCounter(calculateFlowCount());
	}
	
	public int getFlowCount() {
		return getFlowCounter();
	}

	private int calculateFlowCount() {
		int sumOfFlows = 0;
		for (AbstractNode node : flowNodes) {
			sumOfFlows += node.getFlowCount();
		}
		return sumOfFlows;
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
