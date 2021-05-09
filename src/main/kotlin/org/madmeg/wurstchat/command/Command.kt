package org.madmeg.wurstchat.command

import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


open class Command {
    fun getReg(): Register {
        return javaClass.getAnnotation(Register::class.java)
    }
    val name = getReg().name
    val type = getReg().type
    val syntax = getReg().syntax

    open fun onCall(socket: Socket, command: List<String>){
    }

}