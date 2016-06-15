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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
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
		
		//List 没有达到效果
//		DefaultListModel<String> listModel = new DefaultListModel<String>();
//	    listModel.addElement("Debbie Scott");
//	    listModel.addElement("Scott Hommel");
//	    listModel.addElement("Sharon Zakhour");
//	    JList<String> list = new JList<String>(listModel);
//	    list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    


		final Object[] columnNames = {"姓名", "性别", "家庭地址",//列名最好用final修饰
				"电话号码", "生日", "工作", "收入", "婚姻状况","恋爱状况"};
		Object[][] rowData = {
				{"ddd", "男", "江苏南京", "1378313210", "03/24/1985", "学生", "寄生中", "未婚", "没"},
				{"eee", "女", "江苏南京", "13645181705", "xx/xx/1985", "家教", "未知", "未婚", "好象没"},
				{"fff", "男", "江苏南京", "13585331486", "12/08/1985", "汽车推销员", "不确定", "未婚", "有"},
				{"ggg", "女", "江苏南京", "81513779", "xx/xx/1986", "宾馆服务员", "确定但未知", "未婚", "有"},
				{"hhh", "男", "江苏南京", "13651545936", "xx/xx/1985", "学生", "流放中", "未婚", "无数次分手后没有"}
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


//		JScrollPane pane1 = new JScrollPane (example1);//JTable最好加在JScrollPane上
//		JScrollPane pane2 = new JScrollPane (example2);
		JScrollPane pane3 = new JScrollPane (friends);

//		JPanel panel = new JPanel (new GridLayout (0, 1));
//		panel.setPreferredSize (new Dimension (600,400));
//		panel.setBackground (Color.black);
//		panel.add (pane1);
//		panel.add (pane2);
//		panel.add (pane3);		
		
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
