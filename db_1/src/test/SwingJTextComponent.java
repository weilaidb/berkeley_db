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
        //�����ı���ʵ��
        final JTextField textField = new JTextField();
        final JPasswordField  passwordField = new JPasswordField();
        
        //����һ��Panel,�����˱�񲼾ֹ�������ָ��������
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
//        ����ı���ı�ǩ
        northPanel.add(new JLabel("User name:", SwingConstants.RIGHT));
//        ���ı�����ӵ�panel
        northPanel.add(textField);
        northPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        northPanel.add(passwordField);
//        ��pannel��ӵ�frame
        add(northPanel,BorderLayout.NORTH);
        
//        �����ı���ʵ���������ô�С����ӵ�frame������λ��
        final JTextArea textArea = new JTextArea(TEXTAREA_ROWS,TEXTARER_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
        
//        ����һ����ť����ӵ�frame�·�������������¼��������ť���ı�����ʾ�û���������
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