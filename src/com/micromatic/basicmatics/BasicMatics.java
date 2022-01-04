package com.micromatic.basicmatics;

import org.eclipse.swt.widgets.*;

import com.micromatic.basicmatics.settings.*;

import org.eclipse.swt.events.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;

/**
 * The main class
 */
public class BasicMatics {

	/**Main shell*/
	public static Shell shell = new Shell();
	/**Default display*/
	public Display display = Display.getDefault();

	/**Main composite*/
	protected static Composite composite = new Composite(shell, SWT.NONE);
	/**Goes to the Main Divide Page*/
	public static Button dvdm = new Button(composite, SWT.FLAT);
	/**Goes to the Main Multiply Page*/
	public static Button mtplm = new Button(composite, SWT.FLAT);
	/**Goes to the Main Subtract Page*/
	public static Button restm = new Button(composite, SWT.FLAT);
	/**Goes to the Main Add Up Page*/
	public static Button sumem = new Button(composite, SWT.FLAT);
	/**Goes to the Settings Page*/
	public static Button settings;
	/**Hosts the main image*/
	public static Label label = new Label(shell, SWT.NONE);
	/**Instance ofe Settings*/
	protected static final Settings set = new Settings();

	/**The composite for the back and home buttons*/
	protected Composite backcomp = new Composite(shell, SWT.NONE);
	/**Returns home*/
	protected Button home = new Button(backcomp, SWT.NONE);
	/**Goes to the last page*/
	protected Button back = new Button(backcomp, SWT.NONE);

	/**Button that goes to the divide page*/
	public static Button bdvd = new Button(composite, SWT.FLAT);
	/**Button that goes to the division rest page*/
	public static Button bdvdr = new Button(composite, SWT.FLAT);
	/**Button that divides*/
	public static Button dvd = new Button(composite, SWT.FLAT);
	/**Button that makes the division rest*/
	public static Button dvdr = new Button(composite, SWT.FLAT);
	/**Button that multiplies*/
	public static Button mtpl = new Button(composite, SWT.FLAT);
	/**Button that subtracts*/
	public static Button rest = new Button(composite, SWT.FLAT);
	/**Button that adds up*/
	public static Button sume = new Button(composite, SWT.FLAT);
	/**Cleans all*/
	public static Button clean = new Button(composite, SWT.FLAT | SWT.CENTER);
	
	/**
	 * Launch the application.
	 * @param args the arguments
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
		settings.setImage(new Image(display, getClass().getResourceAsStream("/icons/settings.png")));
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
		dvdm.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/divide.png")));
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
		mtplm.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/mtpl.png")));
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
		restm.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/rest.png")));
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
		sumem.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/sume.png")));
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
		home.setImage(new Image(display, getClass().getResourceAsStream("/icons/home.png")));
		if (set.lang(null).equals("es"))
			home.setToolTipText("Vuelve al Inicio");
		else
			home.setToolTipText("Go back to Home");
		
		back.setBounds(21, 0, 18, 18);
		back.setImage(new Image(display, getClass().getResourceAsStream("/icons/back.png")));
		if (set.lang(null).equals("es"))
			back.setToolTipText("Vuelve atr\u00e1s");
		else
			back.setToolTipText("Go back");
		
		backcomp.setVisible(false);
		
		clean.setBounds(236, 37, 75, 25);
		clean.setText("Clean");
		clean.setVisible(false);
		set.lang(clean);
	}

	/**
	 * Gets the default image for use per OS
	 * @return the Image corresponding the OS
	 */
	public Image os() {
		if (OS.name.contains("win")) {
			Settings.props.setOs("windows");
			Settings.os_combo.select(0);
			return new Image(display, getClass().getResourceAsStream("/icons/bsm-windows.png"));
		} else if (OS.name.contains("mac")) {
			Settings.props.setOs("apple");
			Settings.os_combo.select(1);
			return new Image(display, getClass().getResourceAsStream("/icons/bsm-apple.png"));
		} else if (OS.name.contains("nux")) {
			Settings.props.setOs("linux");
			Settings.os_combo.select(2);
			return new Image(display, getClass().getResourceAsStream("/icons/bsm-linux.png"));
		} else if (OS.name.contains("debian")) {
			Settings.props.setOs("debian");
			Settings.os_combo.select(3);
			return new Image(display, getClass().getResourceAsStream("/icons/bsm-debian.png"));
		} else if (OS.name.contains("ubuntu")) {
			Settings.props.setOs("ubuntu");
			Settings.os_combo.select(4);
			return new Image(display, getClass().getResourceAsStream("/icons/bsm-ubuntu.png"));
		} else {
			Settings.props.setOs("bsm");
			Settings.os_combo.select(5);
			return new Image(display, getClass().getResourceAsStream("/icons/bsm.png"));
		}
	}

