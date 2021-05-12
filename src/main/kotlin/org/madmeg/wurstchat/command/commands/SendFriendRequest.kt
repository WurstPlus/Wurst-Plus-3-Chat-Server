package org.madmeg.wurstchat.command.commands

import org.madmeg.wurstchat.clientManager
import org.madmeg.wurstchat.command.Command
import org.madmeg.wurstchat.command.Register
import org.madmeg.wurstchat.command.Types
import org.madmeg.wurstchat.networking.Sockets
import java.net.Socket

/**
 * @author Madmegsox1
 * @since 09/05/2021
 */

@Register("SendFriendRequest", Types.CLIENT, "sendfriendrq")
class SendFriendRequest: Command() {
    override fun onCall(socket: Socket, command: List<String>) {
        val fromClient = clientManager.getClientFromUuid(command[3])!!
        val toClient = clientManager.getClientFromUuid(command[4])!!
        if (toClient.friends.containsKey(fromClient)){
            Sockets().sendData(socket, "server:sendfriendrq:error1")
            return
        }
        toClient.friends.put(fromClient, false)
        fromClient.friends.put(toClient, false)
    }
}