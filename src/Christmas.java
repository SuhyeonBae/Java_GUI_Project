import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Back extends JPanel{
	private int nCase;
	
	Point pos = new Point(100,100); // to generate Pointer
	
	Back(){
		nCase = 0;
	}
	
	public void setnCase(int n) {	//to put the value from public class into nCase.
		this.nCase = n;
		this.repaint();
	}

	public void paintComponent(Graphics g){
		Image img = Toolkit.getDefaultToolkit().getImage("images/christmas/christmas.jpg"); // background image
		g.drawImage(img, 0, 0, this);
		Image img1 = Toolkit.getDefaultToolkit().getImage("images/christmas/bbe.png"); // put images
		Image img2 = Toolkit.getDefaultToolkit().getImage("images/christmas/ge.png");
		Image img4 = Toolkit.getDefaultToolkit().getImage("images/christmas/rbe.png");
		Image img5 = Toolkit.getDefaultToolkit().getImage("images/christmas/re.png");
		Image img8 = Toolkit.getDefaultToolkit().getImage("images/christmas/ybe.png");
		Image img10 =Toolkit.getDefaultToolkit().getImage("images/christmas/roo.png"); 
		Image img11 =Toolkit.getDefaultToolkit().getImage("images/christmas/gift.png"); 
		Image ring =Toolkit.getDefaultToolkit().getImage("images/christmas/ring.png");
		Image bell =Toolkit.getDefaultToolkit().getImage("images/christmas/bell.png"); 
		Image santa =Toolkit.getDefaultToolkit().getImage("images/christmas/santa.png"); 
		Image santa1 =Toolkit.getDefaultToolkit().getImage("images/christmas/santa1.png"); 
		Image img9 = Toolkit.getDefaultToolkit().getImage("images/christmas/tree.png");
		Image tree1= Toolkit.getDefaultToolkit().getImage("images/christmas/tree1.png"); 
		Image tree2 = Toolkit.getDefaultToolkit().getImage("images/christmas/tree2.png"); 
		Image roo1=Toolkit.getDefaultToolkit().getImage("images/christmas/roo1.png");
		Image gift1 =Toolkit.getDefaultToolkit().getImage("images/christmas/gift1.png");
		
		switch(nCase){ // execute case statement by nCase.
		case 1 : 
			g.drawImage(img9, 30, 30, this);
			g.drawImage(img1, 80, 140, this);
			g.drawImage(img2, 240, 240, this);
			g.drawImage(img5, 25, 330, this);
			g.drawImage(img11, 280,320, this);
			g.drawImage(img8, 180,280, this);
			g.drawImage(img4, 300,280, this);
			g.drawImage(bell, 100,280, this);
			g.drawImage(ring, 85, -30, this);
			g.drawImage(bell, 200, 200, this);
			break;
		case 2 : 
			g.drawImage(img10, 70,30, this);
			g.drawImage(img5, 90,160, this);
			g.drawImage(img2, 240,160, this);
			g.drawImage(santa1,200, 200, this);
			break;
		case 3 : 
			g.drawImage(tree2, -20, 120, this);
			g.drawImage(tree1, 300,100, this);
			g.drawImage(santa, 170, 380, this);
			g.drawImage(roo1, 200,360, this);
			g.drawImage(gift1, 150,400, this);
			g.drawImage(gift1, 150,410, this);
			g.drawImage(gift1, 140,400, this);
			g.drawImage(gift1, 160,410, this);
			break;
		case 4 : 
			g.drawImage(tree1, 100,100, this);
			g.drawImage(img10, 20, 20, this);
			g.drawImage(roo1, 200,260, this);
			g.drawImage(bell, 250, 150, this);
			break;
		case 5 : 
			g.drawImage(gift1, 20, 120, this);
			g.drawImage(img5, 300, 190, this);
			g.drawImage(santa, 70, 100, this);
			g.drawImage(santa, 100, 100, this);
			g.drawImage(santa, 130, 100, this);
			g.drawImage(santa, 160, 100, this);
			g.drawImage(santa, 190, 100, this);
			g.drawImage(santa, 210, 100, this);
			g.drawImage(roo1, 200,360, this);
			g.drawImage(gift1, 150,400, this);
			break;
		}
	}
}

public class Christmas extends JFrame {
	Back bk = new Back();
	
	public Christmas(String title) {
		super(title);
		
		// close button -> program finished
		this.addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent we){
				dispose();
			}
		});
		
		
		// to make the frame located in the center of screen.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();  // to get size (weight, height) of the screen.
		setBounds(screenSize.width/2-325, screenSize.height/2-250, 650, 500);

		this.setTitle("Christmas");
		this.setVisible(true);

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5,1)); 	// set Buttons in GridLayout.
		ButtonGroup grp = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("Tree1");
		JRadioButton rb2 = new JRadioButton("Tree2");
		JRadioButton rb3 = new JRadioButton("Tree3");
		JRadioButton rb4 = new JRadioButton("Tree4");
		JRadioButton rb5 = new JRadioButton("Tree5");
		
		jp.setBackground(Color.white);
		rb1.setBackground(Color.white);
		rb2.setBackground(Color.white);
		rb3.setBackground(Color.white);	
		rb4.setBackground(Color.white);
		rb5.setBackground(Color.white);	
		
	    grp.add(rb1);
	    grp.add(rb2);
	    grp.add(rb3);
	    grp.add(rb4);
	    grp.add(rb5);

	    jp.add(rb1);
	    jp.add(rb2);
	    jp.add(rb3);
	    jp.add(rb4);
	    jp.add(rb5);

	    rb1.addActionListener(al);
		rb2.addActionListener(al);
		rb3.addActionListener(al); 
		rb4.addActionListener(al);
		rb5.addActionListener(al); 
	    
	    JPanel menu = new JPanel();
	    menu.setLayout(new BorderLayout());
	    menu.add(jp, BorderLayout.CENTER);
	    
	    Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(menu, BorderLayout.EAST);
		ct.add(bk, BorderLayout.CENTER);
	}
	
	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {  	
			if(e.getActionCommand().equals("Tree1")) { // if checked button is 'Tree1', go to setnCase statement of Back component.
				System.out.println("Select Tree1");
				bk.setnCase(1);
	    	} else if (e.getActionCommand().equals("Tree2")) {
	    		System.out.println("Select Tree2");
		   		bk.setnCase(2);
		   	} else if (e.getActionCommand().equals("Tree3")) {
	    		System.out.println("Select Tree3");
		   		bk.setnCase(3);
		   	} else if (e.getActionCommand().equals("Tree4")) {
	    		System.out.println("Select Tree4");
		   		bk.setnCase(4);
		   	} else if (e.getActionCommand().equals("Tree5")) {
	    		System.out.println("Select Tree5");
		   		bk.setnCase(5);
		   	}
		}
	};
}