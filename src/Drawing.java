import java.awt.*;
import java.awt.event.*;

class Drawing extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;

	Image img = null;
	Graphics gImg = null;
	
	public Drawing(String title) {
		super(title);
		addMouseMotionListener(this);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});

		// starting point & size of the frame.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width/2-250, screenSize.height/2-250, 500, 500);	
		setVisible(true);

		img = createImage(500, 500);
		gImg = img.getGraphics();
		gImg.drawString("Please move the mouse with the left button pressed." ,10, 50);
		repaint();
	}

	public void paint(Graphics g) {
		if(img==null) return;
		g.drawImage(img,0,0,this);
	}

	public void mouseMoved(MouseEvent me) {
		x = me.getX();
		y = me.getY();
	}
	public void mouseDragged(MouseEvent me) {
		if (me.getModifiersEx()!=MouseEvent.BUTTON1_DOWN_MASK ) return;

		gImg.drawLine(x,y, me.getX(),me.getY());
		x = me.getX();
		y = me.getY();

		repaint();
	}
}