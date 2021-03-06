package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	JComboBox<Object>  combox_dbsel;
	
	JTextArea  rview;
	
	JEditorPane left1edit;
	JEditorPane left2edit;
	JEditorPane rightedit;
	JDialog about = null;
	boolean ison = false;
	
	final String version = "v1.0";
	
	
	
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

		
		String title = "J_AutoCCode";
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con=frame.getContentPane();//创建一个中间容器
        
        Container content = new Container(); 
		content.setBackground(Color.black); 
		content.setLayout(new GridLayout(1,10,1,1));
		
		//设置窗体中显示的字体样式
		frame.setFont(new Font("Times",Font.PLAIN, 20));
	    
		
		lableButton = new JButton("Change Lable");
		lableButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorListener());
		
		
		label           = new JLabel("GetList");
		lineEdit_Search = new JTextField(15);
		cleanButton     = new JButton("clean");
		getClipdButton  = new JButton("getClipd");
		checkbox_ag     = new JCheckBox("AG",true);  
		combox_dbsel    = JComboBoxKeyList();
		selDbButton     = new JButton("选择代码库");



		JScrollPane pane3 = new JScrollPane (test_data());	
		
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
        
        Box lvbox=Box.createVerticalBox();
        lvbox.add(hbox1);
        lvbox.add(pane3);
        
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
		aboutButton.addActionListener(new aboutBtnClickListener());
		closeButton        = new JButton("close");
		closeButton.addActionListener(new CloseBtnClickedListener());
		
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
		rview              = new JTextArea(100, 150);
		rview.setLineWrap(true); 
		  
//		rview.setContentType("text/html");  
		
		JScrollPane scrollPane = new JScrollPane(rview);  
//		scrollPane.setPreferredSize(new Dimension(rview.getWidth(), rview.getHeight()));
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        scrollPane.revalidate();
        scrollPane.repaint();

        Box hbox2=Box.createHorizontalBox();//创建一个水平箱子
        hbox2.add(saveButton); //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
        hbox2.add(Box.createHorizontalStrut(20));
        hbox2.add(gencodeButton);  
        
        Box rvbox = Box.createVerticalBox();
        rvbox.add(hbox2);
        rvbox.add(Box.createVerticalGlue());
        rvbox.add(scrollPane);
//        rvbox.add(rview);
	
        
        Box hbox=Box.createHorizontalBox();//创建一个垂直箱子，这个箱子将两个水平箱子添加到其中，创建一个横向 glue 组件。
        hbox.add(lvbox);
        hbox.add(Box.createHorizontalGlue());
        hbox.add(vbox1);
        hbox.add(Box.createHorizontalGlue());        
        hbox.add(rvbox);
        hbox.add(Box.createHorizontalGlue());

        
        con.add(hbox,BorderLayout.CENTER); // 将垂直箱子添加到BorderLayout布局管理器中的中间位置
        
		
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

	public class CloseBtnClickedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

	}
	
	public class aboutBtnClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
//			JButton jButton1=new JButton("OK");
//			jButton1.addActionListener(this);
//			JTextArea info = new JTextArea();
			String verstr = "自动生成代码 \n "
					+ "by 小魏莱 \n" 
					+ version; 
			
			JLabel info;
			

//			info.setText(verstr);
			
			
			
			
			//创建一个按钮对象,该对象被添加到对话框中
			if(ison){
				System.out.print("equals ok");
				// 以下语句等价于jDialog1.setVisible(false);

				/* public void dispose()

				 * 释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源。

				 * 即这些 Component 的资源将被破坏，它们使用的所有内存都将返回到操作系统，

				 * 并将它们标记为不可显示。 */
//				about.setAlwaysOnTop(false);
				about.dispose();
				about.setVisible(false);
				ison = false;
				//				about.setVisible(false);

			}
			else
			{
				System.out.print("else switch");

				info = new JLabel();
				info.setText(verstr);
				about = new JDialog();
				
				about.setTitle("版本");
				about.setAlwaysOnTop(true);
//				about.setDefaultCloseOperation(EXIT_ON_CLOSE);
				about.setVisible(true);
//				about.setPreferredSize(getPreferredSize());
				about.setSize(200, 100);
//				about.getContentPane().add(jButton1);
				about.getContentPane().add(info);
				
				about.setLocationRelativeTo(null);                //让窗体居中显示	
				
				ison = true;
			}


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

	
	
	
	JComboBox<Object> JComboBoxKeyList()
	{
		String dbstrlist[] = { "Android", 
	               "C", 
	               "C++", 
	               "Debug", 
	               "Erlang", 
	               "Hadoop",
	               "Java", 
	               "JavaScript", 
	               "MySql", 
	               "Oracle", 
	               "Patchs", 
	               "Perl", 
	               "Postgresql",
	               "Rust", 
	               "shell", 
	               "Sqlite3", 
	               "Swift", 
	               "Php", 
	               "Python", 
	               "Qt", 
	               "Qtquick", "Unittest"};   
		return new JComboBox<Object>(dbstrlist);
	}
	

	void loadlogo(Frame f)
	{
		try {
			String src = "/img/logo.png";     //图片路径,不支持ICO文件     
			Image image=ImageIO.read(f.getClass().getResource(src));
			//创建图片对象
			f.setIconImage(image);          //设置图标
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	JTable test_data()
	{

		final Object[] columnNames = {"索引字段", "内容字段",//列名最好用final修饰
				};
		Object[][] rowData = {
				{"ddd", "男"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"fff", "男"},
				{"ggg", "女"},
				{"hhh", "男"},
				{"ddd", "男"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"fff", "男"},
				{"ggg", "女"},
				{"hhh", "男"},
				{"ddd", "男"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"fff", "男"},
				{"ggg", "女"},
				{"hhh", "男"},
				{"ddd", "男"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"eee", "女"},
				{"fff", "男"},
				{"ggg", "女"},
				{"hhh", "男"},
		};
		

		JTable friends = new JTable (rowData, columnNames);
		friends.setPreferredScrollableViewportSize(new Dimension(1000, 10000));//设置表格的大小
		friends.setRowHeight (30);//设置每行的高度为20
		friends.setRowHeight (0, 20);//设置第1行的高度为15
		friends.setRowMargin (5);//设置相邻两行单元格的距离
		friends.setRowSelectionAllowed (true);//设置可否被选择.默认为false
		friends.setSelectionBackground (Color.white);//设置所选择行的背景色
		friends.setSelectionForeground (Color.red);//设置所选择行的前景色
		friends.setGridColor (Color.black);//设置网格线的颜色
		friends.selectAll ();//选择所有行
		friends.setRowSelectionInterval (0,2);//设置初始的选择行,这里是1到3行都处于选择状态
		friends.clearSelection ();//取消选择
		friends.setDragEnabled (false);//不懂这个
		friends.setShowGrid (false);//是否显示网格线
		friends.setShowHorizontalLines (false);//是否显示水平的网格线
		friends.setShowVerticalLines (true);//是否显示垂直的网格线
		friends.setValueAt ("tt", 0, 0);//设置某个单元格的值,这个值是一个对象
		friends.doLayout ();
		friends.setBackground (Color.lightGray);
		
		return friends;
	}
	
	
}
