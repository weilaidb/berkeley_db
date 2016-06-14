package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiMain {
	static JFrame frame;
	static JLabel label;
	
	
	static void loadlogo(Frame f)
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
	
	static void genJGui()
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
		
		String title = "dbtest";
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton lableButton = new JButton("Change Lable");
		lableButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorListener());
		
		
		label = new JLabel("i'm a label");
//		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
//		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.getContentPane().add(BorderLayout.EAST, lableButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
	
		
		//load logo
		loadlogo(frame);
		
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		
	}
	
	
	
	static void genGui()
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("==================================");
		System.out.println();
		System.out.println("gui main begin:");
//		genGui();
		genJGui();
	}

}
