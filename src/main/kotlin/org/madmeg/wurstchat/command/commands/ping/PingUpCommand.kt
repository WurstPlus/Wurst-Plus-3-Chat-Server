package org.madmeg.wurstchat.command.commands.ping

import org.madmeg.wurstchat.client.Client
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
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        fromClient.online = true
        //clientManager.getClientFromUuid(command[3])!!.online = true
        Sockets().sendData(socket, "server:pingup")
    }
}