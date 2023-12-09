package property.graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import property.client.TaxLaws;
import property.controllers.Structure;
import property.tax.Economy;
import property.tax.Estate;
import property.tax.Luxury;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class ChooseHomeType {

	private JFrame frmChooseYourEstate;
	private JTextField txtEstateValue;
	private JTextField txtID;
	private TaxLaws law = Structure.generateStructure().getCl().getState().getTaxLaw();

	public void chooseHomeType() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseHomeType window = generateWindow();
					window.frmChooseYourEstate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChooseHomeType() {
		initialize();
	}

	private void initialize() {
		frmChooseYourEstate = new JFrame();
		frmChooseYourEstate.getContentPane().setBackground(Color.YELLOW);
		frmChooseYourEstate.setTitle("CHOOSE YOUR ESTATE");
		frmChooseYourEstate.setBackground(Color.WHITE);
		frmChooseYourEstate.setIconImage(
				Toolkit.getDefaultToolkit().getImage(ChooseHomeType.class.getResource("/Mascotte/Estate.png")));
		frmChooseYourEstate.setBounds(100, 100, 478, 342);
		frmChooseYourEstate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseYourEstate.getContentPane().setLayout(null);

		txtEstateValue = new JTextField();
		txtEstateValue.setBounds(246, 60, 86, 20);
		frmChooseYourEstate.getContentPane().add(txtEstateValue);
		txtEstateValue.setColumns(10);

		JLabel lblEnterTheValue = new JLabel("\r\nEnter the value of the Estate, please");
		lblEnterTheValue.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblEnterTheValue.setForeground(Color.RED);
		lblEnterTheValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheValue.setBounds(20, 49, 216, 43);
		frmChooseYourEstate.getContentPane().add(lblEnterTheValue);

		JLabel lblEnterTheId = new JLabel("\r\nEnter the ID of the Estate, please");
		lblEnterTheId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheId.setForeground(Color.RED);
		lblEnterTheId.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblEnterTheId.setBounds(20, 11, 216, 43);
		frmChooseYourEstate.getContentPane().add(lblEnterTheId);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(246, 22, 86, 20);
		frmChooseYourEstate.getContentPane().add(txtID);

		JLabel lblLuxury = new JLabel("");
		lblLuxury.setIcon(new ImageIcon(ChooseHomeType.class.getResource("/image/Economy.png")));
		lblLuxury.setBounds(47, 113, 128, 128);
		frmChooseYourEstate.getContentPane().add(lblLuxury);

		JLabel lblEconomy = new JLabel("");
		lblEconomy.setIcon(new ImageIcon(ChooseHomeType.class.getResource("/image/Luxury.png")));
		lblEconomy.setBounds(246, 113, 128, 128);
		frmChooseYourEstate.getContentPane().add(lblEconomy);

		JButton btnNewButton = new JButton("Economy");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = txtID.getText();
				String value = txtEstateValue.getText();
				Estate economy = new Economy(Integer.parseInt(id), Double.parseDouble(value),
						law.getDeductionChangeValue(), law.getMaxDeduction(), law.getMinDeduction());
				try {
					notifyControllers(economy);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				frmChooseYourEstate.setVisible(false);

			}
		});
		btnNewButton.setIcon(new ImageIcon(ChooseHomeType.class.getResource("/Mascotte/OK.png")));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setBounds(47, 252, 128, 29);
		frmChooseYourEstate.getContentPane().add(btnNewButton);

		JButton btnLuxury = new JButton("Luxury");
		btnLuxury.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String id = txtID.getText();
				String value = txtEstateValue.getText();
				Estate luxury = new Luxury(Integer.parseInt(id), Double.parseDouble(value), law.getMaxDeduction(),
						law.getPercentage());
				try {
					notifyControllers(luxury);
				} catch (Exception e) {
					e.printStackTrace();
				}

				frmChooseYourEstate.setVisible(false);

			}
		});
		btnLuxury.setIcon(new ImageIcon(ChooseHomeType.class.getResource("/Mascotte/OK.png")));
		btnLuxury.setForeground(Color.CYAN);
		btnLuxury.setBackground(Color.RED);
		btnLuxury.setBounds(246, 252, 128, 29);
		frmChooseYourEstate.getContentPane().add(btnLuxury);

		JButton btnUndo = new JButton("");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				undo().chooseEstateType();
				frmChooseYourEstate.setVisible(false);
			}
		});
		btnUndo.setIcon(new ImageIcon(ChooseHomeType.class.getResource("/image/undo-icon (1).png")));
		btnUndo.setBackground(Color.ORANGE);
		btnUndo.setForeground(Color.CYAN);
		btnUndo.setBounds(410, 13, 42, 29);
		frmChooseYourEstate.getContentPane().add(btnUndo);

	}

	public abstract void notifyControllers(Estate e) throws Exception;

	public abstract ChooseHomeType generateWindow();

	public abstract ChooseHomeOrWorkingEstate undo();

}
