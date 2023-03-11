package com.micromatic.basicmatics.settings

import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Text

data class Language(val lang: String, val target: Button?, val text: Text?) {
    var eng: String = ""
    var esp: String = ""

    var set: String =""
    var apr: String = ""
    var os: String = ""
    var lng: String = ""
    var gen: String = ""
    var cust: String = ""
    var def: String = ""

    var div: String = ""
    var rdiv: String = ""
    var mtp: String = ""
    var add: String = ""
    var sub: String = ""

    var calc: String = ""
    var res: String = ""
    var cle: String = ""

    init {
        when (lang) {
            "es" -> {
                eng = "Ingl\u00e9s"
                esp = "Espa\u00f1ol"

                set = "Ajustes"
                os = "Imagen de Sistema"
                apr = "Resultado aproximado"
                lng = "Idioma"
                gen = "General"
                cust = "Personalizaci\u00f3"
                def = "Predeterminados"

                div = "Dividir"
                rdiv = "Resto de Divisi\u00f3n"
                mtp = "Multiplicar"
                add = "Sumar"
                sub = "Restar"

                calc = "Calcular"
                res = "Resultado"
                cle = "Limpiar"
            }
            "en" -> {
                eng = "English"
                esp = "Spanish"

                set = "Settings"
                os = "OS Image"
                apr = "Aproximated result"
                lng = "Language"
                gen = "General"
                cust = "Customization"
                def = "Default"

                div = "Divide"
                rdiv = "Remainder"
                mtp = "Multiply"
                add = "Add"
                sub = "Subtract"

                calc = "Calculate"
                res = "Result"
                cle = "Clean"
            }
        }
        if (target != null) {
            when (target.text) {
                "Divide" -> {
                    target.text = div
                }

                "Division Rest" -> {
                    target.text = rdiv
                }

                "Multiply" -> {
                    target.text = mtp
                }

                "Sume" -> {
                    target.text = add
                }

                "Rest" -> {
                    target.text = sub
                }

                "Add Up" -> {
                    target.text = add
                }

                "Subtract" -> {
                    target.text = sub
                }

                "Clean" -> {
                    target.text = cle
                }

                "Remainder" -> {
                    target.text = rdiv
                }

                "Restore Default" -> {
                    target.text = def
                }

                "Dividir" -> {
                    target.text = div
                }

                "Resto de Divisi\u00f3" -> {
                    target.text = rdiv
                }

                "Multiplicar" -> {
                    target.text = mtp
                }

                "Sumar" -> {
                    target.text = add
                }

                "Restar" -> {
                    target.text = sub
                }

                "Limpiar" -> {
                    target.text = cle
                }

                "Predeterminados" -> {
                    target.text = def
                }
            }
        }
        if (text != null) {
            when (text.text) {
                "Settings" -> {
                    text.text = set
                }

                "OS Image" -> {
                    text.text = os
                }

                "Aproximated result" -> {
                    text.text = apr
                }

                "Language" -> {
                    text.text = lng
                }

                "General" -> {
                    text.text = gen
                }

                "Customization" -> {
                    text.text = cust
                }

                "Ajustes" -> {
                    text.text = set
                }

                "Imagen de Sistema" -> {
                    text.text = os
                }

                "Resultado aproximado" -> {
                    text.text = apr
                }

                "Idioma" -> {
                    text.text = lng
                }

                "Personalizaci\u00f3n" -> {
                    text.text = cust
                }
            }
        }
    }
}
