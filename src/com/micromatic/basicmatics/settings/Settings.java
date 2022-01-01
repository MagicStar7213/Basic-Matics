package com.micromatic.basicmatics.settings;

import org.eclipse.swt.widgets.*;

import com.micromatic.basicmatics.*;
import java.io.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;

public class Settings {

	/**Settings shell*/
	public static Shell shell = new Shell(SWT.TITLE | SWT.APPLICATION_MODAL | SWT.CLOSE);
	/**Settings display*/
	public Display display = Display.getCurrent();
	/**Main composite*/
	private Composite parent = new Composite(shell, SWT.NONE);
	/**Second Main composite*/
	private static Composite parent1 = new Composite(shell, SWT.NONE);
	/**Language combo*/
	private Combo combo = new Combo(parent, SWT.READ_ONLY);
	/**Approximation button*/
	public Button aprox;
	/**Detects if it is aproximated */
	public Boolean ap;
	/**Title composite*/
	private Composite composite;
	/**Title image*/
	private Label prefimg;
	/**Title*/
	private Label title;
	/**Properties class*/
	public static final BSMProperties props = new BSMProperties();
	/**Image combo*/
	public static Combo os_combo = new Combo(parent1, SWT.READ_ONLY);
	/**Main Class*/
	private static final BasicMatics bsm = new BasicMatics();
	/**Text in the language combo*/
	private Text combo_text;
	/**Text in the os image combo*/
	private Text oscombo_text;
	/**General Title*/
	private Text general = new Text(parent, SWT.READ_ONLY | SWT.CENTER);
	/**Customisation*/
	private Text custom = new Text(parent1, SWT.READ_ONLY | SWT.CENTER);
	/**Default composite*/
	private Composite def_comp = new Composite(shell, SWT.NONE);
	/**Restore Default button*/
	private Button def = new Button(def_comp, SWT.NONE);

