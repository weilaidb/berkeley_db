package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class GuiMain extends JFrame {
	JFrame frame;
	JLabel label;
	JButton lableButton;
	JButton cleanButton;
	JButton getClipdButton;
	JButton selDbButton;
	JButton InDbButton;
	JButton saveButton;
	JButton gencodeButton;
	JButton rightcleanButton;
	JButton rightselindbButton;
	JButton pasteButton;
	JButton autoindbButton;
	JButton modifyButton;
	JButton deleteButton;
	JButton setupButton;
	JButton toolButton;
	JButton aboutButton;
	JButton closeButton;
	JTextField  lineEdit_Search;
	JCheckBox  checkbox_ag;
	JComboBox  combox_dbsel;
	
	void loadlogo(Frame f)
	{
		try {
			String src = "/img/logo.png";     //ͼƬ·��
//			String src = "/img/logo48.ico";     //ͼƬ·��,��֧��ICO�ļ� 
			Image image=ImageIO.read(f.getClass().getResource(src));
			//����ͼƬ����
			f.setIconImage(image);          //����ͼ��
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	@SuppressWarnings("unchecked")
	void genJGui()
	{
		// ����3��ͨ����������������()  
		String clazzName3 = new Object() {  
			public String getClassName() {  
				String clazzName = this.getClass().getName();  
				return clazzName.substring(0, clazzName.lastIndexOf('$'));  
			}  
		}.getClassName();  
		System.out.println(clazzName3);  

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		String title = "J_AutoCCode";
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlowLayout  flow=new FlowLayout( FlowLayout.LEFT, 5, 20 );
		  //���ô�������ʾ��������ʽ
		frame.setFont(new Font("Helvetica",Font.PLAIN, 20));
	    
		frame.setLayout(flow);
		
		lableButton = new JButton("Change Lable");
		lableButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorListener());
		
		
		label           = new JLabel("GetList");
		lineEdit_Search = new JTextField(15);
		cleanButton     = new JButton("clean");
		getClipdButton  = new JButton("getClipd");
		checkbox_ag     = new JCheckBox("AG",true);
		String dbstrlist[] = { "Android", "C", "C++", "Debug", "Erlang", "Hadoop",
				"Java", "JavaScript", "MySql", "Oracle", "Patchs", "Perl", "Postgresql",
				"Rust", "shell", "Sqlite3", "Swift", "Php", "Python", "Qt", 
				"Qtquick", "Unittest"};   
		combox_dbsel    = new JComboBox<Object>(dbstrlist);
		selDbButton     = new JButton("ѡ������");
		InDbButton      = new JButton("���");
		saveButton         = new JButton("save");
		gencodeButton      = new JButton("���ɴ����");
		rightcleanButton   = new JButton("�����");
		rightselindbButton = new JButton("��ѡ���");
		pasteButton        = new JButton("ճ��");
		autoindbButton     = new JButton("�Զ����");
		modifyButton       = new JButton("�޸�");
		deleteButton       = new JButton("ɾ��");
		setupButton        = new JButton("����");
		toolButton         = new JButton("����");
		aboutButton        = new JButton("����");
		closeButton        = new JButton("close");
		
		
		
		frame.getContentPane().add(label);
		frame.getContentPane().add(lineEdit_Search);
		frame.getContentPane().add(cleanButton);
		frame.getContentPane().add(getClipdButton);
		frame.getContentPane().add(checkbox_ag);
		frame.getContentPane().add(combox_dbsel);
		frame.getContentPane().add(selDbButton);
		frame.getContentPane().add(InDbButton);
		frame.getContentPane().add(saveButton);
		frame.getContentPane().add(gencodeButton);

					
		
		
		//load logo
		loadlogo(frame);
		
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;  //�����
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;  //�����
		
		frame.setSize(width , height);
//		frame.
		frame.setVisible(true);
		
		
	}
	
	
	
	void genGui()
	{
		// ����3��ͨ����������������()  
		String clazzName3 = new Object() {  
			public String getClassName() {  
				String clazzName = this.getClass().getName();  
				return clazzName.substring(0, clazzName.lastIndexOf('$'));  
			}  
		}.getClassName();  
		System.out.println(clazzName3);  

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		String title = "future db";
		Frame f=new Frame(title);  
		f.setSize(500,400);  
		f.setLocation(300,200);  
		f.setLayout(new FlowLayout());  

		Button b=new Button("����һ����ť");  
		Button c=new Button("����һ����ť");  

		f.add(b);
		f.add(c);	
		
		f.addWindowListener(new MyWin());  
		
		//load logo
		loadlogo(f);

		
		f.setVisible(true);                  //���ÿɼ�		
		
		System.out.println("Hello world!");  

		
		
		
	}
	

	public class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// ����3��ͨ����������������()  
			String clazzName3 = new Object() {  
				public String getClassName() {  
					String clazzName = this.getClass().getName();  
					return clazzName.substring(0, clazzName.lastIndexOf('$'));  
				}  
			}.getClassName();  
			System.out.println(clazzName3);  
			
//			lableButton.setText("lable clicked!!");
			label.setText("lable clicked!!");

		}

	}

	public class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// ����3��ͨ����������������()  
			String clazzName3 = new Object() {  
				public String getClassName() {  
					String clazzName = this.getClass().getName();  
					return clazzName.substring(0, clazzName.lastIndexOf('$'));  
				}  
			}.getClassName();  
			System.out.println(clazzName3);  
//			lableButton.setText("color clicked!!");
			label.setText("color clicked!!");
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("==================================");
		System.out.println();
		System.out.println("gui main begin:");
//		genGui();
//		genJGui();
		GuiMain gui = new GuiMain();
		gui.genJGui();
	}

	
}
