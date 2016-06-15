package test;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class SwingJTextComponent extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int TEXTAREA_ROWS = 8;
    private static final int TEXTARER_COLUMNS= 20;
    public SwingJTextComponent()
    {
        //创建文本域实例
        final JTextField textField = new JTextField();
        final JPasswordField  passwordField = new JPasswordField();
        
        //定义一个Panel,设置了表格布局管理器并指定行与列
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
//        添加文本域的标签
        northPanel.add(new JLabel("User name:", SwingConstants.RIGHT));
//        将文本域添加到panel
        northPanel.add(textField);
        northPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        northPanel.add(passwordField);
//        将pannel添加到frame
        add(northPanel,BorderLayout.NORTH);
        
//        定义文本区实例，并设置大小，添加到frame的中心位置
        final JTextArea textArea = new JTextArea(TEXTAREA_ROWS,TEXTARER_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
//        定义一个按钮，添加到frame下方，并定义监听事件，点击按钮，文本区显示用户名与密码
        JPanel southPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                textArea.append("User name:" + textField.getText() + 
                        " Password:" + new String(passwordField.getPassword()) + "\n");
            }
        });
        southPanel.add(insertButton);
        add(southPanel,BorderLayout.SOUTH);
        pack();

    }
    
    public static void main(String[] argvs)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                
                JFrame frame = new SwingJTextComponent();
                frame.setTitle("SwingJTextComponent");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        
    }    
}