import java.awt.*;
import java.awt.event.*;
import javax.swing.*;	// swing ����ϱ� ����
public class Help extends Frame{
	Image img;
	
	
	Help(String title){
		super(title);
		
		// ������ ������ �̹��� ����
		this.setIconImage(new ImageIcon("images/help_icon.png").getImage());
		
		img = Toolkit.getDefaultToolkit().getImage("images/help.jpg");	// help.jpg�̹����� ������ͼ� img�� ����!
		
		
		// ������ �ݱ� ��ư ������ �̺�Ʈ ó��
		addWindowListener(new WindowAdapter(){
			public void windowClosing (WindowEvent we) {
				dispose();
			}
		});
				
		//	������ ���� �κ� 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(screenSize.width/2-350, screenSize.height/2-300, 700, 500);	//������ ������ġ, ũ�� ����
		this.setVisible(true);	// ������ ȭ�鿡 ���̱�
	}
	
	
	// paint() ȣ�� ����
	// 1. ȭ���� ���̸鼭 ȣ��
	// 2. �������ٰ� �ٽ� ���̸� ȣ��
	// 3. �ּ�ȭ �ƴٰ� �ٽ� ���̸� ȣ��
	public void paint(Graphics g){	// �������̵�
		if(img == null){
			return;
		}
		
		g.drawImage(img, 0, 0, this);
		
	}

}
