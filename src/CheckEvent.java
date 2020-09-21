import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
public class CheckEvent extends Frame {
	// Initialization for member variables is done in constructor.
	Label q1, q2, score;
	Checkbox q1cb1, q1cb2, q1cb3, q1cb4;
	Checkbox q2cb1, q2cb2, q2cb3, q2cb4;
	CheckboxGroup group;
	Button ok;
	
	CheckEvent(String title){
		super(title);
		
		q1 = new Label("1. When is the method of 'actionPerfomed' from 'ActionEvent' called? (select all)");
		q1cb1 = new Checkbox("When to click Button");
		q1cb2 = new Checkbox("When to Enter in TextField");
		q1cb3 = new Checkbox("When to click MenuItem");
		q1cb4 = new Checkbox("When to double-click item from the List");
		
		q2 = new Label("2. What's the default setting for Frames' LayoutManager? (choose only one)");
		group = new CheckboxGroup();
		q2cb1 = new Checkbox("FlowLayout", group, false);
		q2cb2 = new Checkbox("GridLayout", group, false);
		q2cb3 = new Checkbox("BorderLayout", group, false);
		q2cb4 = new Checkbox("CardLayout", group, false);
		
		score = new Label("¡Ú Result : ");
		ok = new Button("You can see the result by clicking it.");
		
		
		// Close Button -> Program finished.
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent we) {
				dispose();

			}
		});
		
		// Attach components to Frame.
		add(q1);	add(q1cb1);	add(q1cb2);	add(q1cb3);	add(q1cb4);
		add(new Label(""));
		add(q2);	add(q2cb1);	add(q2cb2);	add(q2cb3);	add(q2cb4);
		add(score);	add(ok);
		
		// Event when to click button.
		ok.addActionListener(new EventCheck2());
		
		
		//	Frame setting
		this.setLayout(new GridLayout(13,1));	// row:13 column:1
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		this.setBounds(screenSize.width/2-250, screenSize.height/2-200, 500, 400);	// starting point & size of the frame.
		this.setVisible(true);
	}	

	class EventCheck2 implements ActionListener	{
		public void actionPerformed(ActionEvent arg0) {
			double total = 0.0;
			if(q1cb1.getState()){				//if check or not? -> true/ false	
				total+= 12.5;
			}
			if(q1cb2.getState()){
				total += 12.5;
			}
			if(q1cb3.getState()){
				total += 12.5;
			}
			if(q1cb4.getState()){
				total += 12.5;
			}
			if(q2cb3.getState()){
				total += 50.0;
			}
			score.setText("¡Ú Result : Your score is " + total+".");

		}
		
	}

}