	/**
	 * Open the window.
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				shell.setVisible(false);
				e.doit = false;
			}
		});
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell.setSize(450, 230);
		shell.setText("Settings");
		shell.setImage(new Image(display, getClass().getResourceAsStream("icons/@x45/settings.png")));
		
		parent.setBounds(10, 71, 177, 90);
		
		parent1.setBounds(209, 10, 215, 141);
		
		os_combo.setBounds(10, 34, 91, 23);
		os_combo.setItems(new String[] {"Windows", "macOS", "Linux", "Debian", "Ubuntu", "BasicMatics"});
		
		oscombo_text = new Text(parent1, SWT.READ_ONLY);
		oscombo_text.setBounds(107, 37, 108, 15);
		oscombo_text.setText("OS Image");
		
		os_combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					props.in = new FileInputStream(props.file);
					props.props.load(props.in);
					switch (os_combo.getSelectionIndex()) {
					case 0 :
						BasicMatics.label.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-windows.png")));
						BasicMatics.shell.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-windows.png")));
						props.setOs("windows");
						break;
					case 1 :
						BasicMatics.label.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-apple.png")));
						BasicMatics.shell.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-apple.png")));
						props.setOs("apple");
						break;
					case 2 :
						BasicMatics.label.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-linux.png")));
						BasicMatics.shell.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-linux.png")));
						props.setOs("linux");
						break;
					case 3 :
						BasicMatics.label.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-debian.png")));
						BasicMatics.shell.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-debian.png")));
						props.setOs("debian");
						break;
					case 4 :
						BasicMatics.label.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-ubuntu.png")));
						BasicMatics.shell.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm-ubuntu.png")));
						props.setOs("ubuntu");
						break;
					case 5 :
						BasicMatics.label.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm.png")));
						BasicMatics.shell.setImage(new Image(bsm.display, getClass().getResourceAsStream("icons/bsm.png")));
						props.setOs("bsm");
						break;
					}
				} catch (IOException ignored) {}
			}
		});
		
		combo.setItems(new String[] {"English", "Spanish"});
		combo.setBounds(10, 35, 91, 23);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (combo.getSelectionIndex() == 1) {
					es();
				} else {
					en();
				}
			}
		});
		
		aprox = new Button(parent, SWT.CHECK);
		aprox.setBounds(10, 64, 140, 16);
		aprox.setText("Aproximated result");
		lang(aprox);
		
		combo_text = new Text(parent, SWT.READ_ONLY | SWT.CENTER);
		combo_text.setText("Language");
		combo_text.setBounds(107, 38, 60, 16);
		
		general.setText("General");
		general.setBounds(10, 10, 91, 21);
		general.setFont(new Font(display, "Segoe UI", 10, SWT.BOLD));
		
		custom.setText("Customization");
		custom.setBounds(10, 7, 121, 21);
		custom.setFont(new Font(display, "Segoe UI", 10, SWT.BOLD));
		
		try {
			props.in = new FileInputStream(props.file);
			props.props.load(props.in);
			props.in.close();
			if (props.getOs().equals("windows"))
				os_combo.select(0);
			else if (props.getOs().equals("apple"))
				os_combo.select(1);
			else if (props.getOs().equals("linux"))
				os_combo.select(2);
			else if (props.getOs().equals("debian"))
				os_combo.select(3);
			else if (props.getOs().equals("ubuntu"))
				os_combo.select(4);
			else
				os_combo.select(5);
		} catch (IOException io) { io.printStackTrace(); }

		if (props.getAprox())
			aprox.setSelection(true);
		else
			aprox.setSelection(false);
		
		composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 10, 140, 55);
		
		prefimg = new Label(composite, SWT.NONE);
		prefimg.setBounds(10, 3, 50, 50);
		prefimg.setImage(new Image(display, getClass().getResourceAsStream("icons/@x45/settings.png")));
		
		title = new Label(composite, SWT.CENTER);
		title.setBounds(63, 18, 77, 27);
		title.setText("Settings");
		title.setFont(new Font(display, "Segoe UI", 14, SWT.BOLD));
		
		def_comp.setBounds(209, 157, 215, 24);
		
		def.setBounds(10, 0, 92, 25);
		def.setText("Restore Default");
		def.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (System.getProperty("user.language").equals("es")) {
					es();
					def.setText("Predeterminado");
				} else {
					en();
					def.setText("Restore Deafult");
				}
				BasicMatics.shell.setImage(bsm.os());
				BasicMatics.label.setImage(bsm.os());
				aprox.setSelection(false);
				props.setAprox("false");
			}
		});
		lang(def);
		
		aprox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if (btn.getSelection()) {
					ap = true;
					props.setAprox(ap.toString());
				} else {
					ap = false;
					props.setAprox(ap.toString());
				}
			}
		});

		if (lang(null).equals("es")) {
			combo.setItem(0, "Ingl\u00e9s");
			combo.setItem(1, "Español");
			shell.setText("Ajustes");
			title.setText("Ajustes");
			custom.setText("Personalizaci\u00f3n");
			combo_text.setText("Idioma");
			oscombo_text.setText("Imagen de Sistema");
			combo.select(1);
		} else {
			combo.setItem(0, "English");
			combo.setItem(1, "Spanish");
			shell.setText("Settings");
			title.setText("Settings");
			custom.setText("Customization");
			combo_text.setText("Language");
			oscombo_text.setText("OS Image");
			combo.select(0);
		}
	}

	/**
	 * Translates the button to spanish
	 * @param target the button to change
	 */
	public void es(Button target) {
		if (target != null) {
			switch (target.getText()) {
			case "Divide":
				target.setText("Dividir");
				break;
			case "Multiply":
				target.setText("Multiplicar");
				break;
			case "Subtract":
				target.setText("Restar");
				break;
			case "Add Up":
				target.setText("Sumar");
				break;
			case "Division Rest":
				target.setText("Resto de Divisi\u00f3n");
				break;
			case "Aproximated result":
				target.setText("Resultado aproximado");
				break;
			case "" :
				target.setToolTipText("Accede a la ventana de ajustes");
				break;
			case "Restore Default" :
				target.setText("Predeterminado");
				break;
			}
		}
		props.setLang("es");
	}

