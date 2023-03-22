/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
    
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author My Laptop
 */
   public class LoginFrame extends JFrame{
       private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	private String host = "localhost";
	private int port = 9999;
	private Socket socket;
	
	private DataInputStream dis;
	private DataOutputStream dos;
	
	private String username;
        
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public LoginFrame (){
        setTitle("CLG CHAT");
		
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 240, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(160,190,223));
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Arial", Font.BOLD, 14));
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
                JPanel buttons = new JPanel();
		buttons.setBackground(new Color(230, 240, 247));
		JPanel notificationContainer = new JPanel();
		notificationContainer.setBackground(new Color(230, 240, 247));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(headerPanel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbPassword)
							.addGap(18)
							.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbUsername)
							.addGap(18)
							.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
					.addGap(81))
				.addComponent(notificationContainer, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(buttons, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(headerPanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbUsername)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbPassword))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(notificationContainer, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttons, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		
		JLabel notification = new JLabel("");
		notification.setForeground(Color.RED);
		notification.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		notificationContainer.add(notification);
		
		JButton login = new JButton("Log in");
		JButton signup = new JButton("Sign up");
                login.setEnabled(false);
                signup.setEnabled(false);
                
                JLabel headerContent = new JLabel("LOGIN");
		headerContent.setFont(new Font("Poor Richard", Font.BOLD, 24));
		headerPanel.add(headerContent);
		contentPane.setLayout(gl_contentPane);
    }
}


