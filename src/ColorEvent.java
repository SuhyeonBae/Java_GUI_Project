import java.awt.*;
import java.awt.event.*;
public class ColorEvent extends Frame{
	ColorEvent(String title){
		super(title);
		
		Font f1 = new Font("serif", Font.BOLD, 20);
		Button y = new Button("Yellow");
		Button r = new Button("Red");
		Button g = new Button("Green");
		Button b = new Button("Blue");
		Button random = new Button("Random");

		
		y.setBounds(130, 80, 100, 100);
		r.setBounds(280, 80, 100, 100);
		g.setBounds(130, 230, 100, 100);
		b.setBounds(280, 230, 100, 100);
		random.setBounds(130, 380, 250, 100);


		y.setFont(f1);
		r.setFont(f1);
		g.setFont(f1);
		b.setFont(f1);
		random.setFont(f1);
		
		y.addActionListener(new Y());
		r.addActionListener(new R());
		g.addActionListener(new G());
		b.addActionListener(new B());
		random.addActionListener(new Random());
				
		add(y); add(r); add(g); add(b);	add(random);
		
		// Close Button -> Program finished.
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent we) {
				dispose();
			}
		});
		
		//	Frame setting
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		this.setBounds(screenSize.width/2-250, screenSize.height/2-240, 500, 580);	// starting point & size of the frame.
		this.setLayout(null);
		this.setVisible(true);
	}
	
	// Inner Class for handling Event
	class Y implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setBackground(Color.yellow);
	}}
	
	class R implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setBackground(Color.red);
	}}
	
	class G implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setBackground(Color.green);
	}}
	
	class B implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setBackground(Color.blue);
	}}
	
	class Random implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Color color[] = {Color.blue, Color.yellow, Color.red, Color.green};
			int random = (int)(Math.random()*4);
			setBackground(color[random]);	// Array's name
	}}
		
}
	