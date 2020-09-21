import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;
public class Vending extends Frame {
		Frame f = this;
		String menu[]={"Americano","Cappuccino","Affogato","Dolce Latte", "Greentea Frappuccino", "Javachip Frappuccino", "Strawberry Frappuccino", "Vanilla Frappuccino"};
		int price[]={3500,4000,4500,5000,5500,6000,6500,7000};
		Label pricetag[]=new Label[menu.length];
		Panel menu_choice, menu_confirm, menu_order;
		JButton bt[] = new JButton[menu.length];
		JTextField qty[] = new JTextField[menu.length];
		Label label[] = new Label[menu.length];
		Button minus[] = new Button[menu.length];
		Button plus[] = new Button[menu.length];
		Button ok[] = new Button[menu.length];
		ImageIcon img[] = new ImageIcon[menu.length];
		TextArea confirm;
		Button order, reset, close;
		int count = 0; 
		int all =0;
		String show = "";
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		Vending(String title){
			super(title);
			this.setLayout(new BorderLayout());
			
			Font f1 = new Font("SansSerif", Font.BOLD, 15);
			
			menu_choice = new Panel();
			menu_choice.setLayout(null);
			menu_choice.setLocation(0, 0);
			menu_choice.setPreferredSize(new Dimension(600,450));

			
			// Vending Machine Panel
			for(int i=0; i<menu.length; i++){
				// Initialization
				img[i] = new ImageIcon("images/coffee/" + i +".jpg");
				bt[i] = new JButton(menu[i],img[i]);
				bt[i].setBorderPainted(false);
				bt[i].setContentAreaFilled(false);
				pricetag[i] = new Label(String.valueOf(price[i])+"won",Label.CENTER);
				minus[i] = new Button("-");
				qty[i] = new JTextField("0");
				qty[i].setEditable(false);
				qty[i].setHorizontalAlignment(JTextField.CENTER);
				qty[i].setBackground(Color.white);
				plus[i] = new Button("+");
				ok[i] = new Button("OK");

			
				// Positioning the upper menu & the lower menu
				if(i<4){
					bt[i].setBounds(30+140*i, 50, 100, 100);	
					pricetag[i].setBounds(30+140*i, 150, 100, 20);
					qty[i].setBounds(55+140*i, 170, 50, 20);
					minus[i].setBounds(30+140*i, 170, 20, 20);
					plus[i].setBounds(110+140*i, 170, 20, 20);
					ok[i].setBounds(30+140*i, 200, 100, 20);
				} else {
					bt[i].setBounds(30+140*(i-4), 250, 100, 100);	
					pricetag[i].setBounds(30+140*(i-4), 350, 100, 20);
					qty[i].setBounds(55+140*(i-4), 370, 50, 20);
					minus[i].setBounds(30+140*(i-4), 370, 20, 20);
					plus[i].setBounds(110+140*(i-4), 370, 20, 20);
					ok[i].setBounds(30+140*(i-4), 400, 100, 20);
				}
				
						
				// Attach components
				this.add(menu_choice, BorderLayout.NORTH);
				menu_choice.add(bt[i]);
				menu_choice.add(pricetag[i]);
				menu_choice.add(minus[i]); 
				menu_choice.add(qty[i]);			
				menu_choice.add(plus[i]);
				menu_choice.add(ok[i]);

			}

			
			// Panel for confirming order.
			menu_confirm = new Panel();
			menu_confirm.setBackground(Color.orange);
			confirm = new TextArea("",0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
			confirm.setText("	  Products	 	 Unit Price 	  Q'ty		Total\n\n");
			confirm.setFont(f1);

			this.add(menu_confirm, BorderLayout.CENTER);
			menu_confirm.add(confirm);
			
			menu_order = new Panel();
			order = new Button("Check out");
			reset = new Button("Reset");
			close = new Button("Quit");
			menu_order.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.add(menu_order, BorderLayout.SOUTH);
			menu_order.add(order);
			menu_order.add(reset);
			menu_order.add(close);
			
			
			//*******************메뉴 이벤트*********************//
			
			for(int i=0; i<menu.length; i++){
				int j =i;
				
				bt[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						minus[j].setEnabled(true);
						plus[j].setEnabled(true);
						bt[j].setEnabled(false);
						ok[j].setEnabled(true);
						count = 0;
					}
				});
				
			minus[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(count>0){
						count -= 1;
						qty[j].setText(count+"");
						ok[j].setEnabled(true);
					}else{
						minus[j].setEnabled(false);
					}
				}
			});
			
			plus[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					count += 1;
					qty[j].setText(count+"");
					ok[j].setEnabled(true);
					if(count>0){
						minus[j].setEnabled(true);
					}
				}
			});
			
			ok[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					all += price[j]*count;
					show = bt[j].getActionCommand();
					if(j>=4){
					confirm.append(show + "	  " + price[j]+ "	    " + count + "		" + formatter.format(price[j]*count) +"won\n");
					qty[j].setText("0");
					count = 0;
					}else {
					confirm.append(show + "			  " + price[j]+ "	    " + count + "		" +formatter.format(price[j]*count) +"won\n");
					qty[j].setText("0");
					count = 0;
					}
				}
				
			});
							
			}
			

			//************ 하단 메뉴 이벤트(주문, 초기화, 닫기) ************//
			order.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(f, "Your order is confirmed. \n Thank you! \n Total : "+ formatter.format(all) +"won.");
				}
		
			});
			
			
			reset.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					for(int i =0; i<menu.length; i++){
						bt[i].setEnabled(true);
						minus[i].setEnabled(false);
						plus[i].setEnabled(true);
						qty[i].setText("0");
						confirm.setText("	  Products	 	 Unit Price 	  Q'ty		Total\n\n");
						all = 0;
					}
					
				}
				
			});
			
			
			
			close.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					dispose();
				}				
			});
			
			
			// Close Button -> Program finished.
			addWindowListener(new WindowAdapter(){
				public void windowClosing (WindowEvent we) {
					dispose();
				}
			});
			

					
			//	Frame setting
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setBounds(screenSize.width/2-300, screenSize.height/2-450, 600, 900);	// starting point & size of the frame.
			this.setVisible(true);	// show Frame
		}

		private void valueOf(int i) {
			// TODO Auto-generated method stub
			
		}
		
}
	

