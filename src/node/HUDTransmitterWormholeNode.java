package node;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class HUDTransmitterWormholeNode extends AbstractNonPlaceableNode implements TransmitterWormholeInterface {
	
	public void drawNode(Graphics g) {
		g.setColor(new Color(RVALUE, GVALUE, BVALUE));
		super.drawNode(g);
		g.setColor(new Color(RVALUE2, GVALUE2, BVALUE2));
		g.fillOval(getxCenter() - getRadius() + 4, getyCenter() - getRadius() + 4, getRadius() * 2 - 8, getRadius() * 2 - 8);
	}

}
