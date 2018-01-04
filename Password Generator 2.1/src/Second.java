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
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;

public class Second extends JFrame {

	/**
	 * This is the second version of the app. Check out my github page for log.
	 */
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Second frame = new Second();
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
	public Second() {
		setTitle("Randrom Number Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		JLabel lblLenghtOfThe = new JLabel("Lenght of the password. From 2 to 20.");
		lblLenghtOfThe.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblLenghtOfThe.setBounds(30, 2, 200, 35);
		contentPane.add(lblLenghtOfThe);
		
		JCheckBox chckbxNumbers = new JCheckBox("Numbers");
		chckbxNumbers.setBounds(8, 80, 129, 23);
		contentPane.add(chckbxNumbers);

		JCheckBox chckbxSpecialCharacters = new JCheckBox("Special characters");
		chckbxSpecialCharacters.setSelected(true);
		chckbxSpecialCharacters.setBounds(8, 107, 168, 23);
		contentPane.add(chckbxSpecialCharacters);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 138, 218, 154);
		contentPane.add(textArea);		
		textArea.setText(result);		
		JSlider slider = new JSlider();
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(2);
		slider.setValue(10);
		slider.setPaintLabels(true);
		slider.setToolTipText("Lenght of the password. From 2 to 20 characters.");
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMinimum(2);
		slider.setMaximum(20);
		slider.setBounds(12, 29, 218, 43);
		contentPane.add(slider);  
	   
		JButton btnNewButton = new JButton("New Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = slider.getValue();
				String result = makePassword(value);
				System.out.println(value);
				String actual = result.substring(0, value);
				textArea.setText(actual);
				
				}
			
			
			boolean nums = chckbxNumbers.isSelected();
			boolean specials =  chckbxSpecialCharacters.isSelected();
 
			public String makePassword(int length){
				String password = "";
				for (int i = 0; i < length; i++) {
					System.out.println(length -2);
					nums = chckbxNumbers.isSelected();
					specials = chckbxSpecialCharacters.isSelected();
					String sample = "";					
					String complex = "abcdefgahijklmnoqprstuvwx+-*/+-+-*/+-+-*/+-ABCDEFGHIJKLMNOPQRSTUVWX+-*/+--@#$%&&*???!!";
					String simple = "abcdefgahijklmnoqprstuvwxABCDEFGHIJKLMNOPQRSTUVWX";		

					if (specials == true) {
						sample = complex;
						
					} else {
						sample = simple;
					}
					
					
					password = password + randomCharacter(sample);
				
					if (nums == true) { 
						String randomDigit = randomCharacter("0123456789abcdefgahijklmnoqprstuvwxA0123456789BCDEFGHIJKLMNOPQRSTUVWX");
						password = insertAtRandom(password, randomDigit);
					} else {
						String randomCharacter = randomCharacter("abcdefgahijklmnoqprstuvwx");
						password = insertAtRandom(password, randomCharacter);
				}}
				
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
							
			}});
		
		btnNewButton.setBounds(12, 304, 218, 23);
		contentPane.add(btnNewButton);	
		}
	
	String result = makePassword(10);

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
		}}
