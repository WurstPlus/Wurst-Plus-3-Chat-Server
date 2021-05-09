package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.console.Print
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

@Register("PingDown", Types.PING, "pingdown")
class PingDownCommand: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        Print("Pinged Down from client")
        for(c in clientManager.clients){
            if(c.uuid == command[2]){
                c.online = false
            }
        }
        Sockets().sendData(socket, "server:pingdown")
    }
}