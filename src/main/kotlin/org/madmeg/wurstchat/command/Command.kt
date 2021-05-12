package org.madmeg.wurstchat.command

import org.madmeg.wurstchat.client.Client
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
    val secureKey = getReg().secureKey

    open fun onCall(socket: Socket, command: List<String>, fromClient: Client){
    }

    open fun onCall(socket: Socket, command: List<String>){
    }

}