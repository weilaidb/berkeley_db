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
import javax.swing.JDialog;
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
	JDialog about = null;
	boolean ison = false;
	
	final String version = "v1.0";
	
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
        Container con=frame.getContentPane();//����һ���м�����
        
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
		
		  //���ô�������ʾ��������ʽ
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
		selDbButton     = new JButton("ѡ������");
		
		//List û�дﵽЧ��
//		DefaultListModel<String> listModel = new DefaultListModel<String>();
//	    listModel.addElement("Debbie Scott");
//	    listModel.addElement("Scott Hommel");
//	    listModel.addElement("Sharon Zakhour");
//	    JList<String> list = new JList<String>(listModel);
//	    list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	    


		final Object[] columnNames = {"�����ֶ�", "�����ֶ�",//���������final����
				};
		Object[][] rowData = {
				{"ddd", "��"},
				{"eee", "Ů"},
				{"fff", "��"},
				{"ggg", "Ů"},
				{"hhh", "��"},
		};
		

		JTable friends = new JTable (rowData, columnNames);
		friends.setPreferredScrollableViewportSize(new Dimension(1000, 10000));//���ñ��Ĵ�С
		friends.setRowHeight (30);//����ÿ�еĸ߶�Ϊ20
		friends.setRowHeight (0, 20);//���õ�1�еĸ߶�Ϊ15
		friends.setRowMargin (5);//�����������е�Ԫ��ľ���
		friends.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse
		friends.setSelectionBackground (Color.white);//������ѡ���еı���ɫ
		friends.setSelectionForeground (Color.red);//������ѡ���е�ǰ��ɫ
		friends.setGridColor (Color.black);//���������ߵ���ɫ
		friends.selectAll ();//ѡ��������
		friends.setRowSelectionInterval (0,2);//���ó�ʼ��ѡ����,������1��3�ж�����ѡ��״̬
		friends.clearSelection ();//ȡ��ѡ��
		friends.setDragEnabled (false);//�������
		friends.setShowGrid (false);//�Ƿ���ʾ������
		friends.setShowHorizontalLines (false);//�Ƿ���ʾˮƽ��������
		friends.setShowVerticalLines (true);//�Ƿ���ʾ��ֱ��������
		friends.setValueAt ("tt", 0, 0);//����ĳ����Ԫ���ֵ,���ֵ��һ������
		friends.doLayout ();
		friends.setBackground (Color.lightGray);


		JScrollPane pane3 = new JScrollPane (friends);	
		
        Box hbox1=Box.createHorizontalBox();//����һ��ˮƽ����
        hbox1.add(label); //��ˮƽ���������һ����ǩ��������Ҵ���һ�����ɼ��ġ�20����λ�����������֮�������һ���ı������
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
        
		InDbButton      = new JButton("���");
		rightcleanButton   = new JButton("�����");
		rightselindbButton = new JButton("��ѡ���");
		pasteButton        = new JButton("ճ��");
		autoindbButton     = new JButton("�Զ����");
		modifyButton       = new JButton("�޸�");
		deleteButton       = new JButton("ɾ��");
		setupButton        = new JButton("����");
		toolButton         = new JButton("����");
		aboutButton        = new JButton("����");
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
		gencodeButton      = new JButton("���ɴ����");
		rview              = new JTextArea(100, 150);
		rview.setLineWrap(true); 
		  
//		rview.setContentType("text/html");  
		
		JScrollPane scrollPane = new JScrollPane(rview);  
//		scrollPane.setPreferredSize(new Dimension(rview.getWidth(), rview.getHeight()));
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        scrollPane.revalidate();
        scrollPane.repaint();

        Box hbox2=Box.createHorizontalBox();//����һ��ˮƽ����
        hbox2.add(saveButton); //��ˮƽ���������һ����ǩ��������Ҵ���һ�����ɼ��ġ�20����λ�����������֮�������һ���ı������
        hbox2.add(Box.createHorizontalStrut(20));
        hbox2.add(gencodeButton);  
        
        Box rvbox = Box.createVerticalBox();
        rvbox.add(hbox2);
        rvbox.add(Box.createVerticalGlue());
        rvbox.add(scrollPane);
//        rvbox.add(rview);
	
        
        Box hbox=Box.createHorizontalBox();//����һ����ֱ���ӣ�������ӽ�����ˮƽ������ӵ����У�����һ������ glue �����
        hbox.add(lvbox);
        hbox.add(Box.createHorizontalGlue());
        hbox.add(vbox1);
        hbox.add(Box.createHorizontalGlue());        
        hbox.add(rvbox);
        hbox.add(Box.createHorizontalGlue());

        
        con.add(hbox,BorderLayout.CENTER); // ����ֱ������ӵ�BorderLayout���ֹ������е��м�λ��
        
		
		//load logo
		loadlogo(frame);
		
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;  //�����
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;  //�����
		width/=2;
		height/=2;

		frame.setSize(width , height);
		frame.setVisible(true);
		
		setLocationRelativeTo(null);               //�ô��������ʾ
			
		
		
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
			String verstr = "�Զ����ɴ��� \n "
					+ "by Сκ�� \n" 
					+ version; 
			
			JLabel info;
			

//			info.setText(verstr);
			
			
			
			
			//����һ����ť����,�ö�����ӵ��Ի�����
			if(ison){
				System.out.print("equals ok");
				// �������ȼ���jDialog1.setVisible(false);

				/* public void dispose()

				 * �ͷ��ɴ� Window�������������ӵ�е������������ʹ�õ����б�����Ļ��Դ��

				 * ����Щ Component ����Դ�����ƻ�������ʹ�õ������ڴ涼�����ص�����ϵͳ��

				 * �������Ǳ��Ϊ������ʾ�� */
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
				
				about.setTitle("�汾");
				about.setAlwaysOnTop(true);
//				about.setDefaultCloseOperation(EXIT_ON_CLOSE);
				about.setVisible(true);
//				about.setPreferredSize(getPreferredSize());
				about.setSize(200, 100);
//				about.getContentPane().add(jButton1);
				about.getContentPane().add(info);
				
				about.setLocationRelativeTo(null);                //�ô��������ʾ	
				
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

	
}
