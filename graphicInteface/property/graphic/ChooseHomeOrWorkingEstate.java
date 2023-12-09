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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class ChooseHomeOrWorkingEstate {

	private JFrame frmChooseYourEstate;

	public void chooseEstateType() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseHomeOrWorkingEstate window = generateHomeOrWorkingEstate();
					window.frmChooseYourEstate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChooseHomeOrWorkingEstate() {
		initialize();
	}

	private void initialize() {
		frmChooseYourEstate = new JFrame();
		frmChooseYourEstate.getContentPane().setBackground(Color.YELLOW);
		frmChooseYourEstate.setTitle("CHOOSE YOUR ESTATE");
		frmChooseYourEstate.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChooseHomeOrWorkingEstate.class.getResource("/Mascotte/Estate.png")));
		frmChooseYourEstate.setBackground(Color.WHITE);
		frmChooseYourEstate.setBounds(100, 100, 450, 300);
		frmChooseYourEstate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChooseYourEstate.getContentPane().setLayout(null);

		JLabel Home = new JLabel("");
		Home.setIcon(new ImageIcon(ChooseHomeOrWorkingEstate.class.getResource("/EstateImg/Home.png")));
		Home.setBounds(50, 56, 128, 128);
		frmChooseYourEstate.getContentPane().add(Home);

		JLabel WorkingEstate = new JLabel("");
		WorkingEstate
				.setIcon(new ImageIcon(ChooseHomeOrWorkingEstate.class.getResource("/EstateImg/Working Estate.png")));
		WorkingEstate.setBounds(266, 56, 128, 128);
		frmChooseYourEstate.getContentPane().add(WorkingEstate);

		JButton workingEstateButton = new JButton("Working Estate");
		workingEstateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				workingType().chooseWorkingEstateType();
				frmChooseYourEstate.setVisible(false);
			}
		});
		workingEstateButton.setIcon(new ImageIcon(ChooseHomeOrWorkingEstate.class.getResource("/Mascotte/OK.png")));
		workingEstateButton.setBackground(Color.RED);
		workingEstateButton.setForeground(Color.CYAN);
		workingEstateButton.setBounds(252, 195, 154, 41);
		frmChooseYourEstate.getContentPane().add(workingEstateButton);

		JButton btnHome = new JButton("Home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				homeType().chooseHomeType();
				frmChooseYourEstate.setVisible(false);
			}
		});
		btnHome.setIcon(new ImageIcon(ChooseHomeOrWorkingEstate.class.getResource("/Mascotte/OK.png")));
		btnHome.setBackground(Color.RED);
		btnHome.setForeground(Color.CYAN);
		btnHome.setBounds(44, 195, 145, 41);
		frmChooseYourEstate.getContentPane().add(btnHome);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ChooseHomeOrWorkingEstate.class.getResource("/image/undo-icon (1).png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmChooseYourEstate.setVisible(false);
			}
		});
		button.setForeground(Color.CYAN);
		button.setBackground(Color.ORANGE);
		button.setBounds(384, 11, 40, 23);
		frmChooseYourEstate.getContentPane().add(button);
	}

	public abstract ChooseHomeType homeType();

	public abstract ChooseWorkingEstateType workingType();

	public abstract ChooseHomeOrWorkingEstate generateHomeOrWorkingEstate();

}
