import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setTitle("Randrom Number Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 212, 211);
		contentPane.add(textArea);
		
		textArea.setText(result);
		
		JButton btnNewButton = new JButton("Generate New Random Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String result = makePassword(10);
				System.out.println(result);
				textArea.setText(result);
				
				}
			

			public String makePassword(int length){
				String password = "";
				for (int i = 0; i < length - 2; i++) {
					password = password + randomCharacter("abcdefgahijklmnoqprstuvwxABCDEFGHIJKLMNOPQRSTUVWX+-*/+-");
				}
				
			String randomDigit = randomCharacter("0123456789");
			password = insertAtRandom(password, randomDigit);
			String randomSymbol = randomCharacter("ABCDEFGHIJKLMNOPQRSTUVWX");
			password = insertAtRandom(password, randomSymbol);
			return password;
				
			}
			public String randomCharacter(String characters){
				int n = characters.length();
				int r = (int) (n * Math.random());
				return characters.substring(r, r + 1);
			}
		public String insertAtRandom(String str, String toInsert){
			int n = str.length();
			int r = (int)((n+1) * Math.random());
			return str.substring(0,  r) + toInsert + str.substring(r);
			
		
				
			}
		
		});
		
		
		btnNewButton.setBounds(10, 233, 212, 23);
		contentPane.add(btnNewButton);
		
		
		
	}

	String result = makePassword(12);

	public static String makePassword(int length){
		String password = "";
		for (int i = 0; i < length - 2; i++) {
			password = password + randomCharacter("abcdefgahijklmnoqprstuvwx");
		}
		
	String randomDigit = randomCharacter("0123456789");
	password = insertAtRandom(password, randomDigit);
	String randomSymbol = randomCharacter("123456789");
	password = insertAtRandom(password, randomSymbol);
	return password;
		
	}
	public static String randomCharacter(String characters){
		int n = characters.length();
		int r = (int) (n * Math.random());
		return characters.substring(r, r + 1);
	}
	public static String insertAtRandom(String str, String toInsert){
	int n = str.length();
	int r = (int)((n+1) * Math.random());
	return str.substring(0,  r) + toInsert + str.substring(r);


}	
}
