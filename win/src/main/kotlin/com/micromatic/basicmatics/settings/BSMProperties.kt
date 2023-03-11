package com.micromatic.basicmatics.settings

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

/**Properties file loader */
open class BSMProperties {
    /**References to the properties file */
    private val path: File
        get() {
            return if (OS.name.contains("win"))
                File(System.getProperty("user.home"), "/AppData/Local/Temp")
            else
                File(System.getProperty("user.home"), ".config")
        }
    val file = File(path.path, "/bsm.properties")

    /**Allows to access the file */
    var `in`: FileInputStream? = null

    /**Allows to write the file */
    private var out: FileOutputStream? = null

    /**Properties loading */
    var props = Properties()

    /**
     * Creates the file
     * @throws IOException when it can't create the file
     */
    @Throws(IOException::class)
    fun create() {
        if (!file.exists())
            file.createNewFile()
    }

    /**
     *
     * @param key the key to check
     * @return flase if the key doesn't exist and true if it exists
     */
    fun existsKey(key: String?): Boolean {
        return try {
            `in` = FileInputStream(file)
            props.load(`in`)
            `in`!!.close()
            props.containsKey(key)
        } catch (io: IOException) {
            io.printStackTrace()
            false
        }
    }

    /**
     * It gets from the bsm.properties file if the results are aproximated or equal, by a boolean type
     * @return aprox property
     */
    var aprox: Boolean
        get() {
            create()
            try {
                `in` = FileInputStream(file)
                props.load(`in`)
                `in`!!.close()
            } catch (io: IOException) {
                io.printStackTrace()
            }
            return java.lang.Boolean.parseBoolean(props.getProperty("aprox"))
        }
        set(key) {
            create()
            try {
                `in` = FileInputStream(file)
                props.load(`in`)
                `in`!!.close()
                out = FileOutputStream(file)
                if (props.containsKey("aprox")) {
                    props.replace("aprox", props.getProperty("aprox"), key.toString())
                    props.store(out, null)
                    out!!.close()
                } else {
                    props.setProperty("aprox", key.toString())
                    props.store(out, null)
                    out!!.close()
                }
            } catch (io: IOException) {
                io.printStackTrace()
            }
        }

    /**
     * It sets the language in the properties file
     */
    var lang: String?
        get() {
            create()
            try {
                `in` = FileInputStream(file)
                props.load(`in`)
            } catch (io: IOException) {
                io.printStackTrace()
            }
            return props.getProperty("lang")
        }
        set(key) {
            create()
            try {
                `in` = FileInputStream(file)
                props.load(`in`)
                `in`!!.close()
                out = FileOutputStream(file)
                if (props.containsKey("lang")) {
                    props.replace("lang", props.getProperty("lang"), key)
                    props.store(out, null)
                    out!!.close()
                } else {
                    props.setProperty("lang", key)
                    props.store(out, null)
                    out!!.close()
                }
            } catch (io: IOException) {
                io.printStackTrace()
            }
        }
    /**
     * Gets the Operating System on the properties file
     * @return the os in the properties file
     */
    /**
     * Sets the os image for use
     */
    var os: String?
        get() {
            create()
            try {
                `in` = FileInputStream(file)
                props.load(`in`)
            } catch (io: IOException) {
                io.printStackTrace()
            }
            return props.getProperty("os")
        }
        set(key) {
            create()
            try {
                `in` = FileInputStream(file)
                props.load(`in`)
                `in`!!.close()
                out = FileOutputStream(file)
                if (props.containsKey("os")) {
                    props.replace("os", props.getProperty("os"), key)
                    props.store(out, null)
                    out!!.close()
                } else {
                    props.setProperty("os", key)
                    props.store(out, null)
                    out!!.close()
                }
            } catch (io: IOException) {
                io.printStackTrace()
            }
        }

}