import java.awt.*;
import java.awt.event.*;

public class Card extends Frame{
	Panel slide, buttons;
	Panel p1, p2, p3, p4, p5;
	Button first, prev, next, last;

	CardLayout card = new CardLayout();
	
	Card(String title){
		super(title);
		
		slide = new Panel();
		buttons = new Panel();
		slide.setLayout(card);

		
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		p5 = new Panel();
		
		p1.setBackground(Color.cyan);
		p2.setBackground(Color.yellow);
		p3.setBackground(Color.pink);
		p4.setBackground(Color.blue);
		p5.setBackground(Color.green);
		
		p1.add(new Label("First Page.",Label.CENTER));
		p2.add(new Label("Second Page.",Label.CENTER));
		p3.add(new Label("Third Page.",Label.CENTER));
		p4.add(new Label("Forth Page.",Label.CENTER));
		p5.add(new Label("Fifth Page.",Label.CENTER));
		
		slide.add(p1,"1"); //attach p1 components to slide, naming "1".
		slide.add(p2,"2"); //must be named.
		slide.add(p3,"3"); //must be named.
		slide.add(p4,"4"); //must be named.
		slide.add(p5,"5"); //must be named.
		
		first = new Button("<<");
		prev = new Button("<");
		next = new Button(">");
		last = new Button(">>");
		
		
		//Attach buttons to Panel.
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		
		first.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			card.first(slide);	//show the first slide.
		}
		});
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				card.previous(slide);	//show the previous slide.
			}
		});
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				card.next(slide);	//show the next slide.
			}
		});
		last.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				card.last(slide);	//show the last slide.
			}
		});
		
		//프레임에 컴포넌트 붙이기
		add(slide,"Center");	//Center에 패널slide 붙이기
		add("South", buttons);	//South에 패널 buttons붙이기
		
		
		card.show(slide, "1");	//"1"이라는 이름을 갖는 카드를 보여주면서 시작!! parent:카드 붙이는 곳

		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent we) {
				dispose();
			}
		});
		
		//	프레임 설정 부분 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width/2-350, screenSize.height/2-350, 700, 700);	//프레임 시작위치, 크기 설정	
		this.setVisible(true);
		
	}
	
	class EventCard implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			card.first(slide);	//slide의 처음 패널 보이기!
			
		}
	}

}
