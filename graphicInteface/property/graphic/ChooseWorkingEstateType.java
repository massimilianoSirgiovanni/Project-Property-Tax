package property.graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import property.client.TaxLaws;
import property.controllers.Structure;
import property.tax.Estate;
import property.tax.Military;
import property.tax.Religious;
import property.tax.Shop;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class ChooseWorkingEstateType {

	private JFrame frmChooseYourEstate;
	private JTextField txtId;
	private JTextField txtValue;
	private TaxLaws law = Structure.generateStructure().getCl().getState().getTaxLaw();

	/**
	 * Launch the application.
	 */
	public void chooseWorkingEstateType() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseWorkingEstateType window = workingType();
					window.frmChooseYourEstate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseWorkingEstateType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChooseYourEstate = new JFrame();
		frmChooseYourEstate.setTitle("CHOOSE YOUR ESTATE");
		frmChooseYourEstate.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChooseWorkingEstateType.class.getResource("/Mascotte/Estate.png")));
		frmChooseYourEstate.getContentPane().setBackground(Color.YELLOW);
		frmChooseYourEstate.getContentPane().setLayout(null);

		JLabel lblMilit = new JLabel("");
		lblMilit.setIcon(new ImageIcon(ChooseWorkingEstateType.class.getResource("/EstateImg/Military.png")));
		lblMilit.setBounds(35, 116, 128, 128);
		frmChooseYourEstate.getContentPane().add(lblMilit);

		JLabel lblReligious = new JLabel("");
		lblReligious.setIcon(new ImageIcon(ChooseWorkingEstateType.class.getResource("/EstateImg/religious.png")));
		lblReligious.setBounds(377, 116, 128, 128);
		frmChooseYourEstate.getContentPane().add(lblReligious);

		JLabel lblShop = new JLabel("");
		lblShop.setIcon(new ImageIcon(ChooseWorkingEstateType.class.getResource("/EstateImg/shop.png")));
		lblShop.setBounds(204, 116, 128, 128);
		frmChooseYourEstate.getContentPane().add(lblShop);
		JLabel enterId = new JLabel("\r\nEnter the ID of the Estate, please");
		enterId.setHorizontalAlignment(SwingConstants.CENTER);
		enterId.setForeground(Color.RED);
		enterId.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		enterId.setBounds(60, 11, 216, 43);
		frmChooseYourEstate.getContentPane().add(enterId);

		JLabel enterValue = new JLabel("\r\nEnter the value of the Estate, please");
		enterValue.setHorizontalAlignment(SwingConstants.CENTER);
		enterValue.setForeground(Color.RED);
		enterValue.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		enterValue.setBounds(60, 51, 216, 43);
		frmChooseYourEstate.getContentPane().add(enterValue);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(300, 22, 86, 20);
		frmChooseYourEstate.getContentPane().add(txtId);

		txtValue = new JTextField();
		txtValue.setColumns(10);
		txtValue.setBounds(300, 62, 86, 20);
		frmChooseYourEstate.getContentPane().add(txtValue);
		frmChooseYourEstate.setBounds(100, 100, 543, 355);
		frmChooseYourEstate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnMilitary = new JButton("Military");
		btnMilitary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = txtId.getText();
				String value = txtValue.getText();
				Estate military = new Military(Integer.parseInt(id), Double.parseDouble(value), law.getAliquota());
				try {
					notifyControllers(military);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frmChooseYourEstate.setVisible(false);
			}
		});
		btnMilitary.setIcon(new ImageIcon(ChooseWorkingEstateType.class.getResource("/Mascotte/OK.png")));
		btnMilitary.setForeground(Color.CYAN);
		btnMilitary.setBackground(Color.RED);
		btnMilitary.setBounds(35, 276, 128, 29);
		frmChooseYourEstate.getContentPane().add(btnMilitary);

		JButton btnShop = new JButton("Shop");
		btnShop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = txtId.getText();
				String value = txtValue.getText();
				Estate shop = new Shop(Integer.parseInt(id), Double.parseDouble(value), "");

				try {
					notifyControllers(shop);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frmChooseYourEstate.setVisible(false);
			}
		});
		btnShop.setIcon(new ImageIcon(ChooseWorkingEstateType.class.getResource("/Mascotte/OK.png")));
		btnShop.setForeground(Color.CYAN);
		btnShop.setBackground(Color.RED);
		btnShop.setBounds(204, 276, 128, 29);
		frmChooseYourEstate.getContentPane().add(btnShop);

		JButton btnReligious = new JButton("Religious");
		btnReligious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = txtId.getText();
				String value = txtValue.getText();
				Estate religious = new Religious(Integer.parseInt(id), Double.parseDouble(value));

				try {
					notifyControllers(religious);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frmChooseYourEstate.setVisible(false);
			}
		});
		btnReligious.setIcon(new ImageIcon(ChooseWorkingEstateType.class.getResource("/Mascotte/OK.png")));
		btnReligious.setForeground(Color.CYAN);
		btnReligious.setBackground(Color.RED);
		btnReligious.setBounds(377, 276, 128, 29);
		frmChooseYourEstate.getContentPane().add(btnReligious);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				undo().chooseEstateType();
				frmChooseYourEstate.setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(ChooseWorkingEstateType.class.getResource("/image/undo-icon (1).png")));
		button.setForeground(Color.CYAN);
		button.setBackground(Color.ORANGE);
		button.setBounds(477, 11, 40, 23);
		frmChooseYourEstate.getContentPane().add(button);

	}

	public abstract void notifyControllers(Estate e) throws Exception;

	public abstract ChooseWorkingEstateType workingType();

	public abstract ChooseHomeOrWorkingEstate undo();
}
