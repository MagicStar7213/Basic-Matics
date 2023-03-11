package com.micromatic.basicmatics

import com.micromatic.basicmatics.settings.*
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Display
import java.io.*

open class Load(val display: Display?) {

    /**
     * Gets the default image for use per OS
     * @return the Image corresponding the OS
     */
    fun os(): Image {
        return if (OS.name.contains("win")) {
            Settings.props.os = "windows"
            Settings.os_combo.select(0)
            Image(display!!, javaClass.getResourceAsStream("/icons/bsm-windows.png"))
        } else if (OS.name.contains("mac")) {
            Settings.props.os = "apple"
            Settings.os_combo.select(1)
            Image(display!!, javaClass.getResourceAsStream("/icons/bsm-apple.png"))
        } else if (OS.name.contains("nux")) {
            Settings.props.os = "linux"
            Settings.os_combo.select(2)
            Image(display!!, javaClass.getResourceAsStream("/icons/bsm-linux.png"))
        } else if (OS.name.contains("debian")) {
            Settings.props.os = "debian"
            Settings.os_combo.select(3)
            Image(display!!, javaClass.getResourceAsStream("/icons/bsm-debian.png"))
        } else if (OS.name.contains("ubuntu")) {
            Settings.props.os = "ubuntu"
            Settings.os_combo.select(4)
            Image(display!!, javaClass.getResourceAsStream("/icons/bsm-ubuntu.png"))
        } else {
            Settings.props.os = "bsm"
            Settings.os_combo.select(5)
            Image(display!!, javaClass.getResourceAsStream("/icons/bsm.png"))
        }
    }

    /**
     *
     * @return the Image for use in shell and title
     */
    fun osLoad(): Image {
        return try {
            Settings.props.`in` = FileInputStream(Settings.props.file)
            if (!Settings.props.file.exists()) {
                os()
            } else {
                Settings.props.`in` = FileInputStream(Settings.props.file)
                Settings.props.props.load(Settings.props.`in`)
                Settings.props.`in`!!.close()
                if (!Settings.props.existsKey("os")) {
                    os()
                } else {
                    if (Settings.props.os == "bsm") Image(
                        display,
                        javaClass.getResourceAsStream("/icons/bsm.png")
                    ) else Image(display, javaClass.getResourceAsStream("/icons/bsm-" + Settings.props.os + ".png"))
                }
            }
        } catch (io: IOException) {
            io.printStackTrace()
            Image(display, javaClass.getResourceAsStream("/icons/bsm.png"))
        }
    }

    /**
     * Determines the language to use in each button
     * @param target the button affected
     * @return if @param target == null the language. If not translates the button to the selected language
     */
    fun lang(target: Button?) {
        BSMProperties().lang?.let { Language(it, target, null) }
    }
}