	/**
	 *
	 * @return the Image for use in shell and title
	 */
	public Image osLoad() {
		try {
			Settings.props.in = new FileInputStream(Settings.props.file);
			if (!Settings.props.file.exists()) {
				Settings.props.create();
				return os();
			} else {
				Settings.props.in = new FileInputStream(Settings.props.file);
				Settings.props.props.load(Settings.props.in);
				Settings.props.in.close();
				if (!Settings.props.existsKey("os") ) {
					return os();
				} else {
					if (Settings.props.getOs().equals("bsm"))
						return new Image(display, getClass().getResourceAsStream("/icons/bsm.png"));
					else
						return new Image(display, getClass().getResourceAsStream("/icons/bsm-"+Settings.props.getOs()+".png"));
				}
			}
		} catch (IOException io) { io.printStackTrace(); return new Image(display, getClass().getResourceAsStream("/icons/bsm.png")); }
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
		
		label.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/bsm-divide.png")));
		bdvd.setBounds(51, 20, 75, 25);
		bdvd.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/divide.png")));
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
				
				clean.setVisible(true);
				clean.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						texta.setText("");
						textb.setText("");
						output.setText("");
					}
				});
				
				dvd.setBounds(125, 37, 102, 25);
				dvd.setText("Divide");
				set.lang(dvd);
				dvd.setVisible(true);
				dvd.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						try {
							double res = Ops.divide(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
							if ((res == Math.rint(res)) && !Double.isInfinite(res)) {
								output.setText(""+ (int) res);
							} else if (Settings.props.getAprox()) {
								output.setText(""+ (float) res);
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
						clean.setVisible(false);
					}
				});
				back.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						texta.setVisible(false);
						textb.setVisible(false);
						dvd.setVisible(false);
						back.setVisible(false);
						clean.setVisible(false);
						
						bdvd.setVisible(true);
						bdvdr.setVisible(true);
					}
				});
			}
		});
		set.lang(bdvd);
		
		
		bdvdr.setBounds(132, 20, 122, 25);
		bdvdr.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/divide.png")));
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
				
				clean.setVisible(true);
				clean.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						texta.setText("");
						textb.setText("");
						output.setText("");
					}
				});
				
				dvdr.setBounds(125, 37, 102, 25);
				dvdr.setText("Division Rest");
				dvdr.setVisible(true);
				set.lang(dvd);
				dvdr.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						try {
							double res = Ops.divideRest(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
							if ((res == Math.rint(res)) && !Double.isInfinite(res)) {
								output.setText(""+ (int) res);
							} else if (set.ap) {
								output.setText(""+ (float) res);
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
						clean.setVisible(false);
					}
				});
				back.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						texta.setVisible(false);
						textb.setVisible(false);
						dvdr.setVisible(false);
						back.setVisible(false);
						clean.setVisible(false);
						
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
		
		label.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/bsm-mtpl.png")));
		Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		output.setBounds(95, 226, 233, 32);
		
		output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
		
		Text texta = new Text(composite, SWT.BORDER);
		texta.setBounds(45, 10, 115, 21);
		
		Text textb = new Text(composite, SWT.BORDER);
		textb.setBounds(183, 10, 130, 21);
		
		clean.setVisible(true);
		clean.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				texta.setText("");
				textb.setText("");
				output.setText("");
			}
		});
		
		mtpl.setBounds(125, 37, 102, 25);
		mtpl.setText("Multiply");
		set.lang(mtpl);
		mtpl.setVisible(true);
		mtpl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					double res = Ops.mtpl(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
					if ((res == Math.rint(res)) && !Double.isInfinite(res)) {
						output.setText(""+ (int) res);
					} else if (Settings.props.getAprox()) {
						output.setText(""+ (float) res);
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
				clean.setVisible(false);
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
		
		label.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/bsm-rest.png")));
		Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		output.setBounds(95, 226, 233, 32);
		
		output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
		
		Text texta = new Text(composite, SWT.BORDER);
		texta.setBounds(45, 10, 115, 21);
		
		Text textb = new Text(composite, SWT.BORDER);
		textb.setBounds(183, 10, 130, 21);
		
		clean.setVisible(true);
		clean.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				texta.setText("");
				textb.setText("");
				output.setText("");
			}
		});
		
		rest.setBounds(125, 37, 102, 25);
		rest.setText("Rest");
		set.lang(rest);
		rest.setVisible(true);
		rest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					double res = Ops.rest(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
					if ((res == Math.rint(res)) && !Double.isInfinite(res)) {
						output.setText(""+ (int) res);
					} else if (Settings.props.getAprox()) {
						output.setText(""+ (float) res);
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
				clean.setVisible(false);
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
		
		label.setImage(new Image(display, getClass().getResourceAsStream("/icons/ops/bsm-sume.png")));
		Text output = new Text(shell, SWT.READ_ONLY | SWT.CENTER);
		output.setBounds(95, 226, 233, 32);
		
		output.setFont(new Font(display, "Segoe UI", 20, SWT.BOLD));
		
		Text texta = new Text(composite, SWT.BORDER);
		texta.setBounds(45, 10, 115, 21);
		
		Text textb = new Text(composite, SWT.BORDER);
		textb.setBounds(183, 10, 130, 21);
		
		clean.setVisible(true);
		clean.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				texta.setText("");
				textb.setText("");
				output.setText("");
			}
		});
		
		sume.setBounds(125, 37, 102, 25);
		sume.setText("Add Up");
		set.lang(sume);
		sume.setVisible(true);
		sume.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					double res = Ops.sume(Double.parseDouble(texta.getText()), Double.parseDouble(textb.getText()));
					if ((res == Math.rint(res)) && !Double.isInfinite(res)) {
						output.setText(""+ (int) res);
					} else if (Settings.props.getAprox()) {
						output.setText(""+ (float) res);
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
				clean.setVisible(false);
			}
		});
	}
}