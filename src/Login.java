
import java.awt.*;
import java.awt.event.*;

public class Login extends Frame{
	// 5개의 멤버 변수(인스턴스 변수)
	Label lid, lpwd;
	TextField tfId, tfPwd;
	Button ok;	// 1.이벤트 소스(대상)
	Frame f = this;
	
	Login(String title){	// 매개변수 있는 생성자
		super(title);	// Frame(String);
		lid = new Label("ID : ", Label.RIGHT);	//오른쪽 정렬
		lpwd = new Label("Password : ", Label.RIGHT);
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('●');	//비밀번호 보호하기 위해서
		ok = new Button("OK");
		
		// 이벤트 처리 부분
		// 2. 이벤트 리스너(감지기)
		ok.addActionListener(new EventLogin());
		tfId.addActionListener(new EventLogin());
		tfPwd.addActionListener(new EventLogin());
		
		// 프레임 닫기 버튼 -> 종료부분
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
		// 프레임 중앙에 위치시키기
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		this.setBounds(screenSize.width/2-200, screenSize.height/2-100, 400, 200);	//프레임 시작위치, 크기 설정
		
		this.setLayout(new FlowLayout()); 	//프레임에 컴포넌트 붙이면 가운데 정렬
		add(lid);		add(tfId);		add(lpwd);		add(tfPwd);		add(ok);	// 프레임에 컴포넌트 붙이기
		this.setVisible(true);		//프레임 보이기
	}
	
	// 로그인 이벤트 처리기 (Test3 클래스 내부에 작성한 내부 클래스로 사용)
	class EventLogin implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = tfId.getText();	// 입력한 id 문자열을 가지고 와서 id에 대입.
			String password = tfPwd.getText();	//입력한 password 문자열을 가지고와서 password에 대입
			
			if(id.equals("admin")&& password.equals("admin")){
				Msg m = new Msg(f, id +"님, 성공적으로 로그인 되었습니다.");
				f.setVisible(false);
				f.dispose();
			} else {
				new Msg(f, "입력하신 정보가 유효하지 않습니다. 다시 입력하세요.");
				tfId.setText("");
				tfPwd.setText("");
				tfId.requestFocus();	// id 다시 입력할 수 있도록 ifID로 이동 (focus 줌!)
				tfId.selectAll();	// 전체 선택하기(드래그 상태)
				} 
			}
		}
	}

