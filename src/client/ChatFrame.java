/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import javax.sound.midi.Receiver;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author My Laptop
 */
public class ChatFrame  extends JFrame{
    private JButton btnFile;
	private JButton btnSend;
	private JScrollPane chatPanel;
	private JLabel lbReceiver = new JLabel(" ");
	private JPanel contentPane;
	private JTextField txtMessage;
	private JTextPane chatWindow;
	JComboBox<String> onlineUsers = new JComboBox<String>();
	
	private String username;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	private HashMap<String, JTextPane> chatWindows = new HashMap<String, JTextPane>();
	
	Thread receiver;
        public ChatFrame(String username, DataInputStream dis, DataOutputStream dos) {
            setTitle("CLG CHAT");	
		this.username = username;
		this.dis = dis;
		this.dos = dos;
//		receiver = new Thread(new Receiver(dis));
		receiver.start();
		
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(230, 240, 247));
		setContentPane(contentPane);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(160, 190, 223));
		
		txtMessage = new JTextField();
		txtMessage.setEnabled(false);
		txtMessage.setColumns(10);
		
		btnSend = new JButton("");
		btnSend.setEnabled(false);
		btnSend.setIcon(new ImageIcon("data\\icon\\component\\send.png"));
		
		chatPanel = new JScrollPane();
		chatPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(new Color(230, 240, 247));
		
		btnFile = new JButton("");
                JLabel userImage = new JLabel(new ImageIcon("data\\icon\\component\\user.png"));
                JPanel panel = new JPanel();
		panel.setBackground(new Color(230,240,247));
		JLabel lblNewLabel_1 = new JLabel("CHAT WITH");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_leftPanel = new GroupLayout(leftPanel);
		gl_leftPanel.setHorizontalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(userImage, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addGap(25))
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(29))
				.addGroup(Alignment.TRAILING, gl_leftPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(onlineUsers, 0, 101, Short.MAX_VALUE)
					.addContainerGap())
		);
                gl_leftPanel.setVerticalGroup(
			gl_leftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_leftPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(userImage)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(onlineUsers, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		
		JLabel lbUsername = new JLabel(this.username);
		lbUsername.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lbUsername);
		leftPanel.setLayout(gl_leftPanel);
		
		JLabel headerContent = new JLabel("CLG CHAT");
		headerContent.setFont(new Font("Poor Richard", Font.BOLD, 24));
		header.add(headerContent);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.setBackground(new Color(230,240,247));
		chatPanel.setColumnHeaderView(usernamePanel);
		
		lbReceiver.setFont(new Font("Arial", Font.BOLD, 16));
		usernamePanel.add(lbReceiver);
		
		chatWindows.put(" ", new JTextPane());
		chatWindow = chatWindows.get(" ");
		chatWindow.setFont(new Font("Arial", Font.PLAIN, 14));
		chatWindow.setEditable(false);
		
		chatPanel.setViewportView(chatWindow);
//		contentPane.setLayout(gl_contentPane);
        }
    
}
