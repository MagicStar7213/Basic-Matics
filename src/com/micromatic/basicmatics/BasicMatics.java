package com.micromatic.basicmatics;

import org.eclipse.swt.widgets.*;

import com.micromatic.basicmatics.settings.*;

import org.eclipse.swt.events.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;

public class BasicMatics {

	public static Shell shell = new Shell();
	public Display display = Display.getDefault();
	
	protected static Composite composite = new Composite(shell, SWT.NONE);
	public static Button dvdm = new Button(composite, SWT.FLAT);
	public static Button mtplm = new Button(composite, SWT.FLAT);
	public static Button restm = new Button(composite, SWT.FLAT);
	public static Button sumem = new Button(composite, SWT.FLAT);
	public static Button settings;
	public static Label label = new Label(shell, SWT.NONE);
	protected static final Settings set = new Settings();
	
	protected Composite backcomp = new Composite(shell, SWT.NONE);
	protected Button home = new Button(backcomp, SWT.NONE);
	protected Button back = new Button(backcomp, SWT.NONE);
	
	public static Button bdvd = new Button(composite, SWT.FLAT);
	public static Button bdvdr = new Button(composite, SWT.FLAT);
	public static Button dvd = new Button(composite, SWT.FLAT);
	public static Button dvdr = new Button(composite, SWT.FLAT);
		
	public static Button mtpl = new Button(composite, SWT.FLAT);
		
	public static Button rest = new Button(composite, SWT.FLAT);
		
	public static Button sume = new Button(composite, SWT.FLAT);
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BasicMatics window = new BasicMatics();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();
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
		shell.setSize(450, 300);
		shell.setText("Basic Matics");
		shell.setImage(osLoad());
		
