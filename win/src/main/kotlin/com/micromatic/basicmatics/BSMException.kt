package com.micromatic.basicmatics

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.MessageBox

/**Exception Handler */
open class BSMException : Exception() {
    /**
     * Handles errors in the app
     * @param exc the message of warning
     */
    fun dialogStackTrace(exc: String?) {
        val dialog = MessageBox(BasicMatics.shell, SWT.OK or SWT.CANCEL or SWT.ICON_ERROR)
        dialog.text = "Error"
        dialog.message = exc
        if (dialog.open() == SWT.CANCEL) BasicMatics.shell.close()
    }

    /**
     * Launches a warning to fill the gaps
     * @param exc the warning message
     */
    fun fillGaps(exc: String?) {
        val dialog = MessageBox(BasicMatics.shell, SWT.OK or SWT.ICON_ERROR)
        dialog.text = "Error"
        dialog.message = exc
        if (dialog.open() == SWT.OK);
    }
}