package node;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class StartNode extends AbstractNode {

	public StartNode(float x, float y) {
		super(x, y);
	}

	public void drawNode(Graphics g) {
		g.setColor(new Color(50, 205, 50));
		g.fill(getNodeShape());
	}

}
