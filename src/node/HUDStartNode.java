package node;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class HUDStartNode extends AbstractNonPlaceableNode implements StartNodeInterface {

	public void drawNode(Graphics g) {
		g.setColor(new Color(RVALUE, GVALUE, BVALUE));
		super.drawNode(g);
	}

}
