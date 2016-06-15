package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JViewport;
import javax.swing.plaf.synth.SynthScrollPaneUI;

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
	
	JTextArea  rview;
	
	JEditorPane left1edit;
	JEditorPane left2edit;
	JEditorPane rightedit;
	
	void loadlogo(Frame f)
	{
		try {
			String src = "/img/logo.png";     //图片路径
//			String src = "/img/logo48.ico";     //图片路径,不支持ICO文件 
			Image image=ImageIO.read(f.getClass().getResource(src));
			//创建图片对象
			f.setIconImage(image);          //设置图标
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	@SuppressWarnings("unchecked")
	void genJGui()
	{
		// 方法3：通过分析匿名类名称()  
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
        Container con=frame.getContentPane();//创建一个中间容器
        
//		FlowLayout  flow = new FlowLayout( FlowLayout.LEFT, 5, 20 );
		GridLayout  grid = new GridLayout(10,10,1,1);
		
		JPanel p=new JPanel(new GridLayout(1,10,1,1));
//		JPanel pl=new JPanel(new FlowLayout( FlowLayout.LEFT, 5, 20 )); 
		JPanel pl=new JPanel(new GridLayout(1,10,1,1)); 
		Container content = new Container(); 
		content.setBackground(Color.black); 
		content.setLayout(new GridLayout(1,10,1,1));
		
		JPanel pc=new JPanel(new GridLayout(1,2,1,1)); 
		JPanel pr=new JPanel(new GridLayout(1,4,1,1)); 
		
		  //设置窗体中显示的字体样式
		frame.setFont(new Font("Times",Font.PLAIN, 20));
	    
		
		
//		frame.setLayout(flow);
//		frame.setLayout(grid);
		
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
		selDbButton     = new JButton("选择代码库");
        Box hbox1=Box.createHorizontalBox();//创建一个水平箱子
        hbox1.add(label); //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
        hbox1.add(Box.createHorizontalStrut(5));
        hbox1.add(lineEdit_Search);
        hbox1.add(Box.createHorizontalStrut(5));
        hbox1.add(cleanButton);
        hbox1.add(getClipdButton);
        hbox1.add(checkbox_ag);
        hbox1.add(combox_dbsel);
        hbox1.add(selDbButton);
           
        
		InDbButton      = new JButton("入库");
		rightcleanButton   = new JButton("右清空");
		rightselindbButton = new JButton("右选入库");
		pasteButton        = new JButton("粘上");
		autoindbButton     = new JButton("自动入库");
		modifyButton       = new JButton("修改");
		deleteButton       = new JButton("删除");
		setupButton        = new JButton("设置");
		toolButton         = new JButton("工具");
		aboutButton        = new JButton("关于");
		closeButton        = new JButton("close");
        Box vbox1=Box.createVerticalBox();
        vbox1.add(InDbButton);
        vbox1.add(rightcleanButton);
        vbox1.add(rightselindbButton);
        vbox1.add(pasteButton);
        vbox1.add(autoindbButton);
        vbox1.add(modifyButton);
        vbox1.add(deleteButton);
        vbox1.add(setupButton);
        vbox1.add(toolButton);
        vbox1.add(aboutButton);
        vbox1.add(closeButton);
        
		
		saveButton         = new JButton("save");
		gencodeButton      = new JButton("生成代码库");
		rview              = new JTextArea(500, 15);
		rview.setLineWrap(true); 
		  
//		rview.setContentType("text/html");  

//        JTextArea textArea = new JTextArea(500, 15);  
         
//        JScrollPane scrollPane = new JScrollPane(textArea);  
		
		JScrollPane scrollPane = new JScrollPane(rview);  
//		scrollPane.setPreferredSize(new Dimension(rview.getWidth(), rview.getHeight()));
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        scrollPane.revalidate();
        scrollPane.repaint();

        Box hbox2=Box.createHorizontalBox();//创建一个水平箱子
        hbox2.add(saveButton); //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
//        hbox2.add(Box.createHorizontalStrut(20));
        hbox2.add(gencodeButton);  
        
        Box rvbox = Box.createVerticalBox();
        rvbox.add(hbox2);
        rvbox.add(Box.createVerticalGlue());
        rvbox.add(scrollPane);
//        rvbox.add(rview);
	
        
        Box hbox=Box.createHorizontalBox();//创建一个垂直箱子，这个箱子将两个水平箱子添加到其中，创建一个横向 glue 组件。
        hbox.add(hbox1);
        hbox.add(Box.createHorizontalGlue());
        hbox.add(vbox1);
        hbox.add(Box.createHorizontalGlue());        
        hbox.add(rvbox);
        hbox.add(Box.createHorizontalGlue());

        
        con.add(hbox,BorderLayout.CENTER); // 将垂直箱子添加到BorderLayout布局管理器中的中间位置
        
//
//		left1edit          = new JEditorPane();
//		left2edit          = new JEditorPane();
//		rightedit          = new JEditorPane();
//		left1edit.setLayout(new GridLayout(9,4));
//		left2edit.setLayout(new GridLayout(9,1));
//		rightedit.setLayout(new GridLayout(9,4));
//		
//		
//		
//		p.add(label);
//		p.add(lineEdit_Search);
//		p.add(cleanButton);
//		p.add(getClipdButton);
//		p.add(checkbox_ag);
//		p.add(combox_dbsel);
//		p.add(selDbButton);
//		p.add(InDbButton);
//		p.add(saveButton);
//		p.add(gencodeButton);
//		
////		pl.add(left1edit);
////		pc.add(left2edit);
////		pr.add(rightedit);
//		
//		pl.add(left1edit);
//		pl.add(left2edit);
//		pl.add(rightedit);
//			
//		
//		content.add("l1", left1edit);
//		content.add("l2", left2edit);
//		content.add("r", rightedit);
//		//将文本框放置在窗体NORTH位置
//
//        frame.getContentPane().add(p,BorderLayout.NORTH);  
////        frame.getContentPane().add(pl,BorderLayout.SOUTH);  
//        frame.getContentPane().add(content,BorderLayout.SOUTH);  
////        frame.getContentPane().add(pc,BorderLayout.CENTER);  
////        frame.getContentPane().add(pr,BorderLayout.EAST);  
//		
		
		//load logo
		loadlogo(frame);
		
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;  //桌面宽
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;  //桌面高
		width/=2;
		height/=2;

		frame.setSize(width , height);
		frame.setVisible(true);
		
		setLocationRelativeTo(null);               //让窗体居中显示
			
		
		
	}
	


	public class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// 方法3：通过分析匿名类名称()  
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
			// 方法3：通过分析匿名类名称()  
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
