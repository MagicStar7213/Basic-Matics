package com.micromatic.basicmatics;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

/**Exception Handler*/
@SuppressWarnings("serial")
public class BSMException extends Exception {
	/**
	 * Handles errors in the app
	 * @param exc the message of warning
	 */
	public static void dialogStackTrace(String exc) {
		MessageBox dialog = new MessageBox(BasicMatics.shell, SWT.OK | SWT.CANCEL | SWT.ICON_ERROR);
		dialog.setText("Error");
		dialog.setMessage(exc);
		if (dialog.open() == SWT.CANCEL)
			BasicMatics.shell.close();
	}

	/**
	 * Launches a warning to fill the gaps
	 * @param exc the warning message
	 */
	public static void fillGaps(String exc) {
		MessageBox dialog = new MessageBox(BasicMatics.shell, SWT.OK | SWT.ICON_ERROR);
		dialog.setText("Error");
		dialog.setMessage(exc);
		if (dialog.open() == SWT.OK);
	}
}