package node;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class RecieverWormholeNode extends AbstractPlaceableFlowableNode implements RecieverWormholeInterface {

	public RecieverWormholeNode(float x, float y) {
		super(x, y);
	}
	
	public void drawNode(Graphics g) {
		g.setColor(new Color(RVALUE, GVALUE, BVALUE));
		g.fill(getNodeShape());
		g.setColor(new Color(RVALUE2, GVALUE2, BVALUE2));
		g.fillOval(getxCenter() - getRadius() + 4, getyCenter() - getRadius() + 4, getRadius() * 2 - 8, getRadius() * 2 - 8);
		super.drawNodeFlowCounter(g);
	}

}
