package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.client.ClientManager
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

@Register("PingUp", Types.PING, "pingup")
class PingUpCommand: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        Print("Pinged Up from client")
        for(c in clientManager.clients){
            if(c.uuid == command[2]){
                c.online = true
            }
        }
        Sockets().sendData(socket, "server:pingup")
    }
}