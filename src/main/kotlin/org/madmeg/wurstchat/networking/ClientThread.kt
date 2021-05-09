package org.madmeg.wurstchat.networking

import org.madmeg.wurstchat.Main
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */


class ClientThread(socket: Socket, parent: Main): Thread() {
    val socket: Socket = socket
    val parent: Main = parent
    override fun run() {
        handleClient()
        parent.clientThreads.remove(this)
    }

    private fun handleClient(){
        val reader = Sockets().receiveData(socket)

        val data = reader.readLine() // Reads the data
        val command = data.split(":") // Splits command

        for(c in parent.commands.commands){
            if(command[1] == c.syntax && command[0] == "client"){
                c.onCall(socket, command)
            }
        }
    }
}