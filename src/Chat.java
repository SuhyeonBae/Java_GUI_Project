import java.awt.*;
import java.awt.event.*;
public class Chat extends Frame {
	TextArea ta;
	TextField tf;

	Chat(String title){
		super(title);
		ta = new TextArea();
		tf = new TextField("Write Here.");
		
		
		ta.setBackground(new Color(230,230,250));
		tf.setBackground(new Color(210, 210, 240));
		add(BorderLayout.CENTER, ta);
		add(tf, BorderLayout.SOUTH);

		// to handle event when to enter text in TextField(tf).
		tf.addActionListener(new ChatEvent());
		
		// Close Button -> Program finished.
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent we) {
				dispose();
			}
		});
		
		//	Frame Setting
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width/2-250, screenSize.height/2-200, 500, 400);	// starting point & size of the frame.
		this.setVisible(true);		
	}
	
	// to handle event by inner class
	class ChatEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ta.append(tf.getText()+"\n"); // attach text after former one.
			tf.requestFocus();
			tf.setText("");
			
		}
		
	}

}