		settings = new Button(shell, SWT.CENTER);
		settings.setImage(new Image(display, "icons/settings.png"));
		settings.setBounds(399, 10, 25, 25);
		settings.setToolTipText("Access the settings page");
		settings.setText("");
		settings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				set.open();
			}
		});
		set.lang(settings);
		
		label.setBounds(133, 10, 128, 128);
		label.setImage(osLoad());
		
		composite.setBounds(35, 156, 358, 64);
		
		dvdm.setBounds(10, 20, 75, 25);
		dvdm.setImage(new Image(display, "icons/ops/divide.png"));
		dvdm.setText("Divide");
		dvdm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				divide();
				bdvd.setVisible(true);
				bdvdr.setVisible(true);
			}
		});
		set.lang(dvdm);
		
		mtplm.setBounds(91, 20, 95, 25);
		mtplm.setImage(new Image(display, "icons/ops/mtpl.png"));
		mtplm.setText("Multiply");
		mtplm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mtpl();
				mtpl.setVisible(true);
			}
		});
		set.lang(mtplm);
		
		restm.setBounds(192, 20, 75, 25);
		restm.setImage(new Image(display, "icons/ops/rest.png"));
		restm.setText("Subtract");
		restm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				rest();
				rest.setVisible(true);
			}
		});
		set.lang(restm);
		
		sumem.setBounds(273, 20, 75, 25);
		sumem.setImage(new Image(display, "icons/ops/sume.png"));
		sumem.setText("Add Up");
		sumem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sume();
				sume.setVisible(true);
			}
		});
		set.lang(sumem);
		
		backcomp.setBounds(10, 10, 45, 18);
		
		home.setBounds(0, 0, 18, 18);
		home.setImage(new Image(display, "icons/home.png"));
		if (set.lang(null).equals("es"))
			home.setToolTipText("Vuelve al Inicio");
		else
			home.setToolTipText("Go back to Home");
		
		back.setBounds(21, 0, 18, 18);
		back.setImage(new Image(display, "icons/back.png"));
		if (set.lang(null).equals("es"))
			back.setToolTipText("Vuelve atr\u00e1s");
		else
			back.setToolTipText("Go back");
		
		backcomp.setVisible(false);
	}
	
	public Image os() {
		if (OS.name.indexOf("win") >= 0) {
			Settings.props.setOs("windows");
			Settings.os_combo.select(0);
			return new Image(display, "icons/bsm-windows.png");
		} else if (OS.name.indexOf("mac") >= 0) {
			Settings.props.setOs("apple");
			Settings.os_combo.select(1);
			return (new Image(display, "icons/bsm-apple.png"));
		} else if (OS.name.indexOf("nux") >= 0) {
			Settings.props.setOs("linux");
			Settings.os_combo.select(2);
			return new Image(display, "icons/bsm-linux.png");
		} else if (OS.name.indexOf("debian") >= 0) {
			Settings.props.setOs("debian");
			Settings.os_combo.select(3);
			return new Image(display, "icons/bsm-debian.png");
		} else if (OS.name.indexOf("ubuntu") >= 0) {
			Settings.props.setOs("ubuntu");
			Settings.os_combo.select(4);
			return new Image(display, "icons/bsm-ubuntu.png");
		} else {
			Settings.props.setOs("bsm");
			Settings.os_combo.select(5);
			return new Image(display, "icons/bsm.png");
		}
	}
	
	public Image osLoad() {
		try {
			Settings.props.in = new FileInputStream(Settings.props.file);
			if (!Settings.props.file.exists()) {
				Settings.props.create();
				Settings.props.props.load(Settings.props.in);
				Settings.props.in.close();
				return os();
			} else {
				Settings.props.props.load(Settings.props.in);
				Settings.props.in.close();
				if (!Settings.props.existsKey("os") ) {
					return os();
				} else {
					if (Settings.props.getOs().equals("bsm"))
						return new Image(display, "icons/bsm.png");
					else
						return new Image(display, "icons/bsm-"+Settings.props.getOs()+".png");
				}
			}
		} catch (IOException io) { io.printStackTrace(); return new Image(display, "icons/bsm.png"); }
	}
	
	/**
	 * Creates the dividing interface
	 * @since Beta 1.3
	 */
	
	public void divide() {
		if (set.lang(null).equals("es"))
			shell.setText("Basic Matics - Divisi\u00f3n");
		else
			shell.setText("Basic Matics - Division");
		backcomp.setVisible(true);
		home.setVisible(true);
		back.setVisible(false);
		
		dvdm.setVisible(false);
		mtplm.setVisible(false);
		restm.setVisible(false);
		sumem.setVisible(false);
		
		label.setImage(new Image(display, "icons/ops/bsm-divide.png"));
		bdvd.setBounds(51, 20, 75, 25);
		bdvd.setImage(new Image(display, "icons/ops/divide.png"));
		bdvd.setText("Divide");
		bdvd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				home.setVisible(true);
				back.setVisible(true);
				
				bdvd.setVisible(false);
				bdvdr.setVisible(false);
				
				Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
				output.setBounds(95, 226, 233, 32);
				
				output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
				
				Text texta = new Text(composite, SWT.BORDER);
				texta.setBounds(45, 10, 115, 21);
				
				Text textb = new Text(composite, SWT.BORDER);
				textb.setBounds(183, 10, 130, 21);
				
				dvd.setBounds(125, 37, 102, 25);
				dvd.setText("Divide");
				set.lang(dvd);
				dvd.setVisible(true);
				dvd.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						try {
							Double res = Ops.divide(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
							int index = res.toString().indexOf(".");
							if (res.toString().substring(index+1).equals("0")) {
								output.setText(""+res.intValue());
							} else if (Settings.props.getAprox()) {
								output.setText(""+res.floatValue());
							} else {
								output.setText(""+res);
							}
						} catch (NumberFormatException nfe) {
							if (set.lang(null).equals("es"))
								BSMException.fillGaps("Rellena todos los huecos");
							else
								BSMException.fillGaps("Fill all the gaps");
						}
					}
				});
				
				home.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						dvd.setVisible(false);
						texta.setVisible(false);
						textb.setVisible(false);
						
						label.setImage(osLoad());
						dvdm.setVisible(true);
						mtplm.setVisible(true);
						sumem.setVisible(true);
						restm.setVisible(true);
						
						back.setVisible(false);
						home.setVisible(false);
					}
				});
				back.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						texta.setVisible(false);
						textb.setVisible(false);
						dvd.setVisible(false);
						back.setVisible(false);
						
						bdvd.setVisible(true);
						bdvdr.setVisible(true);
					}
				});
			}
		});
		set.lang(bdvd);
		
		
		bdvdr.setBounds(132, 20, 122, 25);
		bdvdr.setImage(new Image(display, "icons/ops/divide.png"));
		bdvdr.setText("Division Rest");
		bdvdr.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				back.setVisible(true);
				
				bdvd.setVisible(false);
				bdvdr.setVisible(false);
				
				Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
				output.setBounds(95, 226, 233, 32);
				
				output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
				
				Text texta = new Text(composite, SWT.BORDER);
				texta.setBounds(45, 10, 115, 21);
				
				Text textb = new Text(composite, SWT.BORDER);
				textb.setBounds(183, 10, 130, 21);
				
				dvdr.setBounds(125, 37, 102, 25);
				dvdr.setText("Division Rest");
				dvdr.setVisible(true);
				set.lang(dvd);
				dvdr.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						try {
							Double res = Ops.divideRest(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
							int index = res.toString().indexOf(".");
							if (res.toString().substring(index+1).equals("0")) {
								output.setText(""+res.intValue());
							} else if (Settings.props.getAprox()) {
								output.setText(""+res.floatValue());
							} else {
								output.setText(""+res);
							}
						} catch (NumberFormatException nfe) {
							if (set.lang(null).equals("es"))
								BSMException.fillGaps("Rellena todos los huecos");
							else
								BSMException.fillGaps("Fill all the gaps");
						}
					}
				});
				
				home.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						dvdr.setVisible(false);
						texta.setVisible(false);
						textb.setVisible(false);
						
						label.setImage(osLoad());
						dvdm.setVisible(true);
						mtplm.setVisible(true);
						sumem.setVisible(true);
						restm.setVisible(true);
						
						back.setVisible(false);
						home.setVisible(false);
					}
				});
				back.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						texta.setVisible(false);
						textb.setVisible(false);
						dvdr.setVisible(false);
						back.setVisible(false);
						
						bdvd.setVisible(true);
						bdvdr.setVisible(true);
					}
				});
			}
		});
		set.lang(bdvdr);
		home.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bdvd.setVisible(false);
				bdvdr.setVisible(false);
				
				label.setImage(osLoad());
				dvdm.setVisible(true);
				mtplm.setVisible(true);
				sumem.setVisible(true);
				restm.setVisible(true);
				
				back.setVisible(false);
				home.setVisible(false);
			}
		});
	}
	
	/**
	 * Creates the multiplying interface
	 * @since Beta 1.3
	 */
	
	public void mtpl() {
		if (set.lang(null).equals("es"))
			shell.setText("Basic Matics - Multiplicaci\u00f3n");
		else
			shell.setText("Basic Matics - Multiplication");
		backcomp.setVisible(true);
		home.setVisible(true);
		back.setVisible(false);
		
		dvdm.setVisible(false);
		mtplm.setVisible(false);
		restm.setVisible(false);
		sumem.setVisible(false);
		
		label.setImage(new Image(display, "icons/ops/bsm-mtpl.png"));
		Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		output.setBounds(95, 226, 233, 32);
		
		output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
		
		Text texta = new Text(composite, SWT.BORDER);
		texta.setBounds(45, 10, 115, 21);
		
		Text textb = new Text(composite, SWT.BORDER);
		textb.setBounds(183, 10, 130, 21);
		
		mtpl.setBounds(125, 37, 102, 25);
		mtpl.setText("Multiply");
		set.lang(mtpl);
		mtpl.setVisible(true);
		mtpl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Double res = Ops.mtpl(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
					int index = res.toString().indexOf(".");
					if (res.toString().substring(index+1).equals("0")) {
						output.setText(""+res.intValue());
					} else if (Settings.props.getAprox()) {
						output.setText(""+res.floatValue());
					} else {
						output.setText(""+res);
					}
				} catch (NumberFormatException nfe) {
					if (set.lang(null).equals("es"))
						BSMException.fillGaps("Rellena todos los huecos");
					else
						BSMException.fillGaps("Fill all the gaps");
				}
			}
		});
		
		home.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				mtpl.setVisible(false);
				texta.setVisible(false);
				textb.setVisible(false);
				
				label.setImage(osLoad());
				dvdm.setVisible(true);
				mtplm.setVisible(true);
				sumem.setVisible(true);
				restm.setVisible(true);
				
				back.setVisible(false);
				home.setVisible(false);
			}
		});
	}
	
	/**
	 * Creates the subtracting interface
	 * @since Beta 1.3
	 */
	
	public void rest() {
		if (set.lang(null).equals("es"))
			shell.setText("Basic Matics - Resta");
		else
			shell.setText("Basic Matics - Subtraction");
		backcomp.setVisible(true);
		home.setVisible(true);
		back.setVisible(false);
		
		dvdm.setVisible(false);
		mtplm.setVisible(false);
		restm.setVisible(false);
		sumem.setVisible(false);
		
		label.setImage(new Image(display, "icons/ops/bsm-rest.png"));
		Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		output.setBounds(95, 226, 233, 32);
		
		output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
		
		Text texta = new Text(composite, SWT.BORDER);
		texta.setBounds(45, 10, 115, 21);
		
		Text textb = new Text(composite, SWT.BORDER);
		textb.setBounds(183, 10, 130, 21);
		
		rest.setBounds(125, 37, 102, 25);
		rest.setText("Rest");
		set.lang(rest);
		rest.setVisible(true);
		rest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Double res = Ops.rest(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
					int index = res.toString().indexOf(".");
					if (res.toString().substring(index+1).equals("0")) {
						output.setText(""+res.intValue());
					} else if (Settings.props.getAprox()) {
						output.setText(""+res.floatValue());
					} else {
						output.setText(""+res);
					}
				} catch (NumberFormatException nfe) {
					if (set.lang(null).equals("es"))
						BSMException.fillGaps("Rellena todos los huecos");
					else
						BSMException.fillGaps("Fill all the gaps");
				}
			}
		});
		
		home.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				rest.setVisible(false);
				texta.setVisible(false);
				textb.setVisible(false);
				
				label.setImage(osLoad());
				dvdm.setVisible(true);
				mtplm.setVisible(true);
				sumem.setVisible(true);
				restm.setVisible(true);
				
				back.setVisible(false);
				home.setVisible(false);
			}
		});
	}
	
	/**
	 * Creates the adding up interface
	 * @since Beta 1.3
	 */
	
	public void sume() {
		if (set.lang(null).equals("es"))
			shell.setText("Basic Matics - Suma");
		else
			shell.setText("Basic Matics - Addition");
		backcomp.setVisible(true);
		home.setVisible(true);
		back.setVisible(false);
		
		dvdm.setVisible(false);
		mtplm.setVisible(false);
		restm.setVisible(false);
		sumem.setVisible(false);
		
		label.setImage(new Image(display, "icons/ops/bsm-sume.png"));
		Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		output.setBounds(95, 226, 233, 32);
		
		output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
		
		Text texta = new Text(composite, SWT.BORDER);
		texta.setBounds(45, 10, 115, 21);
		
		Text textb = new Text(composite, SWT.BORDER);
		textb.setBounds(183, 10, 130, 21);
		
		sume.setBounds(125, 37, 102, 25);
		sume.setText("Add Up");
		set.lang(sume);
		sume.setVisible(true);
		sume.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Double res = Ops.rest(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
					int index = res.toString().indexOf(".");
					if (res.toString().substring(index+1).equals("0")) {
						output.setText(""+res.intValue());
					} else if (Settings.props.getAprox()) {
						output.setText(""+res.floatValue());
					} else {
						output.setText(""+res);
					}
				} catch (NumberFormatException nfe) {
					if (set.lang(null).equals("es"))
						BSMException.fillGaps("Rellena todos los huecos");
					else
						BSMException.fillGaps("Fill all the gaps");
				}
			}
		});
		
		home.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sume.setVisible(false);
				texta.setVisible(false);
				textb.setVisible(false);
				
				label.setImage(osLoad());
				dvdm.setVisible(true);
				mtplm.setVisible(true);
				sumem.setVisible(true);
				restm.setVisible(true);
				
				back.setVisible(false);
				home.setVisible(false);
			}
		});
	}
}