	/**
	 * Translates all to spanish
	 */
	private void es() {
		es(BasicMatics.dvdm);
		es(BasicMatics.mtplm);
		es(BasicMatics.restm);
		es(BasicMatics.sumem);
		es(BasicMatics.bdvd);
		es(BasicMatics.bdvdr);
		es(BasicMatics.dvd);
		es(BasicMatics.dvdr);
		es(BasicMatics.mtpl);
		es(BasicMatics.rest);
		es(BasicMatics.sume);
		es(def);
		es(aprox);
		combo.setItem(0, "Ingl\u00e9s");
		combo.setItem(1, "Español");
		shell.setText("Ajustes");
		title.setText("Ajustes");
		custom.setText("Personalizaci\u00f3n");
		combo_text.setText("Idioma");
		oscombo_text.setText("Imagen de Sistema");
		props.setLang("es");
		combo.select(1);
	}

	/**
	 * Translates to english the selected button
	 * @param target the button selected
	 */
	public void en(Button target) {
		if (target != null) {
			switch (target.getText()) {
			case "Dividir":
				target.setText("Divide");
				break;
			case "Multiplicar":
				target.setText("Multiply");
				break;
			case "Restar":
				target.setText("Subtract");
				break;
			case "Sumar":
				target.setText("Add Up");
				break;
			case "Resto de Divisi\u00f3n":
				target.setText("Division Rest");
				break;
			case "Resultado aproximado":
				target.setText("Aproximated result");
				break;
			case "" :
				target.setToolTipText("Access the settings page");
				break;
			case "Predeterminado" :
				target.setText("Restore Deafult");
				break;
			}
		}
		props.setLang("en");
	}

	/**
	 * Translates all to english
	 */
	private void en() {
		en(BasicMatics.dvdm);
		en(BasicMatics.mtplm);
		en(BasicMatics.restm);
		en(BasicMatics.sumem);
		en(BasicMatics.bdvd);
		en(BasicMatics.bdvdr);
		en(BasicMatics.dvd);
		en(BasicMatics.dvdr);
		en(BasicMatics.mtpl);
		en(BasicMatics.rest);
		en(BasicMatics.sume);
		en(def);
		en(aprox);
		combo.setItem(0, "English");
		combo.setItem(1, "Spanish");
		shell.setText("Settings");
		title.setText("Settings");
		custom.setText("Customization");
		combo_text.setText("Language");
		oscombo_text.setText("OS Image");
		props.setLang("en");
		combo.select(0);
	}

	/**
	 * Determines the language to use in each button
	 * @param target the button affected
	 * @return if @param target == null the language. If not translates the button to the selected language
	 */
	public String lang(Button target) {
		try {
			if (!props.file.exists()) {
				props.create();
				if (System.getProperty("user.language").equals("es")) {
					es(target);
				}
				else {
					en(target);
				}
				return System.getProperty("user.language");
			} else {
				if (props.existsKey("lang")) {
					if (props.getLang().equals("es"))
						es(target);
					else
						en(target);
					return props.getLang();
				} else {
					if (System.getProperty("user.language").equals("es")) {
						es(target);
					}
					else {
						en(target);
					}
					return System.getProperty("user.language");
				}
			}
		} catch (IOException io) {
			if (System.getProperty("user.language").equals("es"))
				BSMException.fillGaps("Ha ocurrido un error al cargar el idioma, se establecera el predeterminado");
			else
				BSMException.fillGaps("An error occurred while loading the language, using the default one");
			return System.getProperty("user.language");
		}
	}
}
