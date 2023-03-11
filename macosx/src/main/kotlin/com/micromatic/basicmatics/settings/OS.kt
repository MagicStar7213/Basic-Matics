package com.micromatic.basicmatics.settings

import java.util.*

/**OS variables and methods */
interface OS {
    companion object {
        /**
         * Gets the name of the OS
         */
        val name = System.getProperty("os.name").lowercase(Locale.getDefault())
    }
}