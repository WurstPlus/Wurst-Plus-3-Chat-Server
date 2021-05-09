package org.madmeg.wurstchat.console


import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


class Print(message: String) {
    init {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM HH:mm")
        val formatted = current.format(formatter)
        println("[$formatted] -> $message")
    }
}