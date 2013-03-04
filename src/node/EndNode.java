package node;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EndNode extends AbstractPlaceableFlowableNode implements EndNodeInterface {

	public EndNode(float x, float y) {
		super(x, y);
	}

	public void drawNode(Graphics g) {
		if (isSelected()) {
			g.setColor(Color.yellow);
			g.fillOval(getxCenter() - getRadius() - 2, getyCenter() - getRadius() - 2, getRadius() * 2 + 4, getRadius() * 2 + 4);
		}
		g.setColor(new Color(RVALUE, GVALUE, BVALUE));
		super.drawNode(g);
	}

}
