import java.awt.*;
import java.awt.event.*;
public class Coffee extends Frame{
	Label m1, m2, m3;
	Panel p1, p2, p3;
	Checkbox coffee1, coffee2, coffee3;
	Checkbox small, medium, large;
	CheckboxGroup size, coffee;
	Button ok;
	Font f1 = new Font("Serif", Font.BOLD, 22);
	Font f2 = new Font("Sans Serif", Font.PLAIN, 18);
	int coffee_total, size_total;
	
	Coffee(String title){
		super(title);
		
		m1 = new Label("Choose Coffee", Label.CENTER);
		m1.setBackground(new Color(255,181,107));
		m1.setFont(f1);
		p1 = new Panel();
		p1.setBackground(new Color(255,181,107));
		coffee = new CheckboxGroup();
		coffee1 = new Checkbox("Americano(1000won)", coffee, false);
		coffee1.setFont(f2);
		coffee2 = new Checkbox("CafeLatte(2000won)", coffee, false);
		coffee2.setFont(f2);
		coffee3 = new Checkbox("Caramel Machhiato(3000won)",coffee, false);
		coffee3.setFont(f2);
		
		m2 = new Label("Choose the size", Label.CENTER);
		m2.setFont(f1);
		m2.setBackground(new Color(204,153,153));
		p2 = new Panel();
		p2.setBackground(new Color(204,153,153));
		size = new CheckboxGroup();
		small = new Checkbox("Small(+0)", size, false);
		small.setFont(f2);
		medium = new Checkbox("Medium(+500)", size, false);
		medium.setFont(f2);
		large = new Checkbox("Large(+1000)", size, false);
		large.setFont(f2);
		
		p3 = new Panel();
		p3.setLayout(null);
		p3.setBackground(new Color(252,222,214));
		ok = new Button("Check");
		ok.setBounds(150, 15, 120, 60);
		ok.setBackground(new Color(252,141,113));
		ok.setFont(f1);
		m3 = new Label("Total : ",Label.CENTER);
		m3.setFont(f1);
		m3.setBackground(Color.black);
		m3.setForeground(Color.yellow);
		m3.setBounds(300, 15, 300, 60);
		
		
		// Event when to click button.
		ok.addActionListener(new Event());
		
		
		// Attach components to Frame.
		add(m1);		add(p1); p1.add(coffee1); p1.add(coffee2); p1.add(coffee3);
		add(m2);		add(p2); p2.add(small); p2.add(medium); p2.add(large);
		add(p3); p3.add(ok); p3.add(m3);
		
		// Close button -> Program finished.
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent we) {
				dispose();	//	to release memory of Coffee Frame.

			}
		});
		// Frame Setting 
		this.setLayout(new GridLayout(5,1));	// row:5 column:1
		
		// to make the frame located in the center of screen.
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();	// to get size (weight, height) of the screen.
		setBounds(screenSize.width/2-350, screenSize.height/2-250,700,500);
		this.setVisible(true);
	}	
	
		
		
		class Event implements ActionListener{
			public void actionPerformed(ActionEvent e){
				int total = 0;
				if(coffee1.getState()){
					total = 1000;
				}
				if(coffee2.getState()){
					total = 2000;
				}
				if(coffee3.getState()){
					total = 3000;
				}
				if(small.getState()){
					total += 0;
				}
				if(medium.getState()){
					total += 500;
				}
				if(large.getState()){
					total +=1000;
				}
				m3.setText("Total : "+total);
			}
		}


}
