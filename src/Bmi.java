import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
public class Bmi extends Frame{
		Frame f = this;
		Label l1, l2, l3, l4, l5, l6, l7, result1, result2;
		Panel p1, p2, p3;
		Canvas cvs;
		TextField tall_tf, weight_tf;
		double tall, weight, bmi;
		Button cal, reset;
		Image img = Toolkit.getDefaultToolkit().getImage("images/bmi1.jpg");
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		Bmi(String title){
			super(title);
			
			this.setLayout(null);
			Font f1 = new Font("Monospaced", Font.BOLD, 18);
			Font f2 = new Font("Monospaced", Font.PLAIN, 12);
			Font f3 = new Font("SansSerif", Font.BOLD, 13);
			
			// Label1 Design
			l1 = new Label("   ¡Ý My Body Mass Index(BMI)");
			l1.setBounds(0, 30, 700, 50);
			l1.setBackground(new Color(10,175,107));
			l1.setForeground(Color.white);
			l1.setFont(f1);
			
			//Panle1 Design
			p1 = new Panel();
			p1.setBounds(50, 100, 600, 85);
			p1.setBackground(new Color(248,248,248));
			p1.setLayout(new FlowLayout(FlowLayout.LEFT,3,5));
			l2 = new Label(" Body mass index (BMI) is a value derived from the mass (weight) and height of a person.", Label.LEFT);
			l3 = new Label(" The BMI is a convenient rule of thumb used to broadly categorize a person as underweight,", Label.LEFT);
			l4 = new Label(" normal weight, overweight, or obese based on tissue mass (muscle, fat, and bone) and height.", Label.LEFT);
			l2.setFont(f2); l3.setFont(f2); l4.setFont(f2);
			
			
			// Panel2 Design
			p2 = new Panel();
			p2.setBounds(50,200, 600, 40);
			p2.setBackground(new Color(255,247,232));
			p2.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
			l5 = new Label("Height(cm):");
			l6 = new Label("   Weight(kg):");
			l7 = new Label("               ");
			tall_tf = new TextField("", 10);
			weight_tf = new TextField("",10);
			cal = new Button(" Calculate ");
			cal.setBackground(new Color(10,175,107));
			cal.setForeground(Color.white);
			reset = new Button(" Reset ");
			reset.setBackground(Color.darkGray);
			reset.setForeground(Color.white);

			
			// Panel3 Design
			p3 = new Panel();
			p3.setBounds(70,250, 600, 60);
			p3.setLayout(new GridLayout(2,1));
			result1 = new Label("Obesity : ");
			result2 = new Label("BMI : ");
			result1.setFont(f3);
			result2.setFont(f3);
			
			//Canvas for images
			cvs = new Canvas(){
				public void paint(Graphics g){
					g.drawImage(img, 0, 0, this);
				}
			};
			cvs.setBounds(50,320,600,80);

			// Attach components
			this.add(l1);
			this.add(p1); p1.add(l2); p1.add(l3); p1.add(l4);
			this.add(p2); p2.add(l5); p2.add(tall_tf); p2.add(l6); p2.add(weight_tf); p2.add(l7); p2.add(cal); p2.add(reset);
			this.add(p3); p3.add(result1); p3.add(result2);
			this.add(cvs);
			
			
			// Event when to click button.
			cal.addActionListener(new Result());
			reset.addActionListener(new Reset());

			
			// Close Button -> Program finished.
			addWindowListener(new WindowAdapter(){
				public void windowClosing (WindowEvent we) {
					dispose();
				}
			});
					
			//	Frame setting
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setBounds(screenSize.width/2-350, screenSize.height/2-235, 700, 470);	// starting point & size of the frame.
			this.setVisible(true);

		}
		
		// Inner class for handling event
		// Calculate Event
		class Result implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				try{
					tall = Double.parseDouble(tall_tf.getText());
					weight = Double.parseDouble(weight_tf.getText());
					bmi = weight/(tall*0.01)/(tall*0.01);
					result2.setText("BMI : "+ String.format("%.2f", bmi));
					result2.setForeground(Color.red);
					result1.setForeground(Color.red);

					
						
					if(bmi<=18.5){
						result1.setText("Obesity : underweight");
					} else if(bmi>18.5 && bmi<=23){
						result1.setText("Obesity : normal weight");
					} else if(bmi>23 && bmi<=25){
						result1.setText("Obesity : overweight");
					} else if(bmi>25){
						result1.setText("Obesity : obese");
					}
				} catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Only numbers are allowed to input.", "Warning", JOptionPane.ERROR_MESSAGE);
					tall_tf.setText("");
					weight_tf.setText("");
					tall_tf.requestFocus();
					result1.setText("Obesity : ");
					result2.setText("BMI : ");
					result1.setForeground(Color.black);
					result2.setForeground(Color.black);
				}

			}
		}
		class Reset implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				tall_tf.setText("");
				weight_tf.setText("");
				tall_tf.requestFocus();	
				result1.setText("Obesity : ");
				result2.setText("BMI : ");
				result1.setForeground(Color.black);
				result2.setForeground(Color.black);
			}	
		}
		
		
}
