package com.micromatic.basicmatics.settings

import com.micromatic.basicmatics.*
import org.eclipse.swt.SWT
import org.eclipse.swt.events.*
import org.eclipse.swt.widgets.*
import org.eclipse.swt.graphics.*
import java.io.*

open class Settings {
    /**Settings display */
    var display = Display.getCurrent()

    /**Main composite */
    private val parent = Composite(shell, SWT.NONE)

    /**Language combo */
    private val combo = Combo(parent, SWT.READ_ONLY)

    /**Approximation button */
    var aprox: Button? = null

    /**Detects if it is aproximated  */
    var ap = props.aprox

    /**Title composite */
    private var composite: Composite? = null

    /**Title image */
    private var prefimg: Label? = null

    /**Title */
    private var title: Label? = null

    /**Text in the language combo */
    private var combo_text: Text? = null

    /**Text in the os image combo */
    private var oscombo_text: Text? = null

    /**General Title */
    private val general = Text(parent, SWT.READ_ONLY or SWT.CENTER)

    /**Customisation */
    private val custom = Text(parent1, SWT.READ_ONLY or SWT.CENTER)

    /**Default composite */
    private val def_comp = Composite(shell, SWT.NONE)

    /**Restore Default button */
    private val def = Button(def_comp, SWT.NONE)

    private val load = Load(BasicMatics.display)

    private val targetArray = arrayOf(aprox, def)
    private val textArray = arrayOf(combo_text, oscombo_text, general, custom)

    /**
     * Open the window.
     */
    fun open() {
        createContents()
        shell.open()
        shell.layout()
        while (!shell.isDisposed) {
            if (!display.readAndDispatch()) {
                display.sleep()
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected fun createContents() {
        shell.setSize(450, 230)
        shell.text = "Settings"
        shell.image = Image(display, javaClass.getResourceAsStream("/icons/@x45/settings.png"))
        parent.setBounds(10, 71, 177, 90)
        parent1.setBounds(209, 10, 215, 141)
        os_combo.setBounds(10, 34, 91, 23)
        os_combo.setItems(*arrayOf("Windows", "macOS", "Linux", "Debian", "Ubuntu", "Basic Matics"))
        oscombo_text = Text(parent1, SWT.READ_ONLY)
        oscombo_text!!.setBounds(107, 37, 108, 15)
        oscombo_text!!.text = "OS Image"
        os_combo.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                try {
                    props.`in` = FileInputStream(props.file)
                    props.props.load(props.`in`)
                    when (os_combo.selectionIndex) {
                        0 -> {
                            BasicMatics.label.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-windows.png"))
                            BasicMatics.shell.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-windows.png"))
                            props.os = "windows"
                        }
                        1 -> {
                            BasicMatics.label.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-apple.png"))
                            BasicMatics.shell.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-apple.png"))
                            props.os = "apple"
                        }
                        2 -> {
                            BasicMatics.label.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-linux.png"))
                            BasicMatics.shell.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-linux.png"))
                            props.os = "linux"
                        }
                        3 -> {
                            BasicMatics.label.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-debian.png"))
                            BasicMatics.shell.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-debian.png"))
                            props.os = "debian"
                        }
                        4 -> {
                            BasicMatics.label.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-ubuntu.png"))
                            BasicMatics.shell.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm-ubuntu.png"))
                            props.os = "ubuntu"
                        }
                        5 -> {
                            BasicMatics.label.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm.png"))
                            BasicMatics.shell.image =
                                Image(bsm.display, javaClass.getResourceAsStream("/icons/bsm.png"))
                            props.os = "bsm"
                        }
                    }
                } catch (ignored: IOException) {
                }
            }
        })
        combo.setItems(*arrayOf("English", "Spanish"))
        combo.setBounds(10, 35, 91, 23)
        combo.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                for (a in targetArray) {
                    if (combo.selectionIndex == 1)
                        Language("es", a, null)
                    else
                        Language("en", a, null)
                }
                for (a in textArray) {
                    if (combo.selectionIndex == 1)
                        Language("es", null, a)
                    else
                        Language("en", null, a)
                }
            }
        })
        aprox = Button(parent, SWT.CHECK)
        aprox!!.setBounds(10, 64, 140, 16)
        aprox!!.text = "Aproximated result"
        load.lang(aprox)
        combo_text = Text(parent, SWT.READ_ONLY or SWT.CENTER)
        combo_text!!.text = "Language"
        combo_text!!.setBounds(107, 38, 60, 16)
        general.text = "General"
        general.setBounds(10, 10, 91, 21)
        general.font = Font(display, "Segoe UI", 10, SWT.BOLD)
        custom.text = "Customization"
        custom.setBounds(10, 7, 121, 21)
        custom.font = Font(display, "Segoe UI", 10, SWT.BOLD)
        try {
            props.`in` = FileInputStream(props.file)
            props.props.load(props.`in`)
            props.`in`!!.close()
            if (props.os == "windows") os_combo.select(0) else if (props.os == "apple") os_combo.select(1) else if (props.os == "linux") os_combo.select(
                2
            ) else if (props.os == "debian") os_combo.select(3) else if (props.os == "ubuntu") os_combo.select(4) else os_combo.select(
                5
            )
        } catch (io: IOException) {
            io.printStackTrace()
        }
        if (props.aprox) aprox!!.selection = true else aprox!!.selection = false
        composite = Composite(shell, SWT.NONE)
        composite!!.setBounds(10, 10, 140, 55)
        prefimg = Label(composite, SWT.NONE)
        prefimg!!.setBounds(10, 3, 50, 50)
        prefimg!!.image = Image(display, javaClass.getResourceAsStream("/icons/@x45/settings.png"))
        title = Label(composite, SWT.CENTER)
        title!!.setBounds(63, 18, 77, 27)
        title!!.text = "Settings"
        title!!.font = Font(display, "Segoe UI", 14, SWT.BOLD)
        def_comp.setBounds(209, 157, 215, 24)
        def.setBounds(10, 0, 92, 25)
        def.text = "Restore Default"
        def.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                for (a in targetArray) {
                    if (combo.selectionIndex == 1)
                        Language("es", a, null)
                    else
                        Language("en", a, null)
                }
                for (a in textArray) {
                    if (combo.selectionIndex == 1)
                        Language("es", null, a)
                    else
                        Language("en", null, a)
                }
                BasicMatics.shell.image = load.os()
                BasicMatics.label.image = load.os()
                aprox!!.selection = false
                props.aprox = false
            }
        })
        load.lang(def)
        aprox!!.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                val btn = e.source as Button
                if (btn.selection) {
                    ap = true
                    props.aprox = ap
                } else {
                    ap = false
                    props.aprox = ap
                }
            }
        })
        if (BSMProperties().lang == "es") {
            combo.setItem(0, "Ingl\u00e9s")
            combo.setItem(1, "Español")
            combo.select(1)
        } else {
            combo.setItem(0, "English")
            combo.setItem(1, "Spanish")
            combo.select(0)
        }
    }

    companion object {
        /**Settings shell */
        var shell = Shell(SWT.TITLE or SWT.APPLICATION_MODAL or SWT.CLOSE or SWT.DIALOG_TRIM)

        /**Second Main composite */
        private val parent1 = Composite(shell, SWT.NONE)

        /**Properties class */
        val props = BSMProperties()

        /**Image combo */
        var os_combo = Combo(parent1, SWT.READ_ONLY)

        /**Main Class */
        private val bsm = BasicMatics
    }
}