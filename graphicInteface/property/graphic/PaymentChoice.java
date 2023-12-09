package property.graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import property.client.BankTransfer;
import property.client.CreditCardPayment;
import property.client.Payment;
import property.controllers.Structure;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentChoice {

	private JFrame frmChooseYourPayment;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Payment strategy;

	/**
	 * Launch the application.
	 */
	public static void paymentChoice() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentChoice window = new PaymentChoice();
					window.frmChooseYourPayment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentChoice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChooseYourPayment = new JFrame();
		frmChooseYourPayment.setTitle("CHOOSE YOUR PAYMENT STRATEGY");
		frmChooseYourPayment.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(PaymentChoice.class.getResource("/Mascotte/Cash-register-icon.png")));
		frmChooseYourPayment.getContentPane().setBackground(Color.YELLOW);
		frmChooseYourPayment.getContentPane().setLayout(null);

		JLabel lblPayWithCredit = new JLabel("PAY WITH CREDIT CARD");
		lblPayWithCredit.setFont(new Font("Rockwell Nova Cond", Font.BOLD, 20));
		lblPayWithCredit.setForeground(Color.BLUE);
		lblPayWithCredit.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayWithCredit.setBounds(40, 39, 291, 100);
		frmChooseYourPayment.getContentPane().add(lblPayWithCredit);

		JLabel lblPayWithBank = new JLabel("PAY WITH BANK TRANSFER");
		lblPayWithBank.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayWithBank.setForeground(Color.BLUE);
		lblPayWithBank.setFont(new Font("Rockwell Nova Cond", Font.BOLD, 20));
		lblPayWithBank.setBounds(40, 201, 291, 105);
		frmChooseYourPayment.getContentPane().add(lblPayWithBank);

		JRadioButton radioButton = new JRadioButton("");
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		radioButton.setBackground(Color.YELLOW);
		radioButton.setBounds(40, 75, 21, 35);
		frmChooseYourPayment.getContentPane().add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBackground(Color.YELLOW);
		radioButton_1.setBounds(40, 234, 21, 35);
		frmChooseYourPayment.getContentPane().add(radioButton_1);

		JButton btnConferm = new JButton("CONFERM");
		btnConferm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (radioButton.isSelected()) {
					strategy = new CreditCardPayment();

				} else {
					strategy = new BankTransfer();
				}

				Structure.generateStructure().getCl().generatePaymentStrategy(strategy);

				JOptionPane.showMessageDialog(null, Structure.generateStructure().getCl().payTax());

				frmChooseYourPayment.setVisible(false);

			}
		});
		btnConferm.setBounds(199, 331, 215, 23);
		frmChooseYourPayment.getContentPane().add(btnConferm);

		JLabel CreditCard = new JLabel("");
		CreditCard.setIcon(new ImageIcon(PaymentChoice.class.getResource("/Mascotte/Credit Card.png")));
		CreditCard.setBounds(358, 26, 128, 128);
		frmChooseYourPayment.getContentPane().add(CreditCard);

		JLabel BankTransfer = new JLabel("");
		BankTransfer.setIcon(new ImageIcon(PaymentChoice.class.getResource("/Mascotte/Bank Transfer.png")));
		BankTransfer.setBounds(358, 178, 128, 128);
		frmChooseYourPayment.getContentPane().add(BankTransfer);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmChooseYourPayment.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(PaymentChoice.class.getResource("/image/undo-icon (1).png")));
		button.setForeground(Color.CYAN);
		button.setBackground(Color.ORANGE);
		button.setBounds(532, 11, 40, 23);
		frmChooseYourPayment.getContentPane().add(button);
		frmChooseYourPayment.setBounds(100, 100, 598, 422);
		frmChooseYourPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
