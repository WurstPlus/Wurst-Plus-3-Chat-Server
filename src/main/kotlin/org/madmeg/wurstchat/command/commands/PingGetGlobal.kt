package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.globalChat
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 12/05/2021
 */
@Register("PingGetGlobal", Types.PING, "pinggetglobal")
class PingGetGlobal: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        val client = clientManager.getClientFromUuid(command[3])
        val toSend = ":"
        if(globalChat.messages.isEmpty()){
            Sockets().sendData(socket, "server:")
        }
    }
}