import java.awt.*;
import java.awt.event.*;
import javax.swing.*;	// swing 사용하기 위해
public class Help extends Frame{
	Image img;
	
	
	Help(String title){
		super(title);
		
		// 프레임 아이콘 이미지 설정
		this.setIconImage(new ImageIcon("images/help_icon.png").getImage());
		
		img = Toolkit.getDefaultToolkit().getImage("images/help.jpg");	// help.jpg이미지를 가지고와서 img에 대입!
		
		
		// 프레임 닫기 버튼 누르면 이벤트 처리
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent we) {
				dispose();
			}
		});
				
		//	프레임 설정 부분 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width/2-350, screenSize.height/2-300, 700, 500);	//프레임 시작위치, 크기 설정
		this.setVisible(true);	// 프레임 화면에 보이기
	}
	
	
	// paint() 호출 시점
	// 1. 화면이 보이면서 호출
	// 2. 가려졌다가 다시 보이면 호출
	// 3. 최소화 됐다가 다시 보이면 호출
	public void paint(Graphics g){	// 오버라이딩
		if(img == null){
			return;
		}
		
		g.drawImage(img, 0, 0, this);
		
	}

}
