import java.awt.*;	// for using components.
import java.awt.event.*;	// for handling events.
import javax.swing.*;	// for using swing.

public class MenuStart extends Frame {
	Image img;
	MenuStart(String title){
		super(title);
		
		// to set image of the frame icon.
		this.setIconImage(new ImageIcon("images/icon.png").getImage());
		
		// to make the frame located in the center of screen.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();	// to get size (weight, height) of the screen.
		setBounds(screenSize.width/2-350, screenSize.height/2-225,700,450);
		
		MenuBar mb = new MenuBar();	// to generate the object of MenuBar.
		
		// Menu : File
		Menu m1 = new Menu("File");
		MenuItem mi1 = new MenuItem("Join", new MenuShortcut('J', true));	// ctrl + shift + J (to set shortcut key)
		MenuItem mi2 = new MenuItem("Quit", new MenuShortcut('E'));	// ctrl + E (shortcut key)
		
		mi2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // force to quit.
			}
		});	

		
		// Menu : Events:Practice
		Menu m2 = new Menu("Events:Practice");
		MenuItem mi3 = new MenuItem("Coffee Choice");
		MenuItem mi4 = new MenuItem("CheckBox Event");
		MenuItem mi5 = new MenuItem("Color Event");
		MenuItem mi9 = new MenuItem("Christmas");
		MenuItem mi10 = new MenuItem("Chat");
		MenuItem mi11 = new MenuItem("Card Layout");
		MenuItem mi12 = new MenuItem("Canvas Event");
		
		mi3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// If you click 'Coffee choice'menu, the frame will be showed.
				new Coffee("Coffee Choice");
			}
		});

		mi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new CheckEvent("checkBox Event");
			}
		});

		mi5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new ColorEvent("Color Event");
			}
		});
		
		mi9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Christmas("Christmas");
			}
		});
		mi10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Chat("Chat");
			}
		});
		mi11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Card("Card Layout");
			}
		});
		mi12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Drawing("Canvas Event");
			}
		});
		
		
		//	Menu : Events:Project
		Menu m3 = new Menu("Events:Project");
		MenuItem mi6 = new MenuItem("Starbucks Vending Machine");
		MenuItem mi7 = new MenuItem("BMI Calculator");
		

		mi6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Vending("Starbucks Vending Machine");
			}
		});
		mi7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Bmi("BMI Calculator");
			}
		});
		
		
		//Menu : Help
		Menu m4 = new Menu("Help");
		MenuItem mi8 = new MenuItem("Description for Menu");
		
		mi8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Help("Description for Menu");
			}
		});
		
		
		// Attach 'Menu' to 'MenuBar'
		mb.add(m1);	
		m1.add(mi1);		m1.addSeparator();		m1.add(mi2);
	
		mb.add(m2);
		m2.add(mi3); m2.add(mi4); m2.add(mi5); m2.add(mi9); m2.add(mi10); m2.add(mi11); m2.add(mi12);
		
		mb.add(m3);
		m3.add(mi6);		m3.add(mi7);

		mb.add(m4);		
		m4.add(mi8);
		
		// Close Button -> Program finished.
		addWindowListener(new WindowAdapter(){
		public void windowClosing (WindowEvent we) {
		System.exit(0);
			}
		});
		
		img = Toolkit.getDefaultToolkit().getImage("images/main.jpg");
		
		// Frame setting
		this.setMenuBar(mb);	// Attach MenuBar to Frame
		this.setVisible(true);	// Show Frame to screen.
		
	}
	

	public static void main(String[] args) {
		new MenuStart("Java Project");
		// new Login("Login");
	}
	public void paint(Graphics g){
		if(img==null){
			return;
		}
		int imgWidth = img.getWidth(this);
		int imgHeight = img.getHeight(this);
		g.drawImage(img, (getWidth()-imgWidth)/2, (getHeight()-imgHeight)/2, this);
	}

}
