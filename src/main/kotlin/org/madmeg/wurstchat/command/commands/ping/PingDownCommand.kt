package org.madmeg.wurstchat.command.commands.ping

import org.madmeg.wurstchat.client.Client
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
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        fromClient.online = false
        //clientManager.getClientFromUuid(command[3])!!.online = false
        Sockets().sendData(socket, "server:pingdown")
    }
}