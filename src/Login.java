
import java.awt.*;
import java.awt.event.*;

public class Login extends Frame{
	// 5���� ��� ����(�ν��Ͻ� ����)
	Label lid, lpwd;
	TextField tfId, tfPwd;
	Button ok;	// 1.�̺�Ʈ �ҽ�(���)
	Frame f = this;
	
	Login(String title){	// �Ű����� �ִ� ������
		super(title);	// Frame(String);
		lid = new Label("ID : ", Label.RIGHT);	//������ ����
		lpwd = new Label("Password : ", Label.RIGHT);
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('��');	//��й�ȣ ��ȣ�ϱ� ���ؼ�
		ok = new Button("OK");
		
		// �̺�Ʈ ó�� �κ�
		// 2. �̺�Ʈ ������(������)
		ok.addActionListener(new EventLogin());
		tfId.addActionListener(new EventLogin());
		tfPwd.addActionListener(new EventLogin());
		
		// ������ �ݱ� ��ư -> ����κ�
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
		// ������ �߾ӿ� ��ġ��Ű��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		this.setBounds(screenSize.width/2-200, screenSize.height/2-100, 400, 200);	//������ ������ġ, ũ�� ����
		
		this.setLayout(new FlowLayout()); 	//�����ӿ� ������Ʈ ���̸� ��� ����
		add(lid);		add(tfId);		add(lpwd);		add(tfPwd);		add(ok);	// �����ӿ� ������Ʈ ���̱�
		this.setVisible(true);		//������ ���̱�
	}
	
	// �α��� �̺�Ʈ ó���� (Test3 Ŭ���� ���ο� �ۼ��� ���� Ŭ������ ���)
	class EventLogin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = tfId.getText();	// �Է��� id ���ڿ��� ������ �ͼ� id�� ����.
			String password = tfPwd.getText();	//�Է��� password ���ڿ��� ������ͼ� password�� ����
			
			if(id.equals("admin")&& password.equals("admin")){
				Msg m = new Msg(f, id +"��, ���������� �α��� �Ǿ����ϴ�.");
				f.setVisible(false);
				f.dispose();
			} else {
				new Msg(f, "�Է��Ͻ� ������ ��ȿ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
				tfId.setText("");
				tfPwd.setText("");
				tfId.requestFocus();	// id �ٽ� �Է��� �� �ֵ��� ifID�� �̵� (focus ��!)
				tfId.selectAll();	// ��ü �����ϱ�(�巡�� ����)
				} 
			}
		}
	}

