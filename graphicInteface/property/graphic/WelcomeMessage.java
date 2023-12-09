package property.graphic;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;

import property.controllers.NameController;
import property.controllers.StringControllers;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class WelcomeMessage {

	protected Shell shlWelcome;
	private Text insertName;
	private StringControllers name = new NameController();

	public static void WelcomeClient() {
		try {
			WelcomeMessage window = new WelcomeMessage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlWelcome.open();
		shlWelcome.layout();
		while (!shlWelcome.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		shlWelcome = new Shell();
		shlWelcome.setSize(new Point(753, 213));
		shlWelcome.setMaximized(true);
		shlWelcome.setImage(SWTResourceManager.getImage(WelcomeMessage.class, "/Mascotte/welcome.png"));
		shlWelcome.setSize(450, 213);
		shlWelcome.setText("WELCOME!");
		shlWelcome.setLayout(null);
		Label mascotte = new Label(shlWelcome, SWT.BORDER | SWT.SHADOW_IN);
		mascotte.setImage(SWTResourceManager.getImage(WelcomeMessage.class, "/Mascotte/noctis.jpg"));

		mascotte.setBounds(10, 24, 140, 140);

		Label lblNewLabel = new Label(shlWelcome, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(173, 25, 216, 39);
		lblNewLabel.setText("Hello my name is Noctis");

		Label lblWhatsYourName = new Label(shlWelcome, SWT.NONE);
		lblWhatsYourName.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.BOLD));
		lblWhatsYourName.setAlignment(SWT.CENTER);
		lblWhatsYourName.setBounds(156, 57, 268, 30);
		lblWhatsYourName.setText("What's your name?");

		insertName = new Text(shlWelcome, SWT.BORDER);
		insertName.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		insertName.setBounds(181, 93, 208, 30);

		Button btnNewButton = new Button(shlWelcome, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(WelcomeMessage.class, "/Mascotte/OK.png"));
		btnNewButton.setBounds(229, 129, 119, 35);
		btnNewButton.setText("CONFERM");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				name.update(insertName.getText());
				shlWelcome.close();

			}

		});

	}

}
