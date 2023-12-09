package property.graphic;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JList;

import property.controllers.Structure;
import property.tax.Estate;

import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Documents {

	private JFrame frmDocuments;
	private Structure str = Structure.generateStructure();

	/**
	 * Launch the application.
	 */
	public static void documents() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Documents window = new Documents();
					window.frmDocuments.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public Documents() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		frmDocuments = new JFrame();
		frmDocuments.setTitle("DOCUMENTS");
		frmDocuments.setIconImage(Toolkit.getDefaultToolkit().getImage(Documents.class
				.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Background-Color-Black.png")));
		frmDocuments.getContentPane().setBackground(Color.ORANGE);
		frmDocuments.setBounds(100, 100, 543, 546);
		frmDocuments.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDocuments.getContentPane().setLayout(null);

		JLabel lblTaxPax = new JLabel("TAX PAX");
		lblTaxPax.setVerticalAlignment(SwingConstants.TOP);
		lblTaxPax.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaxPax.setFont(new Font("Sitka Small", Font.BOLD, 17));
		lblTaxPax.setBounds(10, 25, 507, 53);
		frmDocuments.getContentPane().add(lblTaxPax);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 507, 412);
		frmDocuments.getContentPane().add(scrollPane);

		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setForeground(new Color(0, 0, 0));
		list.setToolTipText("");
		list.setFont(new Font("Sitka Small", Font.ITALIC, 17));

		DefaultListModel<String> DML = new DefaultListModel<String>();
		Iterator<Estate> it = str.getCl().getCompl().getIterator();
		while (it.hasNext()) {
			Estate current = it.next();
			DML.addElement(current.document());
			DML.addElement(
					"  Tax to pay for the Estate: " + current.getTax(str.getCl().getState().getTaxLaw().getCoeff()));
			DML.addElement(" ");
			DML.addElement(" ");

		}

		list.setModel(DML);

		JButton btnUndo = new JButton("CLOSE");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDocuments.setVisible(false);
			}
		});
		btnUndo.setForeground(Color.BLUE);
		btnUndo.setBackground(Color.RED);
		btnUndo.setBounds(218, 473, 91, 23);
		frmDocuments.getContentPane().add(btnUndo);

	}
}
