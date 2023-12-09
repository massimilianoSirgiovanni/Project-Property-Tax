package property.graphic;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import property.controllers.Structure;

import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

public class Home {

	protected Shell shlTaxPax;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	private Structure str = Structure.generateStructure();

	public static void main(String[] args) {
		try {
			Home window = new Home();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {

		WelcomeMessage.WelcomeClient();
		Display display = Display.getDefault();
		createContents();
		shlTaxPax.open();
		shlTaxPax.layout();
		while (!shlTaxPax.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTaxPax = new Shell();
		shlTaxPax.setImage(SWTResourceManager.getImage(Home.class, "/Mascotte/Home.png"));
		shlTaxPax.setLocation(new Point(26, 26));
		shlTaxPax.setModified(true);
		shlTaxPax.setBackground(SWTResourceManager.getColor(255, 255, 0));
		shlTaxPax.setSize(1338, 728);
		shlTaxPax.setText("TAX PAX");

		String title = "TAX PAX";

		Label balance_1 = new Label(shlTaxPax, SWT.NONE);
		balance_1.setImage(SWTResourceManager.getImage(Home.class, "/Mascotte/balance.png"));
		balance_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		balance_1.setBounds(874, 0, 136, 136);
		formToolkit.adapt(balance_1, true, true);

		Label balance_2 = new Label(shlTaxPax, SWT.NONE);
		balance_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		balance_2.setImage(SWTResourceManager.getImage(Home.class, "/Mascotte/balance.png"));
		balance_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		balance_2.setBounds(318, 0, 136, 136);
		formToolkit.adapt(balance_2, true, true);
		Label strip = formToolkit.createLabel(shlTaxPax, title, SWT.NONE);
		strip.setFont(SWTResourceManager.getFont("PT Serif", 50, SWT.BOLD));

		strip.setAlignment(SWT.CENTER);
		strip.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		strip.setForeground(SWTResourceManager.getColor(255, 255, 0));
		strip.setBounds(0, 0, 1320, 136);

		Button btnNewButton = formToolkit.createButton(shlTaxPax, "ADD ESTATE", SWT.BORDER);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChooseHomeOrWorkingEstate choose = new AddHomeOrWorkingEstate();
				choose.chooseEstateType();
			}
		});

		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 9, SWT.NORMAL));
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_FOREGROUND));
		btnNewButton.setBounds(10, 137, 141, 57);

		Button btnRemoveEstate = formToolkit.createButton(shlTaxPax, "REMOVE ESTATE", SWT.BORDER);
		btnRemoveEstate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				ChooseHomeOrWorkingEstate removeChoice = new RemoveHomeOrWorkingEstate();
				removeChoice.chooseEstateType();

			}
		});
		btnRemoveEstate.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 9, SWT.NORMAL));
		btnRemoveEstate.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_FOREGROUND));
		btnRemoveEstate.setBounds(10, 200, 141, 57);

		Button btnGetTax = formToolkit.createButton(shlTaxPax, "GET TAX", SWT.BORDER);
		btnGetTax.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GetTaxWindow.getTax();
			}
		});

		btnGetTax.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 9, SWT.NORMAL));
		btnGetTax.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_FOREGROUND));
		btnGetTax.setBounds(1185, 137, 125, 57);

		Button btnPay = formToolkit.createButton(shlTaxPax, "PAY", SWT.BORDER);
		btnPay.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PaymentChoice.paymentChoice();
			}
		});
		btnPay.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 9, SWT.NORMAL));
		btnPay.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_FOREGROUND));
		btnPay.setBounds(1185, 263, 125, 57);

		Button btnDocuments = formToolkit.createButton(shlTaxPax, "DOCUMENTS", SWT.BORDER);
		btnDocuments.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Documents.documents();
			}
		});
		btnDocuments.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_FOREGROUND));
		btnDocuments.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 9, SWT.NORMAL));
		btnDocuments.setBounds(1185, 200, 125, 57);

		Composite composite = new Composite(shlTaxPax, SWT.NONE);
		composite.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		composite.setBounds(155, 142, 1024, 537);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);

		Label lblThankYouFor = new Label(composite, SWT.NONE);
		lblThankYouFor.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblThankYouFor.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblThankYouFor.setAlignment(SWT.CENTER);
		lblThankYouFor.setBounds(10, 10, 696, 32);
		formToolkit.adapt(lblThankYouFor, true, true);
		lblThankYouFor.setText(str.getCl().getName() + " thank you for choosing TAX PAX");

		Label lblWeWillHelp = new Label(composite, SWT.NONE);
		lblWeWillHelp.setAlignment(SWT.CENTER);
		lblWeWillHelp.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblWeWillHelp.setBounds(20, 48, 670, 21);
		formToolkit.adapt(lblWeWillHelp, true, true);
		lblWeWillHelp.setText("We will help you manage your taxes easily and in peace");

		Label lblWordOfNoctis = new Label(composite, SWT.NONE);
		lblWordOfNoctis.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblWordOfNoctis.setAlignment(SWT.CENTER);
		lblWordOfNoctis.setBounds(20, 85, 686, 21);
		formToolkit.adapt(lblWordOfNoctis, true, true);
		lblWordOfNoctis.setText("Word of Noctis");

		Label noctis2 = new Label(composite, SWT.NONE);
		noctis2.setImage(SWTResourceManager.getImage(Home.class, "/Mascotte/Noctis 2.1.PNG"));
		noctis2.setBounds(630, 0, 371, 442);
		formToolkit.adapt(noctis2, true, true);

		Label lblARecommendationWhen = new Label(composite, SWT.NONE);
		lblARecommendationWhen.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD | SWT.ITALIC));
		lblARecommendationWhen.setAlignment(SWT.CENTER);
		lblARecommendationWhen.setBounds(279, 441, 618, 49);
		formToolkit.adapt(lblARecommendationWhen, true, true);
		lblARecommendationWhen.setText(
				"A Recommendation, when you want to cancel an operation, do not click on the x above to close the window, click on the buttons with the green arrow, thanks");

		Label lblAttention = new Label(composite, SWT.NONE);
		lblAttention.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblAttention.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblAttention.setAlignment(SWT.CENTER);
		lblAttention.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.BOLD));
		lblAttention.setBounds(44, 422, 217, 80);
		formToolkit.adapt(lblAttention, true, true);
		lblAttention.setText("ATTENTION!");

		Label label = new Label(composite, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setImage(
				SWTResourceManager.getImage(Home.class, "/org/eclipse/jface/fieldassist/images/warn_ovr@2x.png"));
		label.setBounds(10, 426, 47, 38);
		formToolkit.adapt(label, true, true);

		Label lblOnTheRight = new Label(composite, SWT.NONE);
		lblOnTheRight.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblOnTheRight.setAlignment(SWT.CENTER);
		lblOnTheRight.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblOnTheRight.setBounds(233, 191, 343, 49);
		formToolkit.adapt(lblOnTheRight, true, true);
		lblOnTheRight.setText("On the right you can add or remove buildings from your account");

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setImage(SWTResourceManager.getImage(Home.class, "/Mascotte/Home.png"));
		label_1.setBounds(70, 156, 139, 137);
		formToolkit.adapt(label_1, true, true);

		Label lblOnTheLeft = new Label(composite, SWT.NONE);
		lblOnTheLeft.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblOnTheLeft.setAlignment(SWT.CENTER);
		lblOnTheLeft.setBounds(70, 319, 338, 58);
		formToolkit.adapt(lblOnTheLeft, true, true);
		lblOnTheLeft.setText("On the left you will find all the buttons needed to manage the bureaucratic part");

		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setImage(SWTResourceManager.getImage(Home.class, "/Mascotte/Cash-register-icon.png"));
		label_2.setBounds(432, 249, 153, 128);
		formToolkit.adapt(label_2, true, true);

	}
}
