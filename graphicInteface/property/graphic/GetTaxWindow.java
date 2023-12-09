package property.graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import property.controllers.Structure;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class GetTaxWindow {

	private JFrame frmTax;
	private JTextField textField;
	private Structure str = Structure.generateStructure();
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void getTax() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetTaxWindow window = new GetTaxWindow();
					window.frmTax.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GetTaxWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTax = new JFrame();
		frmTax.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTax.setVisible(false);
			}
		});
		frmTax.getContentPane().setBackground(Color.WHITE);
		frmTax.getContentPane().setForeground(Color.YELLOW);
		frmTax.getContentPane().setLayout(null);

		JLabel lblTheTaxesYou = new JLabel("\r\nThe taxes you must pay are");
		lblTheTaxesYou.setFont(new Font("Sitka Small", Font.BOLD, 17));
		lblTheTaxesYou.setForeground(Color.RED);
		lblTheTaxesYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheTaxesYou.setBounds(10, 87, 299, 73);
		frmTax.getContentPane().add(lblTheTaxesYou);

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setBounds(298, 107, 126, 34);
		frmTax.getContentPane().add(textField);
		textField.setColumns(10);
		frmTax.setTitle("TAX");
		frmTax.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GetTaxWindow.class.getResource("/org/eclipse/jface/dialogs/images/message_info.png")));
		frmTax.setBounds(100, 100, 450, 300);
		frmTax.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField.setText(str.getCl().getTax() + "");

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Sitka Small", Font.BOLD, 17));
		label.setBounds(80, 11, 299, 73);
		frmTax.getContentPane().add(label);
		label.setText("Dear " + str.getCl().getName());

		JButton btnConferm = new JButton("CONFERM");
		btnConferm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTax.setVisible(false);
			}
		});
		btnConferm.setIcon(new ImageIcon(GetTaxWindow.class.getResource("/Mascotte/OK.png")));
		btnConferm.setBounds(180, 171, 146, 39);
		frmTax.getContentPane().add(btnConferm);

	}
}
