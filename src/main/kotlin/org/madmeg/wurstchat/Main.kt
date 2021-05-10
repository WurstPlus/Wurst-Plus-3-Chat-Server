package org.madmeg.wurstchat

import org.madmeg.wurstchat.client.ClientManager
import org.madmeg.wurstchat.command.Commands
import org.madmeg.wurstchat.console.Print
import org.madmeg.wurstchat.console.ShutdownThread
import org.madmeg.wurstchat.networking.ClientThread
import org.madmeg.wurstchat.networking.Sockets

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

val PORT = 4200
var clientManager: ClientManager = ClientManager()
val running: Boolean = true

class Main {
    val clientThreads: ArrayList<ClientThread> = arrayListOf()
    var commands: Commands = Commands()
    init {
        Print("Starting Wurst Server!")
        clientThreads.clear()
        val socket = Sockets().openPort()
        Print("Started Wurst server on port $PORT!")
        Runtime.getRuntime().addShutdownHook(ShutdownThread())
        while (running){
            Print("Listening for Clients")
            val cSocket = Sockets().receiveSocket(socket)
            val thread = ClientThread(cSocket, this)
            clientThreads.add(thread)
            Print("Starting new thread for ${cSocket.inetAddress}")
            thread.start()
        }
    }
}



fun main(){
    Main()
}