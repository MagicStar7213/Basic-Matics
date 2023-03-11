package com.micromatic.basicmatics

import com.micromatic.basicmatics.settings.BSMProperties
import com.micromatic.basicmatics.settings.Settings
import org.eclipse.swt.SWT
import org.eclipse.swt.events.*
import org.eclipse.swt.graphics.*
import org.eclipse.swt.widgets.*

/**
 * The main class
 */
open class BasicMatics {

    /**The composite for the back and home buttons */
    protected var backcomp = Composite(shell, SWT.NONE)

    /**Returns home */
    protected var home = Button(backcomp, SWT.NONE)

    /**Goes to the last page */
    protected var back = Button(backcomp, SWT.NONE)

    private val bsmexc = BSMException()
    private val load = Load(display)

    /**
     * Open the window.
     */
    fun open() {
        createContents()
        shell.open()
        shell.layout()
        while (!shell.isDisposed) {
            if (!display.readAndDispatch())
                display.sleep()
        }
    }

    /**
     * Create contents of the window.
     */
    private fun createContents() {
        shell.setSize(450, 300)
        shell.text = "Basic Matics"
        shell.image = load.osLoad()
        settings = Button(shell, SWT.CENTER)
        settings!!.image = Image(display, javaClass.getResourceAsStream("/icons/settings.png"))
        settings!!.setBounds(399, 10, 25, 25)
        settings!!.toolTipText = "Access the settings page"
        settings!!.text = ""
        settings!!.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                set.open()
            }
        })
        load.lang(settings)
        label.setBounds(133, 10, 128, 128)
        label.image = load.osLoad()
        composite.setBounds(35, 156, 358, 64)
        divm.setBounds(10, 20, 75, 25)
        divm.image = Image(display, javaClass.getResourceAsStream("/icons/ops/divide.png"))
        divm.text = "Divide"
        divm.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                div()
                bdiv.isVisible = true
                bdiv.isVisible = true
            }
        })
        load.lang(divm)
        mtpm.setBounds(91, 20, 95, 25)
        mtpm.image = Image(display, javaClass.getResourceAsStream("/icons/ops/mtpl.png"))
        mtpm.text = "Multiply"
        mtpm.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                mtp()
                mtp.isVisible = true
            }
        })
        load.lang(mtpm)
        subm.setBounds(192, 20, 75, 25)
        subm.image = Image(display, javaClass.getResourceAsStream("/icons/ops/rest.png"))
        subm.text = "Rest"
        subm.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                sub()
                sub.isVisible = true
            }
        })
        load.lang(subm)
        addm.setBounds(273, 20, 75, 25)
        addm.image = Image(display, javaClass.getResourceAsStream("/icons/ops/sume.png"))
        addm.text = "Sume"
        addm.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                add()
                add.isVisible = true
            }
        })
        load.lang(addm)
        backcomp.setBounds(10, 10, 45, 18)
        home.setBounds(0, 0, 18, 18)
        home.image = Image(display, javaClass.getResourceAsStream("/icons/home.png"))
        if (BSMProperties().lang == "es") home.toolTipText = "Vuelve al Inicio" else home.toolTipText = "Go back to Home"
        back.setBounds(21, 0, 18, 18)
        back.image = Image(display, javaClass.getResourceAsStream("/icons/back.png"))
        if (BSMProperties().lang == "es") back.toolTipText = "Vuelve atr\u00e1s" else back.toolTipText = "Go back"
        backcomp.isVisible = false
        clean.setBounds(236, 37, 75, 25)
        clean.text = "Clean"
        clean.isVisible = false
        load.lang(clean)
    }

    /**
     * Creates the dividing interface
     * @since Beta 1.3
     */
    fun div() {
        if (BSMProperties().lang == "es") shell.text = "Basic Matics - Divisi\u00f3n" else shell.text =
            "Basic Matics - Division"
        backcomp.isVisible = true
        home.isVisible = true
        back.isVisible = false
        divm.isVisible = false
        mtpm.isVisible = false
        subm.isVisible = false
        addm.isVisible = false
        label.image = Image(display, javaClass.getResourceAsStream("/icons/ops/bsm-divide.png"))
        bdiv.setBounds(51, 20, 75, 25)
        bdiv.image = Image(display, javaClass.getResourceAsStream("/icons/ops/divide.png"))
        bdiv.text = "Divide"
        bdiv.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                home.isVisible = true
                back.isVisible = true
                bdiv.isVisible = false
                bdivr.isVisible = false
                val output = Text(shell, SWT.READ_ONLY or SWT.CENTER)
                output.setBounds(95, 226, 233, 32)
                output.font = Font(display, "Segoe UI", 20, SWT.BOLD)
                val texta = Text(composite, SWT.BORDER)
                texta.setBounds(45, 10, 115, 21)
                val textb = Text(composite, SWT.BORDER)
                textb.setBounds(183, 10, 130, 21)
                clean.isVisible = true
                clean.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        texta.text = ""
                        textb.text = ""
                        output.text = ""
                    }
                })
                div.setBounds(125, 37, 102, 25)
                div.text = "Divide"
                load.lang(div)
                div.isVisible = true
                div.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        try {
                            val res = texta.text.toDouble() / textb.text.toDouble()
                            if (res % 1 == 0.0) {
                                output.text = "" + res.toInt()
                            } else if (Settings.props.aprox) {
                                output.text = "" + res.toFloat()
                            } else {
                                output.text = "" + res
                            }
                        } catch (nfe: NumberFormatException) {
                            if (BSMProperties().lang == "es") bsmexc.fillGaps("Rellena todos los huecos") else bsmexc.fillGaps(
                                "Fill all the gaps"
                            )
                        }
                    }
                })
                home.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        div.isVisible = false
                        texta.isVisible = false
                        textb.isVisible = false
                        label.image = load.osLoad()
                        divm.isVisible = true
                        mtpm.isVisible = true
                        addm.isVisible = true
                        subm.isVisible = true
                        back.isVisible = false
                        home.isVisible = false
                        clean.isVisible = false
                    }
                })
                back.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        texta.isVisible = false
                        textb.isVisible = false
                        div.isVisible = false
                        back.isVisible = false
                        clean.isVisible = false
                        bdiv.isVisible = true
                        bdivr.isVisible = true
                    }
                })
            }
        })
        load.lang(bdiv)
        bdivr.setBounds(132, 20, 122, 25)
        bdivr.image = Image(display, javaClass.getResourceAsStream("/icons/ops/divide.png"))
        bdivr.text = "Division Rest"
        bdivr.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                back.isVisible = true
                divr.isVisible = false
                divr.isVisible = false
                val output = Text(shell, SWT.READ_ONLY or SWT.CENTER)
                output.setBounds(95, 226, 233, 32)
                output.font = Font(display, "Segoe UI", 20, SWT.BOLD)
                val texta = Text(composite, SWT.BORDER)
                texta.setBounds(45, 10, 115, 21)
                val textb = Text(composite, SWT.BORDER)
                textb.setBounds(183, 10, 130, 21)
                clean.isVisible = true
                clean.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        texta.text = ""
                        textb.text = ""
                        output.text = ""
                    }
                })
                divr.setBounds(125, 37, 102, 25)
                divr.text = "Division Rest"
                divr.isVisible = true
                load.lang(div)
                divr.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        try {
                            val res = texta.text.toDouble() % textb.text.toDouble()
                            if (res % 1 == 0.0)
                                output.text = "" + res.toInt()
                            else if (Settings.props.aprox)
                                output.text = "" + res.toFloat()
                            else
                                output.text = "" + res
                        } catch (nfe: NumberFormatException) {
                            if (BSMProperties().lang == "es")
                                bsmexc.fillGaps(
                                    "Ha habido un error"
                                )
                            else
                                bsmexc.fillGaps(
                                    "An error occured"
                                )
                        }
                    }
                })
                home.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        divr.isVisible = false
                        texta.isVisible = false
                        textb.isVisible = false
                        label.image = load.osLoad()
                        divm.isVisible = true
                        mtpm.isVisible = true
                        addm.isVisible = true
                        subm.isVisible = true
                        back.isVisible = false
                        home.isVisible = false
                        clean.isVisible = false
                    }
                })
                back.addSelectionListener(object : SelectionAdapter() {
                    override fun widgetSelected(e: SelectionEvent) {
                        texta.isVisible = false
                        textb.isVisible = false
                        divr.isVisible = false
                        back.isVisible = false
                        clean.isVisible = false
                        bdiv.isVisible = true
                        bdivr.isVisible = true
                    }
                })
            }
        })
        load.lang(bdivr)
        home.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                bdivr.isVisible = false
                bdivr.isVisible = false
                label.image = load.osLoad()
                divm.isVisible = true
                mtpm.isVisible = true
                addm.isVisible = true
                subm.isVisible = true
                back.isVisible = false
                home.isVisible = false
            }
        })
    }

    /**
     * Creates the multiplying interface
     * @since Beta 1.3
     */
    fun mtp() {
        if (BSMProperties().lang == "es") shell.text = "Basic Matics - Multiplicaci\u00f3n" else shell.text =
            "Basic Matics - Multiplication"
        backcomp.isVisible = true
        home.isVisible = true
        back.isVisible = false
        divm.isVisible = false
        mtpm.isVisible = false
        addm.isVisible = false
        subm.isVisible = false
        label.image = Image(display, javaClass.getResourceAsStream("/icons/ops/bsm-mtpl.png"))
        val output = Text(shell, SWT.READ_ONLY or SWT.CENTER)
        output.setBounds(95, 226, 233, 32)
        output.font = Font(display, "Segoe UI", 20, SWT.BOLD)
        val texta = Text(composite, SWT.BORDER)
        texta.setBounds(45, 10, 115, 21)
        val textb = Text(composite, SWT.BORDER)
        textb.setBounds(183, 10, 130, 21)
        clean.isVisible = true
        clean.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                texta.text = ""
                textb.text = ""
                output.text = ""
            }
        })
        mtp.setBounds(125, 37, 102, 25)
        mtp.text = "Multiply"
        load.lang(mtp)
        mtp.isVisible = true
        mtp.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                try {
                    val res = texta.text.toDouble() * textb.text.toDouble()
                    if (res % 1 == 0.0) {
                        output.text = "" + res.toInt()
                    } else if (Settings.props.aprox) {
                        output.text = "" + res.toFloat()
                    } else {
                        output.text = "" + res
                    }
                } catch (nfe: NumberFormatException) {
                    if (BSMProperties().lang == "es") bsmexc.fillGaps("Rellena todos los huecos") else bsmexc.fillGaps(
                        "Fill all the gaps"
                    )
                }
            }
        })
        home.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                mtp.isVisible = false
                texta.isVisible = false
                textb.isVisible = false
                label.image = load.osLoad()
                divm.isVisible = true
                mtpm.isVisible = true
                addm.isVisible = true
                subm.isVisible = true
                back.isVisible = false
                home.isVisible = false
                clean.isVisible = false
            }
        })
    }

    /**
     * Creates the adding up interface
     * @since Beta 1.3
     */
    fun add() {
        if (BSMProperties().lang == "es") shell.text = "Basic Matics - Suma" else shell.text = "Basic Matics - Addition"
        backcomp.isVisible = true
        home.isVisible = true
        back.isVisible = false
        divm.isVisible = false
        mtpm.isVisible = false
        addm.isVisible = false
        subm.isVisible = false
        label.image = Image(display, javaClass.getResourceAsStream("/icons/ops/bsm-sume.png"))
        val output = Text(shell, SWT.READ_ONLY or SWT.CENTER)
        output.setBounds(95, 226, 233, 32)
        output.font = Font(display, "Segoe UI", 20, SWT.BOLD)
        val texta = Text(composite, SWT.BORDER)
        texta.setBounds(45, 10, 115, 21)
        val textb = Text(composite, SWT.BORDER)
        textb.setBounds(183, 10, 130, 21)
        clean.isVisible = true
        clean.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                texta.text = ""
                textb.text = ""
                output.text = ""
            }
        })
        add.setBounds(125, 37, 102, 25)
        add.text = "Add Up"
        load.lang(add)
        add.isVisible = true
        add.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                try {
                    val res = texta.text.toDouble() + textb.text.toDouble()
                    if (res % 1 == 0.0) {
                        output.text = "" + res.toInt()
                    } else if (Settings.props.aprox) {
                        output.text = "" + res.toFloat()
                    } else {
                        output.text = "" + res
                    }
                } catch (nfe: NumberFormatException) {
                    if (BSMProperties().lang == "es") bsmexc.fillGaps("Rellena todos los huecos") else bsmexc.fillGaps(
                        "Fill all the gaps"
                    )
                }
            }
        })
        home.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                add.isVisible = false
                texta.isVisible = false
                textb.isVisible = false
                label.image = load.osLoad()
                divm.isVisible = true
                mtpm.isVisible = true
                addm.isVisible = true
                subm.isVisible = true
                back.isVisible = false
                home.isVisible = false
                clean.isVisible = false
            }
        })
    }

    /**
     * Creates the subtracting interface
     * @since Beta 1.3
     */
    fun sub() {
        if (BSMProperties().lang == "es") shell.text = "Basic Matics - Resta" else shell.text = "Basic Matics - Subtraction"
        backcomp.isVisible = true
        home.isVisible = true
        back.isVisible = false
        divm.isVisible = false
        mtpm.isVisible = false
        addm.isVisible = false
        subm.isVisible = false
        label.image = Image(display, javaClass.getResourceAsStream("/icons/ops/bsm-rest.png"))
        val output = Text(shell, SWT.READ_ONLY or SWT.CENTER)
        output.setBounds(95, 226, 233, 32)
        output.font = Font(display, "Segoe UI", 20, SWT.BOLD)
        val texta = Text(composite, SWT.BORDER)
        texta.setBounds(45, 10, 115, 21)
        val textb = Text(composite, SWT.BORDER)
        textb.setBounds(183, 10, 130, 21)
        clean.isVisible = true
        clean.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                texta.text = ""
                textb.text = ""
                output.text = ""
            }
        })
        sub.setBounds(125, 37, 102, 25)
        sub.text = "Rest"
        load.lang(sub)
        sub.isVisible = true
        sub.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                try {
                    val res = texta.text.toDouble() - textb.text.toDouble()
                    if (res % 1 == 0.0) {
                        output.text = "" + res.toInt()
                    } else if (Settings.props.aprox) {
                        output.text = "" + res.toFloat()
                    } else {
                        output.text = "" + res
                    }
                } catch (nfe: NumberFormatException) {
                    if (BSMProperties().lang == "es") bsmexc.fillGaps("Rellena todos los huecos") else bsmexc.fillGaps(
                        "Fill all the gaps"
                    )
                }
            }
        })
        home.addSelectionListener(object : SelectionAdapter() {
            override fun widgetSelected(e: SelectionEvent) {
                sub.isVisible = false
                texta.isVisible = false
                textb.isVisible = false
                label.image = load.osLoad()
                divm.isVisible = true
                mtpm.isVisible = true
                addm.isVisible = true
                subm.isVisible = true
                back.isVisible = false
                home.isVisible = false
                clean.isVisible = false
            }
        })
    }

    companion object {
        /**Main shell */
        @JvmField
        var shell = Shell()

        /**Default display */
        @JvmField
        var display: Display = Display.getDefault()

        /**Main composite */
        protected var composite = Composite(shell, SWT.NONE)

        /**Goes to the Main Divide Page */
        @JvmField
        var divm = Button(composite, SWT.FLAT)

        /**Goes to the Main Multiply Page */
        @JvmField
        var mtpm = Button(composite, SWT.FLAT)

        /**Goes to the Main Subtract Page */
        @JvmField
        var subm = Button(composite, SWT.FLAT)

        /**Goes to the Main Add Up Page */
        @JvmField
        var addm = Button(composite, SWT.FLAT)

        /**Goes to the Settings Page */
        var settings: Button? = null

        /**Hosts the main image */
        @JvmField
        var label = Label(shell, SWT.NONE)

        /**Instance ofe Settings */
        protected val set = Settings()

        /**Button that goes to the divide page */
        @JvmField
        var bdiv = Button(composite, SWT.FLAT)

        /**Button that goes to the division rest page */
        @JvmField
        var bdivr = Button(composite, SWT.FLAT)

        /**Button that divides */
        @JvmField
        var div = Button(composite, SWT.FLAT)

        /**Button that makes the division rest */
        @JvmField
        var divr = Button(composite, SWT.FLAT)

        /**Button that multiplies */
        var mtp = Button(composite, SWT.FLAT)

        /**Button that subtracts */
        var sub = Button(composite, SWT.FLAT)

        /**Button that adds up */
        var add = Button(composite, SWT.FLAT)

        /**Cleans all */
        @JvmField
        var clean = Button(composite, SWT.FLAT or SWT.CENTER)

        /**
         * Launch the application.
         * @param args the arguments
         */
        @JvmStatic
        fun main(args: Array<String>) {
            try {
                val window = BasicMatics()
                window.open()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}