package com.micromatic.basicmatics;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

@SuppressWarnings("serial")
public class BSMException extends Exception {
	
	public static void dialogStackTrace(String exc) {
		MessageBox dialog = new MessageBox(BasicMatics.shell, SWT.OK | SWT.CANCEL | SWT.ICON_ERROR);
		dialog.setText("Error");
		dialog.setMessage(exc);
		if (dialog.open() == SWT.CANCEL)
			BasicMatics.shell.close();
	}
	
	public static void fillGaps(String exc) {
		MessageBox dialog = new MessageBox(BasicMatics.shell, SWT.OK | SWT.ICON_ERROR);
		dialog.setText("Error");
		dialog.setMessage(exc);
		if (dialog.open() == SWT.OK);
	}
}