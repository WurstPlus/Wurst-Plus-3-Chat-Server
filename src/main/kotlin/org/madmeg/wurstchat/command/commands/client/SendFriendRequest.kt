package org.madmeg.wurstchat.command.commands.client

import org.madmeg.wurstchat.client.Client
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
    override fun onCall(socket: Socket, command: List<String>, fromClient: Client) {
        val toClient = clientManager.getClientFromUuid(command[5])!!
        if (toClient.friends.containsKey(fromClient)){
            Sockets().sendData(socket, "server:sendfriendrq:error1")
            return
        }
        toClient.friends.put(fromClient, false)
        fromClient.friends.put(toClient, true)
        Sockets().sendData(socket, "server:sendfriendrq:sent")
    }
}