package Thread;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneOffset;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainClock extends JFrame {

	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClock frame = new MainClock("+07:00");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainClock(String muigio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 432);	
		getContentPane().setLayout(null);
		
		Clock clock = new Clock(muigio);
		clock.setBounds(57, 50, 500, 170);
		getContentPane().add(clock);
		Thread t = new Thread(clock);
		t.start();
		
		JLabel lblNewLabel = new JLabel("Múi giờ:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(57, 276, 120, 52);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 25));
		textField.setBounds(187, 276, 197, 52);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(textField.getText());
			}
		});
		btnNewButton.setBounds(407, 276, 144, 52);
		getContentPane().add(btnNewButton);
		setVisible(true);
	}
	
	public void open(String muigio) {
		try {
			ZoneOffset offset = ZoneOffset.of(muigio);
			new MainClock(muigio);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			textField.setText("");
		}
		
	}
}
